package com.paytm.pgplus.upipsphandler.model;

import java.io.Serializable;

public class SimplifiedPaymentOffers implements Serializable {
    private static final long serialVersionUID = 1055633537338061499L;
    private String promoCode;
    private boolean applyAvailablePromo;
    private boolean validatePromo;
    private String promoAmount;
    private PromoCartDetails cartDetails;

    public SimplifiedPaymentOffers() {
    }

    public String getPromoCode() {
        return this.promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public boolean isApplyAvailablePromo() {
        return this.applyAvailablePromo;
    }

    public void setApplyAvailablePromo(boolean applyAvailablePromo) {
        this.applyAvailablePromo = applyAvailablePromo;
    }

    public boolean isValidatePromo() {
        return this.validatePromo;
    }

    public void setValidatePromo(boolean validatePromo) {
        this.validatePromo = validatePromo;
    }

    public String getPromoAmount() {
        return this.promoAmount;
    }

    public void setPromoAmount(String promoAmount) {
        this.promoAmount = promoAmount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SimplifiedPaymentOffer{");
        sb.append("promoCode='").append(this.promoCode).append('\'');
        sb.append(", applyAvailablePromo=").append(this.applyAvailablePromo);
        sb.append(", validatePromo=").append(this.validatePromo);
        sb.append(", promoAmount=").append(this.promoAmount);
        sb.append(", cartDetails=").append(this.cartDetails);
        sb.append('}');
        return sb.toString();
    }

    public PromoCartDetails getCartDetails() {
        return this.cartDetails;
    }

    public void setCartDetails(PromoCartDetails cartDetails) {
        this.cartDetails = cartDetails;
    }
}

