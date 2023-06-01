package com.paytm.pgplus.upipsphandler.component;

import com.paytm.pgplus.biz.core.model.request.BizCancelFundOrderRequest;
import com.paytm.pgplus.biz.core.model.request.BizCancelOrderRequest;
import com.paytm.pgplus.biz.core.model.request.BizCancelOrderResponse;
import com.paytm.pgplus.biz.core.order.service.IOrderService;
import com.paytm.pgplus.biz.mapping.models.MappingMerchantData;
import com.paytm.pgplus.biz.workflow.model.WorkFlowRequestBean;
import com.paytm.pgplus.common.model.EnvInfoRequestBean;
import com.paytm.pgplus.facade.paymentrouter.enums.Routes;
import com.paytm.pgplus.logging.ExtendedLogger;
import com.paytm.pgplus.pgproxycommon.models.GenericCoreResponseBean;
import com.paytm.pgplus.request.InitiateTransactionRequestBody;
import com.paytm.pgplus.upipsphandler.constants.TheiaConstant;
import com.paytm.pgplus.upipsphandler.exception.offline.SessionExpiredException;
import com.paytm.pgplus.upipsphandler.model.common.NativeRetryInfo;
import com.paytm.pgplus.upipsphandler.service.IMerchantMappingService;
import com.paytm.pgplus.upipsphandler.service.impl.AOAUtils;
import com.paytm.pgplus.upipsphandler.utils.ConfigurationUtil;
import com.paytm.pgplus.upipsphandler.service.impl.MerchantExtendInfoUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class NativeRetryUtil {
    @Autowired
    private MerchantExtendInfoUtils merchantExtendInfoUtils;
    @Autowired
    private NativeSessionUtil nativeSessionUtil;
    @Autowired
    @Qualifier("merchantMappingService")
    private IMerchantMappingService merchantMappingService;
    @Autowired
    @Qualifier("aoaUtils")
    private AOAUtils aoaUtils;
    @Autowired
    private RouterUtil routerUtil;
    @Autowired
    @Qualifier("orderService")
    private IOrderService orderServiceImpl;
    private static final Logger LOGGER = LoggerFactory.getLogger(NativeRetryUtil.class);
    private static final ExtendedLogger EXT_LOGGER = ExtendedLogger.create(NativeRetryUtil.class);

    private static final String RISK_REJECT_ORDER_CLOSE_REASON = "RISK_REJECT";

    public boolean isRetryPossible(WorkFlowRequestBean workFlowRequestBean) {
        String token = workFlowRequestBean.getTxnToken();
        String mid = workFlowRequestBean.getPaytmMID();

        if (StringUtils.isBlank(token)) {
            token = mid + workFlowRequestBean.getOrderID();
        }

        int allowedRetryCountsForMerchant;

        // default perform retry on all scan and pay transactions
        if (workFlowRequestBean.isScanAndPayFlow()
                && Boolean.valueOf(ConfigurationUtil.getProperty(TheiaConstant.RetryConstants.OFFLINE_RETRY_ALL,
                "false"))) {
            allowedRetryCountsForMerchant = Integer.parseInt(ConfigurationUtil
                    .getProperty(TheiaConstant.RetryConstants.MAX_RETRY_ALLOWED_ON_OFFLINE_MERCHANT));
            EXT_LOGGER.customInfo("Transaction is scan and pay, perform " + allowedRetryCountsForMerchant
                    + " max retries on static QR merchant");
        } else
            allowedRetryCountsForMerchant = merchantExtendInfoUtils.getNumberOfRetries(mid);

        workFlowRequestBean.setMaxAllowedOnMerchant(allowedRetryCountsForMerchant);
        Integer currentRetryCountBankFails = nativeSessionUtil.getRetryPaymentCount(token);
        Integer totalPaymentCount = nativeSessionUtil.getTotalPaymenCount(token);
        if (totalPaymentCount != null)
            workFlowRequestBean.setNativeTotalPaymentCount(totalPaymentCount);

        if (currentRetryCountBankFails == null) {
            return true;
        }
        EXT_LOGGER.customInfo("Checking if retry possible, current retry count for bank fails : {}",
                currentRetryCountBankFails);
        workFlowRequestBean.setNativeRetryCount(currentRetryCountBankFails + 1);
        if (allowedRetryCountsForMerchant <= 0) {
            LOGGER.debug("Max number of payment retry is zero or less for merchantID : {}", mid);
            return false;
        }

        if (currentRetryCountBankFails < allowedRetryCountsForMerchant) {
            LOGGER.info("Merchant retry case, current retry count for merchant : {}", currentRetryCountBankFails);
            return true;
        }
        return false;
    }
    public Integer increaseRetryCount(String txnToken, String mid, String orderId) {
        if (txnToken == null) {
            return null;
        }
        Integer currentRetryCount = nativeSessionUtil.getRetryPaymentCount(txnToken);
        // first payment attempt
        if (currentRetryCount == null) {
            currentRetryCount = 0;
            nativeSessionUtil.setRetryPaymentCount(txnToken, 0);
        } else {
            currentRetryCount = currentRetryCount + 1;
            LOGGER.info("Setting current retry count as  : {}", currentRetryCount);
            nativeSessionUtil.setRetryPaymentCount(txnToken, currentRetryCount);
            nativeSessionUtil.updateTokenExpiry(txnToken, mid, orderId);
        }
        return currentRetryCount;
    }
    public String getCallbackUrl(String token) {
        InitiateTransactionRequestBody orderDetails = nativeSessionUtil.getOrderDetail(token);
        return orderDetails.getCallbackUrl();
    }
//    public void invalidateSession(String txnToken, NativeRetryInfo nativeRetryInfo,
//                                  InitiateTransactionRequestBody orderDetail, EnvInfoRequestBean envInfo, boolean isRiskReject) {
//        if (nativeRetryInfo != null) {
//            invalidateSession(txnToken, nativeRetryInfo.isRetryAllowed(), orderDetail, envInfo, false);
//        }
//    }
    public void invalidateSession(final String txnToken, final boolean isSessionValid,
                                  InitiateTransactionRequestBody orderDetail, EnvInfoRequestBean envInfo, boolean isRiskReject) {
        if (!isSessionValid) {
            if (txnToken != null) {
                String midOrderIDToken = null;

                try {
                    if (ObjectUtils.isEmpty(orderDetail))
                        orderDetail = nativeSessionUtil.getOrderDetail(txnToken);

                } catch (NullPointerException e) {
                    LOGGER.error("Session Invalidate Exception in case of deleting keys", e);
                    throw SessionExpiredException.getException();
                }
                if (!ObjectUtils.isEmpty(orderDetail)) {
                    LOGGER.debug("TxnId:{} token found in Redis", txnToken);
                    midOrderIDToken = nativeSessionUtil.getMidOrderIdKeyForRedis(orderDetail.getMid(),
                            orderDetail.getOrderId());
                    String transId = getTxnId(txnToken);
                    if (StringUtils.isNotBlank(transId)) {
                        if (orderDetail.isNativeAddMoney()) {
                            if (isRiskReject) {
                                LOGGER.info("Closing fund order due to risk reject");
                                closeFundOrderOnRiskReject(orderDetail, transId, envInfo);
                            } else {
                                LOGGER.info("Closing fund order to invalidate Session");
                                closeFundOrderOnInvalidateSession(orderDetail, transId, envInfo);
                            }
                        } else {
                            String paymentMid = nativeSessionUtil.getFieldValue(transId, "PaymentMid");

                            /**
                             * Stored the original mid in order to proceed with
                             * the transaction after closing order on dummy mid.
                             */

                            String originalMid = orderDetail.getMid();
                            if (StringUtils.isNotBlank(paymentMid)) {
                                orderDetail.setMid(paymentMid);
                            }
                            if (isRiskReject) {
                                LOGGER.info("Closing order acquiring order to risk reject");
                                closeOrderOnRiskReject(orderDetail, transId);
                            } else {
                                LOGGER.info("Closing Order to Invalidate Session");
                                closeOrderOnInvalidateSession(orderDetail, transId);
                            }

                            orderDetail.setMid(originalMid);
                        }
                    }

                }
                // stopping key delete
                /*
                 * try { // Assumption: If txnToken exists then midOrderIDToken
                 * and // vice-versa LOGGER.info("Deleting keys {} , {}",
                 * midOrderIDToken, txnToken);
                 * nativeSessionUtil.deleteKey(midOrderIDToken, txnToken); }
                 * catch (JedisDataException e) { LOGGER.error(
                 * "Session Invalidate Exception in case of deleting keys", e);
                 * throw SessionExpiredException.getException(); } LOGGER.debug(
                 * "Sucessfully deleted keys: txnId :{},midOrderIdToken: {}",
                 * txnToken, midOrderIDToken);
                 */
            }
        }
    }
    public void invalidateSession(final String txnToken, final boolean sessionValidate, String mid, String orderID,
                                  EnvInfoRequestBean envInfo) {
        InitiateTransactionRequestBody orderDetail = nativeSessionUtil.getOrderDetail(txnToken);
        if (ObjectUtils.isEmpty(orderDetail) && StringUtils.isNotEmpty(mid) && StringUtils.isNotEmpty(orderID)) {
            orderDetail = new InitiateTransactionRequestBody();
            orderDetail.setMid(mid);
            orderDetail.setOrderId(orderID);
        }
        invalidateSession(txnToken, sessionValidate, orderDetail, envInfo, false);

    }

    public String getTxnId(String token) {
        return nativeSessionUtil.getTxnId(token);
    }

    public void closeFundOrderOnRiskReject(InitiateTransactionRequestBody orderDetail, String transId,
                                           EnvInfoRequestBean envInfo) {
        BizCancelFundOrderRequest bizCancelFundOrderRequest = new BizCancelFundOrderRequest(transId, envInfo,
                RISK_REJECT_ORDER_CLOSE_REASON);
        bizCancelFundOrderRequest.setPaytmMerchantId(orderDetail.getMid());
        bizCancelFundOrderRequest.setRoute(Routes.PG2);
        final GenericCoreResponseBean<BizCancelOrderResponse> cancelFundOrder = orderServiceImpl
                .closeFundOrder(bizCancelFundOrderRequest);
        if (!cancelFundOrder.isSuccessfullyProcessed()) {
            LOGGER.error("Close/Cancel fund order failed due to :: {}", cancelFundOrder.getFailureMessage());
        }
    }

    private void closeFundOrderOnInvalidateSession(InitiateTransactionRequestBody orderDetail, String transId,
                                                   EnvInfoRequestBean envInfo) {
        BizCancelFundOrderRequest bizCancelFundOrderRequest = new BizCancelFundOrderRequest(transId, envInfo);
        bizCancelFundOrderRequest.setPaytmMerchantId(orderDetail.getMid());
        bizCancelFundOrderRequest.setRoute(Routes.PG2);
        final GenericCoreResponseBean<BizCancelOrderResponse> cancelFundOrder = orderServiceImpl
                .closeFundOrder(bizCancelFundOrderRequest);
        if (!cancelFundOrder.isSuccessfullyProcessed()) {
            LOGGER.error("Close/Cancel fund order failed due to :: {}", cancelFundOrder.getFailureMessage());
        }
    }

    public void closeOrderOnRiskReject(InitiateTransactionRequestBody orderDetail, String transId) {

        final GenericCoreResponseBean<MappingMerchantData> merchantMappingResponse = merchantMappingService
                .fetchMerchanData(orderDetail.getMid());
        if ((merchantMappingResponse != null) && (merchantMappingResponse.getResponse() != null)) {
            String alipayMid = merchantMappingResponse.getResponse().getAlipayId();
            boolean fromAoaMerchant = aoaUtils.isAOAMerchant(orderDetail.getMid());
            BizCancelOrderRequest bizCancelOrderRequest = new BizCancelOrderRequest(alipayMid, transId,
                    RISK_REJECT_ORDER_CLOSE_REASON, fromAoaMerchant, orderDetail.getMid(), this.routerUtil.getRoute(
                    orderDetail.getMid(), orderDetail.getOrderId(), "closeOrderOnRiskReject"));
            final GenericCoreResponseBean<BizCancelOrderResponse> cancelOrder = orderServiceImpl
                    .closeOrder(bizCancelOrderRequest);
            if (!cancelOrder.isSuccessfullyProcessed()) {
                LOGGER.error("Close/Cancel order failed due to :: {}", cancelOrder.getFailureMessage());
            }
        }

    }

    private void closeOrderOnInvalidateSession(InitiateTransactionRequestBody orderDetail, String transId) {

        final GenericCoreResponseBean<MappingMerchantData> merchantMappingResponse = merchantMappingService
                .fetchMerchanData(orderDetail.getMid());
        if ((merchantMappingResponse != null) && (merchantMappingResponse.getResponse() != null)) {
            String alipayMid = merchantMappingResponse.getResponse().getAlipayId();
            boolean fromAoaMerchant = aoaUtils.isAOAMerchant(orderDetail.getMid());
            BizCancelOrderRequest bizCancelOrderRequest = new BizCancelOrderRequest(alipayMid, transId,
                    "Session Invalidation", fromAoaMerchant, orderDetail.getMid(), this.routerUtil.getRoute(
                    orderDetail.getMid(), orderDetail.getOrderId(), "closeOrderOnInvalidateSession"));
            final GenericCoreResponseBean<BizCancelOrderResponse> cancelOrder = orderServiceImpl
                    .closeOrder(bizCancelOrderRequest);
            if (!cancelOrder.isSuccessfullyProcessed()) {
                LOGGER.error("Close/Cancel order failed due to :: {}", cancelOrder.getFailureMessage());
            }
        }

    }

    public int getAllowedRetryCountsOnMerchant(String mid) {
        int allowedRetryCountsForMerchant = merchantExtendInfoUtils.getNumberOfRetries(mid);
        return allowedRetryCountsForMerchant;
    }
}
