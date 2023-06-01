package com.paytm.pgplus.upipsphandler.enums;

public enum ValidationMessage {
    ERROR_MSG,
    INVALID_CARD_NUMBER,
    DISABLED_PAYMENT_MODE,
    INVALID_BANK,
    INVALID_BIN,
    SBI_ADD_MONEY,
    INVALID_TXN_AMOUNT;

    private ValidationMessage() {
    }
}

