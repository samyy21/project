/**
 * 
 */
package com.paytm.pgplus.upipsphandler.enums;

/**
 * @author amit.dubey
 *
 */
public enum ResultCode {
    ACCEPTED_SUCCESS("00000009", "A", "Accepted Success", "ACCEPTED_SUCCESS"), SUCCESS("00000000", "S", "Success",
            "SUCCESS"), MESSAGE_ID_INVALID("22015002", "F", "Failure", "MESSAGE_ID_INVALID"), CALLED_NUMBER_ILLEGAL(
            "22015014", "F", "Failure", "CALLED_NUMBER_ILLEGAL"), CONTENT_TOO_LONG("22015016", "F", "Failure",
            "CONTENT_TOO_LONG"), SYSTEM_ERROR("00000900", "U", "System error", "SYSTEM_ERROR"), PARAM_MISSING(
            "00000002", "F", "One or more mandatory parameters is/are missing.", "PARAM_MISSING"), PARAM_ILLEGAL(
            "00000004", "F", "Illegal parameters", "PARAM_ILLEGAL"), INVALID_SIGNATURE("00000007", "F",
            "Signature is invalid.", "INVALID_SIGNATURE"), KEY_NO_FOUND("00000008", "F", "Key is not found.",
            "KEY_NO_FOUND"), NO_INTERFACE_DEF("00000013", "F", "API is not defined", "NO_INTERFACE_DEF"), API_IS_INVALID(
            "00000014", "F", "API is invalid (or not active)", "API_IS_INVALID"), MSG_PARSE_ERROR("00000015", "F",
            "wrong request body", "MSG_PARSE_ERROR"), OAUTH_FAILED("00000016", "F", "oAuth authentication failed",
            "OAUTH_FAILED"), FUNCTION_NOT_MATCH("00000017", "F", "Function parameter does not match API",
            "FUNCTION_NOT_MATCH"), VERIFY_CLIENT_SECRET_FAIL("12014151", "F", "ClientSecret verification failed",
            "VERIFY_CLIENT_SECRET_FAIL"), CLIENT_FORBIDDEN_ACCESS_API("12014152", "F",
            "Client is not authorized to use this API", "CLIENT_FORBIDDEN_ACCESS_API"), UNKNOWN_CLIENT("12014155", "F",
            "Unknown client", "UNKNOWN_CLIENT"), INVALID_CLIENT_STATUS("12014156", "F", "Invalid client status",
            "INVALID_CLIENT_STATUS"), PROCESS_FAIL("00000019", "F", "PROCESS FAIL", "PROCESS_FAIL"), RISK_REJECT(
            "00000011", "F", "risk rejected", "RISK_REJECT"), ACCEPTED_IDEMPOTENT_ERROR("00000010", "A",
            "Already accepted", "ACCEPTED_IDEMPOTENT_ERROR"), ORDER_IS_PAID("12005009", "F", "order is paid",
            "ORDER_IS_PAID"), INVALID_TOKEN("234234234", "F", "Invalid token", "INVALID_TOKEN"), NOTIFICATION_EXPIRY_TIME(
            "25678123", "F", "Notification time expired", "NOTIFICATION_EXPIRY_TIME"), ORDER_IS_CLOSED("12005100", "F",
            "close an order that is already closed", "ORDER_IS_CLOSED"), TRANSACTION_CLOSED("12006038", "F",
            "transaction is already closed", "TRANS_CLOSED"), UNKNOWN_ERROR("9999", "F", "Something went wrong",
            "UNKNOWN_ERROR"), CARD_TYPE_DOES_NOT_EXISTS("9234", "F", "Card Type doesn't exist",
            "CARD_TYPE_DOES_NOT_EXISTS"), CARD_DOESNT_EXIST("2789", "S", "Card does not exist for given parameters",
            "CARD_DOESNT_EXIST"), INVALID_INPUT_DATA("9163", "F", "Invalid data entered by user", "INVALID_INPUT_DATA"), MERCHANT_AMOUNT_EXCEED_DAILY_LIMIT(
            "12110001", "F", "Daily merchant limit breached", "MERCHANT_AMOUNT_EXCEED_DAILY_LIMIT"), MERCHANT_AMOUNT_EXCEED_WEEKLY_LIMIT(
            "12110003", "F", "Weekly merchant limit breached", "MERCHANT_AMOUNT_EXCEED_WEEKLY_LIMIT"), MERCHANT_AMOUNT_EXCEED_MONTHLY_LIMIT(
            "12110005", "F", "Monthly merchant limit breached", "MERCHANT_AMOUNT_EXCEED_MONTHLY_LIMIT"), SECURITY_VERIFY_FAIL(
            "12011004", "F", "SECURITY_VERIFY_FAIL", "SECURITY_VERIFY_FAIL"), VALIDATE_CODE_SEND_TIMES_LIMIT(
            "00000000", "F", "Retry limit breached to send otp", "VALIDATE_CODE_SEND_TIMES_LIMIT"), VALIDATE_CODE_SEND_FAILURE(
            "00000000", "F", "Failed to send otp", "VALIDATE_CODE_SEND_FAILURE"), INVALID_SSO_TOKEN("2004", "F",
            "SSO Token is invalid", "SSO_TOKEN_VALIDATION_EXCEPTION"), REPEAT_REQUEST_INCONSISTENT("2023", "F",
            "Repeat Request Inconsistent", "REPEAT_REQUEST_INCONSISTENT"), SUCCESS_IDEMPOTENT_ERROR("0002", "S",
            "Success Idempotent", "SUCCESS_IDEMPOTENT_ERROR"), JWT_VALIDATION_EXCEPTION("613", "F", "JWT is invalid",
            "JWT_VALIDATION_EXCEPTION"), TRANS_PAID("12006037", "F", "Transaction already paid", "TRANS_PAID"), EDC_MERCHANT_AMOUNT_EXCEED_DAILY_LIMIT(
            "12110012", "F", "Merchant device daily amount limit exceed", "EDC_MERCHANT_AMOUNT_EXCEED_DAILY_LIMIT"), EDC_MERCHANT_AMOUNT_EXCEED_MONTHLY_LIMIT(
            "12110013", "F", "Merchant device monthly amount limit exceed", "EDC_MERCHANT_AMOUNT_EXCEED_MONTHLY_LIMIT"), LINK_MONTHLY_AMOUNT_LIMIT_EXCEED(
            "12110014",
            "F",
            "Payment failed because the merchant crossed their monthly transaction limit for link payments. Please ask the merchant to reach out to Paytm Helpdesk",
            "LINK_MONTHLY_AMOUNT_LIMIT_EXCEED"), MERCHANT_AMOUNT_EXCEED_TXN_LIMIT("12110015", "F",
            "Payment declined as the merchant transaction limit got breached here", "MERCHANT_AMOUNT_EXCEED_TXN_LIMIT"), MERCHANT_LINK_PAYMENT_AMOUNT_EXCEED_DAILY_LIMIT(
            "12110016",
            "F",
            "Payment failed because the merchant crossed their daily transaction limit for link payments. Please ask the merchant to reach out to Paytm Helpdesk",
            "MERCHANT_LINK_PAYMENT_AMOUNT_EXCEED_DAILY_LIMIT"), MERCHANT_LINK_PAYMENT_AMOUNT_EXCEED_WEEKLY_LIMIT(
            "12110017",
            "F",
            "Payment failed because the merchant crossed their weekly transaction limit for link payments. Please ask the merchant to reach out to Paytm Helpdesk",
            "MERCHANT_LINK_PAYMENT_AMOUNT_EXCEED_WEEKLY_LIMIT"), MERCHANT_LINK_PAYMENT_AMOUNT_EXCEED_MONTHLY_LIMIT(
            "12110014",
            "F",
            "Payment failed because the merchant crossed their monthly transaction limit for link payments. Please ask the merchant to reach out to Paytm Helpdesk",
            "MERCHANT_LINK_PAYMENT_AMOUNT_EXCEED_MONTHLY_LIMIT"), MERCHANT_LINK_PAYMENT_AMOUNT_EXCEED_TXN_LIMIT(
            "12110018",
            "F",
            "Payment failed because the merchant crossed their amount transaction limit for link payments. Please ask the merchant to reach out to Paytm Helpdesk",
            "MERCHANT_LINK_PAYMENT_AMOUNT_EXCEED_TXN_LIMIT"),
            DC_DOM_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110020", "F", "Merchant Debit card daily acceptance limit exceeded, please try with another payment option",
            "DC_DOM_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            DC_DOM_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110021", "F", "Merchant Debit card monthly acceptance limit exceeded, please try with another payment option",
            "DC_DOM_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            DC_DOM_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110022", "F", "Merchant Debit card transaction limit exceeded due to which transaction won't processed",
            "DC_DOM_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            DC_DOM_RUPAY_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110023", "F", "Merchant Rupay Debit Card daily acceptance limit exceeded, please try with another payment option",
            "DC_DOM_RUPAY_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            DC_DOM_RUPAY_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110024", "F", "Merchant Rupay Debit Card monthly acceptance limit exceeded, please try with another payment option",
            "DC_DOM_RUPAY_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            DC_DOM_RUPAY_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110025", "F", "Merchant Rupay Debit Card transaction limit exceeded due to which transaction won't processed",
            "DC_DOM_RUPAY_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            DC_DOM_VISA_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110026", "F", "Merchant VISA Debit Card daily acceptance limit exceeded, please try with another payment option",
            "DC_DOM_VISA_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            DC_DOM_VISA_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110027", "F", "Merchant VISA Debit Card monthly acceptance limit exceeded, please try with another payment option",
            "DC_DOM_VISA_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            DC_DOM_VISA_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110028", "F", "Merchant VISA Debit Card transaction limit exceeded due to which transaction won't processed",
            "DC_DOM_VISA_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            CC_DOM_VISA_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110029", "F", "Merchant VISA Credit Card daily acceptance limit exceeded, please try with another payment option",
            "CC_DOM_VISA_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            CC_DOM_VISA_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110030", "F", "Merchant VISA Credit Card monthly acceptance limit exceeded, please try with another payment option",
            "CC_DOM_VISA_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            CC_DOM_VISA_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110031", "F", "Merchant VISA Credit Card transaction limit exceeded due to which transaction won't processed",
            "CC_DOM_VISA_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            CC_DOM_MASTER_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110032", "F", "Merchant Credit Card daily acceptance limit exceeded, please try with another payment option",
            "CC_DOM_MASTER_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            CC_DOM_MASTER_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110033", "F", "Merchant Credit Card monthly acceptance limit exceeded, please try with another payment option",
            "CC_DOM_MASTER_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            CC_DOM_MASTER_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110034", "F", "Merchant Credit Card transaction limit exceeded due to which transaction won't processed",
            "CC_DOM_MASTER_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            CC_INTL_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110035", "F", "Merchant Credit Card daily acceptance limit exceeded, please try with another payment option",
            "CC_INTL_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            CC_INTL_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110036", "F", "Merchant Credit Card monthly acceptance limit exceeded, please try with another payment option",
            "CC_INTL_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            CC_INTL_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110037", "F", "Merchant Credit Card transaction limit exceeded due to which transaction won't processed",
            "CC_INTL_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            CC_INTL_VISA_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110038", "F", "Merchant VISA Credit Card daily acceptance limit exceeded, please try with another payment option",
            "CC_INTL_VISA_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            CC_INTL_VISA_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110039", "F", "Merchant VISA Credit Card monthly acceptance limit exceeded, please try with another payment option",
            "CC_INTL_VISA_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            CC_INTL_VISA_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110040", "F", "Merchant Credit Card transaction limit exceeded due to which transaction won't processed",
            "CC_INTL_VISA_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            CC_INTL_MASTER_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110041", "F", "Merchant Master Credit Card daily acceptance limit exceeded, please try with another payment option",
            "CC_INTL_MASTER_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            CC_INTL_MASTER_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110042", "F", "Merchant Master Credit Card monthly acceptance limit exceeded, please try with another payment option",
            "CC_INTL_MASTER_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            CC_INTL_MASTER_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110043", "F", "Merchant Credit Card transaction limit exceeded due to which transaction won't processed",
            "CC_INTL_MASTER_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            BALANCE_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110044", "F", "Merchant Wallet daily acceptance limit exceeded, please try with another payment option",
            "BALANCE_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            BALANCE_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110045", "F", "Merchant Wallet monthly acceptance limit exceeded, please try with another payment option",
            "BALANCE_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            BALANCE_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110046", "F", "Merchant Wallet transaction limit exceeded due to which transaction won't processed",
            "BALANCE_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            UPI_COLLECT_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110047", "F", "Merchant UPI daily acceptance limit exceeded, please try with another payment option",
            "UPI_COLLECT_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            UPI_COLLECT_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110048", "F", "Merchant UPI monthly acceptance limit exceeded, please try with another payment option",
            "UPI_COLLECT_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            UPI_COLLECT_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110049", "F", "Merchant UPI transaction limit exceeded due to which transaction won't processed",
            "UPI_COLLECT_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            UPI_INTENT_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110050", "F", "Merchant UPI daily acceptance limit exceeded, please try with another payment option",
            "UPI_INTENT_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            UPI_INTENT_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110051", "F", "Merchant UPI monthly acceptance limit exceeded, please try with another payment option",
            "UPI_INTENT_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            UPI_INTENT_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110052", "F", "Merchant UPI transaction limit exceeded due to which transaction won't processed",
            "UPI_INTENT_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            UPI_PUSH_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110053", "F", "Merchant UPI daily acceptance limit exceeded, please try with another payment option",
            "UPI_PUSH_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            UPI_PUSH_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110054", "F", "Merchant UPI monthly acceptance limit exceeded, please try with another payment option",
            "UPI_PUSH_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            UPI_PUSH_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110055", "F", "Merchant UPI transaction limit exceeded due to which transaction won't processed",
            "UPI_PUSH_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            UPI_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110056", "F", "Merchant UPI daily acceptance limit exceeded, please try with another payment option",
            "UPI_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            UPI_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110057", "F", "Merchant UPI monthly acceptance limit exceeded, please try with another payment option",
            "UPI_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            UPI_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110058", "F", "Merchant UPI transaction limit exceeded due to which transaction won't processed",
            "UPI_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            NB_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110059", "F","Merchant NetBanking daily acceptance limit exceeded, please try with another payment option" ,
            "NB_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            NB_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110060", "F","Merchant NetBanking monthly acceptance limit exceeded, please try with another payment option",
            "NB_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            NB_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110061", "F","Merchant NetBanking transaction limit exceeded due to which transaction won't processed" ,
            "NB_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT"),
            POSTPAID_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT("12110062","F","Merchant Postpaid daily acceptance limit exceeded, please try with another payment option",
            "POSTPAID_LIMIT_CHECK_AMOUNT_OVER_DAILY_LIMIT"),
            POSTPAID_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT("12110063","F","Merchant Postpaid monthly acceptance limit exceeded, please try with another payment option",
            "POSTPAID_LIMIT_CHECK_AMOUNT_OVER_MONTHLY_LIMIT"),
            POSTPAID_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT("12110064","F","Merchant Postpaid transaction limit exceeded due to which transaction won't processed",
            "POSTPAID_LIMIT_CHECK_AMOUNT_OVER_MAX_SINGLE_LIMIT");


    private String resultCodeId;
    private String resultStatus;
    private String resultMsg;
    private String code;

    /**
     * @param resultCodeId
     * @param resultStatus
     * @param resultMsg
     * @param code
     */
    private ResultCode(String resultCodeId, String resultStatus, String resultMsg, String code) {
        this.resultCodeId = resultCodeId;
        this.resultStatus = resultStatus;
        this.resultMsg = resultMsg;
        this.code = code;
    }

    public static ResultCode getEnumByCode(String code) {
        for (ResultCode rc : values()) {
            if (code.equalsIgnoreCase(rc.getCode())) {
                return rc;
            }
        }
        return null;
    }

    /**
     * @return the resultCodeId
     */
    public String getResultCodeId() {
        return resultCodeId;
    }

    /**
     * @return the resultStatus
     */
    public String getResultStatus() {
        return resultStatus;
    }

    /**
     * @return the resultMsg
     */
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * @return the resultCode
     */
    public String getCode() {
        return code;
    }

}
