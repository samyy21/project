package com.paytm.pgplus.upipsphandler.enums;

import com.paytm.pgplus.common.enums.EPayMethodGroup;
import org.apache.commons.lang3.StringUtils;

public enum EPayMethod {
    BALANCE("BALANCE", "PPI", "Wallet", "Paytm Balance", EPayMethodGroup.PAYTM_FEATURED),
    BANK_EXPRESS("BANK_EXPRESS", "BANK_EXPRESS", "BANK_EXPRESS", "BANK_EXPRESS", EPayMethodGroup.OTHER_OPTIONS),
    NET_BANKING("NET_BANKING", "NB", "Net Banking", "Net Banking", EPayMethodGroup.OTHER_OPTIONS),
    CREDIT_CARD("CREDIT_CARD", "CC", "Credit Card", "Credit Card", EPayMethodGroup.OTHER_OPTIONS),
    DEBIT_CARD("DEBIT_CARD", "DC", "Debit Card", "Debit Card", EPayMethodGroup.OTHER_OPTIONS),
    IMPS("IMPS", "IMPS", "IMPS", "IMPS", EPayMethodGroup.OTHER_OPTIONS),
    ATM("ATM", "ATM", "ATM", "ATM", EPayMethodGroup.OTHER_OPTIONS),
    EMI("EMI", "EMI", "EMI", "EMI", EPayMethodGroup.OTHER_OPTIONS),
    COD("COD", "COD", "COD", "Cash on Delivery (COD)", EPayMethodGroup.OTHER_OPTIONS),
    MP_COD("MP_COD", "COD", "COD", "Cash on Delivery (COD)", EPayMethodGroup.OTHER_OPTIONS),
    HYBRID_PAYMENT("HYBRID_PAYMENT", "HYBRID", "HYBRID", "HYBRID", EPayMethodGroup.OTHER_OPTIONS),
    UPI("UPI", "UPI", "BHIM UPI", "BHIM UPI", EPayMethodGroup.OTHER_OPTIONS),
    PAYTM_DIGITAL_CREDIT("PAYTM_DIGITAL_CREDIT", "PAYTM_DIGITAL_CREDIT", "Paytm Postpaid", "Paytm Postpaid", "PDC", EPayMethodGroup.PAYTM_FEATURED),
    PPBL("NET_BANKING_PPBL", "PPBL", "Paytm Bank Account", "Paytm Payments Bank", EPayMethodGroup.PAYTM_FEATURED),
    RENEW_PPBL("PPBL", "PPBL", "Paytm Bank Account", "Paytm Bank Account", EPayMethodGroup.PAYTM_FEATURED),
    SAVED_CARD("SAVED_CARD", "SC", "SC", "Saved Card", EPayMethodGroup.SAVED_CARD),
    WALLET("WALLET", "WALLET", "Wallet", "Paytm Wallet", EPayMethodGroup.PAYTM_FEATURED),
    LOYALTY_POINT("LOYALTY_POINT", "LOYALTY_POINT", "Loyalty Point", "Loyalty Point", EPayMethodGroup.OTHER_OPTIONS),
    SAVED_VPA("SAVED_VPA", "SV", "SV", "Saved VPA", EPayMethodGroup.SAVED_VPA),
    EMI_DC("EMI_DC", "EMI_DC", "EMI_DC", "EMI_DC", EPayMethodGroup.OTHER_OPTIONS),
    ADVANCE_DEPOSIT_ACCOUNT("ADVANCE_DEPOSIT_ACCOUNT", "ADVANCE_DEPOSIT_ACCOUNT", "Paytm Advance Account", "Paytm Advance Account", "ADA", EPayMethodGroup.PAYTM_FEATURED),
    UPI_INTENT("UPI_INTENT", "UPI_INTENT", "UPI_INTENT", "UPI_INTENT", "UI", EPayMethodGroup.OTHER_OPTIONS),
    BANK_MANDATE("BANK_MANDATE", "BANK_MANDATE", "Bank Account (E-mandate)", "Bank Account (E-mandate)", "BM", EPayMethodGroup.OTHER_OPTIONS),
    NBFC("NBFC", "NBFC", "NBFC", "NBFC", EPayMethodGroup.OTHER_OPTIONS),
    GIFT_VOUCHER("GIFT_VOUCHER", "GIFT_VOUCHER", "GIFT_VOUCHER", "GIFT_VOUCHER", "GV", EPayMethodGroup.PAYTM_FEATURED),
    SAVED_MANDATE_BANK("SAVED_MANDATE_BANK", "SAVED_MANDATE_BANK", "SAVED_MANDATE_BANK", "SAVED_MANDATE_BANK", "SMB", EPayMethodGroup.SAVED_MANDATE_BANK),
    BANK_TRANSFER("BANK_TRANSFER", "BANK_TRANSFER", "NEFT/ RTGS/ IMPS", "NEFT/ RTGS/ IMPS", "BT", EPayMethodGroup.OTHER_OPTIONS),
    BNPL("BNPL", "BNPL", "BNPL", "BNPL", EPayMethodGroup.OTHER_OPTIONS),
    UPI_LITE("UPI_LITE", "upi_lite", "UPI LITE", "UPI LITE", EPayMethodGroup.OTHER_OPTIONS);

