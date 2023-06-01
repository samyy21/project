package com.paytm.pgplus.upipsphandler.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum SubsPaymentMode {
    NORMAL("NA", "Wallet with AddnPay"),
    PPI("BALANCE", "Wallet"),
    CC("CREDIT_CARD", "Credit Card"),
    DC("DEBIT_CARD", "Debit Card"),
    PPBL("PPBL", "Paytm Payments Bank"),
    BANK_MANDATE("BANK_MANDATE", "Bank Mandate"),
    UNKNOWN("NA", "Blank payment mode during subscription contact creation"),
    UPI("UPI", "UPI");

    public static final Set<String> nonAddNPaySubsPayModes;
    private String ePayMethodName;
    private String discription;

    private SubsPaymentMode(String ePayMethodName, String discription) {
        this.ePayMethodName = ePayMethodName;
        this.discription = discription;
    }

    public static SubsPaymentMode getSubsPaymentMode(String subsPay) {
        SubsPaymentMode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SubsPaymentMode paymentMode = var1[var3];
            if (StringUtils.isNotBlank(paymentMode.name()) && paymentMode.name().equals(subsPay)) {
                return paymentMode;
            }
        }

        return null;
    }

    public static Set<String> getEPayMethodNames() {
        return (Set) Arrays.stream(values()).map((mode) -> {
            return mode.getePayMethodName();
        }).collect(Collectors.toSet());
    }

    public static Set<String> getEPayMethodNamesNotLoggedIn() {
        Set<String> subsPayMethod = new HashSet();
        subsPayMethod.add(PPI.ePayMethodName);
        subsPayMethod.add(DC.ePayMethodName);
        subsPayMethod.add(CC.ePayMethodName);
        subsPayMethod.add(BANK_MANDATE.ePayMethodName);
        subsPayMethod.add(UPI.ePayMethodName);
        return subsPayMethod;
    }

    public static Set<String> getCardPayModes() {
        Set<String> subsPayMethod = new HashSet();
        subsPayMethod.add(DC.name());
        subsPayMethod.add(CC.name());
        subsPayMethod.add(NORMAL.name());
        return subsPayMethod;
    }

    public String getePayMethodName() {
        return this.ePayMethodName;
    }

    public String getDiscription() {
        return this.discription;
    }

    static {
        HashSet<String> subsPayModes = new HashSet();
        subsPayModes.add(CC.name());
        subsPayModes.add(DC.name());
        subsPayModes.add(PPBL.name());
        nonAddNPaySubsPayModes = Collections.unmodifiableSet(subsPayModes);
    }
}

