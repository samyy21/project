package com.paytm.pgplus.upipsphandler.utils;

import com.paytm.pgplus.common.enums.ERequestType;
import com.paytm.pgplus.facade.payment.enums.PaymentStatus;
import com.paytm.pgplus.payloadvault.theia.request.PaymentRequestBean;
import com.paytm.pgplus.payloadvault.theia.response.TransactionResponse;
import com.paytm.pgplus.pgproxycommon.enums.ExternalTransactionStatus;
import com.paytm.pgplus.upipsphandler.constants.TheiaConstant;
import com.paytm.pgplus.upipsphandler.enums.EventNameEnum;
import com.paytm.pgplus.upipsphandler.log.EventLogger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.MDC;

import java.util.LinkedHashMap;
import java.util.Map;

public class EventUtils {

    private static final String DEFAULT_PARAM_VALUE = "";
    public static void pushTheiaEvents(EventNameEnum loggerEvents, Map<String, String> metaData) {
        String mid = MDC.get("MID") != null ? MDC.get("MID") : DEFAULT_PARAM_VALUE;
        String orderId = MDC.get("ORDER_ID") != null ? MDC.get("ORDER_ID") : DEFAULT_PARAM_VALUE;
        EventLogger.pushEventLog(mid, orderId, loggerEvents, 1, metaData);
    }
    public static void pushTheiaEvents(com.paytm.pgplus.common.enums.EventNameEnum loggerEvents, Map<String, String> metaData) {
        String mid = MDC.get("MID") != null ? MDC.get("MID") : DEFAULT_PARAM_VALUE;
        String orderId = MDC.get("ORDER_ID") != null ? MDC.get("ORDER_ID") : DEFAULT_PARAM_VALUE;
        com.paytm.pgplus.common.log.EventLogger.pushEventLog(mid, orderId, loggerEvents, 1, metaData);
    }
    public static void pushTheiaEvents(String mid, String orderId, EventNameEnum loggerEvents,
                                       Map<String, String> metaData) {
        mid = mid != null ? mid : DEFAULT_PARAM_VALUE;
        orderId = orderId != null ? orderId : DEFAULT_PARAM_VALUE;
        EventLogger.pushEventLog(mid, orderId, loggerEvents, 1, metaData);
    }
    public static void pushTheiaEvents(EventNameEnum loggerEvents, Pair<String, String>... args) {
        Map<String, String> metaData = new LinkedHashMap<>();
        if (args != null) {
            for (Pair<String, String> pair : args) {
                metaData.put(pair.getKey(), pair.getValue());
            }
        }
        pushTheiaEvents(loggerEvents, metaData);
    }
    public static void pushTheiaEvents(String mid, String orderId, com.paytm.pgplus.common.enums.EventNameEnum loggerEvents,
                                       Map<String, String> metaData) {
        mid = mid != null ? mid : DEFAULT_PARAM_VALUE;
        orderId = orderId != null ? orderId : DEFAULT_PARAM_VALUE;
        com.paytm.pgplus.common.log.EventLogger.pushEventLog(mid, orderId, loggerEvents, 1, metaData);
    }
    public static void logResponseCode(String apiName, EventNameEnum eventNameEnum, String responseCode,
                                       String responseMsg) {
        if (StringUtils.isNotBlank(apiName)) {
            EventLogger.logResponseCode(apiName, eventNameEnum, responseCode, responseMsg);
        }
    }
    public static void pushTheiaEventforbizError(com.paytm.pgplus.common.enums.EventNameEnum loggerEvents, String mid, String orderId, String msg) {
        Map<String, String> metaData = new LinkedHashMap<>();
        metaData.put("eventMsg", "SYSTEM_ERROR, Reason :: " + msg);
        pushTheiaEvents(mid, orderId, loggerEvents, metaData);
    }
    public static void pushLinkBasedPaymentCompletedEvent(TransactionResponse response, PaymentRequestBean requestData) {
        Map<String, String> metaData = new LinkedHashMap<>();
        if (requestData != null) {
            metaData.put(TheiaConstant.LinkBasedParams.LINK_ID, requestData.getLinkId());
            metaData.put(TheiaConstant.LinkBasedParams.INVOICE_ID, requestData.getInvoiceId());
            if (requestData.getLinkDetailsData() != null) {
                metaData.put(TheiaConstant.LinkBasedParams.SUB_REQUEST_TYPE, requestData.getLinkDetailsData()
                        .getSubRequestType());
            }
        } else {
            metaData.put(TheiaConstant.LinkBasedParams.LINK_ID, "");
            metaData.put(TheiaConstant.LinkBasedParams.INVOICE_ID, "");
        }

        metaData.put(TheiaConstant.LinkBasedParams.REQUEST_TYPE, response.getRequestType());
        if (StringUtils.isEmpty(response.getRequestType())) {
            if (requestData != null && StringUtils.isNotEmpty(requestData.getLinkId())) {
                metaData.put(TheiaConstant.LinkBasedParams.REQUEST_TYPE, ERequestType.LINK_BASED_PAYMENT.getType());
            } else if (requestData != null && StringUtils.isNotEmpty(requestData.getInvoiceId())) {
                metaData.put(TheiaConstant.LinkBasedParams.REQUEST_TYPE,
                        ERequestType.LINK_BASED_PAYMENT_INVOICE.getType());
            }
        }
        if (requestData != null && StringUtils.isNotEmpty(requestData.getLinkId())) {
            metaData.put(TheiaConstant.LinkBasedParams.LINK_TYPE, TheiaConstant.LinkRiskParams.LINK_TYPE_NON_INVOICE);
        } else if (requestData != null && StringUtils.isNotEmpty(requestData.getInvoiceId())) {
            metaData.put(TheiaConstant.LinkBasedParams.LINK_TYPE, TheiaConstant.LinkRiskParams.LINK_INVOICE_TYPE);
        } else {
            metaData.put(TheiaConstant.LinkBasedParams.LINK_TYPE, "");
        }
        metaData.put(TheiaConstant.LinkBasedParams.TXN_AMOUNT, response.getTxnAmount());
        metaData.put(TheiaConstant.LinkBasedParams.PAYMENT_MODE, response.getPaymentMode());
        metaData.put(TheiaConstant.LinkBasedParams.BANK_NAME, response.getBankName());
        metaData.put(TheiaConstant.LinkBasedParams.TXN_STATUS, response.getTransactionStatus());
        if (PaymentStatus.SUCCESS.name().equalsIgnoreCase(response.getTransactionStatus())) {
            metaData.put(TheiaConstant.LinkBasedParams.TXN_STATUS, ExternalTransactionStatus.TXN_SUCCESS.name());
        } else if (PaymentStatus.FAIL.name().equalsIgnoreCase(response.getTransactionStatus())) {
            metaData.put(TheiaConstant.LinkBasedParams.TXN_STATUS, ExternalTransactionStatus.TXN_FAILURE.name());
        }
        metaData.put(TheiaConstant.LinkBasedParams.MERC_UNIQ_REF, response.getMerchUniqueReference());
        metaData.put(TheiaConstant.LinkBasedParams.RESPONSE_CODE, response.getResponseCode());
        metaData.put(TheiaConstant.LinkBasedParams.RESPONSE_MESSAGE, response.getResponseMsg());
        String mid = response.getMid();
        String orderId = response.getOrderId();
        EventUtils.pushTheiaEvents(mid, orderId, com.paytm.pgplus.common.enums.EventNameEnum.LINK_BASED_PAYMENT_COMPLETED, metaData);
    }

    public static void pushTheiaEventMessages(com.paytm.pgplus.common.enums.EventNameEnum loggerEvents) {
        String mid = MDC.get("MID") != null ? MDC.get("MID") : DEFAULT_PARAM_VALUE;
        String orderId = MDC.get("ORDER_ID") != null ? MDC.get("ORDER_ID") : DEFAULT_PARAM_VALUE;
        com.paytm.pgplus.common.log.EventLogger.pushEventMessage(mid, orderId, loggerEvents);
    }
}
