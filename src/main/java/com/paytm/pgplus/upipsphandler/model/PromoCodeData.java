package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class PromoCodeData implements Serializable {
    private static final long serialVersionUID = 1L;
    private long promocodeId;
    private String promoCode;
    private Set<String> paymentModes;
    private Map<Integer, Long> cardBins;
    private Set<Long> nbBanks;
    private Set<Long> merchants;
    private String startDate;
    private String endDate;
    private long promocodeType;
    private String promocodeTypeName;
    private String promoMsg;
    private String promoErrorMsg;
    private Set<String> promoCardType;
    private String savedCardDate;
    private Map<Long, Integer> txnLimitMap;
    private int maxCount;
    private double maxAmount;
    private double minAmount;
    private boolean isCardLimit;
    private boolean isCustLimit;
    private boolean promoOnSavedCard;
    private boolean validatePromoWithWallet;

    public PromoCodeData() {
    }

    public boolean isValidatePromoWithWallet() {
        return this.validatePromoWithWallet;
    }

    public void setValidatePromoWithWallet(boolean validatePromoWithWallet) {
        this.validatePromoWithWallet = validatePromoWithWallet;
    }

    public String getSavedCardDate() {
        return this.savedCardDate;
    }

    public void setSavedCardDate(String savedCardDate) {
        this.savedCardDate = savedCardDate;
    }

    public Map<Long, Integer> getTxnLimitMap() {
        return this.txnLimitMap;
    }

    public void setTxnLimitMap(Map<Long, Integer> txnLimitMap) {
        this.txnLimitMap = txnLimitMap;
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public double getMaxAmount() {
        return this.maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public double getMinAmount() {
        return this.minAmount;
    }

    public void setMinAmount(double minAmount) {
        this.minAmount = minAmount;
    }

    public boolean isCardLimit() {
        return this.isCardLimit;
    }

    public void setCardLimit(boolean isCardLimit) {
        this.isCardLimit = isCardLimit;
    }

    public boolean isCustLimit() {
        return this.isCustLimit;
    }

    public void setCustLimit(boolean isCustLimit) {
        this.isCustLimit = isCustLimit;
    }

    public long getPromocodeId() {
        return this.promocodeId;
    }

    public void setPromocodeId(long promocodeId) {
        this.promocodeId = promocodeId;
    }

    public String getPromoCode() {
        return this.promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public Map<Integer, Long> getCardBins() {
        return this.cardBins;
    }

    public void setCardBins(Map<Integer, Long> cardBins) {
        this.cardBins = cardBins;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getPromocodeType() {
        return this.promocodeType;
    }

    public void setPromocodeType(long promocodeType) {
        this.promocodeType = promocodeType;
    }

    public String getPromoMsg() {
        return this.promoMsg;
    }

    public void setPromoMsg(String promoMsg) {
        this.promoMsg = promoMsg;
    }

    public String getPromoErrorMsg() {
        return this.promoErrorMsg;
    }

    public void setPromoErrorMsg(String promoErrorMsg) {
        this.promoErrorMsg = promoErrorMsg;
    }

    public Set<String> getPaymentModes() {
        return this.paymentModes;
    }

    public void setPaymentModes(Set<String> paymentModes) {
        this.paymentModes = paymentModes;
    }

    public Set<Long> getNbBanks() {
        return this.nbBanks;
    }

    public void setNbBanks(Set<Long> nbBanks) {
        this.nbBanks = nbBanks;
    }

    public Set<Long> getMerchants() {
        return this.merchants;
    }

    public void setMerchants(Set<Long> merchants) {
        this.merchants = merchants;
    }

    public Set<String> getPromoCardType() {
        return this.promoCardType;
    }

    public void setPromoCardType(Set<String> promoCardType) {
        this.promoCardType = promoCardType;
    }

    public boolean isPromoOnSavedCard() {
        return this.promoOnSavedCard;
    }

    public void setPromoOnSavedCard(boolean promoOnSavedCard) {
        this.promoOnSavedCard = promoOnSavedCard;
    }

    public String getPromocodeTypeName() {
        return this.promocodeTypeName;
    }

    public void setPromocodeTypeName(String promocodeTypeName) {
        this.promocodeTypeName = promocodeTypeName;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PromoCodeData [promocodeId=").append(this.promocodeId).append(", promoCode=").append(this.promoCode).append(", paymentModes=").append(this.paymentModes).append(", cardBins=").append(this.cardBins).append(", nbBanks=").append(this.nbBanks).append(", merchants=").append(this.merchants).append(", startDate=").append(this.startDate).append(", endDate=").append(this.endDate).append(", promocodeType=").append(this.promocodeType).append(", promocodeTypeName=").append(this.promocodeTypeName).append(", promoMsg=").append(this.promoMsg).append(", promoErrorMsg=").append(this.promoErrorMsg).append(", promoCardType=").append(this.promoCardType).append(", savedCardDate=").append(this.savedCardDate).append(", txnLimitMap=").append(this.txnLimitMap).append(", maxCount=").append(this.maxCount).append(", maxAmount=").append(this.maxAmount).append(", minAmount=").append(this.minAmount).append(", isCardLimit=").append(this.isCardLimit).append(", isCustLimit=").append(this.isCustLimit).append(", promoOnSavedCard=").append(this.promoOnSavedCard).append(", validatePromoWithWallet=").append(this.validatePromoWithWallet).append("]");
        return builder.toString();
    }
}

