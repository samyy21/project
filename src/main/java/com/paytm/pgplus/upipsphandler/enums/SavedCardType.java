package com.paytm.pgplus.upipsphandler.enums;

public enum SavedCardType {
    CC("CREDIT_CARD"), DC("DEBIT_CARD"), UPI("UPI"), IMPS("IMPS");

    private String cardType;

    SavedCardType(String savedCardType) {
        this.cardType = savedCardType;
    }

    public String getCardType() {
        return cardType;
    }
}
