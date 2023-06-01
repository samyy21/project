/*
 * This File is the sole property of Paytm(One97 Communications Limited)
 */
package com.paytm.pgplus.upipsphandler.enums;

import org.apache.commons.lang3.StringUtils;

public enum ERequestType {

    DEFAULT("DEFAULT", "StandardDirectPayAcquiringProd"), EMAIL_INVOICE("EMAIL_INVOICE", "InvoicingAcquiringProd"), SMS_INVOICE(
            "SMS_INVOICE", "InvoicingAcquiringProd"), SUBSCRIPTION("SUBSCRIPTION", "StandardDirectPayAcquiringProd"), SUBSCRIPTION_PARTIAL_RENEWAL(
            "PARTIAL_RENEW_SUBSCRIPTION", "RecurringAcquiringProd"), SUBSCRIBE("SUBSCRIBE", "RecurringAcquiringProd"), SUBSCRIPTION_RENEWAL(
            "RENEW_SUBSCRIPTION", "RecurringAcquiringProd"), SEAMLESS("SEAMLESS", "SeamlessPaymentAcquiringProd"), SEAMLESS_NATIVE(
            "SEAMLESS_NATIVE", "StandardDirectPayAcquiringProd"), ADD_MONEY("ADD_MONEY", "UserTopupMultiPay"), ADD_AND_PAY(
            "ADD_AND_PAY", "UserTopupMultiPay"), PAYTM_EXPRESS("PAYTM_EXPRESS", "StandardAcquiringProdByJSChargePayee"), PAYTM_EXPRESS_BUYER_PAYS_CHARGE(
            "PAYTM_EXPRESS", "StandardAcquiringProdByJSChargePayer"), TOPUP_EXPRESS("TOPUP_EXPRESS",
            "UserTopupMultiPay"), CC_BILL_PAYMENT("CC_BILL_PAYMENT", "StandardDirectPayAcquiringProd"), LINK_BASED_PAYMENT(
            "LINK_BASED_PAYMENT", "StandardDirectPayAcquiringProd"), STOCK_TRADE("STOCK_TRADE",
            "SeamlessPaymentForStockProd"), OFFLINE("OFFLINE", "StandardDirectPayAcquiringProd"), SEAMLESS_ACS(
            "SEAMLESS_ACS", "SeamlessPaymentAcquiringProd"), ADDMONEY_EXPRESS("EXPRESS_ADD_MONEY", "UserTopupMultiPay"), NATIVE(
            "NATIVE", "StandardDirectPayAcquiringProd"), DYNAMIC_QR("DYNAMIC_QR", "StandardDirectPayAcquiringProd"), MOTO_CHANNEL(
            "MOTO_CHANNEL", "DirectDebitPaymentsByMotoChannel"), LINK_BASED_PAYMENT_INVOICE(
            "LINK_BASED_PAYMENT_INVOICE", "StandardDirectPayAcquiringProd"), SEAMLESS_3D_FORM("SEAMLESS_3D_FORM",
            "StandardDirectPayAcquiringProd"), SEAMLESS_NB("SEAMLESS_NB", "StandardDirectPayAcquiringProd"), QR_PRN_ENABLED(
            "QR_PRN_ENABLED", "QrAcquiringProd"), RESELLER("RESELLER", "StandardDirectPayAcquiringProd"), NATIVE_SUBSCRIPTION(
            "NATIVE_SUBSCRIPTION", "RecurringAcquiringProd"), UNI_PAY("UNI_PAY", "AOADirectPayAcquiringProd"), DYNAMIC_QR_2FA(
            "DYNAMIC_QR_2FA", "QrAcquiringProd"), NATIVE_PAY("NATIVE_PAY", "StandardDirectPayAcquiringProd"), DEFAULT_MF(
            "DEFAULT_MF", "DefaultMutualFundAcquiringProd"), NATIVE_MF("NATIVE_MF", "NativeMutualFundAcquiringProd"), NATIVE_MF_PAY(
            "NATIVE_MF_PAY", "NativeMutualFundAcquiringProd"), EDCPosAcquiring("EDCPosAcquiring", "EDCPosAcquiring"), NATIVE_SUBSCRIPTION_PAY(
            "NATIVE_SUBSCRIPTION_PAY", "RecurringAcquiringProd"), NATIVE_ST("NATIVE_ST", "SeamlessPaymentForStockProd"), NATIVE_ST_PAY(
            "NATIVE_ST_PAY", "SeamlessPaymentForStockProd"), NATIVE_MF_SIP("NATIVE_MF_SIP",
            "NativeMutualFundsSipAcquiringProd"), SUBS_RENEWAL_MF_SIP("SUBS_RENEWAL_MF_SIP",
            "NativeMutualFundsSipAcquiringProd"), NATIVE_MF_SIP_PAY("NATIVE_MF_SIP_PAY",
            "NativeMutualFundsSipAcquiringProd"), EDCPayConfirm("EDCPayConfirm", "EDCPayConfirmAcquiringProd"), EDC_PAY_CONFIRM(
            "EDC_PAY_CONFIRM", "AuthCaptureInternalConfirmProd"), EDC_CASH_AT_POS("EDC_CASH_AT_POS",
            "AuthCaptureEDCCashProd"), EDC_CASH_AT_POS_INCENTIVE("EDC_CASH_AT_POS_INCENTIVE",
            "StandardPayEDCIncentiveProd"), PREAUTH("PREAUTH", "StandardAcquiringPreAuthCapture"), NCMC_FLOWS(
            "NCMC_FLOWS", "NPCIqSparcProd"), OFFLINE_SALE("OFFLINE_SALE", "AuthCaptureOfflineConfirmProd"), EDC_PCF_ON_PAY_CONFIRM(
            "EDC_PCF_ON_PAY_CONFIRM", "AuthCaptureConfirmDynamicTargetProd"), StandardPayConfirmDynamicTargetProd(
            "StandardPayConfirmDynamicTargetProd", "StandardPayConfirmDynamicTargetProd"), StandardAcquiringEscrowDelayedSettlement(
            "StandardAcquiringEscrowDelayedSettlement", "StandardAcquiringEscrowDelayedSettlement"), UNI_PAY_PAY(
            "UNI_PAY_PAY", "AOADirectPayAcquiringProd"), RISK_VERIFIER_PG("RISK_VERIFIER_PG",
            "StandardDirectPayAcquiringProd");
    String type;

