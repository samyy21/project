package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class OfferDetail implements Serializable {
    private static final long serialVersionUID = 351093415600877382L;
    private String offerId;
    private List<String> velocityOfferId;

    public OfferDetail() {
    }

    public String getOfferId() {
        return this.offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public List<String> getVelocityOfferId() {
        return this.velocityOfferId;
    }

    public void setVelocityOfferId(List<String> velocityOfferId) {
        this.velocityOfferId = velocityOfferId;
    }

    public String toString() {
        return "OfferDetail{offerId='" + this.offerId + '\'' + "velocityOfferId=" + this.velocityOfferId + '}';
    }
}

