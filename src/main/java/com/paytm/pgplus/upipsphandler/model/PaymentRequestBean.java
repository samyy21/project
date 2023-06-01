//package com.paytm.pgplus.upipsphandler.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.paytm.pgplus.Annotations.Mask;
//import com.paytm.pgplus.upipsphandler.model.common.CardTokenInfo;
//import com.paytm.pgplus.Annotations.MaskToStringBuilder;
//import com.paytm.pgplus.cache.model.MerchantExtendedInfoResponse;
//import com.paytm.pgplus.common.model.PayerAccountDetails;
//import com.paytm.pgplus.common.model.TpvInfo;
//import com.paytm.pgplus.upipsphandler.model.common.VanInfo;
//import com.paytm.pgplus.common.util.LinkPaymentUtil;
//import com.paytm.pgplus.facade.emisubvention.models.Item;
//import com.paytm.pgplus.facade.exception.FacadeCheckedException;
//import com.paytm.pgplus.facade.payment.models.EMIChannelInfo;
//import com.paytm.pgplus.facade.utils.JsonMapper;
//import com.paytm.pgplus.facade.wallet.models.QRCodeInfoResponseData;
//import com.paytm.pgplus.models.*;
//import com.paytm.pgplus.models.ExtendInfo;
//import com.paytm.pgplus.models.GoodsInfo;
//import com.paytm.pgplus.models.SimplifiedPaymentOffers;
//import com.paytm.pgplus.models.SplitInfoData;
//import com.paytm.pgplus.models.SplitSettlementInfoData;
//import com.paytm.pgplus.models.TwoFAConfig;
//import com.paytm.pgplus.payloadvault.base.ExtraParameterMap;
//import com.paytm.pgplus.payloadvault.theia.enums.UserSubWalletType;
//import com.paytm.pgplus.payloadvault.theia.request.UpiLiteRequestData;
//import com.paytm.pgplus.promo.service.client.model.PromoCodeResponse;
//import org.apache.commons.lang3.ObjectUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.*;
//
//@JsonIgnoreProperties(
//        ignoreUnknown = true
//)
//public class PaymentRequestBean extends ExtraParameterMap implements Serializable {
//    private static final Logger LOGGER = LoggerFactory.getLogger(com.paytm.pgplus.payloadvault.theia.request.PaymentRequestBean.class);
//    private static final TypeReference<HashMap<UserSubWalletType, BigDecimal>> SUBWALLET_TYPE_REF = new TypeReference<HashMap<UserSubWalletType, BigDecimal>>() {
//    };
//    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
//    private static final long serialVersionUID = -2993251646329678295L;
//    private transient HttpServletRequest request;
//    @JsonProperty("REQUEST_TYPE")
//    private String requestType;
//    @JsonProperty("MID")
//    private String mid;
//    @JsonProperty("ORDER_ID")
//    private String orderId;
//    @JsonProperty("CUST_ID")
//    private String custId;
//    @JsonProperty("TXN_AMOUNT")
//    private String txnAmount;
//    @JsonProperty("TIP_AMOUNT")
//    private String tipAmount;
//    @JsonProperty("CHANNEL_ID")
//    private String channelId;
//    @JsonProperty("INDUSTRY_TYPE_ID")
//    private String industryTypeId;
//    @JsonProperty("WEBSITE")
//    private String website;
//    @JsonProperty("CHECKSUMHASH")
//    private String checksumhash;
//    @JsonProperty("MOBILE_NO")
//    @com.paytm.pgplus.Annotations.Mask
//    private String mobileNo;
//    @JsonProperty("EMAIL")
//    private String email;
//    private String authMode;
//    @JsonProperty("PAYMENT_TYPE_ID")
//    private String paymentTypeId;
//    private String cardType;
//    private String bankCode;
//    private String promoCampId;
//    private String orderDetails;
//    private String comments;
//    private String dob;
//    private String pan_Card;
//    private String dlNumber;
//    private String msisdn;
//    private String verified_by;
//    private String isUserVerified;
//    @JsonProperty("ADDRESS_1")
//    private String address1;
//    private String address2;
//    private String city;
//    private String state;
//    @JsonProperty("PINCODE")
//    private String pincode;
//    private String loginTheme;
//    @JsonProperty("CALLBACK_URL")
//    private String callbackUrl;
//    private String theme;
//    @JsonProperty("MERC_UNQ_REF")
//    private String merchUniqueReference;
//    @JsonProperty("UDF_1")
//    private String udf1;
//    @JsonProperty("UDF_2")
//    private String udf2;
//    @JsonProperty("UDF_3")
//    private String udf3;
//    @JsonProperty("ADDITIONAL_INFO")
//    private String additionalInfo;
//    private String cancelPoint;
//    @JsonProperty("payerCmid")
//    private String payerCmid;
//    @com.paytm.pgplus.Annotations.Mask(
//            prefixNoMaskLen = 10,
//            maskStr = "*",
//            suffixNoMaskLen = 4
//    )
//    private String ssoToken;
//    private String paymentMode;
//    @JsonProperty("PAYMENT_MODE_ONLY")
//    private String paymentModeOnly;
//    private String disabledPaymentMode;
//    private String authCode;
//    private String savedCardID;
//    @JsonProperty("PEON_URL")
//    private String peonURL;
//    private String subsPPIOnly;
//    private String subsPaymentMode;
//    private String subscriptionAmountType;
//    private String subscriptionMaxAmount;
//    private String subscriptionServiceID;
//    private String subscriptionID;
//    private String subscriptionFrequency;
//    private String subscriptionFrequencyUnit;
//    private String subscriptionExpiryDate;
//    private String subscriptionEnableRetry;
//    private String subscriptionGraceDays;
//    private String subscriptionStartDate;
//    private String subscriptionRetryCount;
//    private String accountType;
//    @com.paytm.pgplus.Annotations.Mask
//    private String paymentDetails;
//    private String storeCard;
//    @JsonProperty("X-Forwarded-For")
//    private String clientIp;
//    private String merchantKey;
//    private String cardNo;
//    private String cvv;
//    private String expiryDate;
//    private String otp;
//    private String virtualPaymentAddr;
//    private String walletAmount;
//    private String totalAmount;
//    private String invoicePaymentType;
//    private String orderTimeOutMilliSecond;
//    private String alipayMerchantId;
//    private String oAuthState;
//    private String connectiontype;
//    private String checksumString;
//    private Map<String, String> checksumMap;
//    private com.paytm.pgplus.promo.service.client.model.PromoCodeResponse promoCodeResponse;
//    private boolean isSessionRequired = true;
//    private String encParams;
//    private String deviceId;
//    private String deviceSource;
//    private String goodsInfo;
//    private String shippingInfo;
//    private String deviceIdFromCookie;
//    private String isRefund;
//    private boolean promoCodeValid;
//    private String currency;
//    private String appIp;
//    private String riskExtendedInfo;
//    private String isSavedCard;
//    private String isAddMoney;
//    private String validationError;
//    @Mask(
//            prefixNoMaskLen = 6,
//            suffixNoMaskLen = 4
//    )
//    private String paytmToken;
//    private String creditCardBillNo;
//    private String passCode;
//    private String customizeCode;
//    private String successCallbackUrl;
//    private String failureCallbackUrl;
//    private String pendingCallbackUrl;
//    private boolean cardTokenRequired;
//    private String qrMerchantCallbackUrl;
//    private String linkId;
//    private String longUrl;
//    private String shortUrl;
//    private String linkName;
//    private String linkDescription;
//    private boolean merchantLimitEnabled;
//    private boolean merchantLimitUpdated;
//    @JsonProperty("EMI_OPTIONS")
//    private String emiOption;
//    private boolean isOfflineFastForwardRequest;
//    private boolean isOfflineFetchPayApi;
//    @JsonProperty("credsAllowed")
//    private String creditBlock;
//    @JsonProperty("accountNumber")
//    private String accountNumber;
//    @JsonProperty("bank")
//    private String bankName;
//    @JsonProperty("MPIN")
//    private String mpin;
//    @JsonProperty("sequenceNumber")
//    private String seqNo;
//    private boolean isQREnabled;
//    private String iDebitOption;
//    private String invoiceId;
//    private String txnId;
//    private String maskedCustomerMobileNumber;
//    private String posId;
//    private String uniqueReferenceLabel;
//    private String uniqueReferenceValue;
//    private String pccCode;
//    private String prn;
//    private String txnToken;
//    private boolean isCartValidationRequired;
//    private boolean isEmi;
//    private String emiPlanID;
//    private boolean fastForwardRequest;
//    private boolean upiLite;
//    private com.paytm.pgplus.payloadvault.theia.request.UpiLiteRequestData upiLiteRequestData;
//    @JsonProperty("ACCOUNT_REF_ID")
//    private String account_ref_id;
//    @JsonProperty("BUSINESS_ID")
//    private String business_id;
//    private boolean isEncryptedCardDetail;
//    private boolean nativeRetryEnabled;
//    private String nativeRetryErrorMessage;
//    private String walletType;
//    private String amountToBeRefunded;
//    @JsonProperty("appId")
//    private String appId;
//    private Map<UserSubWalletType, BigDecimal> subwalletAmount;
//    private boolean merchantVerifiedChecksum;
//    private boolean checksumVerificationResult;
//    private boolean isEnhancedCashierPageRequest;
//    private String directPayModeType;
//    private String emitype;
//    private String clientId;
//    private String allowUnverifiedAccount;
//    private String aggMid;
//    private String validateAccountNumber;
//    private String additionalInfoMF;
//    private boolean ccBillPaymentRequest;
//    private boolean isSubscription;
//    private boolean isCreateOrderRequired;
//    private String targetPhoneNo;
//    private String addMoneyDestination;
//    private String kycCode;
//    private String kycVersion;
//    private boolean postpaidOnboardingSupported;
//    private int currentPaymentCount;
//    private String userName;
//    private boolean isNativeJsonRequest;
//    private String nativePayAllowed;
//    private boolean nativeOtpSupported;
//    private boolean isDeepLinkRequired;
//    private boolean isDeepLinkFromInsta;
//    private String refUrl;
//    private String txnNote;
//    private boolean showStoreSavecard = true;
//    private boolean isCreateTopupRequired;
//    private boolean isNativeAddMoney;
//    private Map<String, String> additoinalInfoMap;
//    private String internalErrorCode;
//    private com.paytm.pgplus.cache.model.MerchantPreferenceInfoResponse merchantPreferenceInfoResponse;
//    private MerchantExtendedInfoResponse merchantExtendedInfoResponse;
//    private String tokenType;
//    private String workflow;
//    private String bankIFSC;
//    private boolean isMotoPaymentBySubscription;
//    private String mandateType;
//    private String templateId;
//    private String corporateCustId;
//    private String bId;
//    private String cardHash;
//    private boolean isAddMoneyRiskInvolved;
//    private String amountForWalletConsultInRisk;
//    private String amountForPaymentFlow;
//    private boolean enhancedCashierPaymentRequest;
//    private boolean dynamicQrRequired;
//    private boolean gvConsentFlow;
//    private String appVersion;
//    private String merchantRequestedChannelId;
//    private boolean isRiskVerifiedEnhanceFlow;
//    private String securityId;
//    private String promoAmount;
//    @JsonIgnore
//    private SplitSettlementInfo splitSettlementInfo;
//    private String mandateAuthMode;
//    private String mandateBankCode;
//    private boolean autoRenewal;
//    private boolean autoRetry;
//    private boolean communicationManager;
//    private String renewalAmount;
//    private UserInfo userInfo;
//    private com.paytm.pgplus.models.GoodsInfo subsGoodsInfo;
//    private String oneClickInfo;
//    private String paymentFormId;
//    private String linkNotes;
//    private boolean isInternalFetchPaymentOptions;
//    private String guestToken;
//    private String paymentFlowExpectedNative;
//    private List<com.paytm.pgplus.facade.emisubvention.models.Item> items;
//    @JsonProperty("isEmiSubventionRequired")
//    private boolean isEmiSubventionRequired;
//    private String emiSubventedTransactionAmount;
//    private String emiSubventionCustomerId;
//    private String exchangeRate;
//    private String upiAccRefId;
//    private String version;
//    private String originChannel;
//    private String previousOrderId;
//    @JsonIgnoreProperties({"createOrderForInitiateTxnRequest"})
//    private boolean createOrderForInitiateTxnRequest;
//    private com.paytm.pgplus.models.ExtendInfo extendInfo;
//    private String aggType;
//    private OrderPricingInfo orderPricingInfo;
//    private boolean offlineTxnFlow;
//    @JsonProperty("productCode")
//    private String productCode;
//    private boolean mlvSupported;
//    private com.paytm.pgplus.facade.wallet.models.QRCodeInfoResponseData qRCodeInfo;
//    private String queryParams;
//    private Date debitDate;
//    private String accessToken;
//    private String pwpCategory;
//    private boolean prepaidCard;
//    private boolean isExternalFetchPaymentOptions;
//    private String loyaltyPointRootUserId;
//    private String loyaltyPointRootUserPGMid;
//    private com.paytm.pgplus.models.SimplifiedPaymentOffers simplifiedPaymentOffers;
//    private boolean scanAndPayFlow;
//    private String subscriptionPurpose;
//    private boolean parseRiskExtendInfoAsJson;
//    private String applyPaymentOffer;
//    private String fetchAllPaymentOffers;
//    private Boolean isSdkProcessTxnFlow;
//    private String resellerId;
//    private String resellerName;
//    @JsonProperty("splitSettlementInfo")
//    private com.paytm.pgplus.models.SplitSettlementInfoData splitSettlementInfoData;
//    private String merchantLinkRefId;
//    private String osType;
//    private String pspApp;
//    private boolean returnDisabledChannelInFpo;
//    private String initiateTransId;
//    private String preAuthExpiryDate;
//    private boolean preAuth;
//    private boolean isEcomTokenTxn;
//    private String jwtToken;
//    private Map<String, Object> bankTransferDTO;
//    private Map<String, String> linkOrderExtendInfo;
//    private String paytmCustId;
//    private String qrCodeId;
//    private String merchantDisplayName;
//    private boolean dccSelectedByUser;
//    private boolean paymentCallFromDccPage;
//    private String subRequestType;
//    private String subsLinkId;
//    private boolean displayWarningMessageForLink;
//    private boolean flexiSubscription;
//    private boolean autoRefund;
//    private String paymentMid;
//    private String paymentOrderId;
//    private boolean blockNonCCDCPaymodes;
//    private boolean useInvestmentAsFundingSource;
//    private boolean autoDebitRequest;
//    private Boolean isOfflineMerchant;
//    private com.paytm.pgplus.models.TwoFAConfig twoFAConfig;
//    private boolean paymentResumed;
//    private PaymentOffer paymentOffer;
//    private String paymodeSequence;
//    private EmiSubventionInfo emiSubventionInfo;
//    private VanInfo vanInfo;
//    private List<TpvInfo> tpvInfos;
//    private String feesAmount;
//    private String cardPreAuthType;
//    private Long preAuthBlockSeconds;
//    private PaymentOfferV2 paymentOfferV2;
//    private String preferredOtpPage;
//    private boolean needAppIntentEndpoint;
//    private String appCallbackUrl;
//    private String browserName;
//    private String requestedTimeStamp;
//    private boolean upiConvertedToAddNPay;
//    private boolean addNPayOnPostpaidSupported;
//    private boolean appInvoke;
//    private String fromAOARequest;
//    private CoftConsent coftConsent;
//    private boolean isCoftTokenTxn;
//    private boolean returnToken;
//    private CardTokenInfo cardTokenInfo;
//    private String emiSubventionStratergy;
//    private Boolean edcLinkTxn;
//    private com.paytm.pgplus.facade.payment.models.EMIChannelInfo emiChannelInfo;
//    private boolean aoaSubsOnPgMid;
//    private boolean subsAoaPgMidTxn;
//    private String sgwReferenceId;
//    private String type;
//    private com.paytm.pgplus.facade.acquiring.models.UltimateBeneficiaryDetails ultimateBeneficiaryDetails;
//    private String ppblAccountType;
//    private String createNonQRDeepLink;
//    private Boolean addOneRupee;
//    private TwoFADetails twoFADetails;
//    private boolean superGwFpoApiHit;
//    private List<com.paytm.pgplus.common.model.PayerAccountDetails> payerAccountDetails;
//    @JsonProperty("linkDetails")
//    private com.paytm.pgplus.common.model.link.LinkDetailResponseBody linkDetailsData;
//    private String upiIntentLinkId;
//    private boolean isCCOnUPI;
//    private Boolean variableLengthOtpSupported;
//    private String merchantVpa;
//    private boolean isDealsFlow;
//    private boolean orderPSPRequest;
//    private String simSubscriptionId;
//    private boolean isQRIdFlowOnly;
//    private String qrTxnAmountInRupees;
//    private String source;
//    private String dqrLinkId;
//    private String dqrInvoiceId;
//    private boolean isGenerateEsnRequest;
//    private boolean cvvLessTransaction;
//
//    public boolean isAutoDebitRequest() {
//        return this.autoDebitRequest;
//    }
//
//    public void setAutoDebitRequest(boolean autoDebitRequest) {
//        this.autoDebitRequest = autoDebitRequest;
//    }
//
//    public PaymentRequestBean() {
//    }
//
//    public PaymentRequestBean(HttpServletRequest request) {
//        this.request = request;
//        this.requestType = StringUtils.isNotBlank(request.getParameter("REQUEST_TYPE")) ? request.getParameter("REQUEST_TYPE") : "DEFAULT";
//        this.mid = StringUtils.isNotBlank(request.getParameter("MID")) ? request.getParameter("MID") : request.getParameter("mid");
//        this.orderId = StringUtils.isNotBlank(request.getParameter("ORDER_ID")) ? request.getParameter("ORDER_ID") : request.getParameter("orderId");
//        this.custId = request.getParameter("CUST_ID");
//        this.txnAmount = request.getParameter("TXN_AMOUNT");
//        this.tipAmount = request.getParameter("TIP_AMOUNT");
//        this.channelId = request.getParameter("CHANNEL_ID");
//        this.industryTypeId = request.getParameter("INDUSTRY_TYPE_ID") != null ? request.getParameter("INDUSTRY_TYPE_ID") : "NA";
//        this.website = request.getParameter("WEBSITE");
//        this.checksumhash = request.getParameter("CHECKSUMHASH");
//        this.mobileNo = request.getParameter("MOBILE_NO");
//        this.email = request.getParameter("EMAIL");
//        this.authMode = request.getParameter("AUTH_MODE");
//        this.paymentTypeId = request.getParameter("PAYMENT_TYPE_ID");
//        this.cardType = request.getParameter("CARD_TYPE");
//        this.bankCode = this.getBankCodeParameter(request);
//        this.promoCampId = request.getParameter("PROMO_CAMP_ID");
//        this.orderDetails = request.getParameter("ORDER_DETAILS");
//        this.comments = request.getParameter("COMMENTS");
//        this.dob = request.getParameter("DOB");
//        this.pan_Card = request.getParameter("PAN_CARD");
//        this.dlNumber = request.getParameter("DL_NUMBER");
//        this.msisdn = request.getParameter("MSISDN");
//        this.oneClickInfo = request.getParameter("oneClickInfo");
//        this.verified_by = request.getParameter("VERIFIED_BY");
//        this.isUserVerified = request.getParameter("IS_USER_VERIFIED");
//        this.address1 = request.getParameter("ADDRESS_1");
//        this.address2 = request.getParameter("ADDRESS_2");
//        this.city = request.getParameter("CITY");
//        this.state = request.getParameter("STATE");
//        this.pincode = request.getParameter("PINCODE");
//        this.loginTheme = request.getParameter("LOGIN_THEME");
//        this.callbackUrl = request.getParameter("CALLBACK_URL");
//        this.theme = request.getParameter("THEME");
//        this.cancelPoint = request.getParameter("TARGET");
//        this.paymentDetails = request.getParameter("PAYMENT_DETAILS");
//        this.ssoToken = request.getParameter("SSO_TOKEN");
//        this.paytmToken = request.getParameter("PAYTM_TOKEN");
//        this.storeCard = request.getParameter("STORE_CARD");
//        this.paymentMode = request.getParameter("txnMode");
//        this.paymentModeOnly = request.getParameter("PAYMENT_MODE_ONLY");
//        this.disabledPaymentMode = StringUtils.isNotBlank((String)request.getAttribute("PAYMENT_MODE_DISABLE")) ? (String)request.getAttribute("PAYMENT_MODE_DISABLE") : request.getParameter("PAYMENT_MODE_DISABLE");
//        this.authCode = request.getParameter("code");
//        this.savedCardID = request.getParameter("SAVED_CARD_ID");
//        this.subsPaymentMode = request.getParameter("SUBS_PAYMENT_MODE");
//        this.subsPPIOnly = request.getParameter("SUBS_PPI_ONLY");
//        this.subscriptionAmountType = request.getParameter("SUBS_AMOUNT_TYPE");
//        this.subscriptionServiceID = request.getParameter("SUBS_SERVICE_ID");
//        this.subscriptionID = StringUtils.isNotBlank(request.getParameter("SUBS_ID")) ? request.getParameter("SUBS_ID") : request.getParameter("SUBSCRIPTION_ID");
//        this.subscriptionFrequency = request.getParameter("SUBS_FREQUENCY");
//        this.subscriptionFrequencyUnit = request.getParameter("SUBS_FREQUENCY_UNIT");
//        this.subscriptionExpiryDate = request.getParameter("SUBS_EXPIRY_DATE");
//        this.subscriptionEnableRetry = request.getParameter("SUBS_ENABLE_RETRY");
//        this.subscriptionGraceDays = request.getParameter("SUBS_GRACE_DAYS");
//        this.subscriptionStartDate = request.getParameter("SUBS_START_DATE");
//        this.isMotoPaymentBySubscription = StringUtils.isNotBlank(request.getParameter("IS_SUBS_MOTO_PAYMENT")) ? Boolean.valueOf(request.getParameter("IS_SUBS_MOTO_PAYMENT")) : false;
//        this.clientIp = request.getHeader("X-Forwarded-For");
//        this.merchUniqueReference = request.getParameter("MERC_UNQ_REF");
//        this.udf1 = request.getParameter("UDF_1");
//        this.udf2 = request.getParameter("UDF_2");
//        this.udf3 = request.getParameter("UDF_3");
//        this.additionalInfo = request.getParameter("ADDITIONAL_INFO");
//        this.payerCmid = request.getParameter("payerCmid");
//        this.virtualPaymentAddr = request.getParameter("VIRTUAL_PAYMENT_ADDRESS");
//        this.cardNo = request.getParameter("CARD_NO");
//        this.cvv = request.getParameter("CVV");
//        this.expiryDate = request.getParameter("EXPIRY_DATE");
//        this.otp = request.getParameter("otp");
//        this.walletAmount = request.getParameter("WALLET_AMOUNT");
//        this.totalAmount = request.getParameter("TOTAL_AMOUNT");
//        this.peonURL = request.getParameter("PEON_URL");
//        this.invoicePaymentType = request.getParameter("INVOICE_PAYMENT_TYPE");
//        this.orderTimeOutMilliSecond = request.getParameter("ORDER_TIMEOUT_MILLI_SECOND");
//        this.oAuthState = request.getParameter("state");
//        this.subscriptionMaxAmount = request.getParameter("SUBS_MAX_AMOUNT");
//        this.connectiontype = request.getParameter("CONNECTION_TYPE");
//        this.encParams = request.getParameter("ENC_DATA");
//        this.subscriptionRetryCount = request.getParameter("SUBS_RETRY_COUNT");
//        this.creditCardBillNo = request.getParameter("CC_BILL_NO");
//        this.deviceId = request.getParameter("DEVICE_ID");
//        this.deviceSource = request.getParameter("DEVICE_SOURCE");
//        this.goodsInfo = request.getParameter("GOODS_INFO");
//        this.shippingInfo = request.getParameter("SHIPPING_INFO");
//        if (StringUtils.isBlank(this.deviceId) && request.getCookies() != null) {
//            Cookie[] var2 = request.getCookies();
//            int var3 = var2.length;
//
//            for(int var4 = 0; var4 < var3; ++var4) {
//                Cookie cookie = var2[var4];
//                if ("PAYTM_PG".equals(cookie.getName())) {
//                    this.deviceIdFromCookie = cookie.getValue();
//                }
//            }
//        }
//
//        this.riskExtendedInfo = request.getParameter("risk_extended_info");
//        this.isSavedCard = request.getParameter("IS_SAVED_CARD");
//        this.isAddMoney = request.getParameter("addMoney");
//        this.passCode = request.getParameter("PASS_CODE");
//        this.customizeCode = request.getParameter("CUSTOMIZE_CODE");
//        this.emiOption = request.getParameter("EMI_OPTIONS");
//        this.iDebitOption = request.getParameter("IDEBIT_OPTION");
//        this.cardTokenRequired = StringUtils.isNotBlank(request.getParameter("cardTokenRequired")) ? Boolean.valueOf(request.getParameter("cardTokenRequired")) : false;
//        this.creditBlock = request.getParameter("credsAllowed");
//        this.accountNumber = request.getParameter("accountNumber");
//        this.bankName = request.getParameter("bank");
//        this.mpin = request.getParameter("MPIN");
//        this.appId = request.getParameter("appId");
//        this.setLinkId(request.getParameter("LINK_ID"));
//        this.invoiceId = request.getParameter("INVOICE_ID");
//        this.linkDescription = request.getParameter("LINK_DESCRIPTION");
//        this.longUrl = request.getParameter("LONG_URL");
//        this.shortUrl = request.getParameter("SHORT_URL");
//        this.linkName = request.getParameter("LINK_NAME");
//        this.maskedCustomerMobileNumber = request.getParameter("MASKED_CUSTOMER_MOBILE_NUMBER");
//        this.posId = request.getParameter("POS_ID");
//        this.uniqueReferenceLabel = request.getParameter("UNIQUE_REFERENCE_LABEL");
//        this.uniqueReferenceValue = request.getParameter("UNIQUE_REFERENCE_VALUE");
//        this.pccCode = request.getParameter("PCC_CODE");
//        this.prn = request.getParameter("PRN");
//        this.txnId = request.getParameter("TXN_ID");
//        this.seqNo = request.getParameter("sequenceNumber");
//        this.txnToken = request.getParameter("txnToken");
//        if ("EMI".equals(request.getParameter("paymentMode"))) {
//            this.isEmi = true;
//        }
//
//        this.emiPlanID = request.getParameter("planId");
//        if (this.emiPlanID == null) {
//            this.emiPlanID = request.getParameter("emiPlanId");
//        }
//
//        this.account_ref_id = request.getParameter("ACCOUNT_REF_ID");
//        this.business_id = request.getParameter("BUSINESS_ID");
//        this.isEncryptedCardDetail = StringUtils.isNotBlank(request.getParameter("IS_ENCRYPTED_CARD_DETAIL")) ? Boolean.valueOf(request.getParameter("IS_ENCRYPTED_CARD_DETAIL")) : false;
//        this.isCartValidationRequired = StringUtils.isNotBlank(request.getParameter("validationRequired")) ? Boolean.valueOf(request.getParameter("validationRequired")) : false;
//        this.txnToken = request.getParameter("txnToken");
//        this.walletType = request.getParameter("walletType");
//        this.accountType = request.getParameter("ACCOUNT_TYPE");
//        this.directPayModeType = request.getParameter("DIRECT_PAYMODE_TYPE");
//        this.setSubwalletAmount(request.getParameter("subwalletAmount"));
//        this.emitype = request.getParameter("EMI_TYPE");
//        this.clientId = request.getParameter("CLIENTID");
//        this.ccBillPaymentRequest = Boolean.valueOf(request.getParameter("ccBillPaymentRequest"));
//        if ("CC_BILL_PAYMENT".equals(this.requestType)) {
//            this.ccBillPaymentRequest = true;
//        }
//
//        this.allowUnverifiedAccount = request.getParameter("allowUnverifiedAccount");
//        this.aggMid = request.getParameter("aggMid");
//        this.validateAccountNumber = request.getParameter("validateAccountNumber");
//        this.additionalInfoMF = request.getParameter("additionalInfo");
//        this.isNativeJsonRequest = Boolean.valueOf(request.getParameter("nativeJsonRequest"));
//        this.kycCode = request.getParameter("kycCode");
//        this.kycVersion = request.getParameter("kycVersion");
//        this.postpaidOnboardingSupported = Boolean.valueOf(request.getParameter("postpaidOnboardingSupported"));
//        this.targetPhoneNo = request.getParameter("targetPhoneNo");
//        this.addMoneyDestination = request.getParameter("addMoneyDestination");
//        this.bankIFSC = request.getParameter("bankIfsc");
//        this.isDeepLinkRequired = Boolean.valueOf(request.getParameter("isDeepLinkReq"));
//        this.isDeepLinkFromInsta = Boolean.valueOf(request.getParameter("INSTA_DEEPLINK"));
//        this.refUrl = request.getParameter("refUrl");
//        this.txnNote = request.getParameter("txnNote");
//        this.tokenType = request.getParameter("tokenType");
//        this.isNativeAddMoney = Boolean.valueOf(request.getParameter("isNativeAddMoney"));
//        this.templateId = request.getParameter("templateId");
//        this.corporateCustId = request.getParameter("corporateCustId");
//        this.bId = request.getParameter("bId");
//        this.workflow = request.getAttribute("workFlow") != null ? (String)request.getAttribute("workFlow") : request.getParameter("workFlow");
//        this.cardHash = request.getParameter("cardHash");
//        this.userName = request.getParameter("USER_NAME");
//        this.enhancedCashierPaymentRequest = Boolean.valueOf(request.getParameter("enhancedCashierPaymentRequest"));
//        this.isAddMoneyRiskInvolved = Boolean.valueOf(request.getParameter("isAddMoneyRiskInvolved"));
//        this.gvConsentFlow = Boolean.valueOf(request.getParameter("GV_CONSENT_FLOW"));
//        this.merchantRequestedChannelId = request.getParameter("merchantRequestedChannelId");
//        this.autoRenewal = Boolean.valueOf(request.getParameter("isAutoRenewal"));
//        this.autoRetry = Boolean.valueOf(request.getParameter("isAutoRetry"));
//        this.communicationManager = Boolean.valueOf(request.getParameter("isCommunicationManager"));
//        this.renewalAmount = request.getParameter("renewalAmount");
//
//        try {
//            if (StringUtils.isNotBlank(request.getParameter("subscriptionGoodsInfo"))) {
//                this.subsGoodsInfo = (com.paytm.pgplus.models.GoodsInfo) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("subscriptionGoodsInfo"), com.paytm.pgplus.models.GoodsInfo.class);
//            }
//        } catch (FacadeCheckedException var17) {
//            LOGGER.error("error occurred while parsing subscriptionGoodsInfo");
//        }
//
//        try {
//            if (StringUtils.isNotBlank(request.getParameter("extendInfo"))) {
//                this.extendInfo = (com.paytm.pgplus.models.ExtendInfo) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("extendInfo"), com.paytm.pgplus.models.ExtendInfo.class);
//            }
//        } catch (FacadeCheckedException var16) {
//            LOGGER.error("error occurred while parsing ExtendedInfo extendInfo {}, Error: {}", request.getParameter("extendInfo"), var16.getMessage());
//        }
//
//        this.isRiskVerifiedEnhanceFlow = Boolean.valueOf(request.getParameter("isRiskVerifiedEnhanceFlow"));
//        this.securityId = request.getParameter("securityId");
//        this.mandateAuthMode = request.getParameter("mandateAuthMode");
//        this.promoAmount = request.getParameter("promoAmount");
//        this.guestToken = request.getParameter("guestToken");
//        this.upiAccRefId = request.getParameter("upiAccRefId");
//        this.originChannel = request.getParameter("origin-channel");
//        this.appVersion = request.getParameter("appVersion");
//        this.paymentFlowExpectedNative = request.getParameter("paymentFlowExpectedNative");
//        this.aggType = request.getParameter("aggType");
//        if (StringUtils.isNotEmpty(request.getParameter("orderPricingInfo"))) {
//            try {
//                this.orderPricingInfo = (OrderPricingInfo) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("orderPricingInfo"), OrderPricingInfo.class);
//            } catch (FacadeCheckedException var15) {
//                LOGGER.error("Error while parsing ORDER_PRICING_INFO");
//            }
//        }
//
//        this.offlineTxnFlow = Boolean.valueOf(request.getParameter("offlineTxnFlow"));
//        this.productCode = request.getParameter("productCode");
//        this.queryParams = request.getQueryString();
//        String debitDate = null != request.getAttribute("debitDate") ? (String)request.getAttribute("debitDate") : "";
//        if (StringUtils.isNotBlank(debitDate)) {
//            this.debitDate = new Date(debitDate);
//        }
//
//        this.pwpCategory = request.getParameter("pwpCategory");
//        if (StringUtils.isNotEmpty(request.getParameter("simplifiedPaymentOffers"))) {
//            try {
//                this.simplifiedPaymentOffers = (com.paytm.pgplus.models.SimplifiedPaymentOffers) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("simplifiedPaymentOffers"), com.paytm.pgplus.models.SimplifiedPaymentOffers.class);
//            } catch (FacadeCheckedException var14) {
//                LOGGER.error("Error while parsing SIMPLIFIED_PAYMENT_OFFER");
//            }
//        }
//
//        this.scanAndPayFlow = Boolean.valueOf(request.getParameter("scanAndPayFlow"));
//        this.mandateType = request.getParameter("mandateBankCode");
//        this.subscriptionPurpose = request.getParameter("subscriptionPurpose");
//        this.applyPaymentOffer = request.getParameter("applyPaymentOffer");
//        this.fetchAllPaymentOffers = request.getParameter("fetchAllPaymentOffers");
//        this.subRequestType = request.getParameter("subRequestType");
//        if (StringUtils.isNotEmpty(request.getParameter("linkDetails"))) {
//            try {
//                this.linkDetailsData = (com.paytm.pgplus.common.model.link.LinkDetailResponseBody) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("linkDetails"), com.paytm.pgplus.common.model.link.LinkDetailResponseBody.class);
//            } catch (FacadeCheckedException var13) {
//                LOGGER.error("Error while parsing LINK_DETAILS");
//            }
//        }
//
//        this.isSdkProcessTxnFlow = (Boolean)request.getAttribute("sdkProcessTxnFlow");
//        this.osType = request.getParameter("osType");
//        this.pspApp = request.getParameter("pspApp");
//        this.initiateTransId = (String)request.getAttribute("initiateTransId");
//        this.preAuthExpiryDate = request.getParameter("preAuthExpiryDate");
//        this.preAuth = Boolean.parseBoolean(request.getParameter("preAuth"));
//        this.paymentResumed = Boolean.parseBoolean(request.getParameter("paymentResumed"));
//        this.type = request.getParameter("type");
//        this.upiLite = Boolean.parseBoolean(request.getParameter("isupilite"));
//        this.setDefaults(request);
//        this.merchantDisplayName = request.getParameter("merchantDisplayName");
//        this.subsLinkId = request.getParameter("subsLinkId");
//        this.isOfflineMerchant = StringUtils.isNotBlank(request.getParameter("isOfflineMerchant")) ? Boolean.valueOf(request.getParameter("isOfflineMerchant")) : null;
//        if (StringUtils.isNotEmpty(request.getParameter("paymentOffersApplied"))) {
//            try {
//                this.paymentOffer = (PaymentOffer) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("paymentOffersApplied"), PaymentOffer.class);
//            } catch (FacadeCheckedException var12) {
//                LOGGER.error("Error while parsing payment offers applied");
//            }
//        } else if (StringUtils.isNotEmpty(request.getParameter("paymentOffersAppliedV2"))) {
//            try {
//                this.paymentOfferV2 = (PaymentOfferV2) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("paymentOffersAppliedV2"), PaymentOfferV2.class);
//            } catch (FacadeCheckedException var11) {
//                LOGGER.error("Error while parsing payment offers v2 applied");
//            }
//        }
//
//        if (StringUtils.isNotEmpty(request.getParameter("vanInfo"))) {
//            try {
//                this.vanInfo = (VanInfo) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("vanInfo"), VanInfo.class);
//            } catch (FacadeCheckedException var10) {
//                LOGGER.error("Error while parsing Van Info For Van Checkout flow");
//            }
//        }
//
//        if (StringUtils.isNotEmpty(request.getParameter("tpvInfos"))) {
//            try {
//                this.tpvInfos = (List) com.paytm.pgplus.facade.utils.JsonMapper.readValue(request.getParameter("tpvInfos"), new TypeReference<List<TpvInfo>>() {
//                });
//            } catch (IOException var9) {
//                LOGGER.error("Error while parsing Tpv Info For bank transfer flow");
//            }
//        }
//
//        if (request.getParameter("cardPreAuthType") != null) {
//            this.cardPreAuthType = request.getParameter("cardPreAuthType");
//        }
//
//        if (request.getParameter("PreAuthBlockSeconds") != null) {
//            this.preAuthBlockSeconds = Long.valueOf(request.getParameter("PreAuthBlockSeconds"));
//        }
//
//        this.preferredOtpPage = request.getParameter("preferredOtpPage");
//        this.needAppIntentEndpoint = Boolean.TRUE.equals(request.getAttribute("needAppIntentEndpoint"));
//        this.appCallbackUrl = request.getParameter("appCallbackUrl");
//        this.browserName = request.getParameter("browserName");
//        this.requestedTimeStamp = request.getParameter("requestedTimeStamp");
//        if (this.getExtraParamsMap() == null) {
//            this.setExtraParamsMap(new HashMap());
//        }
//
//        if (request.getParameter("challanIdNum") != null) {
//            this.getExtraParamsMap().put("challanIdNum", request.getParameter("challanIdNum"));
//        }
//
//        if (request.getParameter("upiLiteRequestData") != null) {
//            try {
//                this.upiLiteRequestData = (com.paytm.pgplus.payloadvault.theia.request.UpiLiteRequestData) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("upiLiteRequestData"), com.paytm.pgplus.payloadvault.theia.request.UpiLiteRequestData.class);
//            } catch (Exception var8) {
//                LOGGER.error("Failed for parse upiLiteRequestData");
//            }
//        }
//
//        if (StringUtils.isNotBlank(request.getParameter("ultimateBeneficiaryName"))) {
//            this.ultimateBeneficiaryDetails = new com.paytm.pgplus.facade.acquiring.models.UltimateBeneficiaryDetails(request.getParameter("ultimateBeneficiaryName"));
//        }
//
//        if (StringUtils.isNotEmpty(request.getParameter("payerAccountDetails"))) {
//            try {
//                this.payerAccountDetails = (List) com.paytm.pgplus.facade.utils.JsonMapper.readValue(request.getParameter("payerAccountDetails"), new TypeReference<List<com.paytm.pgplus.common.model.PayerAccountDetails>>() {
//                });
//            } catch (IOException var7) {
//                LOGGER.error("Error while parsing PayerAccountDetails For bank transfer flow");
//            }
//        }
//
//        if (StringUtils.isNotBlank(request.getParameter("ppblAccountType"))) {
//            this.ppblAccountType = request.getParameter("ppblAccountType");
//        }
//
//        this.createNonQRDeepLink = request.getParameter("createNonQRDeepLink");
//        if (StringUtils.isNotEmpty(request.getParameter("twoFAConfig"))) {
//            try {
//                this.twoFAConfig = (com.paytm.pgplus.models.TwoFAConfig) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("twoFAConfig"), com.paytm.pgplus.models.TwoFAConfig.class);
//            } catch (FacadeCheckedException var6) {
//                LOGGER.error("Error while parsing TWO_FA_CONFIG Object");
//            }
//        }
//
//        this.addOneRupee = Boolean.valueOf(request.getParameter("addOneRupee"));
//        if (request.getParameter("variableLengthOtpSupported") != null) {
//            this.variableLengthOtpSupported = Boolean.parseBoolean(request.getParameter("variableLengthOtpSupported"));
//        }
//
//        if (StringUtils.isNotBlank(request.getParameter("merchantVpa"))) {
//            this.merchantVpa = request.getParameter("merchantVpa");
//        }
//
//        if (StringUtils.isNotBlank(request.getParameter("isQRIdFlowOnly"))) {
//            this.isQRIdFlowOnly = Boolean.parseBoolean(request.getParameter("isQRIdFlowOnly"));
//        }
//
//        this.simSubscriptionId = request.getParameter("simSubscriptionId");
//        if (request.getParameter("source") != null) {
//            this.source = request.getParameter("source");
//        }
//
//        this.simSubscriptionId = request.getParameter("simSubscriptionId");
//        this.cvvLessTransaction = Boolean.parseBoolean(request.getParameter("isCvvLessTransaction"));
//    }
//
//    public String getPaymentFlowExpectedNative() {
//        return this.paymentFlowExpectedNative;
//    }
//
//    public void setPaymentFlowExpectedNative(String paymentFlowExpectedNative) {
//        this.paymentFlowExpectedNative = paymentFlowExpectedNative;
//        this.previousOrderId = this.request.getParameter("previousOrderId");
//    }
//
//    public String getTargetPhoneNo() {
//        return this.targetPhoneNo;
//    }
//
//    public void setTargetPhoneNo(String targetPhoneNo) {
//        this.targetPhoneNo = targetPhoneNo;
//    }
//
//    public String getAddMoneyDestination() {
//        return this.addMoneyDestination;
//    }
//
//    public void setAddMoneyDestination(String addMoneyDestination) {
//        this.addMoneyDestination = addMoneyDestination;
//    }
//
//    public String getRiskExtendedInfo() {
//        return this.riskExtendedInfo;
//    }
//
//    public void setRiskExtendedInfo(String riskExtendedInfo) {
//        this.riskExtendedInfo = riskExtendedInfo;
//    }
//
//    public boolean isUpiLite() {
//        return this.upiLite;
//    }
//
//    public void setUpiLite(boolean upiLite) {
//        this.upiLite = upiLite;
//    }
//
//    public PaymentRequestBean(HttpServletRequest request, boolean getFromAttribute) {
//        this.request = request;
//        this.requestType = StringUtils.isNotBlank((String)request.getAttribute("REQUEST_TYPE")) ? (String)request.getAttribute("REQUEST_TYPE") : "DEFAULT";
//        this.mid = (String)request.getAttribute("MID");
//        this.orderId = (String)request.getAttribute("ORDER_ID");
//        this.custId = (String)request.getAttribute("CUST_ID");
//        this.txnAmount = (String)request.getAttribute("TXN_AMOUNT");
//        this.tipAmount = (String)request.getAttribute("TIP_AMOUNT");
//        this.channelId = (String)request.getAttribute("CHANNEL_ID");
//        this.industryTypeId = request.getParameter("INDUSTRY_TYPE_ID") != null ? request.getParameter("INDUSTRY_TYPE_ID") : "NA";
//        this.website = (String)request.getAttribute("WEBSITE");
//        this.checksumhash = (String)request.getAttribute("CHECKSUMHASH");
//        this.mobileNo = (String)request.getAttribute("MOBILE_NO");
//        this.email = (String)request.getAttribute("EMAIL");
//        this.authMode = (String)request.getAttribute("AUTH_MODE");
//        this.paymentTypeId = (String)request.getAttribute("PAYMENT_TYPE_ID");
//        this.cardType = (String)request.getAttribute("CARD_TYPE");
//        this.bankCode = (String)request.getAttribute("BANK_CODE");
//        this.promoCampId = (String)request.getAttribute("PROMO_CAMP_ID");
//        this.orderDetails = (String)request.getAttribute("ORDER_DETAILS");
//        this.comments = (String)request.getAttribute("COMMENTS");
//        this.dob = (String)request.getAttribute("DOB");
//        this.pan_Card = (String)request.getAttribute("PAN_CARD");
//        this.dlNumber = (String)request.getAttribute("DL_NUMBER");
//        this.msisdn = (String)request.getAttribute("MSISDN");
//        this.address1 = (String)request.getAttribute("ADDRESS_1");
//        this.address2 = (String)request.getAttribute("ADDRESS_2");
//        this.city = (String)request.getAttribute("CITY");
//        this.state = (String)request.getAttribute("STATE");
//        this.pincode = (String)request.getAttribute("PINCODE");
//        this.loginTheme = (String)request.getAttribute("LOGIN_THEME");
//        this.callbackUrl = (String)request.getAttribute("CALLBACK_URL");
//        this.theme = (String)request.getAttribute("THEME");
//        this.cancelPoint = (String)request.getAttribute("TARGET");
//        this.paymentDetails = (String)request.getAttribute("PAYMENT_DETAILS");
//        this.ssoToken = (String)request.getAttribute("SSO_TOKEN");
//        this.paytmToken = (String)request.getAttribute("PAYTM_TOKEN");
//        this.storeCard = (String)request.getAttribute("STORE_CARD");
//        this.paymentMode = (String)request.getAttribute("txnMode");
//        this.paymentModeOnly = (String)request.getAttribute("PAYMENT_MODE_ONLY");
//        this.disabledPaymentMode = (String)request.getAttribute("PAYMENT_MODE_DISABLE");
//        this.authCode = (String)request.getAttribute("code");
//        this.savedCardID = (String)request.getAttribute("SAVED_CARD_ID");
//        this.subsPaymentMode = (String)request.getAttribute("SUBS_PAYMENT_MODE");
//        this.subsPPIOnly = (String)request.getAttribute("SUBS_PPI_ONLY");
//        this.subscriptionAmountType = (String)request.getAttribute("SUBS_AMOUNT_TYPE");
//        this.subscriptionServiceID = (String)request.getAttribute("SUBS_SERVICE_ID");
//        this.subscriptionID = StringUtils.isNotBlank(request.getParameter("SUBS_ID")) ? request.getParameter("SUBS_ID") : request.getParameter("SUBSCRIPTION_ID");
//        this.subscriptionFrequency = (String)request.getAttribute("SUBS_FREQUENCY");
//        this.subscriptionFrequencyUnit = (String)request.getAttribute("SUBS_FREQUENCY_UNIT");
//        this.subscriptionExpiryDate = (String)request.getAttribute("SUBS_EXPIRY_DATE");
//        this.subscriptionEnableRetry = (String)request.getAttribute("SUBS_ENABLE_RETRY");
//        this.subscriptionGraceDays = (String)request.getAttribute("SUBS_GRACE_DAYS");
//        this.subscriptionStartDate = (String)request.getAttribute("SUBS_START_DATE");
//        this.clientIp = request.getHeader("X-Forwarded-For");
//        this.merchUniqueReference = (String)request.getAttribute("MERC_UNQ_REF");
//        this.udf1 = (String)request.getAttribute("UDF_1");
//        this.udf2 = (String)request.getAttribute("UDF_2");
//        this.udf3 = (String)request.getAttribute("UDF_3");
//        this.additionalInfo = (String)request.getAttribute("ADDITIONAL_INFO");
//        this.payerCmid = (String)request.getAttribute("payerCmid");
//        this.virtualPaymentAddr = (String)request.getAttribute("VIRTUAL_PAYMENT_ADDRESS");
//        this.cardNo = (String)request.getAttribute("CARD_NO");
//        this.cvv = (String)request.getAttribute("CVV");
//        this.expiryDate = (String)request.getAttribute("EXPIRY_DATE");
//        this.otp = (String)request.getAttribute("otp");
//        this.walletAmount = (String)request.getAttribute("WALLET_AMOUNT");
//        this.totalAmount = (String)request.getAttribute("TOTAL_AMOUNT");
//        this.peonURL = (String)request.getAttribute("PEON_URL");
//        this.invoicePaymentType = (String)request.getAttribute("INVOICE_PAYMENT_TYPE");
//        this.orderTimeOutMilliSecond = (String)request.getAttribute("ORDER_TIMEOUT_MILLI_SECOND");
//        this.oAuthState = (String)request.getAttribute("state");
//        this.subscriptionMaxAmount = (String)request.getAttribute("SUBS_MAX_AMOUNT");
//        this.connectiontype = (String)request.getAttribute("CONNECTION_TYPE");
//        this.encParams = (String)request.getAttribute("ENC_DATA");
//        this.subscriptionRetryCount = (String)request.getAttribute("SUBS_RETRY_COUNT");
//        this.creditCardBillNo = (String)request.getAttribute("CC_BILL_NO");
//        this.deviceId = (String)request.getAttribute("DEVICE_ID");
//        this.deviceSource = (String)request.getAttribute("DEVICE_SOURCE");
//        this.goodsInfo = (String)request.getAttribute("GOODS_INFO");
//        this.shippingInfo = (String)request.getAttribute("SHIPPING_INFO");
//        if (StringUtils.isBlank(this.deviceId) && request.getCookies() != null) {
//            Cookie[] var3 = request.getCookies();
//            int var4 = var3.length;
//
//            for(int var5 = 0; var5 < var4; ++var5) {
//                Cookie cookie = var3[var5];
//                if ("PAYTM_PG".equals(cookie.getName())) {
//                    this.deviceIdFromCookie = cookie.getValue();
//                }
//            }
//        }
//
//        this.riskExtendedInfo = (String)request.getAttribute("risk_extended_info");
//        this.directPayModeType = (String)request.getAttribute("DIRECT_PAYMODE_TYPE");
//        this.isSavedCard = (String)request.getAttribute("IS_SAVED_CARD");
//        this.isAddMoney = (String)request.getAttribute("addMoney");
//        this.passCode = (String)request.getAttribute("PASS_CODE");
//        this.customizeCode = (String)request.getAttribute("CUSTOMIZE_CODE");
//        this.successCallbackUrl = request.getParameter("SUCCESS_CALLBACK_URL");
//        this.failureCallbackUrl = request.getParameter("FAILURE_CALLBACK_URL");
//        this.pendingCallbackUrl = request.getParameter("PENDING_CALLBACK_URL");
//        this.setLinkId(request.getParameter("LINK_ID"));
//        this.linkDescription = request.getParameter("LINK_DESCRIPTION");
//        this.longUrl = request.getParameter("LONG_URL");
//        this.shortUrl = request.getParameter("SHORT_URL");
//        this.linkName = request.getParameter("LINK_NAME");
//        this.emiOption = request.getParameter("EMI_OPTIONS");
//        this.iDebitOption = (String)request.getAttribute("IDEBIT_OPTION");
//        this.maskedCustomerMobileNumber = request.getParameter("MASKED_CUSTOMER_MOBILE_NUMBER");
//        this.posId = request.getParameter("POS_ID");
//        this.uniqueReferenceLabel = request.getParameter("UNIQUE_REFERENCE_LABEL");
//        this.uniqueReferenceValue = request.getParameter("UNIQUE_REFERENCE_VALUE");
//        this.pccCode = request.getParameter("PCC_CODE");
//        this.prn = request.getParameter("PRN");
//        this.txnId = request.getParameter("TXN_ID");
//        this.txnToken = request.getParameter("txnToken");
//        this.isCartValidationRequired = request.getAttribute("validationRequired") != null && StringUtils.isNotBlank((String)request.getAttribute("validationRequired")) ? Boolean.valueOf((String)request.getAttribute("validationRequired")) : false;
//        this.clientId = request.getParameter("CLIENTID");
//        this.ccBillPaymentRequest = Boolean.valueOf((String)request.getAttribute("ccBillPaymentRequest"));
//        if ("CC_BILL_PAYMENT".equals(this.requestType)) {
//            this.ccBillPaymentRequest = true;
//        }
//
//        this.allowUnverifiedAccount = (String)request.getAttribute("allowUnverifiedAccount");
//        this.aggMid = (String)request.getAttribute("aggMid");
//        this.validateAccountNumber = (String)request.getAttribute("validateAccountNumber");
//        this.kycCode = (String)request.getAttribute("kycCode");
//        this.kycVersion = (String)request.getAttribute("kycVersion");
//        this.postpaidOnboardingSupported = Boolean.valueOf(String.valueOf(request.getAttribute("postpaidOnboardingSupported")));
//        this.isNativeAddMoney = Boolean.valueOf((String)request.getAttribute("isNativeAddMoney"));
//        this.gvConsentFlow = Boolean.valueOf((String)request.getAttribute("GV_CONSENT_FLOW"));
//        this.isRiskVerifiedEnhanceFlow = Boolean.valueOf((String)request.getAttribute("isRiskVerifiedEnhanceFlow"));
//        this.securityId = (String)request.getAttribute("securityId");
//        this.bankIFSC = request.getParameter("bankIfsc");
//        this.mandateAuthMode = request.getParameter("mandateAuthMode");
//        this.upiAccRefId = request.getParameter("upiAccRefId");
//        this.appVersion = (String)request.getAttribute("appVersion");
//        this.originChannel = (String)request.getAttribute("origin-channel");
//        this.aggType = request.getParameter("aggType");
//        if (StringUtils.isNotEmpty(request.getParameter("orderPricingInfo"))) {
//            try {
//                this.orderPricingInfo = (OrderPricingInfo) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("orderPricingInfo"), OrderPricingInfo.class);
//            } catch (FacadeCheckedException var12) {
//                LOGGER.error("Error while parsing ORDER_PRICING_INFO");
//            }
//        }
//
//        this.offlineTxnFlow = Boolean.valueOf(request.getParameter("offlineTxnFlow"));
//        this.productCode = (String)request.getAttribute("productCode");
//        this.queryParams = request.getQueryString();
//        String debitDate = null != request.getAttribute("debitDate") ? (String)request.getAttribute("debitDate") : "";
//        if (StringUtils.isNotBlank(debitDate)) {
//            this.debitDate = new Date(debitDate);
//        }
//
//        if (StringUtils.isNotEmpty(request.getParameter("simplifiedPaymentOffers"))) {
//            try {
//                this.simplifiedPaymentOffers = (com.paytm.pgplus.models.SimplifiedPaymentOffers) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("simplifiedPaymentOffers"), com.paytm.pgplus.models.SimplifiedPaymentOffers.class);
//            } catch (FacadeCheckedException var11) {
//                LOGGER.error("Error while parsing SIMPLIFIED_PAYMENT_OFFER");
//            }
//        }
//
//        if (StringUtils.isNotEmpty(request.getParameter("linkDetails"))) {
//            try {
//                this.linkDetailsData = (com.paytm.pgplus.common.model.link.LinkDetailResponseBody) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("linkDetails"), com.paytm.pgplus.common.model.link.LinkDetailResponseBody.class);
//            } catch (FacadeCheckedException var10) {
//                LOGGER.error("Error while parsing LINK_DETAILS");
//            }
//        }
//
//        this.subRequestType = request.getParameter("subRequestType");
//        this.mandateType = request.getParameter("mandateBankCode");
//        this.subscriptionPurpose = request.getParameter("subscriptionPurpose");
//        this.isSdkProcessTxnFlow = (Boolean)request.getAttribute("sdkProcessTxnFlow");
//        this.osType = request.getParameter("osType");
//        this.pspApp = request.getParameter("pspApp");
//        this.paymentResumed = Boolean.parseBoolean(request.getParameter("paymentResumed"));
//        this.upiLite = Boolean.parseBoolean(request.getParameter("isupilite"));
//        if (request.getAttribute("dynamicQrRequired") != null) {
//            this.dynamicQrRequired = (Boolean)request.getAttribute("dynamicQrRequired");
//        }
//
//        this.preAuthExpiryDate = request.getParameter("validityEndDate");
//        this.setDefaults(request);
//        this.merchantDisplayName = request.getParameter("merchantDisplayName");
//        this.isOfflineMerchant = StringUtils.isNotBlank(request.getParameter("isOfflineMerchant")) ? Boolean.valueOf(request.getParameter("isOfflineMerchant")) : null;
//        if (StringUtils.isNotEmpty(request.getParameter("paymentOffersApplied"))) {
//            try {
//                this.paymentOffer = (PaymentOffer) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("paymentOffersApplied"), PaymentOffer.class);
//            } catch (FacadeCheckedException var9) {
//                LOGGER.error("Error while parsing payment offers applied");
//            }
//        } else if (StringUtils.isNotEmpty(request.getParameter("paymentOffersAppliedV2"))) {
//            try {
//                this.paymentOfferV2 = (PaymentOfferV2) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("paymentOffersApplied"), PaymentOfferV2.class);
//            } catch (FacadeCheckedException var8) {
//                LOGGER.error("Error while parsing payment offers v2 applied");
//            }
//        }
//
//        this.cardPreAuthType = (String)request.getAttribute("cardPreAuthType");
//        this.preAuthBlockSeconds = (Long)request.getAttribute("PreAuthBlockSeconds");
//        if (ObjectUtils.notEqual(request.getAttribute("ultimateBeneficiaryName"), (Object)null)) {
//            this.ultimateBeneficiaryDetails = new com.paytm.pgplus.facade.acquiring.models.UltimateBeneficiaryDetails((String)request.getAttribute("ultimateBeneficiaryName"));
//        }
//
//        if (ObjectUtils.notEqual(request.getAttribute("createNonQRDeepLink"), (Object)null)) {
//            this.createNonQRDeepLink = (String)request.getAttribute("createNonQRDeepLink");
//        }
//
//        if (StringUtils.isNotEmpty(request.getParameter("twoFAConfig"))) {
//            try {
//                this.twoFAConfig = (com.paytm.pgplus.models.TwoFAConfig) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("twoFAConfig"), com.paytm.pgplus.models.TwoFAConfig.class);
//            } catch (FacadeCheckedException var7) {
//                LOGGER.error("Error while parsing TWO_FA_CONFIG Object");
//            }
//        }
//
//        this.addOneRupee = Boolean.valueOf(request.getParameter("addOneRupee"));
//        if (request.getParameter("variableLengthOtpSupported") != null) {
//            this.variableLengthOtpSupported = Boolean.parseBoolean(request.getParameter("variableLengthOtpSupported"));
//        }
//
//        this.simSubscriptionId = request.getParameter("simSubscriptionId");
//        if (request.getParameter("source") != null) {
//            this.source = request.getParameter("source");
//        }
//
//    }
//
//    private String getBankCodeParameter(HttpServletRequest request) {
//        String bankCode = request.getParameter("BANK_CODE");
//        return StringUtils.isBlank(bankCode) && "PAYTM_EXPRESS".equals(request.getParameter("REQUEST_TYPE")) ? request.getParameter("emiBankName") : bankCode;
//    }
//
//    public String getCreditBlock() {
//        return this.creditBlock;
//    }
//
//    public String getAccountNumber() {
//        return this.accountNumber;
//    }
//
//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public String getBankName() {
//        return this.bankName;
//    }
//
//    public void setBankName(String bankName) {
//        this.bankName = bankName;
//    }
//
//    public String getMpin() {
//        return this.mpin;
//    }
//
//    public String getIsAddMoney() {
//        return this.isAddMoney;
//    }
//
//    public boolean isCardTokenRequired() {
//        return this.cardTokenRequired;
//    }
//
//    public void setiDebitOption(String iDebitOption) {
//        this.iDebitOption = iDebitOption;
//    }
//
//    public String getTxnId() {
//        return this.txnId;
//    }
//
//    public void setTxnId(String txnId) {
//        this.txnId = txnId;
//    }
//
//    public String getSuccessCallbackUrl() {
//        return this.successCallbackUrl;
//    }
//
//    public void setSuccessCallbackUrl(String successCallbackUrl) {
//        this.successCallbackUrl = successCallbackUrl;
//    }
//
//    public String getFailureCallbackUrl() {
//        return this.failureCallbackUrl;
//    }
//
//    public void setFailureCallbackUrl(String failureCallbackUrl) {
//        this.failureCallbackUrl = failureCallbackUrl;
//    }
//
//    public String getPendingCallbackUrl() {
//        return this.pendingCallbackUrl;
//    }
//
//    public void setPendingCallbackUrl(String pendingCallbackUrl) {
//        this.pendingCallbackUrl = pendingCallbackUrl;
//    }
//
//    public boolean getCardTokenRequired() {
//        return this.cardTokenRequired;
//    }
//
//    public void setCardTokenRequired(boolean cardTokenRequired) {
//        this.cardTokenRequired = cardTokenRequired;
//    }
//
//    public String getValidationError() {
//        return this.validationError;
//    }
//
//    public void setValidationError(String validationError) {
//        this.validationError = validationError;
//    }
//
//    public String getIsSavedCard() {
//        return this.isSavedCard;
//    }
//
//    public void setIsSavedCard(String isSavedCard) {
//        this.isSavedCard = isSavedCard;
//    }
//
//    public String isAddMoney() {
//        return this.isAddMoney;
//    }
//
//    public void setIsAddMoney(String isAddMoney) {
//        this.isAddMoney = isAddMoney;
//    }
//
//    public String getAppIp() {
//        return this.appIp;
//    }
//
//    public void setAppIp(String appIp) {
//        this.appIp = appIp;
//    }
//
//    public String getCurrency() {
//        return this.currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//
//    public String getPaytmToken() {
//        return this.paytmToken;
//    }
//
//    public void setPaytmToken(String paytmToken) {
//        this.paytmToken = paytmToken;
//    }
//
//    public String getMerchantRequestedChannelId() {
//        return this.merchantRequestedChannelId;
//    }
//
//    public void setMerchantRequestedChannelId(String merchantRequestedChannelId) {
//        this.merchantRequestedChannelId = merchantRequestedChannelId;
//    }
//
//    public boolean isPromoCodeValid() {
//        return this.promoCodeValid;
//    }
//
//    public void setPromoCodeValid(boolean promoCodeValid) {
//        this.promoCodeValid = promoCodeValid;
//    }
//
//    public String getEncParams() {
//        return this.encParams;
//    }
//
//    public void setEncParams(String encParams) {
//        this.encParams = encParams;
//    }
//
//    public String getSubscriptionID() {
//        return this.subscriptionID;
//    }
//
//    public void setSubscriptionID(String subscriptionID) {
//        this.subscriptionID = subscriptionID;
//    }
//
//    public String getSubsPPIOnly() {
//        return this.subsPPIOnly;
//    }
//
//    public void setSubsPPIOnly(String subsPPIOnly) {
//        this.subsPPIOnly = subsPPIOnly;
//    }
//
//    public String getSubsPaymentMode() {
//        return this.subsPaymentMode;
//    }
//
//    public void setSubsPaymentMode(String subsPaymentMode) {
//        this.subsPaymentMode = subsPaymentMode;
//    }
//
//    public String getConnectiontype() {
//        return this.connectiontype;
//    }
//
//    public void setConnectiontype(String connectiontype) {
//        this.connectiontype = connectiontype;
//    }
//
//    public String getSubscriptionMaxAmount() {
//        return this.subscriptionMaxAmount;
//    }
//
//    public void setSubscriptionMaxAmount(String subscriptionMaxAmount) {
//        this.subscriptionMaxAmount = subscriptionMaxAmount;
//    }
//
//    public String getAlipayMerchantId() {
//        return this.alipayMerchantId;
//    }
//
//    public void setAlipayMerchantId(String alipayMerchantId) {
//        this.alipayMerchantId = alipayMerchantId;
//    }
//
//    public String getPeonURL() {
//        return this.peonURL;
//    }
//
//    public void setPeonURL(String peonURL) {
//        this.peonURL = peonURL;
//    }
//
//    public String getOrderTimeOutMilliSecond() {
//        return this.orderTimeOutMilliSecond;
//    }
//
//    public void setOrderTimeOutMilliSecond(String orderTimeOutMilliSecond) {
//        this.orderTimeOutMilliSecond = orderTimeOutMilliSecond;
//    }
//
//    public String getInvoicePaymentType() {
//        return this.invoicePaymentType;
//    }
//
//    public void setInvoicePaymentType(String invoicePaymentType) {
//        this.invoicePaymentType = invoicePaymentType;
//    }
//
//    public String getMerchantKey() {
//        return this.merchantKey;
//    }
//
//    public void setMerchantKey(String merchantKey) {
//        this.merchantKey = merchantKey;
//    }
//
//    public String getSubscriptionAmountType() {
//        return this.subscriptionAmountType;
//    }
//
//    public void setSubscriptionAmountType(String subscriptionAmountType) {
//        this.subscriptionAmountType = subscriptionAmountType;
//    }
//
//    public String getSubscriptionServiceID() {
//        return this.subscriptionServiceID;
//    }
//
//    public void setSubscriptionServiceID(String subscriptionServiceID) {
//        this.subscriptionServiceID = subscriptionServiceID;
//    }
//
//    public String getSubscriptionFrequency() {
//        return this.subscriptionFrequency;
//    }
//
//    public void setSubscriptionFrequency(String subscriptionFrequency) {
//        this.subscriptionFrequency = subscriptionFrequency;
//    }
//
//    public String getSubscriptionFrequencyUnit() {
//        return this.subscriptionFrequencyUnit;
//    }
//
//    public void setSubscriptionFrequencyUnit(String subscriptionFrequencyUnit) {
//        this.subscriptionFrequencyUnit = subscriptionFrequencyUnit;
//    }
//
//    public String getSubscriptionExpiryDate() {
//        return this.subscriptionExpiryDate;
//    }
//
//    public void setSubscriptionExpiryDate(String subscriptionExpiryDate) {
//        this.subscriptionExpiryDate = subscriptionExpiryDate;
//    }
//
//    public String getSubscriptionEnableRetry() {
//        return this.subscriptionEnableRetry;
//    }
//
//    public void setSubscriptionEnableRetry(String subscriptionEnableRetry) {
//        this.subscriptionEnableRetry = subscriptionEnableRetry;
//    }
//
//    public String getSubscriptionGraceDays() {
//        return this.subscriptionGraceDays;
//    }
//
//    public void setSubscriptionGraceDays(String subscriptionGraceDays) {
//        this.subscriptionGraceDays = subscriptionGraceDays;
//    }
//
//    public String getSubscriptionStartDate() {
//        return this.subscriptionStartDate;
//    }
//
//    public void setSubscriptionStartDate(String subscriptionStartDate) {
//        this.subscriptionStartDate = subscriptionStartDate;
//    }
//
//    public String getSavedCardID() {
//        return this.savedCardID;
//    }
//
//    public void setSavedCardID(String savedCardID) {
//        this.savedCardID = savedCardID;
//    }
//
//    public String getAuthCode() {
//        return this.authCode;
//    }
//
//    public void setAuthCode(String authCode) {
//        this.authCode = authCode;
//    }
//
//    public HttpServletRequest getRequest() {
//        return this.request;
//    }
//
//    public void setRequest(HttpServletRequest request) {
//        this.request = request;
//    }
//
//    public String getPaymentMode() {
//        return this.paymentMode;
//    }
//
//    public void setPaymentMode(String paymentMode) {
//        this.paymentMode = paymentMode;
//    }
//
//    public String getDisabledPaymentMode() {
//        return this.disabledPaymentMode;
//    }
//
//    public void setDisabledPaymentMode(String disabledPaymentMode) {
//        this.disabledPaymentMode = disabledPaymentMode;
//    }
//
//    public String getRequestType() {
//        return this.requestType;
//    }
//
//    public void setRequestType(String requestType) {
//        this.requestType = requestType;
//    }
//
//    public String getMid() {
//        return this.mid;
//    }
//
//    public void setMid(String mid) {
//        this.mid = mid;
//    }
//
//    public String getOrderId() {
//        return this.orderId;
//    }
//
//    public void setOrderId(String orderId) {
//        this.orderId = orderId;
//    }
//
//    public String getCustId() {
//        return this.custId;
//    }
//
//    public void setCustId(String custId) {
//        this.custId = custId;
//    }
//
//    public String getTxnAmount() {
//        return this.txnAmount;
//    }
//
//    public void setTxnAmount(String txnAmount) {
//        this.txnAmount = txnAmount;
//    }
//
//    public String getChannelId() {
//        return this.channelId;
//    }
//
//    public void setChannelId(String channelId) {
//        this.channelId = channelId;
//    }
//
//    public String getIndustryTypeId() {
//        return this.industryTypeId;
//    }
//
//    public void setIndustryTypeId(String industryTypeId) {
//        this.industryTypeId = industryTypeId;
//    }
//
//    public String getWebsite() {
//        return this.website;
//    }
//
//    public void setWebsite(String website) {
//        this.website = website;
//    }
//
//    public String getChecksumhash() {
//        return this.checksumhash;
//    }
//
//    public void setChecksumhash(String checksumhash) {
//        this.checksumhash = checksumhash;
//    }
//
//    public String getMobileNo() {
//        return this.mobileNo;
//    }
//
//    public void setMobileNo(String mobileNo) {
//        this.mobileNo = mobileNo;
//    }
//
//    public String getEmail() {
//        return this.email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPaymentModeOnly() {
//        return this.paymentModeOnly;
//    }
//
//    public void setPaymentModeOnly(String paymentModeOnly) {
//        this.paymentModeOnly = paymentModeOnly;
//    }
//
//    public String getAuthMode() {
//        return this.authMode;
//    }
//
//    public void setAuthMode(String authMode) {
//        this.authMode = authMode;
//    }
//
//    public String getPaymentTypeId() {
//        return this.paymentTypeId;
//    }
//
//    public void setPaymentTypeId(String paymentTypeId) {
//        this.paymentTypeId = paymentTypeId;
//    }
//
//    public String getCardType() {
//        return this.cardType;
//    }
//
//    public void setCardType(String cardType) {
//        this.cardType = cardType;
//    }
//
//    public String getBankCode() {
//        return this.bankCode;
//    }
//
//    public void setBankCode(String bankCode) {
//        this.bankCode = bankCode;
//    }
//
//    public String getPromoCampId() {
//        return this.promoCampId;
//    }
//
//    public void setPromoCampId(String promoCampId) {
//        this.promoCampId = promoCampId;
//    }
//
//    public String getOrderDetails() {
//        return this.orderDetails;
//    }
//
//    public void setOrderDetails(String orderDetails) {
//        this.orderDetails = orderDetails;
//    }
//
//    public String getComments() {
//        return this.comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
//
//    public String getDob() {
//        return this.dob;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    }
//
//    public String getPan_Card() {
//        return this.pan_Card;
//    }
//
//    public void setPan_Card(String pan_Card) {
//        this.pan_Card = pan_Card;
//    }
//
//    public String getDlNumber() {
//        return this.dlNumber;
//    }
//
//    public void setDlNumber(String dlNumber) {
//        this.dlNumber = dlNumber;
//    }
//
//    public String getMsisdn() {
//        return this.msisdn;
//    }
//
//    public void setMsisdn(String msisdn) {
//        this.msisdn = msisdn;
//    }
//
//    public String getVerified_by() {
//        return this.verified_by;
//    }
//
//    public void setVerified_by(String verified_by) {
//        this.verified_by = verified_by;
//    }
//
//    public String getIsUserVerified() {
//        return this.isUserVerified;
//    }
//
//    public void setIsUserVerified(String isUserVerified) {
//        this.isUserVerified = isUserVerified;
//    }
//
//    public String getAddress1() {
//        return this.address1;
//    }
//
//    public void setAddress1(String address1) {
//        this.address1 = address1;
//    }
//
//    public String getAddress2() {
//        return this.address2;
//    }
//
//    public void setAddress2(String address2) {
//        this.address2 = address2;
//    }
//
//    public String getCity() {
//        return this.city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return this.state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getPincode() {
//        return this.pincode;
//    }
//
//    public void setPincode(String pincode) {
//        this.pincode = pincode;
//    }
//
//    public String getLoginTheme() {
//        return this.loginTheme;
//    }
//
//    public void setLoginTheme(String loginTheme) {
//        this.loginTheme = loginTheme;
//    }
//
//    public String getCallbackUrl() {
//        return this.callbackUrl;
//    }
//
//    public void setCallbackUrl(String callbackUrl) {
//        this.callbackUrl = callbackUrl;
//    }
//
//    public String getTheme() {
//        return this.theme;
//    }
//
//    public void setTheme(String theme) {
//        this.theme = theme;
//    }
//
//    public String getCancelPoint() {
//        return this.cancelPoint;
//    }
//
//    public void setCancelPoint(String cancelPoint) {
//        this.cancelPoint = cancelPoint;
//    }
//
//    public String getSsoToken() {
//        return this.ssoToken;
//    }
//
//    public void setSsoToken(String ssoToken) {
//        this.ssoToken = ssoToken;
//    }
//
//    public String getPaymentDetails() {
//        return this.paymentDetails;
//    }
//
//    public void setPaymentDetails(String paymentDetails) {
//        this.paymentDetails = paymentDetails;
//    }
//
//    public String getStoreCard() {
//        return this.storeCard;
//    }
//
//    public void setStoreCard(String storeCard) {
//        this.storeCard = storeCard;
//    }
//
//    public String getClientIp() {
//        return this.clientIp;
//    }
//
//    public void setClientIp(String clientIp) {
//        this.clientIp = clientIp;
//    }
//
//    public String getCardNo() {
//        return this.cardNo;
//    }
//
//    public void setCardNo(String cardNo) {
//        this.cardNo = cardNo;
//    }
//
//    public String getCvv() {
//        return this.cvv;
//    }
//
//    public void setCvv(String cvv) {
//        this.cvv = cvv;
//    }
//
//    public String getExpiryDate() {
//        return this.expiryDate;
//    }
//
//    public void setExpiryDate(String expiryDate) {
//        this.expiryDate = expiryDate;
//    }
//
//    public String getOtp() {
//        return this.otp;
//    }
//
//    public void setOtp(String otp) {
//        this.otp = otp;
//    }
//
//    public String getWalletAmount() {
//        return this.walletAmount;
//    }
//
//    public void setWalletAmount(String walletAmount) {
//        this.walletAmount = walletAmount;
//    }
//
//    public String getTotalAmount() {
//        return this.totalAmount;
//    }
//
//    public void setTotalAmount(String totalAmount) {
//        this.totalAmount = totalAmount;
//    }
//
//    public String getTipAmount() {
//        return this.tipAmount;
//    }
//
//    public void setTipAmount(String tipAmount) {
//        this.tipAmount = tipAmount;
//    }
//
//    public String getMerchUniqueReference() {
//        return this.merchUniqueReference;
//    }
//
//    public void setMerchUniqueReference(String merchUniqueReference) {
//        this.merchUniqueReference = merchUniqueReference;
//    }
//
//    public String getUdf1() {
//        return this.udf1;
//    }
//
//    public void setUdf1(String udf1) {
//        this.udf1 = udf1;
//    }
//
//    public String getUdf2() {
//        return this.udf2;
//    }
//
//    public void setUdf2(String udf2) {
//        this.udf2 = udf2;
//    }
//
//    public String getUdf3() {
//        return this.udf3;
//    }
//
//    public void setUdf3(String udf3) {
//        this.udf3 = udf3;
//    }
//
//    public String getAdditionalInfo() {
//        return this.additionalInfo;
//    }
//
//    public void setAdditionalInfo(String additionalInfo) {
//        this.additionalInfo = additionalInfo;
//    }
//
//    public String getoAuthState() {
//        return this.oAuthState;
//    }
//
//    public void setoAuthState(String oAuthState) {
//        this.oAuthState = oAuthState;
//    }
//
//    public String getChecksumString() {
//        return this.checksumString;
//    }
//
//    public void setChecksumString(String checksumString) {
//        this.checksumString = checksumString;
//    }
//
//    public Map<String, String> getChecksumMap() {
//        return this.checksumMap == null ? Collections.emptyMap() : this.checksumMap;
//    }
//
//    public void setChecksumMap(Map<String, String> checksumMap) {
//        this.checksumMap = checksumMap;
//    }
//
//    public com.paytm.pgplus.promo.service.client.model.PromoCodeResponse getPromoCodeResponse() {
//        return this.promoCodeResponse;
//    }
//
//    public void setPromoCodeResponse(PromoCodeResponse promoCodeResponse) {
//        this.promoCodeResponse = promoCodeResponse;
//    }
//
//    public boolean isSessionRequired() {
//        return this.isSessionRequired;
//    }
//
//    public void setSessionRequired(boolean isSessionRequired) {
//        this.isSessionRequired = isSessionRequired;
//    }
//
//    public String getSubscriptionRetryCount() {
//        return this.subscriptionRetryCount;
//    }
//
//    public void setSubscriptionRetryCount(String subscriptionRetryCount) {
//        this.subscriptionRetryCount = subscriptionRetryCount;
//    }
//
//    public String getDeviceId() {
//        return this.deviceId;
//    }
//
//    public void setDeviceId(String deviceId) {
//        this.deviceId = deviceId;
//    }
//
//    public String getIsRefund() {
//        return this.isRefund;
//    }
//
//    public void setIsRefund(String isRefund) {
//        this.isRefund = isRefund;
//    }
//
//    public String getDeviceSource() {
//        return this.deviceSource;
//    }
//
//    public void setDeviceSource(String deviceSource) {
//        this.deviceSource = deviceSource;
//    }
//
//    public String getGoodsInfo() {
//        return this.goodsInfo;
//    }
//
//    public void setGoodsInfo(String goodsInfo) {
//        this.goodsInfo = goodsInfo;
//    }
//
//    public String getShippingInfo() {
//        return this.shippingInfo;
//    }
//
//    public void setShippingInfo(String shippingInfo) {
//        this.shippingInfo = shippingInfo;
//    }
//
//    public String getDeviceIdFromCookie() {
//        return this.deviceIdFromCookie;
//    }
//
//    public void setDeviceIdFromCookie(String deviceIdFromCookie) {
//        this.deviceIdFromCookie = deviceIdFromCookie;
//    }
//
//    public String getVirtualPaymentAddr() {
//        return this.virtualPaymentAddr;
//    }
//
//    public void setVirtualPaymentAddr(String virtualPaymentAddr) {
//        this.virtualPaymentAddr = virtualPaymentAddr;
//    }
//
//    public String getCreditCardBillNo() {
//        return this.creditCardBillNo;
//    }
//
//    public void setCreditCardBillNo(String creditCardBillNo) {
//        this.creditCardBillNo = creditCardBillNo;
//    }
//
//    public String getPassCode() {
//        return this.passCode;
//    }
//
//    public void setPassCode(String passCode) {
//        this.passCode = passCode;
//    }
//
//    public String getLinkId() {
//        return this.linkId;
//    }
//
//    public void setLinkId(String linkId) {
//        if (StringUtils.isNotEmpty(linkId) && LinkPaymentUtil.isPaymentFormRequest(linkId)) {
//            this.paymentFormId = "LINK_PAYMENT_FORM_" + linkId;
//            linkId = String.valueOf(LinkPaymentUtil.extractLinkId(linkId));
//        }
//
//        this.linkId = linkId;
//    }
//
//    public String getLongUrl() {
//        return this.longUrl;
//    }
//
//    public void setLongUrl(String longUrl) {
//        this.longUrl = longUrl;
//    }
//
//    public String getShortUrl() {
//        return this.shortUrl;
//    }
//
//    public void setShortUrl(String shortUrl) {
//        this.shortUrl = shortUrl;
//    }
//
//    public String getLinkName() {
//        return this.linkName;
//    }
//
//    public void setLinkName(String linkName) {
//        this.linkName = linkName;
//    }
//
//    public String getLinkDescription() {
//        return this.linkDescription;
//    }
//
//    public void setLinkDescription(String linkDescription) {
//        this.linkDescription = linkDescription;
//    }
//
//    public String getCustomizeCode() {
//        return this.customizeCode;
//    }
//
//    public void setCustomizeCode(String customizeCode) {
//        this.customizeCode = customizeCode;
//    }
//
//    public String getIDebitOption() {
//        return this.iDebitOption;
//    }
//
//    public void setIsDebitEnabled(String isDebitEnabled) {
//        this.iDebitOption = isDebitEnabled;
//    }
//
//    public String getEmiOption() {
//        return this.emiOption;
//    }
//
//    public void setEmiOption(String emiOption) {
//        this.emiOption = emiOption;
//    }
//
//    public boolean isMerchantLimitEnabled() {
//        return this.merchantLimitEnabled;
//    }
//
//    public void setMerchantLimitEnabled(boolean merchantLimitEnabled) {
//        this.merchantLimitEnabled = merchantLimitEnabled;
//    }
//
//    public boolean isMerchantLimitUpdated() {
//        return this.merchantLimitUpdated;
//    }
//
//    public void setMerchantLimitUpdated(boolean merchantLimitUpdated) {
//        this.merchantLimitUpdated = merchantLimitUpdated;
//    }
//
//    public boolean isOfflineFastForwardRequest() {
//        return this.isOfflineFastForwardRequest;
//    }
//
//    public void setOfflineFastForwardRequest(boolean isOfflineFastForwardRequest) {
//        this.isOfflineFastForwardRequest = isOfflineFastForwardRequest;
//    }
//
//    public String getQrMerchantCallbackUrl() {
//        return this.qrMerchantCallbackUrl;
//    }
//
//    public void setQrMerchantCallbackUrl(String qrMerchantCallbackUrl) {
//        this.qrMerchantCallbackUrl = qrMerchantCallbackUrl;
//    }
//
//    public boolean isQREnabled() {
//        return this.isQREnabled;
//    }
//
//    public void setQREnabled(boolean isQREnabled) {
//        this.isQREnabled = isQREnabled;
//    }
//
//    public String getInvoiceId() {
//        return this.invoiceId;
//    }
//
//    public void setInvoiceId(String invoiceId) {
//        this.invoiceId = invoiceId;
//    }
//
//    public boolean isOfflineFetchPayApi() {
//        return this.isOfflineFetchPayApi;
//    }
//
//    public void setOfflineFetchPayApi(boolean isOfflineFetchPayApi) {
//        this.isOfflineFetchPayApi = isOfflineFetchPayApi;
//    }
//
//    public String getMaskedCustomerMobileNumber() {
//        return this.maskedCustomerMobileNumber;
//    }
//
//    public void setMaskedCustomerMobileNumber(String maskedCustomerMobileNumber) {
//        this.maskedCustomerMobileNumber = maskedCustomerMobileNumber;
//    }
//
//    public String getPosId() {
//        return this.posId;
//    }
//
//    public void setPosId(String posId) {
//        this.posId = posId;
//    }
//
//    public String getUniqueReferenceLabel() {
//        return this.uniqueReferenceLabel;
//    }
//
//    public void setUniqueReferenceLabel(String uniqueReferenceLabel) {
//        this.uniqueReferenceLabel = uniqueReferenceLabel;
//    }
//
//    public String getUniqueReferenceValue() {
//        return this.uniqueReferenceValue;
//    }
//
//    public void setUniqueReferenceValue(String uniqueReferenceValue) {
//        this.uniqueReferenceValue = uniqueReferenceValue;
//    }
//
//    public String getPccCode() {
//        return this.pccCode;
//    }
//
//    public void setPccCode(String pccCode) {
//        this.pccCode = pccCode;
//    }
//
//    public String getPrn() {
//        return this.prn;
//    }
//
//    public void setPrn(String prn) {
//        this.prn = prn;
//    }
//
//    public String getSeqNo() {
//        return this.seqNo;
//    }
//
//    public void setSeqNo(String seqNo) {
//        this.seqNo = seqNo;
//    }
//
//    public boolean getIsEmi() {
//        return this.isEmi;
//    }
//
//    public void setIsEmi(boolean isEmi) {
//        this.isEmi = isEmi;
//    }
//
//    public String getEmiPlanID() {
//        return this.emiPlanID;
//    }
//
//    public void setEmiPlanID(String emiPlanID) {
//        this.emiPlanID = emiPlanID;
//    }
//
//    public boolean isFastForwardRequest() {
//        return this.fastForwardRequest;
//    }
//
//    public PaymentRequestBean setFastForwardRequest(boolean fastForwardRequest) {
//        this.fastForwardRequest = fastForwardRequest;
//        return this;
//    }
//
//    public void setTxnToken(String txnToken) {
//        this.txnToken = txnToken;
//    }
//
//    public String getAccount_ref_id() {
//        return this.account_ref_id;
//    }
//
//    public String getBusiness_id() {
//        return this.business_id;
//    }
//
//    public boolean isEncryptedCardDetail() {
//        return this.isEncryptedCardDetail;
//    }
//
//    public void setEncryptedCardDetail(boolean isEncryptedCardDetail) {
//        this.isEncryptedCardDetail = isEncryptedCardDetail;
//    }
//
//    public boolean isCartValidationRequired() {
//        return this.isCartValidationRequired;
//    }
//
//    public void setCartValidationRequired(boolean cartValidationRequired) {
//        this.isCartValidationRequired = cartValidationRequired;
//    }
//
//    public String getTxnToken() {
//        return this.txnToken;
//    }
//
//    public boolean isNativeRetryEnabled() {
//        return this.nativeRetryEnabled;
//    }
//
//    public void setNativeRetryEnabled(boolean nativeRetryEnabled) {
//        this.nativeRetryEnabled = nativeRetryEnabled;
//    }
//
//    public String getNativeRetryErrorMessage() {
//        return this.nativeRetryErrorMessage;
//    }
//
//    public void setNativeRetryErrorMessage(String nativeRetryErrorMessage) {
//        this.nativeRetryErrorMessage = nativeRetryErrorMessage;
//    }
//
//    public String getWalletType() {
//        return this.walletType;
//    }
//
//    public void setWalletType(String walletType) {
//        this.walletType = walletType;
//    }
//
//    public String getAppId() {
//        return this.appId;
//    }
//
//    public void setAppId(String appId) {
//        this.appId = appId;
//    }
//
//    public String getAmountToBeRefunded() {
//        return this.amountToBeRefunded;
//    }
//
//    public void setAmountToBeRefunded(String amountToBeRefunded) {
//        this.amountToBeRefunded = amountToBeRefunded;
//    }
//
//    public String getAccountType() {
//        return this.accountType;
//    }
//
//    public void setAccountType(String accountType) {
//        this.accountType = accountType;
//    }
//
//    public Map<UserSubWalletType, BigDecimal> getSubwalletAmount() {
//        return this.subwalletAmount;
//    }
//
//    public void setSubwalletAmount(String subwalletAmount) {
//        try {
//            if (StringUtils.isNotBlank(subwalletAmount)) {
//                this.subwalletAmount = (Map)OBJECT_MAPPER.readValue(subwalletAmount, SUBWALLET_TYPE_REF);
//            }
//        } catch (IOException var3) {
//            LOGGER.error("Exception occurred while Mapping Subwallet Map :: {}", var3);
//        }
//
//    }
//
//    public boolean isMerchantVerifiedChecksum() {
//        return this.merchantVerifiedChecksum;
//    }
//
//    public void setMerchantVerifiedChecksum(boolean merchantVerifiedChecksum) {
//        this.merchantVerifiedChecksum = merchantVerifiedChecksum;
//    }
//
//    public boolean isChecksumVerificationResult() {
//        return this.checksumVerificationResult;
//    }
//
//    public void setChecksumVerificationResult(boolean checksumVerificationResult) {
//        this.checksumVerificationResult = checksumVerificationResult;
//    }
//
//    public boolean isEnhancedCashierPageRequest() {
//        return this.isEnhancedCashierPageRequest;
//    }
//
//    public void setEnhancedCashierPageRequest(boolean isEnhancedCashierPageRequest) {
//        this.isEnhancedCashierPageRequest = isEnhancedCashierPageRequest;
//    }
//
//    public String getEmitype() {
//        return this.emitype;
//    }
//
//    public void setEmitype(String emitype) {
//        this.emitype = emitype;
//    }
//
//    public String getDirectPayModeType() {
//        return this.directPayModeType;
//    }
//
//    public void setDirectPayModeType(String directPayModeType) {
//        this.directPayModeType = directPayModeType;
//    }
//
//    public String getClientId() {
//        return this.clientId;
//    }
//
//    public void setClientId(String clientId) {
//        this.clientId = clientId;
//    }
//
//    public boolean isCcBillPaymentRequest() {
//        return this.ccBillPaymentRequest;
//    }
//
//    public void setCcBillPaymentRequest(boolean ccBillPaymentRequest) {
//        this.ccBillPaymentRequest = ccBillPaymentRequest;
//    }
//
//    public String getAllowUnverifiedAccount() {
//        return this.allowUnverifiedAccount;
//    }
//
//    public void setAllowUnverifiedAccount(String allowUnverifiedAccount) {
//        this.allowUnverifiedAccount = allowUnverifiedAccount;
//    }
//
//    public String getAggMid() {
//        return this.aggMid;
//    }
//
//    public void setAggMid(String aggMid) {
//        this.aggMid = aggMid;
//    }
//
//    public String getValidateAccountNumber() {
//        return this.validateAccountNumber;
//    }
//
//    public void setValidateAccountNumber(String validateAccountNumber) {
//        this.validateAccountNumber = validateAccountNumber;
//    }
//
//    public String getAdditionalInfoMF() {
//        return this.additionalInfoMF;
//    }
//
//    public void setAdditionalInfoMF(String additionalInfoMF) {
//        this.additionalInfoMF = additionalInfoMF;
//    }
//
//    public boolean isNativeJsonRequest() {
//        return this.isNativeJsonRequest;
//    }
//
//    public void setNativeJsonRequest(boolean nativeJsonRequest) {
//        this.isNativeJsonRequest = nativeJsonRequest;
//    }
//
//    public String getNativePayAllowed() {
//        return this.nativePayAllowed;
//    }
//
//    public void setNativePayAllowed(String nativePayAllowed) {
//        this.nativePayAllowed = nativePayAllowed;
//    }
//
//    public boolean isNativeOtpSupported() {
//        return this.nativeOtpSupported;
//    }
//
//    public void setNativeOtpSupported(boolean nativeOtpSupported) {
//        this.nativeOtpSupported = nativeOtpSupported;
//    }
//
//    public String getKycCode() {
//        return this.kycCode;
//    }
//
//    public void setKycCode(String kycCode) {
//        this.kycCode = kycCode;
//    }
//
//    public String getKycVersion() {
//        return this.kycVersion;
//    }
//
//    public void setKycVersion(String kycVersion) {
//        this.kycVersion = kycVersion;
//    }
//
//    public boolean isPostpaidOnboardingSupported() {
//        return this.postpaidOnboardingSupported;
//    }
//
//    public void setPostpaidOnboardingSupported(boolean postpaidOnboardingSupported) {
//        this.postpaidOnboardingSupported = postpaidOnboardingSupported;
//    }
//
//    public boolean isDeepLinkRequired() {
//        return this.isDeepLinkRequired;
//    }
//
//    public void setDeepLinkRequired(boolean deepLinkRequired) {
//        this.isDeepLinkRequired = deepLinkRequired;
//    }
//
//    public String getRefUrl() {
//        return this.refUrl;
//    }
//
//    public void setRefUrl(String refUrl) {
//        this.refUrl = refUrl;
//    }
//
//    public String getTxnNote() {
//        return this.txnNote;
//    }
//
//    public void setTxnNote(String txnNote) {
//        this.txnNote = txnNote;
//    }
//
//    public boolean isDeepLinkFromInsta() {
//        return this.isDeepLinkFromInsta;
//    }
//
//    public void setDeepLinkFromInsta(boolean isDeepLinkFromInsta) {
//        this.isDeepLinkFromInsta = isDeepLinkFromInsta;
//    }
//
//    public void setSubscription(boolean subscription) {
//        this.isSubscription = subscription;
//    }
//
//    public boolean isSubscription() {
//        return this.isSubscription;
//    }
//
//    public int getCurrentPaymentCount() {
//        return this.currentPaymentCount;
//    }
//
//    public void setCurrentPaymentCount(int currentPaymentCount) {
//        this.currentPaymentCount = currentPaymentCount;
//    }
//
//    public boolean isShowSavecard() {
//        return this.showStoreSavecard;
//    }
//
//    public void setShowSavecard(boolean showSavecard) {
//        this.showStoreSavecard = showSavecard;
//    }
//
//    public boolean isNativeAddMoney() {
//        return this.isNativeAddMoney;
//    }
//
//    public void setNativeAddMoney(boolean nativeAddMoney) {
//        this.isNativeAddMoney = nativeAddMoney;
//    }
//
//    public boolean isCreateTopupRequired() {
//        return this.isCreateTopupRequired;
//    }
//
//    public void setCreateTopupRequired(boolean createTopupRequired) {
//        this.isCreateTopupRequired = createTopupRequired;
//    }
//
//    public Map<String, String> getAdditoinalInfoMap() {
//        return this.additoinalInfoMap;
//    }
//
//    public void setAdditoinalInfoMap(Map<String, String> additoinalInfoMap) {
//        this.additoinalInfoMap = additoinalInfoMap;
//    }
//
//    public String getInternalErrorCode() {
//        return this.internalErrorCode;
//    }
//
//    public void setInternalErrorCode(String internalErrorCode) {
//        this.internalErrorCode = internalErrorCode;
//    }
//
//    public String getUserName() {
//        return this.userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public com.paytm.pgplus.cache.model.MerchantPreferenceInfoResponse getMerchantPreferenceInfoResponse() {
//        return this.merchantPreferenceInfoResponse;
//    }
//
//    public void setMerchantPreferenceInfoResponse(com.paytm.pgplus.cache.model.MerchantPreferenceInfoResponse merchantPreferenceInfoResponse) {
//        this.merchantPreferenceInfoResponse = merchantPreferenceInfoResponse;
//    }
//
//    public MerchantExtendedInfoResponse getMerchantExtendedInfoResponse() {
//        return this.merchantExtendedInfoResponse;
//    }
//
//    public void setMerchantExtendedInfoResponse(MerchantExtendedInfoResponse merchantExtendedInfoResponse) {
//        this.merchantExtendedInfoResponse = merchantExtendedInfoResponse;
//    }
//
//    public String getWorkflow() {
//        return this.workflow;
//    }
//
//    public void setWorkflow(String workflow) {
//        this.workflow = workflow;
//    }
//
//    public String getCorporateCustId() {
//        return this.corporateCustId;
//    }
//
//    public void setCorporateCustId(String corporateCustId) {
//        this.corporateCustId = corporateCustId;
//    }
//
//    public String getTemplateId() {
//        return this.templateId;
//    }
//
//    public void setTemplateId(String templateId) {
//        this.templateId = templateId;
//    }
//
//    public String getbId() {
//        return this.bId;
//    }
//
//    public void setbId(String bId) {
//        this.bId = bId;
//    }
//
//    public String getTokenType() {
//        return this.tokenType;
//    }
//
//    public String getCardHash() {
//        return this.cardHash;
//    }
//
//    public void setCardHash(String cardHash) {
//        this.cardHash = cardHash;
//    }
//
//    public void setTokenType(String tokenType) {
//        this.tokenType = tokenType;
//    }
//
//    public String getBankIFSC() {
//        return this.bankIFSC;
//    }
//
//    public void setBankIFSC(String bankIFSC) {
//        this.bankIFSC = bankIFSC;
//    }
//
//    public boolean isMotoPaymentBySubscription() {
//        return this.isMotoPaymentBySubscription;
//    }
//
//    public void setMotoPaymentBySubscription(boolean motoPaymentBySubscription) {
//        this.isMotoPaymentBySubscription = motoPaymentBySubscription;
//    }
//
//    public String getMandateType() {
//        return this.mandateType;
//    }
//
//    public void setMandateType(String mandateType) {
//        this.mandateType = mandateType;
//    }
//
//    public boolean isCreateOrderRequired() {
//        return this.isCreateOrderRequired;
//    }
//
//    public void setCreateOrderRequired(boolean createOrderRequired) {
//        this.isCreateOrderRequired = createOrderRequired;
//    }
//
//    public boolean isRiskVerifiedEnhanceFlow() {
//        return this.isRiskVerifiedEnhanceFlow;
//    }
//
//    public String getSecurityId() {
//        return this.securityId;
//    }
//
//    public boolean isEnhancedCashierPaymentRequest() {
//        return this.enhancedCashierPaymentRequest;
//    }
//
//    public void setEnhancedCashierPaymentRequest(boolean enhancedCashierPaymentRequest) {
//        this.enhancedCashierPaymentRequest = enhancedCashierPaymentRequest;
//    }
//
//    public boolean isAddMoneyRiskInvolved() {
//        return this.isAddMoneyRiskInvolved;
//    }
//
//    public void setAddMoneyRiskInvolved(boolean addMoneyRiskInvolved) {
//        this.isAddMoneyRiskInvolved = addMoneyRiskInvolved;
//    }
//
//    public String getAmountForWalletConsultInRisk() {
//        return this.amountForWalletConsultInRisk;
//    }
//
//    public void setAmountForWalletConsultInRisk(String amountForWalletConsultInRisk) {
//        this.amountForWalletConsultInRisk = amountForWalletConsultInRisk;
//    }
//
//    public boolean isAutoRenewal() {
//        return this.autoRenewal;
//    }
//
//    public void setAutoRenewal(boolean autoRenewal) {
//        this.autoRenewal = autoRenewal;
//    }
//
//    public boolean isAutoRetry() {
//        return this.autoRetry;
//    }
//
//    public void setAutoRetry(boolean autoRetry) {
//        this.autoRetry = autoRetry;
//    }
//
//    public boolean isCommunicationManager() {
//        return this.communicationManager;
//    }
//
//    public void setCommunicationManager(boolean communicationManager) {
//        this.communicationManager = communicationManager;
//    }
//
//    public String getRenewalAmount() {
//        return this.renewalAmount;
//    }
//
//    public void setRenewalAmount(String renewalAmount) {
//        this.renewalAmount = renewalAmount;
//    }
//
//    public UserInfo getUserInfo() {
//        return this.userInfo;
//    }
//
//    public void setUserInfo(UserInfo userInfo) {
//        this.userInfo = userInfo;
//    }
//
//    public com.paytm.pgplus.models.GoodsInfo getSubsGoodsInfo() {
//        return this.subsGoodsInfo;
//    }
//
//    public void setSubsGoodsInfo(GoodsInfo subsGoodsInfo) {
//        this.subsGoodsInfo = subsGoodsInfo;
//    }
//
//    public boolean isDynamicQrRequired() {
//        return this.dynamicQrRequired;
//    }
//
//    public void setDynamicQrRequired(boolean dynamicQrRequired) {
//        this.dynamicQrRequired = dynamicQrRequired;
//    }
//
//    public boolean isGvConsentFlow() {
//        return this.gvConsentFlow;
//    }
//
//    public String getAppVersion() {
//        return this.appVersion;
//    }
//
//    public void setAppVersion(String appVersion) {
//        this.appVersion = appVersion;
//    }
//
//    public String getPromoAmount() {
//        return this.promoAmount;
//    }
//
//    public void setPayableAmount(String promoAmount) {
//        this.promoAmount = promoAmount;
//    }
//
//    public SplitSettlementInfo getSplitSettlementInfo() {
//        return this.splitSettlementInfo;
//    }
//
//    public void setSplitSettlementInfo(SplitSettlementInfo splitSettlementInfo) {
//        this.splitSettlementInfo = splitSettlementInfo;
//    }
//
//    public String getMandateAuthMode() {
//        return this.mandateAuthMode;
//    }
//
//    public void setMandateAuthMode(String mandateAuthMode) {
//        this.mandateAuthMode = mandateAuthMode;
//    }
//
//    public String getMandateBankCode() {
//        return this.mandateBankCode;
//    }
//
//    public void setMandateBankCode(String mandateBankCode) {
//        this.mandateBankCode = mandateBankCode;
//    }
//
//    public String getOneClickInfo() {
//        return this.oneClickInfo;
//    }
//
//    public void setOneClickInfo(String oneClickInfo) {
//        this.oneClickInfo = oneClickInfo;
//    }
//
//    public boolean isInternalFetchPaymentOptions() {
//        return this.isInternalFetchPaymentOptions;
//    }
//
//    public void setInternalFetchPaymentOptions(boolean internalFetchPaymentOptions) {
//        this.isInternalFetchPaymentOptions = internalFetchPaymentOptions;
//    }
//
//    public String getGuestToken() {
//        return this.guestToken;
//    }
//
//    public void setGuestToken(String guestToken) {
//        this.guestToken = guestToken;
//    }
//
//    public String getVersion() {
//        return this.version;
//    }
//
//    public void setVersion(String version) {
//        this.version = version;
//    }
//
//    public String getOriginChannel() {
//        return this.originChannel;
//    }
//
//    public void setOriginChannel(String originChannel) {
//        this.originChannel = originChannel;
//    }
//
//    public String getUpiAccRefId() {
//        return this.upiAccRefId;
//    }
//
//    public void setUpiAccRefId(String upiAccRefId) {
//        this.upiAccRefId = upiAccRefId;
//    }
//
//    public String getPreviousOrderId() {
//        return this.previousOrderId;
//    }
//
//    public void setPreviousOrderId(String previousOrderId) {
//        this.previousOrderId = previousOrderId;
//    }
//
//    public String toString() {
//        return (new MaskToStringBuilder(this)).setExcludeFieldNames(new String[]{"alipayMerchantId"}).toString();
//    }
//
//    public String getPaymentFormId() {
//        return this.paymentFormId;
//    }
//
//    public void setPaymentFormId(String paymentFormId) {
//        this.paymentFormId = paymentFormId;
//    }
//
//    public String getLinkNotes() {
//        return this.linkNotes;
//    }
//
//    public void setLinkNotes(String linkNotes) {
//        this.linkNotes = linkNotes;
//    }
//
//    public List<com.paytm.pgplus.facade.emisubvention.models.Item> getItems() {
//        return this.items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }
//
//    public boolean isEmiSubventionRequired() {
//        return this.isEmiSubventionRequired;
//    }
//
//    public void setEmiSubventionRequired(boolean emiSubventionRequired) {
//        this.isEmiSubventionRequired = emiSubventionRequired;
//    }
//
//    public String getEmiSubventedTransactionAmount() {
//        return this.emiSubventedTransactionAmount;
//    }
//
//    public void setEmiSubventedTransactionAmount(String emiSubventedTransactionAmount) {
//        this.emiSubventedTransactionAmount = emiSubventedTransactionAmount;
//    }
//
//    public String getEmiSubventionCustomerId() {
//        return this.emiSubventionCustomerId;
//    }
//
//    public void setEmiSubventionCustomerId(String emiSubventionCustomerId) {
//        this.emiSubventionCustomerId = emiSubventionCustomerId;
//    }
//
//    public String getExchangeRate() {
//        return this.exchangeRate;
//    }
//
//    public void setExchangeRate(String exchangeRate) {
//        this.exchangeRate = exchangeRate;
//    }
//
//    public boolean isCreateOrderForInitiateTxnRequest() {
//        return this.createOrderForInitiateTxnRequest;
//    }
//
//    public void setCreateOrderForInitiateTxnRequest(boolean createOrderForInitiateTxnRequest) {
//        this.createOrderForInitiateTxnRequest = createOrderForInitiateTxnRequest;
//    }
//
//    public com.paytm.pgplus.models.ExtendInfo getExtendInfo() {
//        return this.extendInfo;
//    }
//
//    public void setExtendInfo(ExtendInfo extendInfo) {
//        this.extendInfo = extendInfo;
//    }
//
//    public String getAggType() {
//        return this.aggType;
//    }
//
//    public void setAggType(String aggType) {
//        this.aggType = aggType;
//    }
//
//    public OrderPricingInfo getOrderPricingInfo() {
//        return this.orderPricingInfo;
//    }
//
//    public void setOrderPricingInfo(OrderPricingInfo orderPricingInfo) {
//        this.orderPricingInfo = orderPricingInfo;
//    }
//
//    public boolean isOfflineTxnFlow() {
//        return this.offlineTxnFlow;
//    }
//
//    public String getSubscriptionPurpose() {
//        return this.subscriptionPurpose;
//    }
//
//    public void setSubscriptionPurpose(String subscriptionPurpose) {
//        this.subscriptionPurpose = subscriptionPurpose;
//    }
//
//    public void setOfflineTxnFlow(boolean offlineTxnFlow) {
//        this.offlineTxnFlow = offlineTxnFlow;
//    }
//
//    public String getProductCode() {
//        return this.productCode;
//    }
//
//    public void setProductCode(String productCode) {
//        this.productCode = productCode;
//    }
//
//    public boolean isMlvSupported() {
//        return this.mlvSupported;
//    }
//
//    public void setMlvSupported(boolean mlvSupported) {
//        this.mlvSupported = mlvSupported;
//    }
//
//    public com.paytm.pgplus.facade.wallet.models.QRCodeInfoResponseData getqRCodeInfo() {
//        return this.qRCodeInfo;
//    }
//
//    public void setqRCodeInfo(QRCodeInfoResponseData qRCodeInfo) {
//        this.qRCodeInfo = qRCodeInfo;
//    }
//
//    public String getQueryParams() {
//        return this.queryParams;
//    }
//
//    public void setQueryParams(String queryParams) {
//        this.queryParams = queryParams;
//    }
//
//    public Date getDebitDate() {
//        return this.debitDate;
//    }
//
//    public void setDebitDate(Date debitDate) {
//        this.debitDate = debitDate;
//    }
//
//    public String getAccessToken() {
//        return this.accessToken;
//    }
//
//    public void setAccessToken(String accessToken) {
//        this.accessToken = accessToken;
//    }
//
//    public com.paytm.pgplus.models.SimplifiedPaymentOffers getSimplifiedPaymentOffers() {
//        return this.simplifiedPaymentOffers;
//    }
//
//    public void setSimplifiedPaymentOffers(SimplifiedPaymentOffers simplifiedPaymentOffers) {
//        this.simplifiedPaymentOffers = simplifiedPaymentOffers;
//    }
//
//    public boolean isScanAndPayFlow() {
//        return this.scanAndPayFlow;
//    }
//
//    public String getPwpCategory() {
//        return this.pwpCategory;
//    }
//
//    public void setPwpCategory(String pwpCategory) {
//        this.pwpCategory = pwpCategory;
//    }
//
//    public boolean isPrepaidCard() {
//        return this.prepaidCard;
//    }
//
//    public void setPrepaidCard(boolean prepaidCard) {
//        this.prepaidCard = prepaidCard;
//    }
//
//    public boolean isExternalFetchPaymentOptions() {
//        return this.isExternalFetchPaymentOptions;
//    }
//
//    public void setExternalFetchPaymentOptions(boolean externalFetchPaymentOptions) {
//        this.isExternalFetchPaymentOptions = externalFetchPaymentOptions;
//    }
//
//    public String getLoyaltyPointRootUserId() {
//        return this.loyaltyPointRootUserId;
//    }
//
//    public void setLoyaltyPointRootUserId(String loyaltyPointRootUserId) {
//        this.loyaltyPointRootUserId = loyaltyPointRootUserId;
//    }
//
//    public String getLoyaltyPointRootUserPGMid() {
//        return this.loyaltyPointRootUserPGMid;
//    }
//
//    public void setLoyaltyPointRootUserPGMid(String loyaltyPointRootUserPGMid) {
//        this.loyaltyPointRootUserPGMid = loyaltyPointRootUserPGMid;
//    }
//
//    public void setScanAndPayFlow(boolean scanAndPayFlow) {
//        this.scanAndPayFlow = scanAndPayFlow;
//    }
//
//    public boolean isParseRiskExtendInfoAsJson() {
//        return this.parseRiskExtendInfoAsJson;
//    }
//
//    public void setParseRiskExtendInfoAsJson(boolean parseRiskExtendInfoAsJson) {
//        this.parseRiskExtendInfoAsJson = parseRiskExtendInfoAsJson;
//    }
//
//    public String getApplyPaymentOffer() {
//        return this.applyPaymentOffer;
//    }
//
//    public void setApplyPaymentOffer(String applyPaymentOffer) {
//        this.applyPaymentOffer = applyPaymentOffer;
//    }
//
//    public String getFetchAllPaymentOffers() {
//        return this.fetchAllPaymentOffers;
//    }
//
//    public void setFetchAllPaymentOffers(String fetchAllPaymentOffers) {
//        this.fetchAllPaymentOffers = fetchAllPaymentOffers;
//    }
//
//    public Boolean isSdkProcessTxnFlow() {
//        return this.isSdkProcessTxnFlow;
//    }
//
//    public void setSdkProcessTxnFlow(Boolean sdkProcessTxnFlow) {
//        this.isSdkProcessTxnFlow = sdkProcessTxnFlow;
//    }
//
//    public String getResellerId() {
//        return this.resellerId;
//    }
//
//    public void setResellerId(String resellerId) {
//        this.resellerId = resellerId;
//    }
//
//    public String getResellerName() {
//        return this.resellerName;
//    }
//
//    public void setResellerName(String resellerName) {
//        this.resellerName = resellerName;
//    }
//
//    public boolean isEcomTokenTxn() {
//        return this.isEcomTokenTxn;
//    }
//
//    public void setEcomTokenTxn(boolean ecomTokenTxn) {
//        this.isEcomTokenTxn = ecomTokenTxn;
//    }
//
//    public com.paytm.pgplus.models.SplitSettlementInfoData getSplitSettlementInfoData() {
//        return this.splitSettlementInfoData;
//    }
//
//    public Map<String, String> getLinkOrderExtendInfo() {
//        return this.linkOrderExtendInfo;
//    }
//
//    public void setLinkOrderExtendInfo(Map<String, String> linkOrderExtendInfo) {
//        this.linkOrderExtendInfo = linkOrderExtendInfo;
//    }
//
//    public void setSplitSettlementInfoData(com.paytm.pgplus.models.SplitSettlementInfoData splitSettlementInfoData) {
//        this.splitSettlementInfoData = splitSettlementInfoData;
//        this.setSplitSettlementInfo(this.createSplitSettlementInfoFromSplitSettlementInfoData(splitSettlementInfoData));
//    }
//
//    public String getPpblAccountType() {
//        return this.ppblAccountType;
//    }
//
//    public void setPpblAccountType(String ppblAccountType) {
//        this.ppblAccountType = ppblAccountType;
//    }
//
//    public String getQrCodeId() {
//        return this.qrCodeId;
//    }
//
//    public void setQrCodeId(String qrCodeId) {
//        this.qrCodeId = qrCodeId;
//    }
//
//    public String getSubRequestType() {
//        return this.subRequestType;
//    }
//
//    public void setSubRequestType(String subRequestType) {
//        this.subRequestType = subRequestType;
//    }
//
//    public SplitSettlementInfo createSplitSettlementInfoFromSplitSettlementInfoData(SplitSettlementInfoData splitSettlementInfoData) {
//        if (splitSettlementInfoData == null) {
//            return null;
//        } else {
//            SplitSettlementInfo splitSettlementInfo = new SplitSettlementInfo();
//            splitSettlementInfo.setSplitMethod(splitSettlementInfoData.getSplitMethod());
//            splitSettlementInfo.setSplitType(splitSettlementInfoData.getSplitType());
//            splitSettlementInfo.setPostTxnSplitTimeout(splitSettlementInfoData.getPostTxnSplitTimeout());
//            List<com.paytm.pgplus.models.SplitInfoData> splitInfoDataList = splitSettlementInfoData.getSplitInfo();
//            if (splitInfoDataList != null && splitInfoDataList.size() > 0) {
//                List<SplitInfo> splitInfoList = new ArrayList(splitSettlementInfoData.getSplitInfo().size());
//                Iterator var5 = splitInfoDataList.iterator();
//
//                while(var5.hasNext()) {
//                    com.paytm.pgplus.models.SplitInfoData splitInfoData = (SplitInfoData)var5.next();
//                    SplitInfo splitInfo = new SplitInfo();
//                    splitInfo.setAmount(splitInfoData.getAmount());
//                    splitInfo.setMid(splitInfoData.getMid());
//                    splitInfo.setPercentage(splitInfoData.getPercentage());
//                    splitInfoList.add(splitInfo);
//                }
//
//                splitSettlementInfo.setSplitInfo(splitInfoList);
//            }
//
//            return splitSettlementInfo;
//        }
//    }
//
//    public String getMerchantLinkRefId() {
//        return this.merchantLinkRefId;
//    }
//
//    public void setMerchantLinkRefId(String merchantLinkRefId) {
//        this.merchantLinkRefId = merchantLinkRefId;
//    }
//
//    public String getOsType() {
//        return this.osType;
//    }
//
//    public void setOsType(String osType) {
//        this.osType = osType;
//    }
//
//    public String getPspApp() {
//        return this.pspApp;
//    }
//
//    public void setPspApp(String pspApp) {
//        this.pspApp = pspApp;
//    }
//
//    public boolean isReturnDisabledChannelInFpo() {
//        return this.returnDisabledChannelInFpo;
//    }
//
//    public void setReturnDisabledChannelInFpo(boolean returnDisabledChannelInFpo) {
//        this.returnDisabledChannelInFpo = returnDisabledChannelInFpo;
//    }
//
//    public String getInitiateTransId() {
//        return this.initiateTransId;
//    }
//
//    public void setInitiateTransId(String initiateTransId) {
//        this.initiateTransId = initiateTransId;
//    }
//
//    public String getPreAuthExpiryDate() {
//        return this.preAuthExpiryDate;
//    }
//
//    public void setPreAuthExpiryDate(String preAuthExpiryDate) {
//        this.preAuthExpiryDate = preAuthExpiryDate;
//    }
//
//    public boolean isPreAuth() {
//        return this.preAuth;
//    }
//
//    public String getType() {
//        return this.type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public void setPreAuth(boolean preAuth) {
//        this.preAuth = preAuth;
//    }
//
//    public void setDefaults(HttpServletRequest request) {
//        this.isEcomTokenTxn = Boolean.valueOf(request.getParameter("ecomTokenTxn"));
//        this.isCoftTokenTxn = Boolean.valueOf(request.getParameter("coftTokenTxn"));
//        if (request.getParameter("isAutoRefund") != null) {
//            this.autoRefund = Boolean.valueOf(request.getParameter("isAutoRefund"));
//        }
//
//        this.paymentMid = request.getParameter("dummyMerchantId");
//        this.paymentOrderId = request.getParameter("dummyOrderId");
//        if (request.getParameter("blockNonCCDCPaymodes") != null) {
//            this.blockNonCCDCPaymodes = Boolean.valueOf(request.getParameter("blockNonCCDCPaymodes"));
//        }
//
//        this.flexiSubscription = Boolean.parseBoolean(request.getParameter("FLEXI_SUBSCRIPTION"));
//        this.paymentCallFromDccPage = Boolean.valueOf(request.getParameter("paymentCallFromDccPage"));
//        this.dccSelectedByUser = Boolean.valueOf(request.getParameter("dccSelectedByUser"));
//        this.nativeRetryErrorMessage = request.getParameter("errorMessage");
//        this.useInvestmentAsFundingSource = Boolean.valueOf(request.getParameter("useInvestmentAsFundingSource"));
//        if (StringUtils.isNotEmpty(request.getParameter("emiSubventionInfo"))) {
//            try {
//                this.emiSubventionInfo = (EmiSubventionInfo) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("emiSubventionInfo"), EmiSubventionInfo.class);
//            } catch (FacadeCheckedException var5) {
//                LOGGER.error("Error while parsing EMI_SUBVENTION_INFO");
//            }
//        }
//
//        this.upiConvertedToAddNPay = StringUtils.isNotBlank(request.getParameter("upiConvertedToAddNPay")) ? Boolean.valueOf(request.getParameter("upiConvertedToAddNPay")) : false;
//        if (StringUtils.isNotEmpty(request.getParameter("coftConsent"))) {
//            try {
//                this.coftConsent = (CoftConsent) com.paytm.pgplus.facade.utils.JsonMapper.mapJsonToObject(request.getParameter("coftConsent"), CoftConsent.class);
//            } catch (FacadeCheckedException var4) {
//                LOGGER.error("Error while parsing Coft Consent");
//            }
//        }
//
//        if (StringUtils.isNotEmpty(request.getParameter("cardTokenInfo"))) {
//            try {
//                this.cardTokenInfo = (CardTokenInfo) JsonMapper.mapJsonToObject(request.getParameter("cardTokenInfo"), CardTokenInfo.class);
//            } catch (FacadeCheckedException var3) {
//                LOGGER.error("Error while parsing Card Token");
//            }
//        }
//
//        this.edcLinkTxn = StringUtils.isNotBlank(request.getParameter("isEdcLinkTxn")) ? Boolean.valueOf(request.getParameter("isEdcLinkTxn")) : Boolean.FALSE;
//        if (request.getParameter("aoaSubsOnPgMid") != null) {
//            this.aoaSubsOnPgMid = Boolean.valueOf(request.getParameter("aoaSubsOnPgMid"));
//        }
//
//        this.sgwReferenceId = request.getParameter("sgwReferenceId");
//    }
//
//    public String getJwtToken() {
//        return this.jwtToken;
//    }
//
//    public void setJwtToken(String jwtToken) {
//        this.jwtToken = jwtToken;
//    }
//
//    public Map<String, Object> getBankTransferDTO() {
//        return this.bankTransferDTO;
//    }
//
//    public void setBankTransferDTO(Map<String, Object> bankTransferDTO) {
//        this.bankTransferDTO = bankTransferDTO;
//    }
//
//    public String getMerchantDisplayName() {
//        return this.merchantDisplayName;
//    }
//
//    public void setMerchantDisplayName(String merchantDisplayName) {
//        this.merchantDisplayName = merchantDisplayName;
//    }
//
//    public String getSubsLinkId() {
//        return this.subsLinkId;
//    }
//
//    public void setSubsLinkId(String subsLinkId) {
//        this.subsLinkId = subsLinkId;
//    }
//
//    public boolean isDisplayWarningMessageForLink() {
//        return this.displayWarningMessageForLink;
//    }
//
//    public void setDisplayWarningMessageForLink(boolean displayWarningMessageForLink) {
//        this.displayWarningMessageForLink = displayWarningMessageForLink;
//    }
//
//    public void setPaytmCustId(String paytmCustId) {
//        this.paytmCustId = paytmCustId;
//    }
//
//    public String getPaytmCustId() {
//        return this.paytmCustId;
//    }
//
//    public Boolean getOfflineMerchant() {
//        return this.isOfflineMerchant;
//    }
//
//    public void setOfflineMerchant(Boolean offlineMerchant) {
//        this.isOfflineMerchant = offlineMerchant;
//    }
//
//    public boolean isAutoRefund() {
//        return this.autoRefund;
//    }
//
//    public void setAutoRefund(boolean autoRefund) {
//        this.autoRefund = autoRefund;
//    }
//
//    public String getPaymentMid() {
//        return this.paymentMid;
//    }
//
//    public void setPaymentMid(String paymentMid) {
//        this.paymentMid = paymentMid;
//    }
//
//    public String getPaymentOrderId() {
//        return this.paymentOrderId;
//    }
//
//    public void setPaymentOrderId(String paymentOrderId) {
//        this.paymentOrderId = paymentOrderId;
//    }
//
//    public boolean isBlockNonCCDCPaymodes() {
//        return this.blockNonCCDCPaymodes;
//    }
//
//    public void setBlockNonCCDCPaymodes(boolean blockNonCCDCPaymodes) {
//        this.blockNonCCDCPaymodes = blockNonCCDCPaymodes;
//    }
//
//    public boolean isFlexiSubscription() {
//        return this.flexiSubscription;
//    }
//
//    public void setFlexiSubscription(boolean flexiSubscription) {
//        this.flexiSubscription = flexiSubscription;
//    }
//
//    public boolean isDccSelectedByUser() {
//        return this.dccSelectedByUser;
//    }
//
//    public void setDccSelectedByUser(boolean dccSelectedByUser) {
//        this.dccSelectedByUser = dccSelectedByUser;
//    }
//
//    public boolean isPaymentCallFromDccPage() {
//        return this.paymentCallFromDccPage;
//    }
//
//    public void setPaymentCallFromDccPage(boolean paymentCallFromDccPage) {
//        this.paymentCallFromDccPage = paymentCallFromDccPage;
//    }
//
//    public boolean getUseInvestmentAsFundingSource() {
//        return this.useInvestmentAsFundingSource;
//    }
//
//    public void setUseInvestmentAsFundingSource(boolean useInvestmentAsFundingSource) {
//        this.useInvestmentAsFundingSource = useInvestmentAsFundingSource;
//    }
//
//    public boolean isPaymentResumed() {
//        return this.paymentResumed;
//    }
//
//    public void setPaymentResumed(boolean paymentResumed) {
//        this.paymentResumed = paymentResumed;
//    }
//
//    public PaymentOffer getPaymentOffer() {
//        return this.paymentOffer;
//    }
//
//    public void setPaymentOffer(PaymentOffer paymentOffer) {
//        this.paymentOffer = paymentOffer;
//    }
//
//    public String getPaymodeSequence() {
//        return this.paymodeSequence;
//    }
//
//    public void setPaymodeSequence(String paymodeSequence) {
//        this.paymodeSequence = paymodeSequence;
//    }
//
//    public EmiSubventionInfo getEmiSubventionInfo() {
//        return this.emiSubventionInfo;
//    }
//
//    public void setEmiSubventionInfo(EmiSubventionInfo emiSubventionInfo) {
//        this.emiSubventionInfo = emiSubventionInfo;
//    }
//
//    public VanInfo getVanInfo() {
//        return this.vanInfo;
//    }
//
//    public void setVanInfo(VanInfo vanInfo) {
//        this.vanInfo = vanInfo;
//    }
//
//    public List<TpvInfo> getTpvInfos() {
//        return this.tpvInfos;
//    }
//
//    public void setTpvInfos(List<TpvInfo> tpvInfos) {
//        this.tpvInfos = tpvInfos;
//    }
//
//    public String getFeesAmount() {
//        return this.feesAmount;
//    }
//
//    public void setFeesAmount(String feesAmount) {
//        this.feesAmount = feesAmount;
//    }
//
//    public String getCardPreAuthType() {
//        return this.cardPreAuthType;
//    }
//
//    public void setCardPreAuthType(String cardPreAuthType) {
//        this.cardPreAuthType = cardPreAuthType;
//    }
//
//    public Long getPreAuthBlockSeconds() {
//        return this.preAuthBlockSeconds;
//    }
//
//    public void setPreAuthBlockSeconds(Long preAuthBlockSeconds) {
//        this.preAuthBlockSeconds = preAuthBlockSeconds;
//    }
//
//    public PaymentOfferV2 getPaymentOfferV2() {
//        return this.paymentOfferV2;
//    }
//
//    public void setPaymentOfferV2(PaymentOfferV2 paymentOfferV2) {
//        this.paymentOfferV2 = paymentOfferV2;
//    }
//
//    public String getPreferredOtpPage() {
//        return this.preferredOtpPage;
//    }
//
//    public void setPreferredOtpPage(String preferredOtpPage) {
//        this.preferredOtpPage = preferredOtpPage;
//    }
//
//    public boolean isNeedAppIntentEndpoint() {
//        return this.needAppIntentEndpoint;
//    }
//
//    public void setNeedAppIntentEndpoint(boolean needAppIntentEndpoint) {
//        this.needAppIntentEndpoint = needAppIntentEndpoint;
//    }
//
//    public String getAppCallbackUrl() {
//        return this.appCallbackUrl;
//    }
//
//    public void setAppCallbackUrl(String appCallbackUrl) {
//        this.appCallbackUrl = appCallbackUrl;
//    }
//
//    public String getBrowserName() {
//        return this.browserName;
//    }
//
//    public void setBrowserName(String browserName) {
//        this.browserName = browserName;
//    }
//
//    public String getRequestedTimeStamp() {
//        return this.requestedTimeStamp;
//    }
//
//    public void setRequestedTimeStamp(String requestedTimeStamp) {
//        this.requestedTimeStamp = requestedTimeStamp;
//    }
//
//    public boolean isUpiConvertedToAddNPay() {
//        return this.upiConvertedToAddNPay;
//    }
//
//    public boolean isAddNPayOnPostpaidSupported() {
//        return this.addNPayOnPostpaidSupported;
//    }
//
//    public void setAddNPayOnPostpaidSupported(boolean addNPayOnPostpaidSupported) {
//        this.addNPayOnPostpaidSupported = addNPayOnPostpaidSupported;
//    }
//
//    public boolean isAppInvoke() {
//        return this.appInvoke;
//    }
//
//    public void setAppInvoke(boolean appInvoke) {
//        this.appInvoke = appInvoke;
//    }
//
//    public String getFromAOARequest() {
//        return this.fromAOARequest;
//    }
//
//    public void setFromAOARequest(String fromAOARequest) {
//        this.fromAOARequest = fromAOARequest;
//    }
//
//    public CoftConsent getCoftConsent() {
//        return this.coftConsent;
//    }
//
//    public void setCoftConsent(CoftConsent coftConsent) {
//        this.coftConsent = coftConsent;
//    }
//
//    public boolean isCoftTokenTxn() {
//        return this.isCoftTokenTxn;
//    }
//
//    public void setCoftTokenTxn(boolean coftTokenTxn) {
//        this.isCoftTokenTxn = coftTokenTxn;
//    }
//
//    public boolean isReturnToken() {
//        return this.returnToken;
//    }
//
//    public void setReturnToken(boolean returnToken) {
//        this.returnToken = returnToken;
//    }
//
//    public CardTokenInfo getCardTokenInfo() {
//        return this.cardTokenInfo;
//    }
//
//    public void setCardTokenInfo(CardTokenInfo cardTokenInfo) {
//        this.cardTokenInfo = cardTokenInfo;
//    }
//
//    public com.paytm.pgplus.common.model.link.LinkDetailResponseBody getLinkDetailsData() {
//        return this.linkDetailsData;
//    }
//
//    public void setLinkDetailsData(com.paytm.pgplus.common.model.link.LinkDetailResponseBody linkDetailsData) {
//        this.linkDetailsData = linkDetailsData;
//    }
//
//    public Boolean getEdcLinkTxn() {
//        return this.edcLinkTxn;
//    }
//
//    public void setEdcLinkTxn(Boolean edcLinkTxn) {
//        this.edcLinkTxn = edcLinkTxn;
//    }
//
//    public String getEmiSubventionStratergy() {
//        return this.emiSubventionStratergy;
//    }
//
//    public void setEmiSubventionStratergy(String emiSubventionStratergy) {
//        this.emiSubventionStratergy = emiSubventionStratergy;
//    }
//
//    public com.paytm.pgplus.facade.payment.models.EMIChannelInfo getEmiChannelInfo() {
//        return this.emiChannelInfo;
//    }
//
//    public void setEmiChannelInfo(EMIChannelInfo emiChannelInfo) {
//        this.emiChannelInfo = emiChannelInfo;
//    }
//
//    public boolean isAoaSubsOnPgMid() {
//        return this.aoaSubsOnPgMid;
//    }
//
//    public void setAoaSubsOnPgMid(boolean aoaSubsOnPgMid) {
//        this.aoaSubsOnPgMid = aoaSubsOnPgMid;
//    }
//
//    public boolean isSubsAoaPgMidTxn() {
//        return this.subsAoaPgMidTxn;
//    }
//
//    public void setSubsAoaPgMidTxn(boolean subsAoaPgMidTxn) {
//        this.subsAoaPgMidTxn = subsAoaPgMidTxn;
//    }
//
//    public String getSgwReferenceId() {
//        return this.sgwReferenceId;
//    }
//
//    public void setSgwReferenceId(String sgwReferenceId) {
//        this.sgwReferenceId = sgwReferenceId;
//    }
//
//    public com.paytm.pgplus.facade.acquiring.models.UltimateBeneficiaryDetails getUltimateBeneficiaryDetails() {
//        return this.ultimateBeneficiaryDetails;
//    }
//
//    public void setUltimateBeneficiaryDetails(com.paytm.pgplus.facade.acquiring.models.UltimateBeneficiaryDetails ultimateBeneficiaryDetails) {
//        this.ultimateBeneficiaryDetails = ultimateBeneficiaryDetails;
//    }
//
//    public String getAmountForPaymentFlow() {
//        return this.amountForPaymentFlow;
//    }
//
//    public void setAmountForPaymentFlow(String amountForPaymentFlow) {
//        this.amountForPaymentFlow = amountForPaymentFlow;
//    }
//
//    public String getPayerCmid() {
//        return this.payerCmid;
//    }
//
//    public void setPayerCmid(String payerCmid) {
//        this.payerCmid = payerCmid;
//    }
//
//    public List<com.paytm.pgplus.common.model.PayerAccountDetails> getPayerAccountDetails() {
//        return this.payerAccountDetails;
//    }
//
//    public void setPayerAccountDetails(List<PayerAccountDetails> payerAccountDetails) {
//        this.payerAccountDetails = payerAccountDetails;
//    }
//
//    public String getCreateNonQRDeepLink() {
//        return this.createNonQRDeepLink;
//    }
//
//    public void setCreateNonQRDeepLink(String createNonQRDeepLink) {
//        this.createNonQRDeepLink = createNonQRDeepLink;
//    }
//
//    public String getUpiIntentLinkId() {
//        return this.upiIntentLinkId;
//    }
//
//    public void setUpiIntentLinkId(String upiIntentLinkId) {
//        this.upiIntentLinkId = upiIntentLinkId;
//    }
//
//    public com.paytm.pgplus.models.TwoFAConfig getTwoFAConfig() {
//        return this.twoFAConfig;
//    }
//
//    public void setTwoFAConfig(TwoFAConfig twoFAConfig) {
//        this.twoFAConfig = twoFAConfig;
//    }
//
//    public TwoFADetails getTwoFADetails() {
//        return this.twoFADetails;
//    }
//
//    public void setTwoFADetails(TwoFADetails twoFADetails) {
//        this.twoFADetails = twoFADetails;
//    }
//
//    public boolean isCCOnUPI() {
//        return this.isCCOnUPI;
//    }
//
//    public void setCCOnUPI(boolean CCOnUPI) {
//        this.isCCOnUPI = CCOnUPI;
//    }
//
//    public com.paytm.pgplus.payloadvault.theia.request.UpiLiteRequestData getUpiLiteRequestData() {
//        return this.upiLiteRequestData;
//    }
//
//    public void setUpiLiteRequestData(UpiLiteRequestData upiLiteRequestData) {
//        this.upiLiteRequestData = upiLiteRequestData;
//    }
//
//    public String getMerchantVpa() {
//        return this.merchantVpa;
//    }
//
//    public void setMerchantVpa(String merchantVpa) {
//        this.merchantVpa = merchantVpa;
//    }
//
//    public Boolean getAddOneRupee() {
//        return this.addOneRupee;
//    }
//
//    public void setAddOneRupee(Boolean addOneRupee) {
//        this.addOneRupee = addOneRupee;
//    }
//
//    public Boolean isVariableLengthOtpSupported() {
//        return this.variableLengthOtpSupported;
//    }
//
//    public void setVariableLengthOtpSupported(Boolean variableLengthOtpSupported) {
//        this.variableLengthOtpSupported = variableLengthOtpSupported;
//    }
//
//    public boolean isDealsFlow() {
//        return this.isDealsFlow;
//    }
//
//    public void setDealsFlow(boolean dealsFlow) {
//        this.isDealsFlow = dealsFlow;
//    }
//
//    public boolean isOrderPSPRequest() {
//        return this.orderPSPRequest;
//    }
//
//    public void setOrderPSPRequest(boolean orderPSPRequest) {
//        this.orderPSPRequest = orderPSPRequest;
//    }
//
//    public boolean isSuperGwFpoApiHit() {
//        return this.superGwFpoApiHit;
//    }
//
//    public void setSuperGwFpoApiHit(boolean superGwFpoApiHit) {
//        this.superGwFpoApiHit = superGwFpoApiHit;
//    }
//
//    public String getSimSubscriptionId() {
//        return this.simSubscriptionId;
//    }
//
//    public void setSimSubscriptionId(String simSubscriptionId) {
//        this.simSubscriptionId = simSubscriptionId;
//    }
//
//    public String getSource() {
//        return this.source;
//    }
//
//    public void setSource(String source) {
//        this.source = source;
//    }
//
//    public String getDqrLinkId() {
//        return this.dqrLinkId;
//    }
//
//    public void setDqrLinkId(String dqrLinkId) {
//        this.dqrLinkId = dqrLinkId;
//    }
//
//    public String getDqrInvoiceId() {
//        return this.dqrInvoiceId;
//    }
//
//    public void setDqrInvoiceId(String dqrInvoiceId) {
//        this.dqrInvoiceId = dqrInvoiceId;
//    }
//
//    public String getQrTxnAmountInRupees() {
//        return this.qrTxnAmountInRupees;
//    }
//
//    public void setQrTxnAmountInRupees(String qrTxnAmountInRupees) {
//        this.qrTxnAmountInRupees = qrTxnAmountInRupees;
//    }
//
//    public boolean isQRIdFlowOnly() {
//        return this.isQRIdFlowOnly;
//    }
//
//    public void setQRIdFlowOnly(boolean QRIdFlowOnly) {
//        this.isQRIdFlowOnly = QRIdFlowOnly;
//    }
//
//    public boolean isGenerateEsnRequest() {
//        return this.isGenerateEsnRequest;
//    }
//
//    public void setGenerateEsnRequest(boolean generateEsnRequest) {
//        this.isGenerateEsnRequest = generateEsnRequest;
//    }
//
//    public boolean isCvvLessTransaction() {
//        return this.cvvLessTransaction;
//    }
//
//    public void setCvvLessTransaction(boolean cvvLessTransaction) {
//        this.cvvLessTransaction = cvvLessTransaction;
//    }
//}
