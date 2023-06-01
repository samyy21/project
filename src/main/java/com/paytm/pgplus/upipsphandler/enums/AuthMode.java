package com.paytm.pgplus.upipsphandler.enums;

public enum AuthMode {

    PIN("pin"), OTP("otp");

    private String type;

    AuthMode(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}