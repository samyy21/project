package com.paytm.pgplus.upipsphandler.enums;

public enum ResultStatus {

    SUCCESS("S"), FAIL("F"), UNKNOWN("U"), ACCEPTED("A");

    private String value;

    ResultStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

