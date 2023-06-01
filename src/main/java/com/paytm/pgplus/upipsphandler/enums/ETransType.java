package com.paytm.pgplus.upipsphandler.enums;

public enum ETransType {
    ACQUIRING("ACQUIRING"),
    TOP_UP("TOP_UP"),
    SEND_MONEY("SEND_MONEY"),
    REQUEST_MONEY("REQUEST_MONEY"),
    WITHDRAW("WITHDRAW"),
    TRANSFER("TRANSFER"),
    CASHBACK("CASHBACK");

    String type;

    private ETransType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}