    String productCode;

    ERequestType(final String type, final String productCode) {
        this.type = type;
        this.productCode = productCode;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the productCode
     */
    public String getProductCode() {
        return productCode;
    }

    public static ERequestType getByProductCode(final String productCode) {
        for (final ERequestType e : values()) {
            if (e.productCode.equals(productCode)) {
                return e;
            }
        }
        return null;
    }

    public static ERequestType getByRequestType(final String reqType) {
        for (final ERequestType e : values()) {
            if (e.type.equals(reqType)) {
                return e;
            }
        }
        return null;
    }

    public static boolean isNativeOrUniRequest(ERequestType requestType) {
        return ERequestType.NATIVE == requestType || ERequestType.UNI_PAY == requestType
                || ERequestType.NATIVE_SUBSCRIPTION.getType().equals(requestType);
    }

    public static boolean isOfflineOrNativeOrUniRequest(ERequestType requestType) {
        return ERequestType.OFFLINE == requestType || ERequestType.NATIVE == requestType
                || ERequestType.UNI_PAY == requestType || ERequestType.NATIVE_SUBSCRIPTION == requestType;
    }

    public static boolean isOfflineOrNativeOrUniOrNativeMFOrNativeSTRequest(ERequestType requestType) {
        return ERequestType.OFFLINE == requestType || ERequestType.NATIVE == requestType
                || ERequestType.UNI_PAY == requestType || ERequestType.NATIVE_SUBSCRIPTION == requestType
                || ERequestType.NATIVE_MF == requestType || ERequestType.NATIVE_ST == requestType;
    }

    public static boolean isNativeOrUniRequest(String requestType) {
        return StringUtils.isNotBlank(requestType)
                && (ERequestType.NATIVE.getType().equals(requestType)
                        || ERequestType.UNI_PAY.getType().equals(requestType) || ERequestType.NATIVE_SUBSCRIPTION
                        .getType().equals(requestType));
    }

    public static boolean isOfflineOrNativeOrUniOrNativeMFOrNativeSTRequest(String requestType) {
        return StringUtils.isNotBlank(requestType)
                && (ERequestType.OFFLINE.getType().equals(requestType)
                        || ERequestType.NATIVE.getType().equals(requestType)
                        || ERequestType.UNI_PAY.getType().equals(requestType)
                        || ERequestType.isSubscriptionCreationRequest(requestType)
                        || ERequestType.NATIVE_MF.getType().equals(requestType) || ERequestType.NATIVE_ST.getType()
                        .equals(requestType));
    }

    public static boolean isNativeOrUniOrNativeMFOrNativeSTRequest(String requestType) {
        return ERequestType.NATIVE_PAY.getType().equals(requestType)
                || ERequestType.UNI_PAY.getType().equals(requestType)
                || ERequestType.NATIVE_MF_PAY.getType().equals(requestType)
                || ERequestType.NATIVE_ST_PAY.getType().equals(requestType);
    }

    public static boolean isNativeOrNativeSubscriptionOrNativeSubscriptionPayRequest(String requestType) {
        return ERequestType.NATIVE.getType().equals(requestType)
                || ERequestType.NATIVE_SUBSCRIPTION.getType().equals(requestType)
                || ERequestType.NATIVE_SUBSCRIPTION_PAY.getType().equals(requestType);
    }

    public static boolean isNativeOrNativeSubscriptionOrEnhancedAoaRequest(String requestType) {
        return ERequestType.NATIVE.getType().equals(requestType)
                || ERequestType.NATIVE_SUBSCRIPTION.getType().equals(requestType)
                || ERequestType.UNI_PAY.getType().equals(requestType);
    }

    public static boolean isNativeOrNativeSubscriptionRequest(String requestType) {
        return ERequestType.NATIVE.getType().equals(requestType)
                || ERequestType.NATIVE_SUBSCRIPTION.getType().equals(requestType);
    }

    public static boolean isSubscriptionRequest(String requestType) {
        return ERequestType.NATIVE_MF_SIP.getType().equals(requestType)
                || ERequestType.NATIVE_SUBSCRIPTION.getType().equals(requestType)
                || ERequestType.SUBSCRIPTION_RENEWAL.getType().equals(requestType)
                || ERequestType.SUBS_RENEWAL_MF_SIP.getType().equals(requestType);
    }

    public static boolean isMutualFundRequest(String requestType) {
        return ERequestType.NATIVE_MF_SIP.getType().equals(requestType)
                || ERequestType.NATIVE_MF_SIP_PAY.getType().equals(requestType);
    }

    public static boolean isSubscriptionRenewalRequest(String requestType) {
        return ERequestType.SUBSCRIPTION_RENEWAL.getType().equals(requestType)
                || ERequestType.SUBS_RENEWAL_MF_SIP.getType().equals(requestType);
    }

    public static boolean isSubscriptionCreationRequest(String requestType) {
        return ERequestType.NATIVE_MF_SIP.getType().equals(requestType)
                || ERequestType.NATIVE_SUBSCRIPTION.getType().equals(requestType);
    }

    public static boolean isSubscriptionRecurringRequest(ERequestType requestType) {
        return ERequestType.SUBSCRIBE.equals(requestType) || ERequestType.NATIVE_SUBSCRIPTION.equals(requestType)
                || ERequestType.NATIVE_SUBSCRIPTION_PAY.equals(requestType);
    }

    public static boolean isSubscriptionOrMFRequest(ERequestType requestType) {
        return ERequestType.SUBSCRIBE.equals(requestType) || ERequestType.NATIVE_SUBSCRIPTION.equals(requestType)
                || ERequestType.NATIVE_SUBSCRIPTION_PAY.equals(requestType)
                || ERequestType.NATIVE_MF_SIP.equals(requestType) || ERequestType.NATIVE_MF_SIP_PAY.equals(requestType);
    }
}
