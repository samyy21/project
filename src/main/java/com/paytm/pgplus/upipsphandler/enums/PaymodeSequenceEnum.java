package com.paytm.pgplus.upipsphandler.enums;

public enum PaymodeSequenceEnum {
    DEFAULT("PAYMODE_PRIORITY_LIST"), SUBSCRIPTION("SUBSCRIPTION_PAYMODE_PRIORITY_LIST"), NATIVE(
            "NATIVE_PAYMODE_PRIORITY_LIST"), OFFLINE("OFFLINE_PAYMODE_PRIORITY_LIST"), ENHANCE(
            "ENHANCE_PAYMODE_PRIORITY_LIST");

    String preferenceName;

    PaymodeSequenceEnum(String preferenceName) {
        this.preferenceName = preferenceName;
    }

    public String getPreferenceName() {
        return this.preferenceName;
    }
}

