package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class ExtendInfo implements Serializable {
    private static final long serialVersionUID = -2016566338798065270L;
    @JsonProperty("udf1")
    private String udf1;
    @JsonProperty("udf2")
    private String udf2;
    @JsonProperty("udf3")
    private String udf3;
    @JsonProperty("mercUnqRef")
    private String mercUnqRef;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("amountToBeRefunded")
    private String amountToBeRefunded;
    private String subwalletAmount;
    @JsonProperty("linkId")
    private String linkId;
    @JsonProperty("linkDesc")
    private String linkDesc;
    @JsonProperty("linkName")
    private String linkName;
    @JsonProperty("linkInvoiceId")
    private String linkInvoiceId;
    @JsonProperty("orderAdditionalInfo")
    private Map<String, String> orderAdditionalInfo;
    @JsonProperty("upiLiteExtendInfo")
    private Map<String, String> upiLiteExtendInfo;
    private String sdkType;
    private SubsLinkInfo subsLinkInfo;
    @JsonProperty("headAccount")
    private String headAccount;
    @JsonProperty("remitterName")
    private String remitterName;
    private String isCallbackWebsiteDerived;
    private String latitude;
    private String longitude;
    private String userLBSLatitude;
    private String userLBSLongitude;

    public ExtendInfo() {
    }

    @JsonSetter("subwalletAmount")
    public void setSubwalletAmount(Object subwalletAmount) {
        if (subwalletAmount != null) {
            if (subwalletAmount instanceof Map) {
                Map<String, String> subwalletAmountMap = (Map)subwalletAmount;
                JSONObject subwalletAmountJson = new JSONObject(subwalletAmountMap);
                this.subwalletAmount = subwalletAmountJson.toString();
            } else {
                this.subwalletAmount = String.valueOf(subwalletAmount);
            }
        }

    }

    public String getUdf1() {
        return this.udf1;
    }

    public void setUdf1(String udf1) {
        this.udf1 = udf1;
    }

    public String getUdf2() {
        return this.udf2;
    }

    public void setUdf2(String udf2) {
        this.udf2 = udf2;
    }

    public String getUdf3() {
        return this.udf3;
    }

    public void setUdf3(String udf3) {
        this.udf3 = udf3;
    }

    public String getMercUnqRef() {
        return this.mercUnqRef;
    }

    public void setMercUnqRef(String mercUnqRef) {
        this.mercUnqRef = mercUnqRef;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAmountToBeRefunded() {
        return this.amountToBeRefunded;
    }

    public String getSubwalletAmount() {
        return this.subwalletAmount;
    }

    public void setAmountToBeRefunded(String amountToBeRefunded) {
        this.amountToBeRefunded = amountToBeRefunded;
    }

    public String getLinkId() {
        return this.linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getLinkDesc() {
        return this.linkDesc;
    }

    public void setLinkDesc(String linkDesc) {
        this.linkDesc = linkDesc;
    }

    public String getLinkName() {
        return this.linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkInvoiceId() {
        return this.linkInvoiceId;
    }

    public void setLinkInvoiceId(String linkInvoiceId) {
        this.linkInvoiceId = linkInvoiceId;
    }

    public Map<String, String> getOrderAdditionalInfo() {
        return this.orderAdditionalInfo;
    }

    public void setOrderAdditionalInfo(Map<String, String> orderAdditionalInfo) {
        this.orderAdditionalInfo = orderAdditionalInfo;
    }

    public String getSdkType() {
        return this.sdkType;
    }

    public void setSdkType(String sdkType) {
        this.sdkType = sdkType;
    }

    public SubsLinkInfo getSubsLinkInfo() {
        return this.subsLinkInfo;
    }

    public void setSubsLinkInfo(SubsLinkInfo subsLinkInfo) {
        this.subsLinkInfo = subsLinkInfo;
    }

    public String getHeadAccount() {
        return this.headAccount;
    }

    public void setHeadAccount(String headAccount) {
        this.headAccount = headAccount;
    }

    public String getRemitterName() {
        return this.remitterName;
    }

    public void setRemitterName(String remitterName) {
        this.remitterName = remitterName;
    }

    public String getIsCallbackWebsiteDerived() {
        return this.isCallbackWebsiteDerived;
    }

    public void setIsCallbackWebsiteDerived(String isCallbackWebsiteDerived) {
        this.isCallbackWebsiteDerived = isCallbackWebsiteDerived;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getUserLBSLatitude() {
        return this.userLBSLatitude;
    }

    public void setUserLBSLatitude(String userLBSLatitude) {
        this.userLBSLatitude = userLBSLatitude;
    }

    public String getUserLBSLongitude() {
        return this.userLBSLongitude;
    }

    public void setUserLBSLongitude(String userLBSLongitude) {
        this.userLBSLongitude = userLBSLongitude;
    }

    public Map<String, String> getUpiLiteExtendInfo() {
        if (this.upiLiteExtendInfo == null) {
            this.upiLiteExtendInfo = new HashMap();
        }

        return this.upiLiteExtendInfo;
    }

    public void setUpiLiteExtendInfo(Map<String, String> upiLiteExtendInfo) {
        this.upiLiteExtendInfo = upiLiteExtendInfo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ExtendInfo{");
        sb.append("udf1='").append(this.udf1).append('\'');
        sb.append(", udf2='").append(this.udf2).append('\'');
        sb.append(", udf3='").append(this.udf3).append('\'');
        sb.append(", mercUnqRef='").append(this.mercUnqRef).append('\'');
        sb.append(", comments='").append(this.comments).append('\'');
        sb.append(", amountToBeRefunded='").append(this.amountToBeRefunded).append('\'');
        sb.append(", linkId='").append(this.linkId).append('\'');
        sb.append(", linkDesc='").append(this.linkDesc).append('\'');
        sb.append(", linkName='").append(this.linkName).append('\'');
        sb.append(", linkInvoiceId='").append(this.linkInvoiceId).append('\'');
        sb.append(", orderAdditionalInfo='").append(this.orderAdditionalInfo).append('\'');
        sb.append(", sdkType='").append(this.sdkType).append('\'');
        sb.append(", headAccount='").append(this.headAccount).append('\'');
        sb.append(", remitterName='").append(this.remitterName).append('\'');
        sb.append(", isCallbackWebsiteDerived='").append(this.isCallbackWebsiteDerived).append('\'');
        sb.append(", latitude='").append(this.latitude).append('\'');
        sb.append(", longitude='").append(this.longitude).append('\'');
        sb.append(", userLBSLatitude='").append(this.userLBSLatitude).append('\'');
        sb.append(", userLBSLongitude='").append(this.userLBSLongitude).append('\'');
        sb.append(", upiLiteExtendInfo='").append(this.upiLiteExtendInfo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
