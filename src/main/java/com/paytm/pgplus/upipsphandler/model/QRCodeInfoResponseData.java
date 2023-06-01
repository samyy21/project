package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QRCodeInfoResponseData implements Serializable {
    private static final long serialVersionUID = 967085119662238367L;
    private static final String REQUEST_TYPE = "REQUEST_TYPE";
    private static final String EXPIRY_DATE = "EXPIRY_DATE";
    private static final String MERCHANT_NAME = "MERCHANT_NAME";
    private static final String MOBILE_NO = "MOBILE_NO";
    private static final String TXN_AMOUNT = "TXN_AMOUNT";
    private static final String INDUSTRY_TYPE_ID = "INDUSTRY_TYPE_ID";
    private static final String MERCHANT_GUID = "MERCHANT_GUID";
    private static final String ORDER_ID = "ORDER_ID";
    private static final String NAME = "NAME";
    private static final String MERCHANT_STATUS = "MERCHANT_STATUS";
    private static final String CHANNEL_ID = "CHANNEL_ID";
    private static final String PRODUCT_CODE = "PRODUCT_CODE";
    private String payeeType;
    @JsonInclude(
            value = JsonInclude.Include.CUSTOM,
            valueFilter = FetchQrDetailsV2Filter.class
    )
    private String currencyCode;
    @JsonInclude(
            value = JsonInclude.Include.CUSTOM,
            valueFilter = FetchQrDetailsV2Filter.class
    )
    private String category;
    @JsonInclude(
            value = JsonInclude.Include.CUSTOM,
            valueFilter = FetchQrDetailsV2Filter.class
    )
    private String subCategory;
    private String service;
    private String posId;
    private String mode;
    private String offlinePostConvenience;
    private String mappingId;
    private String pgEnabled;
    private String qrCodeId;
    @JsonProperty("REQUEST_TYPE")
    private String requestType;
    @JsonProperty("EXPIRY_DATE")
    private String expiryDate;
    @JsonProperty("MERCHANT_NAME")
    private String merchantName;
    @JsonProperty("NAME")
    private String name;
    @JsonProperty("MOBILE_NO")
    private String mobileNumber;
    @JsonProperty("TXN_AMOUNT")
    private String txnAmount;
    @JsonProperty("INDUSTRY_TYPE_ID")
    private String industryTypeId;
    @JsonProperty("MERCHANT_GUID")
    private String merchantGuid;
    @JsonProperty("ORDER_ID")
    private String orderId;
    private Map<Object, Object> extendedInfo;
    private String merchantContactNo;
    private String url;
    @JsonInclude(
            value = JsonInclude.Include.CUSTOM,
            valueFilter = FetchQrDetailsV2Filter.class
    )
    private String payeeId;
    private String payeeGuid;
    private String payeePhoneNo;
    private String payeeEmailId;
    private String payeeName;
    @JsonInclude(
            value = JsonInclude.Include.CUSTOM,
            valueFilter = FetchQrDetailsV2Filter.class
    )
    private String qrMetaData;
    private String tagLine;
    @JsonInclude(
            value = JsonInclude.Include.CUSTOM,
            valueFilter = FetchQrDetailsV2Filter.class
    )
    private String callBackUrl;
    private String payerId;
    private String merchantTransId;
    private boolean merchantVerified;
    @JsonInclude(
            value = JsonInclude.Include.CUSTOM,
            valueFilter = FetchQrDetailsV2Filter.class
    )
    private String payeeSecondaryNumber;
    private String secondaryPhoneNumbers;
    private String mid;
    @JsonInclude(
            value = JsonInclude.Include.CUSTOM,
            valueFilter = FetchQrDetailsV2Filter.class
    )
    private InvoiceDetails invoiceDetails;
    private String orderAlreadyCreated;
    private String chargeAmount;
    @JsonProperty("CHANNEL_ID")
    private String channelId;
    private boolean orderQr;
    private String kybId;
    private String shopId;
    @JsonProperty("PRODUCT_CODE")
    private String productCode;
    private String subwalletWithdrawMaxAmountDetails;
    private String isEdcRequest;
    private String gstIn;
    private String gstBrkUp;
    private String invoiceNo;
    private String invoiceDate;
    private String enTips;
    private String payerConsent;
    private String skipOrderCreation;

    public QRCodeInfoResponseData() {
    }

    public String getChargeAmount() {
        return this.chargeAmount;
    }

    public void setChargeAmount(String chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public String getOrderAlreadyCreated() {
        return this.orderAlreadyCreated;
    }

    public void setOrderAlreadyCreated(String orderAlreadyCreated) {
        this.orderAlreadyCreated = orderAlreadyCreated;
    }

    public String getPayeeType() {
        return this.payeeType;
    }

    public void setPayeeType(String payeeType) {
        this.payeeType = payeeType;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPosId() {
        return this.posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getOfflinePostConvenience() {
        return this.offlinePostConvenience;
    }

    public void setOfflinePostConvenience(String offlinePostConvenience) {
        this.offlinePostConvenience = offlinePostConvenience;
    }

    public String getMappingId() {
        return this.mappingId;
    }

    public void setMappingId(String mappingId) {
        this.mappingId = mappingId;
    }

    public String getPgEnabled() {
        return this.pgEnabled;
    }

    public void setPgEnabled(String pgEnabled) {
        this.pgEnabled = pgEnabled;
    }

    public String getQrCodeId() {
        return this.qrCodeId;
    }

    public void setQrCodeId(String qrCodeId) {
        this.qrCodeId = qrCodeId;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getTxnAmount() {
        return this.txnAmount;
    }

    public void setTxnAmount(String txnAmount) {
        this.txnAmount = txnAmount;
    }

    public String getIndustryTypeId() {
        return this.industryTypeId;
    }

    public void setIndustryTypeId(String industryTypeId) {
        this.industryTypeId = industryTypeId;
    }

    public String getMerchantGuid() {
        return this.merchantGuid;
    }

    public void setMerchantGuid(String merchantGuid) {
        this.merchantGuid = merchantGuid;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Map<Object, Object> getExtendedInfo() {
        return this.extendedInfo;
    }

    public void setExtendedInfo(Map<Object, Object> extendedInfo) {
        this.extendedInfo = extendedInfo;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantContactNo() {
        return this.merchantContactNo;
    }

    public static String getMerchantStatus() {
        return "MERCHANT_STATUS";
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPayeeId() {
        return this.payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public String getPayeeGuid() {
        return this.payeeGuid;
    }

    public void setPayeeGuid(String payeeGuid) {
        this.payeeGuid = payeeGuid;
    }

    public String getPayeePhoneNo() {
        return this.payeePhoneNo;
    }

    public void setPayeePhoneNo(String payeePhoneNo) {
        this.payeePhoneNo = payeePhoneNo;
    }

    public String getPayeeEmailId() {
        return this.payeeEmailId;
    }

    public void setPayeeEmailId(String payeeEmailId) {
        this.payeeEmailId = payeeEmailId;
    }

    public String getPayeeName() {
        return this.payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getQrMetaData() {
        return this.qrMetaData;
    }

    public void setQrMetaData(String qrMetaData) {
        this.qrMetaData = qrMetaData;
    }

    public String getTagLine() {
        return this.tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public String getCallBackUrl() {
        return this.callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    public String getPayerId() {
        return this.payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getMerchantTransId() {
        return this.merchantTransId;
    }

    public void setMerchantTransId(String merchantTransId) {
        this.merchantTransId = merchantTransId;
    }

    public boolean isMerchantVerified() {
        return this.merchantVerified;
    }

    public void setMerchantVerified(boolean merchantVerified) {
        this.merchantVerified = merchantVerified;
    }

    public void setMerchantContactNo(String merchantContactNo) {
        this.merchantContactNo = merchantContactNo;
    }

    public String getPayeeSecondaryNumber() {
        return this.payeeSecondaryNumber;
    }

    public void setPayeeSecondaryNumber(String payeeSecondaryNumber) {
        this.payeeSecondaryNumber = payeeSecondaryNumber;
    }

    public String getSecondaryPhoneNumbers() {
        return this.secondaryPhoneNumbers;
    }

    public void setSecondaryPhoneNumbers(String secondaryPhoneNumbers) {
        this.secondaryPhoneNumbers = secondaryPhoneNumbers;
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public InvoiceDetails getInvoiceDetails() {
        return this.invoiceDetails;
    }

    public void setInvoiceDetails(InvoiceDetails invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public boolean isOrderQr() {
        return this.orderQr;
    }

    public void setOrderQr(boolean orderQr) {
        this.orderQr = orderQr;
    }

    public String getKybId() {
        return this.kybId;
    }

    public void setKybId(String kybId) {
        this.kybId = kybId;
    }

    public String getShopId() {
        return this.shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getSubwalletWithdrawMaxAmountDetails() {
        return this.subwalletWithdrawMaxAmountDetails;
    }

    public void setSubwalletWithdrawMaxAmountDetails(String subwalletWithdrawMaxAmountDetails) {
        this.subwalletWithdrawMaxAmountDetails = subwalletWithdrawMaxAmountDetails;
    }

    public String getIsEdcRequest() {
        return this.isEdcRequest;
    }

    public void setIsEdcRequest(String isEdcRequest) {
        this.isEdcRequest = isEdcRequest;
    }

    public String getGstIn() {
        return this.gstIn;
    }

    public void setGstIn(String gstIn) {
        this.gstIn = gstIn;
    }

    public String getGstBrkUp() {
        return this.gstBrkUp;
    }

    public void setGstBrkUp(String gstBrkUp) {
        this.gstBrkUp = gstBrkUp;
    }

    public String getInvoiceNo() {
        return this.invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceDate() {
        return this.invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getEnTips() {
        return this.enTips;
    }

    public void setEnTips(String enTips) {
        this.enTips = enTips;
    }

    public String getPayerConsent() {
        return this.payerConsent;
    }

    public void setPayerConsent(String payerConsent) {
        this.payerConsent = payerConsent;
    }

    public String getSkipOrderCreation() {
        return this.skipOrderCreation;
    }

    public void setSkipOrderCreation(String skipOrderCreation) {
        this.skipOrderCreation = skipOrderCreation;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("QRCodeInfoResponseData [payeeType=").append(this.payeeType).append(", currencyCode=").append(this.currencyCode).append(", category=").append(this.category).append(", subCategory=").append(this.subCategory).append(", service=").append(this.service).append(", posId=").append(this.posId).append(", mode=").append(this.mode).append(", offlinePostConvenience=").append(this.offlinePostConvenience).append(", mappingId=").append(this.mappingId).append(", pgEnabled=").append(this.pgEnabled).append(", qrCodeId=").append(this.qrCodeId).append(", requestType=").append(this.requestType).append(", expiryDate=").append(this.expiryDate).append(", name=").append(this.name).append(", mobileNumber=").append(this.mobileNumber).append(", txnAmount=").append(this.txnAmount).append(", industryTypeId=").append(this.industryTypeId).append(", merchantGuid=").append(this.merchantGuid).append(", orderId=").append(this.orderId).append(", merchantName=").append(this.merchantName).append(", extendedInfo=").append(this.extendedInfo).append(", merchantContactNo").append(this.merchantContactNo).append(", url=").append(this.url).append(", payeeId=").append(this.payeeId).append(", payeeGuid=").append(this.payeeGuid).append(", payeePhoneNo=").append(this.payeePhoneNo).append(", payeeEmailId=").append(this.payeeEmailId).append(", payeeName=").append(this.payeeName).append(", qrMetaData=").append(this.qrMetaData).append(", tagLine=").append(this.tagLine).append(", callBackUrl=").append(this.callBackUrl).append(", payerId=").append(this.payerId).append(", merchantTransId=").append(this.merchantTransId).append(", merchantVerified=").append(this.merchantVerified).append(", orderAlreadyCreated=").append(this.orderAlreadyCreated).append(", chargeAmount=").append(this.chargeAmount).append(", channelId=").append(this.channelId).append(", orderQr=").append(this.orderQr).append(", kybId=").append(this.kybId).append(", shopId=").append(", productCode=").append(this.productCode).append(this.shopId).append(", subwalletWithdrawMaxAmountDetails=").append(this.subwalletWithdrawMaxAmountDetails).append(", isEdcRequest=").append(this.isEdcRequest).append(", gstIn=").append(this.gstIn).append(", gstBrkUp=").append(this.gstBrkUp).append(", invoiceNo=").append(this.invoiceNo).append(", invoiceDate=").append(this.invoiceDate).append(", enTips=").append(this.enTips).append(", payerConsent=").append(this.payerConsent).append("]");
        return builder.toString();
    }
}