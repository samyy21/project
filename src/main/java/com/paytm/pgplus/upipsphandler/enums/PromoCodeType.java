package com.paytm.pgplus.upipsphandler.enums;

public enum PromoCodeType {

    CASHBACK("CASHBACK"), DISCOUNT("DISCOUNT");

    private String value;

    private PromoCodeType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
