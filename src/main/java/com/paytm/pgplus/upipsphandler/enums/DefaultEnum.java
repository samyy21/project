package com.paytm.pgplus.upipsphandler.enums;

public enum DefaultEnum {
    Invalid_OTP("Invalid OTP, already used OTP entered"), Success_Rate("Card has a fair success rate"),
    True("True"), False("False"), Insufficient_Balance("Insufficient Balance."),
    HYBRID_DISABLED_MSG("This payment option is not allowed to pay with Paytm Wallet."), BALANCE("Paytm Balance");
    private final String localeString;
    DefaultEnum(String localeString)
    {
        this.localeString = localeString;
    }
    public String getLocaleString() { return localeString; }
}
