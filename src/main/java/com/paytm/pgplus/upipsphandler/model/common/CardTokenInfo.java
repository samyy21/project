package com.paytm.pgplus.upipsphandler.model.common;

import com.paytm.pgplus.Annotations.MaskToStringBuilder;

import java.beans.ConstructorProperties;
import java.io.Serializable;

public class CardTokenInfo implements Serializable {
    private static final long serialVersionUID = 1883519733218798977L;
    private String cardToken;
    private String tokenExpiry;
    private String TAVV;
    private String cardSuffix;
    private String panUniqueReference;
    private String tokenUniqueReference;
    private String merchantTokenRequestorId;

    public String toString() {
        return (new MaskToStringBuilder(this)).toString();
    }

    public String getCardToken() {
        return this.cardToken;
    }

    public String getTokenExpiry() {
        return this.tokenExpiry;
    }

    public String getTAVV() {
        return this.TAVV;
    }

    public String getCardSuffix() {
        return this.cardSuffix;
    }

    public String getPanUniqueReference() {
        return this.panUniqueReference;
    }

    public String getTokenUniqueReference() {
        return this.tokenUniqueReference;
    }

    public String getMerchantTokenRequestorId() {
        return this.merchantTokenRequestorId;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public void setTokenExpiry(String tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }

    public void setTAVV(String TAVV) {
        this.TAVV = TAVV;
    }

    public void setCardSuffix(String cardSuffix) {
        this.cardSuffix = cardSuffix;
    }

    public void setPanUniqueReference(String panUniqueReference) {
        this.panUniqueReference = panUniqueReference;
    }

    public void setTokenUniqueReference(String tokenUniqueReference) {
        this.tokenUniqueReference = tokenUniqueReference;
    }

    public void setMerchantTokenRequestorId(String merchantTokenRequestorId) {
        this.merchantTokenRequestorId = merchantTokenRequestorId;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CardTokenInfo)) {
            return false;
        } else {
            CardTokenInfo other = (CardTokenInfo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$cardToken = this.getCardToken();
                    Object other$cardToken = other.getCardToken();
                    if (this$cardToken == null) {
                        if (other$cardToken == null) {
                            break label95;
                        }
                    } else if (this$cardToken.equals(other$cardToken)) {
                        break label95;
                    }

                    return false;
                }

                Object this$tokenExpiry = this.getTokenExpiry();
                Object other$tokenExpiry = other.getTokenExpiry();
                if (this$tokenExpiry == null) {
                    if (other$tokenExpiry != null) {
                        return false;
                    }
                } else if (!this$tokenExpiry.equals(other$tokenExpiry)) {
                    return false;
                }

                Object this$TAVV = this.getTAVV();
                Object other$TAVV = other.getTAVV();
                if (this$TAVV == null) {
                    if (other$TAVV != null) {
                        return false;
                    }
                } else if (!this$TAVV.equals(other$TAVV)) {
                    return false;
                }

                label74: {
                    Object this$cardSuffix = this.getCardSuffix();
                    Object other$cardSuffix = other.getCardSuffix();
                    if (this$cardSuffix == null) {
                        if (other$cardSuffix == null) {
                            break label74;
                        }
                    } else if (this$cardSuffix.equals(other$cardSuffix)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$panUniqueReference = this.getPanUniqueReference();
                    Object other$panUniqueReference = other.getPanUniqueReference();
                    if (this$panUniqueReference == null) {
                        if (other$panUniqueReference == null) {
                            break label67;
                        }
                    } else if (this$panUniqueReference.equals(other$panUniqueReference)) {
                        break label67;
                    }

                    return false;
                }

                Object this$tokenUniqueReference = this.getTokenUniqueReference();
                Object other$tokenUniqueReference = other.getTokenUniqueReference();
                if (this$tokenUniqueReference == null) {
                    if (other$tokenUniqueReference != null) {
                        return false;
                    }
                } else if (!this$tokenUniqueReference.equals(other$tokenUniqueReference)) {
                    return false;
                }

                Object this$merchantTokenRequestorId = this.getMerchantTokenRequestorId();
                Object other$merchantTokenRequestorId = other.getMerchantTokenRequestorId();
                if (this$merchantTokenRequestorId == null) {
                    if (other$merchantTokenRequestorId != null) {
                        return false;
                    }
                } else if (!this$merchantTokenRequestorId.equals(other$merchantTokenRequestorId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.paytm.pgplus.common.model.CardTokenInfo;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $cardToken = this.getCardToken();
        result = result * 59 + ($cardToken == null ? 43 : $cardToken.hashCode());
        Object $tokenExpiry = this.getTokenExpiry();
        result = result * 59 + ($tokenExpiry == null ? 43 : $tokenExpiry.hashCode());
        Object $TAVV = this.getTAVV();
        result = result * 59 + ($TAVV == null ? 43 : $TAVV.hashCode());
        Object $cardSuffix = this.getCardSuffix();
        result = result * 59 + ($cardSuffix == null ? 43 : $cardSuffix.hashCode());
        Object $panUniqueReference = this.getPanUniqueReference();
        result = result * 59 + ($panUniqueReference == null ? 43 : $panUniqueReference.hashCode());
        Object $tokenUniqueReference = this.getTokenUniqueReference();
        result = result * 59 + ($tokenUniqueReference == null ? 43 : $tokenUniqueReference.hashCode());
        Object $merchantTokenRequestorId = this.getMerchantTokenRequestorId();
        result = result * 59 + ($merchantTokenRequestorId == null ? 43 : $merchantTokenRequestorId.hashCode());
        return result;
    }

    @ConstructorProperties({"cardToken", "tokenExpiry", "TAVV", "cardSuffix", "panUniqueReference", "tokenUniqueReference", "merchantTokenRequestorId"})
    public CardTokenInfo(String cardToken, String tokenExpiry, String TAVV, String cardSuffix, String panUniqueReference, String tokenUniqueReference, String merchantTokenRequestorId) {
        this.cardToken = cardToken;
        this.tokenExpiry = tokenExpiry;
        this.TAVV = TAVV;
        this.cardSuffix = cardSuffix;
        this.panUniqueReference = panUniqueReference;
        this.tokenUniqueReference = tokenUniqueReference;
        this.merchantTokenRequestorId = merchantTokenRequestorId;
    }

    public CardTokenInfo() {
    }
}

