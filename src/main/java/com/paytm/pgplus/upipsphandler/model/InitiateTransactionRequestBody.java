package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paytm.pgplus.Annotations.Mask;
import com.paytm.pgplus.Annotations.MaskToStringBuilder;
import com.paytm.pgplus.enums.EPreAuthType;
import com.paytm.pgplus.enums.TxnType;
import com.paytm.pgplus.facade.affordabilityPlatform.models.request.OrderOfferInfo;
import com.paytm.pgplus.models.*;
import com.paytm.pgplus.request.ExtraParameterMap;
import com.paytm.pgplus.upipsphandler.model.common.TpvInfo;
import com.paytm.pgplus.upipsphandler.model.common.VanInfo;
import com.paytm.pgplus.common.model.link.LinkDetailResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InitiateTransactionRequestBody extends ExtraParameterMap implements Serializable {
    private static final long serialVersionUID = -6262470270585038991L;
    private static final Logger LOGGER = LoggerFactory.getLogger(InitiateTransactionRequestBody.class);
    @JsonProperty("requestType")
    private String requestType;
    @JsonProperty("mid")
    private String mid;
    @JsonProperty("orderId")
    private String orderId;
    @JsonProperty("websiteName")
    private String websiteName;
    @JsonProperty("txnAmount")
    private Money txnAmount;
    @JsonProperty("userInfo")
    private UserInfo userInfo;
    @JsonProperty("paytmSsoToken")
    @Mask(
            prefixNoMaskLen = 6,
            suffixNoMaskLen = 4
    )
    private String paytmSsoToken;
    @JsonProperty("enablePaymentMode")
    private List<PaymentMode> enablePaymentMode = null;
    @JsonProperty("disablePaymentMode")
    private List<PaymentMode> disablePaymentMode = null;
    @JsonProperty("promoCode")
    private String promoCode;
    @JsonProperty("callbackUrl")
    private String callbackUrl;
    @JsonProperty("goods")
    private List<GoodsInfo> goods = null;
    @JsonProperty("shippingInfo")
    private List<ShippingInfo> shippingInfo = null;
    @JsonProperty("extendInfo")
    private ExtendInfo extendInfo;
    @JsonProperty("ccBillPayment")
    private CCBillPayment ccBillPayment;
    private String emiOption;
    private String cardTokenRequired;
    private String cartValidationRequired;
    private Map<String, String> additionalInfo;
    private String aggMid;
    private String channelId;
    private String validateAccountNumber;
    private String allowUnverifiedAccount;
    private String targetPhoneNo;
    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("isNativeAddMoney")
    private boolean isNativeAddMoney;
    private String corporateCustId;
    private String templateId;
    private String bId;
    private PaymentOffer paymentOffersApplied;
    private String cardHash;
    private List<String> enableUpiPsp;
    private RiskFeeDetails riskFeeDetails;
    private List<String> bankAccountNumbers;
    private String emiId;
    @JsonProperty("payableAmount")
    private Money payableAmount;
    @JsonIgnore
    private SplitSettlementInfo splitSettlementInfo;
    @JsonProperty("peonUrl")
    private String PEON_URL;
    private String emiSubventionToken;
    private Map<String, Object> emiSubventionValidationResponse;
    private String previousOrderId;
    private boolean offlineFlow;
    private OrderPricingInfo orderPricingInfo;
    private String aggType;
    private Map<String, String> riskExtendInfo;
    private SimplifiedPaymentOffers simplifiedPaymentOffers;
    private boolean addMoneyFeeAppliedOnWallet;
    private boolean setSSOViaOptLogin;
    private boolean authorized;
    @JsonIgnore
    private boolean appInvoke;
    @JsonProperty("splitSettlementInfo")
    private SplitSettlementInfoData splitSettlementInfoData;
    private TxnType txnType;
    private String preAuthExpiryDate;
    private SimplifiedSubvention simplifiedSubvention;
    @JsonProperty("linkDetails")
    private LinkDetailResponseBody linkDetailsData;
    private boolean autoRefund;
    private boolean autoLoginViaCookie;
    private String paymodeSequence;
    private VanInfo vanInfo;
    @JsonProperty("tpvInfos")
    private List<TpvInfo> tpvInfo;
    private EPreAuthType cardPreAuthType;
    private Long preAuthBlockSeconds;
    private PaymentOfferV2 paymentOffersAppliedV2;
    private boolean needAppIntentEndpoint;
    private String appCallbackUrl;
    private String browserName;
    private String deviceId;
    @JsonProperty("tipAmount")
    private Money tipAmount;
    private boolean aoaSubsOnPgMid;
    private OrderOfferInfo affordabilityDetails;
    private Map<String, String> affordabilityInfo;
    private UltimateBeneficiaryDetails ultimateBeneficiaryDetails;
    private List<PayerAccountDetails> payerAccountDetails;

    public InitiateTransactionRequestBody() {
    }

    public SimplifiedSubvention getSimplifiedSubvention() {
        return this.simplifiedSubvention;
    }

    public void setSimplifiedSubvention(SimplifiedSubvention simplifiedSubvention) {
        this.simplifiedSubvention = simplifiedSubvention;
    }

    public OrderOfferInfo getAffordabilityDetails() {
        return this.affordabilityDetails;
    }

    public Map<String, String> getAffordabilityInfo() {
        return this.affordabilityInfo;
    }

    public boolean isAoaSubsOnPgMid() {
        return this.aoaSubsOnPgMid;
    }

    public void setAoaSubsOnPgMid(boolean aoaSubsOnPgMid) {
        this.aoaSubsOnPgMid = aoaSubsOnPgMid;
    }

    public boolean isAutoLoginViaCookie() {
        return this.autoLoginViaCookie;
    }

    public void setAutoLoginViaCookie(boolean autoLoginViaCookie) {
        this.autoLoginViaCookie = autoLoginViaCookie;
    }

    public boolean isAddMoneyFeeAppliedOnWallet() {
        return this.addMoneyFeeAppliedOnWallet;
    }

    public void setAddMoneyFeeAppliedOnWallet(boolean addMoneyFeeAppliedOnWallet) {
        this.addMoneyFeeAppliedOnWallet = addMoneyFeeAppliedOnWallet;
    }

    public Money getPayableAmount() {
        return this.payableAmount;
    }

    public void setPayableAmount(Money payableAmount) {
        this.payableAmount = payableAmount;
    }

    public String getTargetPhoneNo() {
        return this.targetPhoneNo;
    }

    public void setTargetPhoneNo(String targetPhoneNo) {
        this.targetPhoneNo = targetPhoneNo;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getCartValidationRequired() {
        return this.cartValidationRequired;
    }

    public void setCartValidationRequired(String cartValidationRequired) {
        this.cartValidationRequired = cartValidationRequired;
    }

    public String getEmiOption() {
        return this.emiOption;
    }

    public void setEmiOption(String emiOption) {
        this.emiOption = emiOption;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getWebsiteName() {
        return this.websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public Money getTxnAmount() {
        return this.txnAmount;
    }

    public void setTxnAmount(Money txnAmount) {
        this.txnAmount = txnAmount;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getPaytmSsoToken() {
        return this.paytmSsoToken;
    }

    public void setPaytmSsoToken(String paytmSsoToken) {
        this.paytmSsoToken = paytmSsoToken;
    }

    public List<PaymentMode> getEnablePaymentMode() {
        return this.enablePaymentMode;
    }

    public void setEnablePaymentMode(List<PaymentMode> enablePaymentMode) {
        this.enablePaymentMode = enablePaymentMode;
    }

    public List<PaymentMode> getDisablePaymentMode() {
        return this.disablePaymentMode;
    }

    public void setDisablePaymentMode(List<PaymentMode> disablePaymentMode) {
        this.disablePaymentMode = disablePaymentMode;
    }

    public String getPromoCode() {
        return this.promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getCallbackUrl() {
        return this.callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public List<GoodsInfo> getGoods() {
        return this.goods;
    }

    public void setGoods(List<GoodsInfo> goods) {
        this.goods = goods;
    }

    public List<ShippingInfo> getShippingInfo() {
        return this.shippingInfo;
    }

    public void setShippingInfo(List<ShippingInfo> shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public ExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(ExtendInfo extendInfo) {
        this.extendInfo = extendInfo;
    }

    public String getCardTokenRequired() {
        return this.cardTokenRequired;
    }

    public void setCardTokenRequired(String cardTokenRequired) {
        this.cardTokenRequired = cardTokenRequired;
    }

    public CCBillPayment getCcBillPayment() {
        return this.ccBillPayment;
    }

    public void setCcBillPayment(CCBillPayment ccBillPayment) {
        this.ccBillPayment = ccBillPayment;
    }

    public Map<String, String> getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setAdditionalInfo(Map<String, String> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getAggMid() {
        return this.aggMid;
    }

    public void setAggMid(String aggMid) {
        this.aggMid = aggMid;
    }

    public String getValidateAccountNumber() {
        return this.validateAccountNumber;
    }

    public void setValidateAccountNumber(String validateAccountNumber) {
        this.validateAccountNumber = validateAccountNumber;
    }

    public String getAllowUnverifiedAccount() {
        return this.allowUnverifiedAccount;
    }

    public void setAllowUnverifiedAccount(String allowUnverifiedAccount) {
        this.allowUnverifiedAccount = allowUnverifiedAccount;
    }

    public boolean isNativeAddMoney() {
        return this.isNativeAddMoney;
    }

    public void setNativeAddMoney(boolean nativeAddMoney) {
        this.isNativeAddMoney = nativeAddMoney;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCorporateCustId() {
        return this.corporateCustId;
    }

    public void setCorporateCustId(String corporateCustId) {
        this.corporateCustId = corporateCustId;
    }

    public String getbId() {
        return this.bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public PaymentOffer getPaymentOffersApplied() {
        return this.paymentOffersApplied;
    }

    public void setPaymentOffersApplied(PaymentOffer paymentOffersApplied) {
        this.paymentOffersApplied = paymentOffersApplied;
    }

    public String getCardHash() {
        return this.cardHash;
    }

    public void setCardHash(String cardHash) {
        this.cardHash = cardHash;
    }

    public List<String> getEnableUpiPsp() {
        return this.enableUpiPsp;
    }

    public void setEnableUpiPsp(List<String> enableUpiPsp) {
        this.enableUpiPsp = enableUpiPsp;
    }

    public RiskFeeDetails getRiskFeeDetails() {
        return this.riskFeeDetails;
    }

    public void setRiskFeeDetails(RiskFeeDetails riskFeeDetails) {
        this.riskFeeDetails = riskFeeDetails;
    }

    public List<String> getBankAccountNumbers() {
        return this.bankAccountNumbers;
    }

    public void setBankAccountNumbers(List<String> bankAccountNumbers) {
        this.bankAccountNumbers = bankAccountNumbers;
    }

    public String getEmiId() {
        return this.emiId;
    }

    public void setEmiId(String emiId) {
        this.emiId = emiId;
    }

    public SplitSettlementInfo getSplitSettlementInfo() {
        return this.splitSettlementInfo;
    }

    public void setSplitSettlementInfo(SplitSettlementInfo splitSettlementInfo) {
        this.splitSettlementInfo = splitSettlementInfo;
    }

    public String getPEON_URL() {
        return this.PEON_URL;
    }

    public void setPEON_URL(String PEON_URL) {
        this.PEON_URL = PEON_URL;
    }

    public String getEmiSubventionToken() {
        return this.emiSubventionToken;
    }

    public void setEmiSubventionToken(String emiSubventionToken) {
        this.emiSubventionToken = emiSubventionToken;
    }

    public Map<String, Object> getEmiSubventionValidationResponse() {
        return this.emiSubventionValidationResponse;
    }

    public void setEmiSubventionValidationResponse(Map<String, Object> emiSubventionValidationResponse) {
        this.emiSubventionValidationResponse = emiSubventionValidationResponse;
    }

    public String getPreviousOrderId() {
        return this.previousOrderId;
    }

    public void setPreviousOrderId(String previousOrderId) {
        this.previousOrderId = previousOrderId;
    }

    public boolean isOfflineFlow() {
        return this.offlineFlow;
    }

    public void setOfflineFlow(boolean offlineFlow) {
        this.offlineFlow = offlineFlow;
    }

    public OrderPricingInfo getOrderPricingInfo() {
        return this.orderPricingInfo;
    }

    public void setOrderPricingInfo(OrderPricingInfo orderPricingInfo) {
        this.orderPricingInfo = orderPricingInfo;
    }

    public String getAggType() {
        return this.aggType;
    }

    public void setAggType(String aggType) {
        this.aggType = aggType;
    }

    public Map<String, String> getRiskExtendInfo() {
        return this.riskExtendInfo;
    }

    public void setRiskExtendInfo(Map<String, String> riskExtendInfo) {
        this.riskExtendInfo = riskExtendInfo;
    }

    public SimplifiedPaymentOffers getSimplifiedPaymentOffers() {
        return this.simplifiedPaymentOffers;
    }

    public boolean isAuthorized() {
        return this.authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public void setSimplifiedPaymentOffers(SimplifiedPaymentOffers simplifiedPaymentOffers) {
        this.simplifiedPaymentOffers = simplifiedPaymentOffers;
    }

    public boolean isSetSSOViaOptLogin() {
        return this.setSSOViaOptLogin;
    }

    public void setSetSSOViaOptLogin(boolean setSSOViaOptLogin) {
        this.setSSOViaOptLogin = setSSOViaOptLogin;
    }

    public boolean isAppInvoke() {
        return this.appInvoke;
    }

    public void setAppInvoke(boolean appInvoke) {
        this.appInvoke = appInvoke;
    }

    public SplitSettlementInfoData getSplitSettlementInfoData() {
        return this.splitSettlementInfoData;
    }

    public void setSplitSettlementInfoData(SplitSettlementInfoData splitSettlementInfoData) {
        this.splitSettlementInfoData = splitSettlementInfoData;
        this.setSplitSettlementInfo(this.createSplitSettlementInfoFromSplitSettlementInfoData(splitSettlementInfoData));
    }

    public SplitSettlementInfo createSplitSettlementInfoFromSplitSettlementInfoData(SplitSettlementInfoData splitSettlementInfoData) {
        if (splitSettlementInfoData == null) {
            return null;
        } else {
            SplitSettlementInfo splitSettlementInfo = new SplitSettlementInfo();
            splitSettlementInfo.setSplitMethod(splitSettlementInfoData.getSplitMethod());
            List<SplitInfoData> splitInfoDataList = splitSettlementInfoData.getSplitInfo();
            if (splitInfoDataList != null && splitInfoDataList.size() > 0) {
                List<SplitInfo> splitInfoList = new ArrayList(splitSettlementInfoData.getSplitInfo().size());
                Iterator var5 = splitInfoDataList.iterator();

                while(var5.hasNext()) {
                    SplitInfoData splitInfoData = (SplitInfoData)var5.next();
                    SplitInfo splitInfo = new SplitInfo();
                    splitInfo.setAmount(splitInfoData.getAmount());
                    splitInfo.setMid(splitInfoData.getMid());
                    splitInfo.setPercentage(splitInfoData.getPercentage());
                    splitInfoList.add(splitInfo);
                }

                splitSettlementInfo.setSplitInfo(splitInfoList);
            }

            return splitSettlementInfo;
        }
    }

    public TxnType getTxnType() {
        return this.txnType;
    }

    public void setTxnType(TxnType txnType) {
        this.txnType = txnType;
    }

    public String getPreAuthExpiryDate() {
        return this.preAuthExpiryDate;
    }

    public void setPreAuthExpiryDate(String preAuthExpiryDate) {
        this.preAuthExpiryDate = preAuthExpiryDate;
    }

    public boolean isAutoRefund() {
        return this.autoRefund;
    }

    public void setAutoRefund(boolean autoRefund) {
        this.autoRefund = autoRefund;
    }

    public String getPaymodeSequence() {
        return this.paymodeSequence;
    }

    public void setPaymodeSequence(String paymodeSequence) {
        this.paymodeSequence = paymodeSequence;
    }

    public VanInfo getVanInfo() {
        return this.vanInfo;
    }

    public void setVanInfo(VanInfo vanInfo) {
        this.vanInfo = vanInfo;
    }

    public List<TpvInfo> getTpvInfo() {
        return this.tpvInfo;
    }

    public void setTpvInfo(List<TpvInfo> tpvInfo) {
        this.tpvInfo = tpvInfo;
    }

    public EPreAuthType getCardPreAuthType() {
        return this.cardPreAuthType;
    }

    public void setCardPreAuthType(EPreAuthType cardPreAuthType) {
        this.cardPreAuthType = cardPreAuthType;
    }

    public Long getPreAuthBlockSeconds() {
        return this.preAuthBlockSeconds;
    }

    public void setPreAuthBlockSeconds(Long preAuthBlockSeconds) {
        this.preAuthBlockSeconds = preAuthBlockSeconds;
    }

    public PaymentOfferV2 getPaymentOffersAppliedV2() {
        return this.paymentOffersAppliedV2;
    }

    public void setPaymentOffersAppliedV2(PaymentOfferV2 paymentOffersAppliedV2) {
        this.paymentOffersAppliedV2 = paymentOffersAppliedV2;
    }

    public boolean isNeedAppIntentEndpoint() {
        return this.needAppIntentEndpoint;
    }

    public void setNeedAppIntentEndpoint(boolean needAppIntentEndpoint) {
        this.needAppIntentEndpoint = needAppIntentEndpoint;
    }

    public String getAppCallbackUrl() {
        return this.appCallbackUrl;
    }

    public void setAppCallbackUrl(String appCallbackUrl) {
        this.appCallbackUrl = appCallbackUrl;
    }

    public String getBrowserName() {
        return this.browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Money getTipAmount() {
        return this.tipAmount;
    }

    public UltimateBeneficiaryDetails getUltimateBeneficiaryDetails() {
        return this.ultimateBeneficiaryDetails;
    }

    public void setUltimateBeneficiaryDetails(UltimateBeneficiaryDetails ultimateBeneficiaryDetails) {
        this.ultimateBeneficiaryDetails = ultimateBeneficiaryDetails;
    }

    public void setTipAmount(Money tipAmount) {
        this.tipAmount = tipAmount;
    }

    public com.paytm.pgplus.common.model.link.LinkDetailResponseBody getLinkDetailsData() {
        return this.linkDetailsData;
    }

    public void setLinkDetailsData(LinkDetailResponseBody linkDetailsData) {
        this.linkDetailsData = linkDetailsData;
    }

    public List<PayerAccountDetails> getPayerAccountDetails() {
        return this.payerAccountDetails;
    }

    public void setPayerAccountDetails(List<PayerAccountDetails> payerAccountDetails) {
        this.payerAccountDetails = payerAccountDetails;
    }

    public String toString() {
        return (new MaskToStringBuilder(this)).setExcludeFieldNames(new String[]{"bankAccountNumbers", "accountNumber"}).toString();
    }
}

