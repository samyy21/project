package com.paytm.pgplus.upipsphandler.enums;

public enum AmountType {
    FIX(0, "FIX"),
    VARIABLE(1, "VARIABLE");

    private Integer value;
    private String name;

    private AmountType(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public static AmountType getEnumByValue(Integer val) {
        AmountType[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AmountType amountType = var1[var3];
            if (val.equals(amountType.getValue())) {
                return amountType;
            }
        }

        return null;
    }

    public static AmountType getEnumByName(String name) {
        AmountType[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AmountType se = var1[var3];
            if (name.equals(se.getName())) {
                return se;
            }
        }

        return null;
    }
}

