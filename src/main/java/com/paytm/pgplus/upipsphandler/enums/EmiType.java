package com.paytm.pgplus.upipsphandler.enums;

public enum EmiType {

    DEBIT_CARD("DEBIT_CARD"), CREDIT_CARD("CREDIT_CARD"), NBFC("NBFC");

    String type;

    EmiType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
