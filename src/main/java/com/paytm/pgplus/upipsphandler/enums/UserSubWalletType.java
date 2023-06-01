package com.paytm.pgplus.upipsphandler.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserSubWalletType {
    FOOD((short)2, "FOOD"),
    GIFT((short)3, "GIFT"),
    MULTI_PURPOSE_GIFT((short)4, "MULTI_PURPOSE_GIFT"),
    TOLL((short)6, "TOLL"),
    CLOSED_LOOP_WALLET((short)7, "CLOSED_LOOP_WALLET"),
    CLOSED_LOOP_SUB_WALLET((short)8, "CLOSED_LOOP_SUB_WALLET"),
    FUEL((short)9, "FUEL"),
    INTERNATIONAL_FUNDS_TRANSFER((short)10, "INTERNATIONAL_FUNDS_TRANSFER"),
    CASHBACK((short)11, "CASHBACK"),
    GIFT_VOUCHER((short)12, "GIFT_VOUCHER"),
    COMMUNICATION((short)13, "COMMUNICATION"),
    TRANSIT_BLOCKED_WALLET((short)15, "TRANSIT_BLOCKED_WALLET");

    private short code;
    private String type;

    private UserSubWalletType(short code, String type) {
        this.code = code;
        this.type = type;
    }

    private UserSubWalletType(String type) {
        this.type = type;
    }

    public short getCode() {
        return this.code;
    }

    public void setCode(short code) {
        this.code = code;
    }

    @JsonValue
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static UserSubWalletType getPpiType(short code) {
        UserSubWalletType ppiType = null;
        UserSubWalletType[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            UserSubWalletType ppi = var2[var4];
            if (ppi.getCode() == code) {
                ppiType = ppi;
                break;
            }
        }

        return ppiType;
    }

    public static UserSubWalletType getPpiType(String message) {
        UserSubWalletType ppiType = null;
        UserSubWalletType[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            UserSubWalletType ppi = var2[var4];
            if (ppi.getType().equalsIgnoreCase(message)) {
                ppiType = ppi;
                break;
            }
        }

        return ppiType;
    }
}