    String method;
    String oldName;
    String displayName;
    String newDisplayName;
    String shortName;
    EPayMethodGroup methodGroup;

    private EPayMethod(String method, String oldName, String displayName, String newDisplayName, EPayMethodGroup methodGroup) {
        this.method = method;
        this.oldName = oldName;
        this.displayName = displayName;
        this.newDisplayName = newDisplayName;
        this.shortName = oldName;
        this.methodGroup = methodGroup;
    }

    private EPayMethod(String method, String oldName, String displayName, String newDisplayName, String shortName, EPayMethodGroup methodGroup) {
        this.method = method;
        this.oldName = oldName;
        this.displayName = displayName;
        this.newDisplayName = newDisplayName;
        this.shortName = shortName;
        this.methodGroup = methodGroup;
    }

    public String getMethod() {
        return this.method;
    }

    public String getOldName() {
        return this.oldName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getNewDisplayName() {
        return this.newDisplayName;
    }

    public EPayMethodGroup getMethodGroup() {
        return this.methodGroup;
    }

    public String getShortName() {
        return this.shortName;
    }

    public static EPayMethod getPayMethodByMethod(String method) {
        EPayMethod ePayMethod = null;
        EPayMethod[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            EPayMethod payMethod = var2[var4];
            if (StringUtils.isNotBlank(method) && method.equals(payMethod.getMethod())) {
                ePayMethod = payMethod;
                break;
            }
        }

        if (ePayMethod == null) {
            ePayMethod = getPayMethodV2(method, true);
        }

        return ePayMethod;
    }

    public static EPayMethod getPayMethodByOldName(String oldName) {
        EPayMethod ePayMethod = null;
        EPayMethod[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            EPayMethod payMethod = var2[var4];
            if (StringUtils.isNotBlank(payMethod.oldName) && payMethod.oldName.equals(oldName)) {
                ePayMethod = payMethod;
                break;
            }
        }

        if (ePayMethod == null) {
            ePayMethod = getPayMethodV2(oldName, false);
        }

        return ePayMethod;
    }

    public static EPayMethod getPayMethodByShortName(String shortName) {
        EPayMethod ePayMethod = null;
        EPayMethod[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            EPayMethod payMethod = var2[var4];
            if (StringUtils.isNotBlank(payMethod.shortName) && payMethod.shortName.equals(shortName)) {
                ePayMethod = payMethod;
                break;
            }
        }

        if (ePayMethod == null) {
            ePayMethod = getPayMethodV2(shortName, false);
        }

        return ePayMethod;
    }

    public static EPayMethod getPayMethodByNewDisplayName(String newDisplayName) {
        EPayMethod ePayMethod = null;
        EPayMethod[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            EPayMethod payMethod = var2[var4];
            if (StringUtils.isNotBlank(payMethod.newDisplayName) && payMethod.newDisplayName.equals(newDisplayName)) {
                ePayMethod = payMethod;
                break;
            }
        }

        if (ePayMethod == null) {
            ePayMethod = getPayMethodV2(newDisplayName, false);
        }

        if (ePayMethod == null) {
            ePayMethod = getPayMethodV2(newDisplayName, true);
        }

        if (ePayMethod == null) {
            ePayMethod = getPayMethodForMgv(newDisplayName);
        }

        return ePayMethod;
    }

    private static EPayMethod getPayMethodForMgv(String newDisplayName) {
        return StringUtils.isNotBlank(newDisplayName) && newDisplayName.contains("Voucher") ? GIFT_VOUCHER : null;
    }

    public static EPayMethod getPayMethodV2(String name, boolean isOldName) {
        EPayMethod ePayMethod = null;
        EPayMethod[] var3;
        int var4;
        int var5;
        EPayMethod payMethod;
        if (isOldName) {
            var3 = values();
            var4 = var3.length;

            for(var5 = 0; var5 < var4; ++var5) {
                payMethod = var3[var5];
                if (StringUtils.isNotBlank(payMethod.oldName) && payMethod.oldName.equals(name)) {
                    ePayMethod = payMethod;
                    break;
                }
            }
        } else {
            var3 = values();
            var4 = var3.length;

            for(var5 = 0; var5 < var4; ++var5) {
                payMethod = var3[var5];
                if (StringUtils.isNotBlank(name) && name.equals(payMethod.getMethod())) {
                    ePayMethod = payMethod;
                    break;
                }
            }
        }

        return ePayMethod;
    }
}

