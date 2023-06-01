package com.paytm.pgplus.upipsphandler.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class VanInfo implements Serializable {
    private static final long serialVersionUID = -6492696572038562203L;
    private String van;
    private String entityId;
    private String beneficiaryName;
    private String ifscCode;
    private String bankName;
    private String purpose;
    private UserDefinedFields userDefinedFields;
    private List<CustomerDetails> customerDetails;
    private Map<String, String> extendInfo;
    private String identificationNo;
    private String merchantPrefix;
    private String checkoutFlow;

    public VanInfo() {
    }

    public String getVan() {
        return this.van;
    }

    public void setVan(String van) {
        this.van = van;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getBeneficiaryName() {
        return this.beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getIfscCode() {
        return this.ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPurpose() {
        return this.purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public UserDefinedFields getUserDefinedFields() {
        return this.userDefinedFields;
    }

    public void setUserDefinedFields(UserDefinedFields userDefinedFields) {
        this.userDefinedFields = userDefinedFields;
    }

    public List<CustomerDetails> getCustomerDetails() {
        return this.customerDetails;
    }

    public void setCustomerDetails(List<CustomerDetails> customerDetails) {
        this.customerDetails = customerDetails;
    }

    public Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(Map<String, String> extendInfo) {
        this.extendInfo = extendInfo;
    }

    public String getIdentificationNo() {
        return this.identificationNo;
    }

    public void setIdentificationNo(String identificationNo) {
        this.identificationNo = identificationNo;
    }

    public String getMerchantPrefix() {
        return this.merchantPrefix;
    }

    public void setMerchantPrefix(String merchantPrefix) {
        this.merchantPrefix = merchantPrefix;
    }

    public String getCheckoutFlow() {
        return this.checkoutFlow;
    }

    public void setCheckoutFlow(String checkoutFlow) {
        this.checkoutFlow = checkoutFlow;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VanInfo{");
        sb.append("van='").append(this.van).append('\'');
        sb.append(", entityId='").append(this.entityId).append('\'');
        sb.append(", beneficiaryName='").append(this.beneficiaryName).append('\'');
        sb.append(", ifscCode='").append(this.ifscCode).append('\'');
        sb.append(", bankName='").append(this.bankName).append('\'');
        sb.append(", purpose='").append(this.purpose).append('\'');
        sb.append(", userDefinedFields=").append(this.userDefinedFields);
        sb.append(", customerDetails=").append(this.customerDetails);
        sb.append(", extendInfo=").append(this.extendInfo);
        sb.append(", identificationNo='").append(this.identificationNo).append('\'');
        sb.append(", merchantPrefix='").append(this.merchantPrefix).append('\'');
        sb.append(", checkoutFlow='").append(this.checkoutFlow).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

