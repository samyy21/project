package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class PromoCodeResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String resultStatus;
    private String resultMsg;
    private String promoResponseCode;
    private PromoCodeData promoCodeDetail;
    private String checkPromoValidityURL;
    private String paymentModes;
    private String nbBanks;

    public PromoCodeResponse() {
    }

    public String getNbBanks() {
        return this.nbBanks;
    }

    public void setNbBanks(String nbBanks) {
        this.nbBanks = nbBanks;
    }

    public String getResultStatus() {
        return this.resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getPromoResponseCode() {
        return this.promoResponseCode;
    }

    public void setPromoResponseCode(String promoResponseCode) {
        this.promoResponseCode = promoResponseCode;
    }

    public PromoCodeData getPromoCodeDetail() {
        return this.promoCodeDetail;
    }

    public void setPromoCodeDetail(PromoCodeData promoCodeDetail) {
        this.promoCodeDetail = promoCodeDetail;
    }

    public String getCheckPromoValidityURL() {
        return this.checkPromoValidityURL;
    }

    public void setCheckPromoValidityURL(String checkPromoValidityURL) {
        this.checkPromoValidityURL = checkPromoValidityURL;
    }

    public String getPaymentModes() {
        return this.paymentModes;
    }

    public void setPaymentModes(String paymentModes) {
        this.paymentModes = paymentModes;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PromoCodeResponse [resultStatus=").append(this.resultStatus).append(", resultMsg=").append(this.resultMsg).append(", promoResponseCode=").append(this.promoResponseCode).append(", promoCodeDetail=").append(this.promoCodeDetail).append(", checkPromoValidityURL=").append(this.checkPromoValidityURL).append(", paymentModes=").append(this.paymentModes).append(", nbBanks=").append(this.nbBanks).append("]");
        return builder.toString();
    }
}

