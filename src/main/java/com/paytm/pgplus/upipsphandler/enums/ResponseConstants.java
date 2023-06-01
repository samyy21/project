/**
 *
 */
package com.paytm.pgplus.upipsphandler.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author naman
 *
 */

public enum ResponseConstants {

    // Base Alipay Codes
    PARAM_MISSING("501", "00000002", "PARAM_MISSING", "System Error", false, SystemResponseCode.PARAM_MISSING), PARAM_ILLEGAL(
            "501", "00000004", "PARAM_ILLEGAL", "System Error", false, SystemResponseCode.PARAM_ILLEGAL), INVALID_SIGNATURE(
            "501", "00000007", "INVALID_SIGNATURE", "System Error", false, SystemResponseCode.INVALID_SIGNATURE), KEY_NO_FOUND(
            "501", "00000008", "KEY_NO_FOUND", "System Error", false, SystemResponseCode.KEY_NO_FOUND), NO_INTERFACE_DEF(
            "501", "00000013", "NO_INTERFACE_DEF", "System Error", false, SystemResponseCode.NO_INTERFACE_DEF), API_IS_INVALID(
            "501", "00000014", "API_IS_INVALID", "System Error", false, SystemResponseCode.API_IS_INVALID), MSG_PARSE_ERROR(
            "501", "00000015", "MSG_PARSE_ERROR", "System Error", false, SystemResponseCode.MSG_PARSE_ERROR), OAUTH_FAILED(
            "501", "00000016", "OAUTH_FAILED", "System Error", false, SystemResponseCode.OAUTH_FAILED), FUNCTION_NOT_MATCH(
            "501", "00000017", "FUNCTION_NOT_MATCH", "System Error", false, SystemResponseCode.FUNCTION_NOT_MATCH), SYSTEM_ERROR(
            "501", "00000900", "SYSTEM_ERROR", "System Error", false, SystemResponseCode.SYSTEM_ERROR), QR_EXPIRED_ERROR(
            "501", "", "QR_EXPIRED_ERROR", "QR Code has been expired, Please ask merchant to share the new QR code",
            false, SystemResponseCode.SYSTEM_ERROR), VERIFY_CLIENT_SECRET_FAIL("501", "12014151",
            "VERIFY_CLIENT_SECRET_FAIL", "System Error", false, SystemResponseCode.VERIFY_CLIENT_SECRET_FAIL), CLIENT_FORBIDDEN_ACCESS_API(
            "501", "12014152", "CLIENT_FORBIDDEN_ACCESS_API", "System Error", false,
            SystemResponseCode.CLIENT_FORBIDDEN_ACCESS_API), UNKNOWN_CLIENT("501", "12014155", "UNKNOWN_CLIENT",
            "System Error", false, SystemResponseCode.UNKNOWN_CLIENT), INVALID_CLIENT_STATUS("501", "12014156",
            "INVALID_CLIENT_STATUS", "System Error", false, SystemResponseCode.INVALID_CLIENT_STATUS), UNAUTH_API_FLOW_ACCESS(
            "501", "12014110", "UNAUTH_API_FLOW_ACCESS",
            "You do not have access to this functionality using this API.", false,
            SystemResponseCode.CLIENT_FORBIDDEN_ACCESS_API), MERCHANT_BLOCKED(
            "504",
            "12014157",
            "MERCHANT_BLOCKED",
            "Transaction could not be completed on this Merchant as merchant status is Inactive, please ask Merchant to contact Paytm helpdesk.",
            true, SystemResponseCode.MERCHANT_BLOCKED), MERCHANT_BLOCKED_PAYMENT(
            "506",
            "12014160",
            "MERCHANT_BLOCKED_PAYMENT",
            "Payment acceptance on this merchant is not available currently, please ask the merchant to contact our helpdesk team.",
            true, SystemResponseCode.MERCHANT_BLOCKED_PAYMENT),

    ACCOUNT_NUMBER_MISMATCH("507", null, null, "Account Number Mismatch", true,
            SystemResponseCode.ACCOUNT_NUMBER_MISMATCH),

    ACCOUNT_NUMBER_NOT_EXIST("508", null, null, "Could not fetch account Number", true,
            SystemResponseCode.ACCOUNT_NUMBER_NOT_EXIST), IFSC_NOT_EXIST("509", null, null,
            "Could not fetch ifsc code", true, SystemResponseCode.INVALID_REQUEST),

    ACCOUNT_HOLDER_NAME_NOT_EXIST("510", null, null, "Account Holder name cannot be empty", true,
            SystemResponseCode.INVALID_REQUEST),

    ACCOUNT_TYPE_NOT_EXIST("511", null, null, "Account type canot be empty", true, SystemResponseCode.INVALID_REQUEST),

    INVALID_FREQUENCY_VALUE("512", null, null, "Invalid frequency value for mandate request", true,
            SystemResponseCode.INVALID_REQUEST),

    INVALID_MANDATE_BANK_CODE("513", null, null, "Invalid bank code", true, SystemResponseCode.INVALID_REQUEST),

    INVALID_MANDATE_AUTH_MODE("514", null, null, "Bank does not support the sent auth mode", true,
            SystemResponseCode.INVALID_REQUEST),

    INVALID_MANDATE_MODE("515", null, null, "The bank does not support any mandate mode", true,
            SystemResponseCode.INVALID_REQUEST),

    INVALID_REQUEST("283", "12014159", "INVALID_REQUEST", "Mandatory fields are missing.", true,
            SystemResponseCode.INVALID_REQUEST),

    // Some Common Codes for CreatOrder and CreateOrderAndPay
    SUCCESS_IDEMPOTENT_ERROR("325", "00000012", "SUCCESS_IDEMPOTENT_ERROR",
            "The payment failed due to duplicate order id. Please try again.", true,
            SystemResponseCode.SUCCESS_IDEMPOTENT_ERROR), ACCESS_DENIED("302", "12005001", "ACCESS_DENIED",
            "Invalid Request Type", true, SystemResponseCode.ACCESS_DENIED), AMOUNT_EXCEEDS_LIMIT(
            "196",
            "12005104",
            "AMOUNT_EXCEEDS_LIMIT",
            "Payment failed as amount entered exceeds the allowed limit. Please enter a lower amount and try again or reach out to the merchant for further assistance.",
            true, SystemResponseCode.AMOUNT_EXCEEDS_LIMIT), USER_NOT_EXISTS("501", "12005109", "USER_NOT_EXISTS",
            "System Error", false, SystemResponseCode.USER_NOT_EXISTS), MERCHANT_NOT_EXIST("239", "12003001",
            "MERCHANT_NOT_EXIST", "System Error", false, SystemResponseCode.MERCHANT_NOT_EXIST), USER_STATUS_ABNORMAL(
            "239", "12005110", "USER_STATUS_ABNORMAL", "System Error", false, SystemResponseCode.USER_STATUS_ABNORMAL), REPEAT_REQ_INCONSISTENT(
            "325", "12005112", "REPEAT_REQ_INCONSISTENT",
            "The payment failed due to duplicate order id. Please try again.", true,
            SystemResponseCode.REPEAT_REQ_INCONSISTENT),

    // Common Code for createOrderAndPay, ConsultPayView and Pay
    RISK_REJECT("501", "00000011", "RISK_REJECT", "Risk Reject", false, SystemResponseCode.RISK_REJECT), // Check
    // Paytmcode
    MERCHANT_RISK_REJECT(
            "505",
            "12014158",
            "MERCHANT_RISK_REJECT",
            "Please try with lower amount or different payment source. Transaction limits will revise as you continue using Paytm.",
            true, SystemResponseCode.MERCHANT_RISK_REJECT),

    // Common Code in CreateOrderAndPay and Close Order
    ORDER_STATUS_INVALID("325", "12005003", "ORDER_STATUS_INVALID",
            "The payment failed due to duplicate order id. Please try again.", true,
            SystemResponseCode.ORDER_STATUS_INVALID),

    // Commom Code in ConsultPayView And Pay
    PROCESS_FAIL("501", "00000019", "PROCESS_FAIL", "Process Fail", false, SystemResponseCode.PROCESS_FAIL),

    INVALID_OFFLINE_REQUEST("501", "00000999", "SYSTEM_ERROR", "System Error", false,
            SystemResponseCode.INVALID_OFFLINE_REQUEST),

    TRANS_STATUS_ABNORMAL("501", "12006002", "TRANS_STATUS_ABNORMAL", "Trans Status Abnormal", false,
            SystemResponseCode.TRANS_STATUS_ABNORMAL), // Check
    // Paytmcode
    BALANCE_ACCOUNT_NOT_EXIST("501", "12006011", "BALANCE_ACCOUNT_NOT_EXIST", "Process Fail", false,
            SystemResponseCode.BALANCE_ACCOUNT_NOT_EXIST), // Check
    // Paytmcode
    PAYER_STATUS_ABNORMAL("501", "12006015", "PAYER_STATUS_ABNORMAL", "Process status abnormal", false,
            SystemResponseCode.PAYER_STATUS_ABNORMAL), // Check
    // Paytmcode
    MERCHANT_STATUS_DISABLE("501", "12006031", "MERCHANT_STATUS_DISABLE", "Merchant status disable", false,
            SystemResponseCode.MERCHANT_STATUS_DISABLE), // Check
    // Paytmcode

    KYC_VALIDATION_REQUIRED("700", "12014161", "KYC_VALIDATION_REQUIRED", "", false,
            SystemResponseCode.KYC_VALIDATION_REQUIRED),

    // For create Top-UP
    PAYEE_USER_NOT_EXIST_TOPUP("501", "12007302", "SYSTEM_ERROR", "System Error", false,
            SystemResponseCode.PAYEE_USER_NOT_EXIST_TOPUP), PAYEE_USER_STATUS_DISABLE_TOPUP("501", "12007304",
            "SYSTEM_ERROR", "System Error", false, SystemResponseCode.PAYEE_USER_STATUS_DISABLE_TOPUP), PAYEE_ACCOUNT_NOT_EXIST_TOPUP(
            "501", "12007306", "PAYEE_ACCOUNT_NOT_EXIST_TOPUP", "Payee account does not exist", false,
            SystemResponseCode.PAYEE_ACCOUNT_NOT_EXIST_TOPUP), PAYEE_TYPE_ILLEGAL_TOPUP("501", "12007310",
            "SYSTEM_ERROR", "System Error", false, SystemResponseCode.PAYEE_TYPE_ILLEGAL_TOPUP), ACCOUNT_IN_DISABLE_TOPUP(
            "236", "12007314", "SYSTEM_ERROR", "Wallet does not exist.", false,
            SystemResponseCode.ACCOUNT_IN_DISABLE_TOPUP), EXCEED_KYC_BALANCE_LIMIT_TOPUP("173", "12007317",
            "EXCEED_KYC_BALANCE_LIMIT", "SSO ID exceeds maximum transaction amount", false,
            SystemResponseCode.EXCEED_KYC_BALANCE_LIMIT_TOPUP), EXCEED_NON_KYC_BALANCE_LIMIT_TOPUP("173", "12007318",
            "EXCEED_NON_KYC_BALANCE_LIMIT", "SSO ID exceeds maximum transaction amount", false,
            SystemResponseCode.EXCEED_NON_KYC_BALANCE_LIMIT_TOPUP), AMOUNT_LESS_THAN_MIN_LIMIT_TOPUP("501", "12007319",
            "AMOUNT_LESS_THAN_MIN_LIMIT", "System Error", false, SystemResponseCode.AMOUNT_LESS_THAN_MIN_LIMIT_TOPUP), AMOUNT_EXCEED_SINGLE_LIMIT_TOPUP(
            "157",
            "12007321",
            "AMOUNT_EXCEED_SINGLE_LIMIT",
            "You can add upto Rs.10,000 per month only in your wallet. To increase this limit, please upgrade your wallet from your paytm profile page from laptop/desktop.",
            false, SystemResponseCode.AMOUNT_EXCEED_SINGLE_LIMIT_TOPUP), PAYEE_AMOUNT_EXCEED_DAILY_LIMIT_TOPUP("501",
            "12007323", "PAYEE_AMOUNT_EXCEED_DAILY_LIMIT_TOPUP", "Max Txn amount is crossed for Merchant", false,
            SystemResponseCode.PAYEE_AMOUNT_EXCEED_DAILY_LIMIT_TOPUP), // Check
    // Paytmcode
    PAYEE_AMOUNT_EXCEED_MONTH_LIMIT_TOPUP("501", "12007325", "PAYEE_AMOUNT_EXCEED_MONTH_LIMIT_TOPUP",
            "Per Month Txn amount is crossed for Merchant", false,
            SystemResponseCode.PAYEE_AMOUNT_EXCEED_MONTH_LIMIT_TOPUP), // Check
    // Paytmcode
    PAYEE_AMOUNT_EXCEED_YEAR_LIMIT_TOPUP("501", "12007327", "PAYEE_AMOUNT_EXCEED_YEAR_LIMIT_TOPUP",
            "Per Month Txn amount is crossed for Merchant", false,
            SystemResponseCode.PAYEE_AMOUNT_EXCEED_YEAR_LIMIT_TOPUP), // Check
    // Paytmcode
    REPEAT_REQ_INCONSISTENT_TOPUP("325", "12007204", "REPEAT_REQ_INCONSISTENT_TOPUP",
            "The payment failed due to duplicate order id. Please try again.", true,
            SystemResponseCode.REPEAT_REQ_INCONSISTENT_TOPUP),

    // Create Order And Pay
    BALANCE_NOT_ENOUGH_CREATE_PAY("235", "12005115", "BALANCE_NOT_ENOUGH_CREATE_PAY", "Insufficient balance.", false,
            SystemResponseCode.BALANCE_NOT_ENOUGH_CREATE_PAY), // Check
    // Paytmcode
    PAY_AMOUNT_UNEQUAL_ORDER_AMOUNT("222", "12005113", "PAY_AMOUNT_UNEQUAL_ORDER_AMOUNT",
            "pay amount is different from order amount.", false, SystemResponseCode.PAY_AMOUNT_UNEQUAL_ORDER_AMOUNT), // Check
    // Paytmcode
    EXCEEDS_CHANNEL_LIMIT("501", "12005114", "EXCEEDS_CHANNEL_LIMIT", "System Error", false,
            SystemResponseCode.EXCEEDS_CHANNEL_LIMIT), // Check
    // Paytmcode
    CHANNEL_STATUS_NOT_ENABLE("153", "12005117", "CHANNEL_STATUS_NOT_ENABLE", "System Error", false,
            SystemResponseCode.CHANNEL_STATUS_NOT_ENABLE), // Check
    // Paytmcode
    NEED_RISK_CHALLENGE("239", "12005120", "NEED_RISK_CHALLENGE", "System Error", false,
            SystemResponseCode.NEED_RISK_CHALLENGE), // Check
    // Paytmcode
    DUPLICATE_PAYMENT_REQUEST("150", "12005122", "DUPLICATE_PAYMENT_REQUEST", "System Error", false,
            SystemResponseCode.DUPLICATE_PAYMENT_REQUEST), // Check
    // Prepaid Card Not Supported
    PREPAID_CARD_NOT_SUPPORTED("150", "12006068", "MERCHANT_DOES_NOT_SUPPORT_PREPAID_CARD_PAY",
            "prepaid card is not supported in merchant contract", true, SystemResponseCode.PREPAID_CARD_NOT_SUPPORTED),

    ECOMTOKEN_TRANSACTION_NOT_SUPPORTED("150", "12006072", "ECOMTOKEN_TRANSACTION_NOT_SUPPORTED",
            "EcomToken transaction is not supported in merchant contract", true,
            SystemResponseCode.PREPAID_CARD_NOT_SUPPORTED),
    // Check
    // Paytmcode
    UNSUPPORT_ISSUING_COUNTRY("501", "12006058", "UNSUPPORT_ISSUING_COUNTRY", "System Error", false,
            SystemResponseCode.UNSUPPORT_ISSUING_COUNTRY),

    // Close Order
    ORDER_NOT_EXISTS("357", "12005002", "ORDER_NOT_EXISTS", "Invalid order Id", false,
            SystemResponseCode.ORDER_NOT_EXISTS), ORDER_IS_CLOSED("410", "12005100", "ORDER_IS_CLOSED",
            "order status is closed.", false, SystemResponseCode.ORDER_IS_CLOSED), ORDER_IS_FROZEN("357", "12005004",
            "ORDER_IS_FROZEN", "order status is frozen.", false, SystemResponseCode.ORDER_IS_FROZEN), ORDER_IS_PAID(
            "201", "12005009", "ORDER_IS_PAID", "order is paid", true, SystemResponseCode.ORDER_IS_PAID),

    FUND_ORDER_STATUS_INVALID("391", "12007202", "FUND_ORDER_STATUS_INVALID", "order status is invalid.", false,
            SystemResponseCode.FUND_ORDER_STATUS_INVALID),

    // Consult Fee Boss
    FEE_RATE_NOT_EXIST("501", "12008301", "Fee rate not exist", "Fee rate not exist", false,
            SystemResponseCode.FEE_RATE_NOT_EXIST), // Check
    // Paytmcode
    FEE_RATE_NOT_MATCH("501", "12008302", "Can not match a fee rate", "Can not match a fee rate", false,
            SystemResponseCode.FEE_RATE_NOT_MATCH), // Check
    // Paytmcode

    // Query By merhchant Trans ID
    TARGET_NOT_FOUND("501", "00000020", "order is not found", "order is not found", false,
            SystemResponseCode.TARGET_NOT_FOUND), // Check
    // Paytmcode

    // Cache Card
    CARD_INDEX_NO_NOT_EXIST("501", "12002043", "input card index not exist", "input card index not exist", false,
            SystemResponseCode.CARD_INDEX_NO_NOT_EXIST), // Check
    // Paytmcode

    // Pay
    SESSION_EXPIRY("501", "11006000", "SESSION_EXPIRY", "System Error", false, SystemResponseCode.SESSION_EXPIRY), // Check
    // Paytmcode
    CHANNEL_NOT_AVAILABLE("153", "12006003", "CHANNEL_NOT_AVAILABLE",
            "Channel is not configured with the Payment source,Auth Mode and Communication Mode.", false,
            SystemResponseCode.CHANNEL_NOT_AVAILABLE), // Check
    // Paytmcode
    CHANNEL_NOT_IN_SERVICE_TIME("501", "12006005", "CHANNEL_NOT_IN_SERVICE_TIME", "System Error", false,
            SystemResponseCode.CHANNEL_NOT_IN_SERVICE_TIME), // Check
    // Paytmcode
    CHANNEL_UNDER_MAINTENANCE("501", "12006006", "CHANNEL_UNDER_MAINTENANCE", "System Error", false,
            SystemResponseCode.CHANNEL_UNDER_MAINTENANCE), // Check
    // Paytmcode
    EXCEED_CHANNEL_AMOUNT_LIMIT("501", "12006007", "EXCEED_CHANNEL_AMOUNT_LIMIT", "System Error", false,
            SystemResponseCode.EXCEED_CHANNEL_AMOUNT_LIMIT), // Check
    // Paytmcode
    BALANCE_NOT_ENOUGH_PAY("235", "12006009", "BALANCE_NOT_ENOUGH_PAY", "Insufficient balance.", false,
            SystemResponseCode.BALANCE_NOT_ENOUGH_PAY), // Check
    // Paytmcode
    DUPLICATE_REQUEST("150", "12006012", "DUPLICATE_REQUEST", "System Error", false,
            SystemResponseCode.DUPLICATE_REQUEST), // Check
    // Paytmcode
    PAYMENT_AMOUNT_UNMATCH("501", "12006013", "PAYMENT_AMOUNT_UNMATCH", "System Error", false,
            SystemResponseCode.PAYMENT_AMOUNT_UNMATCH), // Check
    // Paytmcode
    RISK_VERIFICATION("501", "12006014", "RISK_VERIFICATION", "System Error", false,
            SystemResponseCode.RISK_VERIFICATION), // Check
    // Paytmcode
    PAYEE_STATUS_ABNORMAL("501", "12006016", "PAYEE_STATUS_ABNORMAL", "System Error", false,
            SystemResponseCode.RISK_VERIFICATION), // Check
    // Paytmcode
    PAYER_MOBILE_NOT_VERIFY("501", "12006017", "PAYER_MOBILE_NOT_VERIFY", "System Error", false,
            SystemResponseCode.PAYER_MOBILE_NOT_VERIFY), // Check
    // Paytmcode
    PAYEE_MOBILE_NOT_VERIFY("501", "12006018", "PAYEE_MOBILE_NOT_VERIFY", "System Error", false,
            SystemResponseCode.PAYEE_MOBILE_NOT_VERIFY), // Check
    // Paytmcode
    PAYER_USER_NOT_KYC("501", "12006019", "PAYER_USER_NOT_KYC", "System Error", false,
            SystemResponseCode.PAYER_USER_NOT_KYC), // Check
    // Paytmcode
    PAYEE_USER_NOT_KYC("501", "12006020", "PAYEE_USER_NOT_KYC", "System Error", false,
            SystemResponseCode.PAYEE_USER_NOT_KYC), // Check
    // Paytmcode
    ACCOUNT_OUT_DISABLE("501", "12006021", "ACCOUNT_OUT_DISABLE", "System Error", false,
            SystemResponseCode.ACCOUNT_OUT_DISABLE), // Check
    // Paytmcode
    PAYER_AMOUNT_EXCEED_DAILY_LIMIT_PAY("107", "12006025", "PAYER_AMOUNT_EXCEED_DAILY_LIMIT",
            "Max Txn amount is crossed for Cust Id", false, SystemResponseCode.PAYER_AMOUNT_EXCEED_DAILY_LIMIT_PAY), // Check
    // Paytmcode
    PAYEE_AMOUNT_EXCEED_DAILY_LIMIT_PAY("501", "12006026", "PAYEE_AMOUNT_EXCEED_DAILY_LIMIT_PAY",
            "Max Txn amount is crossed for Merchant", false, SystemResponseCode.PAYEE_AMOUNT_EXCEED_DAILY_LIMIT_PAY), // Check
    // Paytmcode
    PAYER_AMOUNT_EXCEED_MONTH_LIMIT_PAY("108", "12006027", "PAYER_AMOUNT_EXCEED_MONTH_LIMIT",
            "PerWeek Txn amount is crossed for Cust Id", false, SystemResponseCode.PAYER_AMOUNT_EXCEED_MONTH_LIMIT_PAY), // Check
    // Paytmcode
    PAYEE_AMOUNT_EXCEED_MONTH_LIMIT_PAY("501", "12006028", "PAYEE_AMOUNT_EXCEED_MONTH_LIMIT",
            "Per Month Txn amount is crossed for Merchant", false,
            SystemResponseCode.PAYEE_AMOUNT_EXCEED_MONTH_LIMIT_PAY), // Check
    // Paytmcode
    PAYER_AMOUNT_EXCEED_YEAR_LIMIT_PAY("109", "12006029", "PAYER_AMOUNT_EXCEED_YEAR_LIMIT",
            "Per Month Txn amount is crossed for Cust Id", false, SystemResponseCode.PAYER_AMOUNT_EXCEED_YEAR_LIMIT_PAY), // Check
    // Paytmcode
    PAYEE_AMOUNT_EXCEED_YEAR_LIMIT_PAY("501", "12006030", "PAYEE_AMOUNT_EXCEED_YEAR_LIMIT",
            "Per Month Txn amount is crossed for Merchant", false,
            SystemResponseCode.PAYEE_AMOUNT_EXCEED_YEAR_LIMIT_PAY), // Check
    // Paytmcode
    MERCHANT_ACCOUNT_OUT_DISABLE("501", "12006032", "MERCHANT_ACCOUNT_OUT_DISABLE", "System Error", false,
            SystemResponseCode.MERCHANT_ACCOUNT_OUT_DISABLE), // Check
    // Paytmcode
    MERCHANT_ACCOUNT_IN_DISABLE("501", "12006033", "MERCHANT_ACCOUNT_IN_DISABLE", "System Error", false,
            SystemResponseCode.MERCHANT_ACCOUNT_IN_DISABLE), // Check
    // Paytmcode
    TRANS_FROZEN("501", "12006036", "TRANS_FROZEN", "System Error", false, SystemResponseCode.TRANS_FROZEN), // Check
    // Paytmcode
    TRANS_PAID("501", "12006037", "TRANS_PAID", "System Error", false, SystemResponseCode.TRANS_PAID), // Check
    // Paytmcode
    TRANS_CLOSED("501", "12006038", "TRANS_CLOSED", "System Error", false, SystemResponseCode.TRANS_CLOSED), // Check
    // Paytmcode
    BUYER_NOT_CONSISTENT("501", "12006040", "BUYER_NOT_CONSISTENT", "System Error", false,
            SystemResponseCode.BUYER_NOT_CONSISTENT), // Check
    // Paytmcode
    SERVICE_INST_NOT_EXIST("501", "12006042", "SERVICE_INST_NOT_EXIST", "System Error", false,
            SystemResponseCode.SERVICE_INST_NOT_EXIST), // Check
    // Paytmcode
    FEE_PAYMENT_CONSULT_FAIL("501", "12006045", "FEE_PAYMENT_CONSULT_FAIL", "System Error", false,
            SystemResponseCode.FEE_PAYMENT_CONSULT_FAIL), // Check
    // Paytmcode
    BALANCE_OVER_LIMIT("501", "12006046", "BALANCE_OVER_LIMIT", "System Error", false,
            SystemResponseCode.BALANCE_OVER_LIMIT), // Check
    // Paytmcode
    HYBRID_CHANNEL_NOT_AVAILABLE("501", "12006047", "HYBRID_CHANNEL_NOT_AVAILABLE", "System Error", false,
            SystemResponseCode.HYBRID_CHANNEL_NOT_AVAILABLE), // Check
    // Paytmcode
    ACCOUNT_BALANCE_QUERY_FAIL("501", "12006041", "ACCOUNT_BALANCE_QUERY_FAIL", "System Error", false,
            SystemResponseCode.ACCOUNT_BALANCE_QUERY_FAIL), // Check
    // Paytmcode
    BALANCE_ACCOUNT_STATUS_DISABLED("501", "12006043", "BALANCE_ACCOUNT_STATUS_DISABLED", "System Error", false,
            SystemResponseCode.BALANCE_ACCOUNT_STATUS_DISABLED), // Check
    // Paytmcode

    // Paytm AddMoney Failed
    ADD_MONEY_WALLET_CONSULT_FAILED("163", null, null, "Wallet Consult failed", true,
            SystemResponseCode.ADD_MONEY_WALLET_CONSULT_FAILED),
    // EMAIL details
    EMI_PROCESSING_FAILED("501", null, null, "EMI Processing Failed: Invalid Params", true,
            SystemResponseCode.EMI_PROCESSING_FAILED),

    // Failure response codes for wallet debit limit
    PAYER_AMOUNT_EXCEED_DAILY_LIMIT_USER_DEFINED("156", "22007341", "PAYER_AMOUNT_EXCEED_DAILY_LIMIT_USER_DEFINED",
            "Per day Txn amount is crossed for Paytm", true,
            SystemResponseCode.PAYER_AMOUNT_EXCEED_DAILY_LIMIT_USER_DEFINED), PAYER_COUNT_EXCEED_DAILY_LIMIT_USER_DEFINED(
            "159", "22007342", "PAYER_COUNT_EXCEED_DAILY_LIMIT_USER_DEFINED", "Per day Txn count is crossed for Paytm",
            true, SystemResponseCode.PAYER_COUNT_EXCEED_DAILY_LIMIT_USER_DEFINED), PAYER_AMOUNT_EXCEED_MONTH_LIMIT_USER_DEFINED(
            "158", "22007343", "PAYER_AMOUNT_EXCEED_MONTH_LIMIT_USER_DEFINED",
            "Per Month Txn amount is crossed for Paytm", true,
            SystemResponseCode.PAYER_AMOUNT_EXCEED_MONTH_LIMIT_USER_DEFINED), PAYER_COUNT_EXCEED_MONTH_LIMIT_USER_DEFINED(
            "161", "22007344", "PAYER_COUNT_EXCEED_MONTH_LIMIT_USER_DEFINED",
            "Per Month Txn count is crossed for Paytm", true,
            SystemResponseCode.PAYER_COUNT_EXCEED_MONTH_LIMIT_USER_DEFINED), PAYER_AMOUNT_EXCEED_MONTH_LIMIT_MIN_KYC(
            "165", "22007345", "PAYER_AMOUNT_EXCEED_MONTH_LIMIT_MIN_KYC",
            "User has crossed the monthly debit limit prescribed by RBI", true,
            SystemResponseCode.PAYER_AMOUNT_EXCEED_MONTH_LIMIT_MIN_KYC),

    // Validation Exceptions
    INVALID_PAYMENT_DETAILS("209", null, "INVALID_PAYMENT_DETAILS", "Invalid Payment Details", true,
            SystemResponseCode.INVALID_PAYMENT_DETAILS), INVALID_REQUEST_TYPE("302", null, "INVALID_REQUEST_TYPE",
            "Invalid Request Type", true, SystemResponseCode.INVALID_REQUEST_TYPE), INVALID_TXN_AMOUNT("308", null,
            "INVALID_TXN_AMOUNT", "Invalid Txn Amount", true, SystemResponseCode.INVALID_TXN_AMOUNT), INVALID_ORDER_ID(
            "309", null, "INVALID_ORDER_ID", "Invalid Order ID", true, SystemResponseCode.INVALID_ORDER_ID), INVALID_CARD_NO(
            "312", null, "INVALID_CARD_NO", "Invalid Card No", true, SystemResponseCode.INVALID_CARD_NO), INVALID_SAVED_CARD_ID(
            "313", null, "INVALID_SAVED_CARD_ID", "Invalid SavedCardID", true, SystemResponseCode.INVALID_SAVED_CARD_ID), INVALID_MONTH(
            "314", null, "INVALID_MONTH", "Invalid Month", true, SystemResponseCode.INVALID_MONTH), INVALID_YEAR("315",
            null, "INVALID_YEAR", "Invalid Year", true, SystemResponseCode.INVALID_YEAR), INVALID_CVV("316", null,
            "INVALID_CVV", "You have entered wrong CVV for this card. Please try again with correct CVV", true,
            SystemResponseCode.INVALID_CVV), INVALID_PAYMENTMODE("317", null, "INVALID_PAYMENTMODE",
            "Invalid payment source", true, SystemResponseCode.INVALID_PAYMENTMODE), PREPAID_AMOUNT_LIMIT_BREACH("317",
            null, "PREPAID_AMOUNT_LIMIT_BREACH", "Prepaid Card Transaction Amount Limit Breach", true,
            SystemResponseCode.AMOUNT_EXCEEDS_LIMIT), INVALID_PROMOCODE("317", null, "INVALID_PROMOCODE",
            "Invalid promo code", true, SystemResponseCode.INVALID_PROMOCODE), INVALID_CUST_ID("318", null,
            "INVALID_CUST_ID", "Invalid CustID", true, SystemResponseCode.INVALID_CUST_ID), INVALID_INDUSTRY_TYPE_ID(
            "319", null, "INVALID_INDUSTRY_TYPE_ID", "Invalid Industry Type ID", true,
            SystemResponseCode.INVALID_INDUSTRY_TYPE_ID), INVALID_CARD_STORE_FLAG("320", null,
            "INVALID_CARD_STORE_FLAG", "Invalid card store flag", true, SystemResponseCode.INVALID_CARD_STORE_FLAG), INVALID_CHANNEL(
            "327", null, "INVALID_CHANNEL", "Invalid channel", true, SystemResponseCode.INVALID_CHANNEL), INVALID_PAYTM_ID(
            "328", null, "INVALID_PAYTM_ID", "Invalid paytm ID", true, SystemResponseCode.INVALID_PAYTM_ID), INVALID_OTP(
            "329", null, "INVALID_OTP", "Invalid OTP", true, SystemResponseCode.INVALID_OTP), INVALID_MID("335", null,
            "INVALID_MID", "Invalid MID", true, SystemResponseCode.INVALID_MID), INVALID_TRANS_TYPE("336", null,
            "INVALID_TRANS_TYPE", "Invalid Trans Type", true, SystemResponseCode.INVALID_TRANS_TYPE), INVALID_SUBS_START_DATE(
            "337", null, "INVALID_SUBS_START_DATE", "Invalid Subs Start date", true,
            SystemResponseCode.INVALID_SUBS_START_DATE), INVALID_SUBS_END_DATE("338", null, "INVALID_SUBS_END_DATE",
            "Invalid Subs End date", true, SystemResponseCode.INVALID_SUBS_END_DATE), INVALID_MMID("339", null,
            "INVALID_MMID", "Invalid MMID", true, SystemResponseCode.INVALID_MMID), INVALID_MOBILE_NUMBER("340", null,
            "INVALID_MOBILE_NUMBER", "Invalid Mobile Number", true, SystemResponseCode.INVALID_MOBILE_NUMBER), INVALID_PARAM(
            "0", null, "INVALID_PARAM", "System Error, invalid param", false, SystemResponseCode.INVALID_PARAM), INVALID_CARD_TOKEN(
            "370", null, "INVALID_CARD_TOKEN", "Invalid Card Token", true, SystemResponseCode.INVALID_CARD_TOKEN), INVALID_CC_BILL_NO(
            "371", null, "INVALID_CC_BILL_NO", "Invalid Credit Card Bill Number", true,
            SystemResponseCode.INVALID_CC_BILL_NO), INVALID_SSO_TOKEN("2004", null, "INVALID_SSO_TOKEN",
            "Invalid User Token", true, SystemResponseCode.INVALID_SSO_TOKEN), INVALID_ONECLICK_TXN_AMOUNT("308", null,
            "INVALID_ONECLICK_TXN_AMOUNT", "Transaction amount exceeds the limit of OTP less payments", true,
            SystemResponseCode.INVALID_ONECLICK_TXN_AMOUNT), INVALID_WALLET_2FA_PASSCODE("401", null, "INVALID_WALLET_2FA_PASSCODE", "You have entered incorrect passcode. Kindly retry.", true,
            SystemResponseCode.INVALID_WALLET_2FA_PASSCODE),

    NATIVE_RETRY_COUNT_BREACHED("372", null, null, "Retry count breached", true,
            SystemResponseCode.NATIVE_RETRY_COUNT_BREACHED),

    // Paytm_Express validation response codes
    INVALID_CARD_NUMBER("PG-1002", null, null, "Invalid Card Number", true, SystemResponseCode.INVALID_CARD_NUMBER), INVALID_EXPIRY_DATE(
            "PG-1003", null, null, "Invalid Expiry Date", true, SystemResponseCode.INVALID_EXPIRY_DATE), TOKEN_NOT_GENERATD(
            "TOKN-JS901", null, null, "Not able to generate token", true, SystemResponseCode.TOKEN_NOT_GENERATD), INCOMPLETE_CARD_INFORMATION(
            "TOKN-JS903", null, null, "Incomplete card information", true,
            SystemResponseCode.INCOMPLETE_CARD_INFORMATION),
    // INVALID_MERCHANT_ID("TOKN-JS904",null,null,"Invalid Mid",true),
    INVALID_JSON_DATA("CMER-JSE101", null, null, "Invalid JSON Data", true, SystemResponseCode.INVALID_JSON_DATA), INVALID_REQUEST_FORMAT(
            "CMER-USEC101", null, null, "Invalid Request Format", true, SystemResponseCode.INVALID_REQUEST_FORMAT), INTERNAL_PROCESSING_ERROR(
            "CMER-IP101", null, null, "Internal Processing Error", true, SystemResponseCode.INTERNAL_PROCESSING_ERROR), FAILURE(
            null, null, null, "FAILURE", true, SystemResponseCode.FAILURE), SUCCESS(null, null, null, "SUCCESS", true,
            SystemResponseCode.SUCCESS),

    // Success
    SUCCESS_RESPONSE_CODE("01", null, null, "Txn Success", true, SystemResponseCode.SUCCESS_RESPONSE_CODE),

    FGW_BANK_FORM_RETRIEVE_FAILED("296", null, null, "Invalid Payment Request", true,
            SystemResponseCode.FGW_BANK_FORM_RETRIEVE_FAILED),

    FGW_PREFERRED_OTP_PAGE_BANK_FAILURE("297", null, null, "Invalid Payment Request", true,
            SystemResponseCode.FGW_PREFERRED_OTP_PAGE_BANK_FAILURE),

    FGW_PREFERRED_OTP_PAGE_MERCHANT_FAILURE("298", null, null, "Invalid Payment Request", true,
            SystemResponseCode.FGW_PREFERRED_OTP_PAGE_MERCHANT_FAILURE),

    FGW_INVALID_VPA("295", null, null, "Invalid VPA", true, SystemResponseCode.FGW_INVALID_VPA),

    LOYALTY_POINT_NOT_CONFIGURED("501", "1001", null, "LOYALTY_POINT_NOT_CONFIGURED", false,
            SystemResponseCode.LOYALTY_POINT_NOT_CONFIGURED),

    MERCHANT_FAILURE_RESPONSE("810", null, null, "Merchant Transaction Failure", true,
            SystemResponseCode.MERCHANT_FAILURE_RESPONSE), SUBVENTION_CHECKOUT_FAILURE("832",
            "SUBVENTION_CHECKOUT_FAILURE", "F", "Subvention offer checkout failure", true,
            SystemResponseCode.PAYMENT_OFFER_CHECKOUT_FAILURE), CORE_SESSION_EXPIRED_FAILURE("402", null, null,
            "Session Expired Failure", true, SystemResponseCode.CORE_SESSION_EXPIRED_FAILURE),

    // Paytm checksum mismatch
    INVALID_CHECKSUM("330", null, "INVALID_CHECKSUM", "Invalid checksum", true, SystemResponseCode.INVALID_CHECKSUM), MERCHANT_VELOCITY_LIMIT_BREACH(
            "RC-00018",
            "MERCHANT_VELOCITY_LIMIT_BREACH",
            "F",
            "Merchant payment acceptance limit breached for this payment method. Please try using UPI or Paytm Payments bank",
            true, SystemResponseCode.MERCHANT_VELOCITY_LIMIT_BREACH),
    // Kyb
    KYB_NO_RELATION_FOUND("510", null, "KYB_NO_RELATION_FOUND", "no relation found in kyb service", true,
            SystemResponseCode.KYB_NO_RELATION_FOUND), KYB_NOT_PERMITTED("511", null, "KYB_NOT_PERMITTED",
            "required permission not found", true, SystemResponseCode.KYB_NOT_PERMITTED), PAYMENT_OFFER_CHECKOUT_FAILURE(
            "RC-00010", "PAYMENT_OFFER_CHECKOUT_FAILURE", "F", "Payment offer checkout failure", true,
            SystemResponseCode.PAYMENT_OFFER_CHECKOUT_FAILURE), PAY_MODES_ARE_BLANK_FOR_PROMO_CODE("810",
            "PAY_MODES_ARE_BLANK_FOR_PROMO_CODE", "F", "No paymodes are configured for applied promo code", true,
            SystemResponseCode.PAY_MODES_ARE_BLANK_FOR_PROMO_CODE),

    // PWP Promo
    PWP_PROMO_NOT_SUPPORTED("583", null, "PROMO_NOT_SUPPORTED", "Mandatory fields are missing.", true,
            SystemResponseCode.INVALID_REQUEST),

    NO_PWP_SUPPORT_MERCHANT("501", "12006070", "NO_PWP_SUPPORT_MERCHANT",
            "No Pay with Paytm(PWP) support in merchant contract", true, SystemResponseCode.INVALID_REQUEST),
    // Gv Consent
    GV_CONSENT_REQUIRED("999", null, null, "Gv consent required!", false, SystemResponseCode.GV_CONSENT_REQUIRED),

    // PPi limit branch
    PPI_LIMIT_PAYMODE_AMOUNT_BREACHED("501", null, "PPI_LIMIT_PAYMODE_AMOUNT_BREACHED",
            "Please try with lower amount or different payment mode for this transaction.", false,
            SystemResponseCode.PPI_LIMIT_PAYMODE_AMOUNT_BREACHED),

    ADD_MONEY_WALLET_LIMIT_BREACH("163", null, null, "Add Money Limit Breach", true,
            SystemResponseCode.ADD_MONEY_WALLET_LIMIT_BREACH),

    INVALID_TIP_AMOUNT("350", null, "INVALID_TIP_AMOUNT", "Tip amount exceeds the Transaction Amount", true,
            SystemResponseCode.INVALID_TIP_AMOUNT),

    GENERATE_TOKEN_DETAIL_FAILURE("385", null, "GENERATE_TOKEN_DETAIL_FAILURE",
            "Cannot Generate Token data for token Index number", true, SystemResponseCode.GENERATE_TOKEN_DETAIL_FAILURE),

    // Payment Adapter
    SUCCESS_PA(null, "000", "SUCCESS from PAYMENT_ADAPTER", "SUCCESS from PAYMENT_ADAPTER", false,
            SystemResponseCode.SUCCESS), UNKNOWN_EXCEPTION(null, "002", "UNKNOWN_EXCEPTION from PAYMENT_ADAPTER",
            "UNKNOWN_EXCEPTION from PAYMENT_ADAPTER", false, SystemResponseCode.SYSTEM_ERROR), PARAM_ILLEGAL_PA(null,
            "001", "PARAM_ILLEGAL from PAYMENT_ADAPTER", "PARAM_ILLEGAL from PAYMENT_ADAPTER", false,
            SystemResponseCode.SYSTEM_ERROR), SYSTEM_ERROR_PA(null, "003", "SYSTEM_ERROR from PAYMENT_ADAPTER",
            "SYSTEM_ERROR from PAYMENT_ADAPTER", false, SystemResponseCode.SYSTEM_ERROR),

    AUTHORIZATION_FAILED("501", "BE1423002", "authorization failed", "authorization failed",
            SystemResponseCode.OAUTH_FAILED), ILLEGAL_PARAMS("501", "BE1431001", "illegal parameters",
            "illegal parameters", SystemResponseCode.PARAM_ILLEGAL), INTERNAL_SERVER_ERROR("501", "BE1426003",
            "internal server error", "internal server error", SystemResponseCode.INTERNAL_PROCESSING_ERROR), MERCHANT_NOT_EXISTS(
            "501", "BE1431003", "Merchant not exist", "Merchant not exist", SystemResponseCode.MERCHANT_NOT_EXIST), USER_DOES_NOT_EXIST(
            "501", "BE1431005", "User not exist", "User not exist", SystemResponseCode.USER_NOT_EXISTS), INVALID_TOKEN_INDEX_NUMBER(
            "501", null, "INVALID_TOKEN_INDEX_NUMBER", "Invalid Token Index Number", true,
            SystemResponseCode.INVALID_TOKEN_INDEX_NUMBER), JWT_VALIDATION_FAILURE("501", null,
            "JWT_VALIDATION_FAILURE", "Jwt Validation Failure", true, SystemResponseCode.JWT_VALIDATION_FAILURE), COFT_SERVICE_ERROR(
            "501", null, "INVALID_TOKEN_INDEX_NUMBER", "Invalid Token Index Number", true,
            SystemResponseCode.COFT_SERVICE_ERROR), COP_COFT_CHANNEL_NOT_AVAILABLE("501", "12006088",
            "COFT_CHANNEL_NOT_AVAILABLE", "Coft channel not available", true,
            SystemResponseCode.COFT_CHANNEL_NOT_AVAILABLE), PAY_COFT_CHANNEL_NOT_AVAILABLE("501", "12006077",
            "COFT_CHANNEL_NOT_AVAILABLE", "Coft channel not available", true,
            SystemResponseCode.COFT_CHANNEL_NOT_AVAILABLE), EDC_LINK_BANK_OFFER_FAILURE("501", null, null,
            "Edc Link Bank Offer failure", true, SystemResponseCode.EDC_LINK_BANK_OFFER_FAILURE), EDC_LINK_BANK_BRAND_EMI_CHECKOUT_FAILURE(
            "501", null, null, "Edc Link Bank/Brand checkout failure", true,
            SystemResponseCode.EDC_LINK_BANK_BRAND_CHECKOUT_FAILURE), TOKEN_DETAIL_NOT_FOUND("501", null,
            "TOKEN_DETAIL_NOT_FOUND", "No Token Details found", true, SystemResponseCode.TOKEN_DETAIL_NOT_FOUND),

    EDC_LINK_BRAND_EMI_OFFER_FAILURE("501", null, null, "Edc Link Brand Offer failure", true,
            SystemResponseCode.EDC_LINK_BANK_OFFER_FAILURE), VALIDATION_API_FAILURE("501", null, null,
            "validation api failure", true, SystemResponseCode.VALIDATION_API_FAILURE), EDC_LINK_VALIDATE_VELOCITY_API_FAILURE(
            "501", null, null, "Edc Link Validate Velocity API failure", true,
            SystemResponseCode.EDC_LINK_VALIDATE_VELOCITY_API_FAILURE), LINK_PAYMENT_CONSULT_FAILURE(
            "501",
            null,
            "LINK_PAYMENT_CONSULT_FAILURE",
            "A payment on this link is already under process. If any amount was deducted it shall be adjusted once the payment is confirmed. Please wait for some time or try again later.",
            true, SystemResponseCode.LINK_PAYMENT_CONSULT_FAILURE),

    WALLET_INACTIVE_FAILURE("501", "22010008", "USER_IN_INACTIVE_STATE",
            "Your wallet has been deactivated as mandated by RBI", true, SystemResponseCode.WALLET_INACTIVE_FAILURE), UPI_USER_NOT_FOUND(
            "514", "", "", "Paytm phone-number not linked to VPA, Try Again", true,
            SystemResponseCode.UPI_USER_NOT_FOUND),

    INVALID_REQUEST_ID("501", null, "INVALID_REQUEST_ID", "Invalid request id", true,
            SystemResponseCode.INVALID_REQUEST_ID), INCORRECT_DETAILS_PASSED("501", null, "INCORRECT_DETAILS_PASSED",
            "Incorrect details passed", true, SystemResponseCode.INCORRECT_DETAILS_PASSED), SIGNATURE_VALIDATION_FAILURE(
            "501", null, "SIGNATURE_VALIDATION_FAILURE", "Signature Validation Failure", true,
            SystemResponseCode.SIGNATURE_VALIDATION_FAILURE), CHECKSUM_VALIDATION_FAILURE("501", null,
            "CHECKSUM_VALIDATION_FAILURE", "CheckSum Validation Failure", true,
            SystemResponseCode.CHECKSUM_VALIDATION_FAILURE), SIGNATURE_TYPE_MISSING("501", null,
            "SIGNATURE_TYPE_MISSING", "Signature type is missing", true, SystemResponseCode.SIGNATURE_TYPE_MISSING), HEAD_IS_MISSING(
            "501", null, "HEAD_IS_MISSING", "Head is missing", true, SystemResponseCode.HEAD_IS_MISSING), PAR_NOT_FOUND(
            "501", null, "PAR_NOT_FOUND", "PAR not found ", true, SystemResponseCode.PAR_NOT_FOUND), CARD_SCHEME_IS_NOT_SUPPORTED(
            "501", null, "CARD_SCHEME_IS_NOT_SUPPORTED", "Card Scheme is not supported", true,
            SystemResponseCode.CARD_SCHEME_IS_NOT_SUPPORTED), DB_ERROR("501", null, "SYSTEM_ERROR", "SYSTEM_ERROR",
            true, SystemResponseCode.DB_ERROR),

    DIGITAL_CARD_EXPIRED("501", null, "DIGITAL_CARD_EXPIRED",
            "Your digital card token has expired. Kindly use another payment option for this payment.", true,
            SystemResponseCode.DIGITAL_CARD_EXPIRED), DIGITAL_TOKEN_EXPIRED("501", null,
            "Your digital card token has expired. Kindly use another payment option for this payment",
            "Your digital card token has expired. Kindly use another payment option for this payment", true,
            SystemResponseCode.DIGITAL_TOKEN_EXPIRED), FAILED_SUSPENDED_TOKEN("501", null,
            "Tokenization Failed, further operation not allowed",
            "Your digital card token has expired. Kindly use another payment option for this payment.", true,
            SystemResponseCode.FAILED_SUSPENDED_TOKEN), FAILED_RETRY_INIT("501", null,
            "Tokenization under process, Please try after some time.",
            "Your card tokenization is under process. Please try after some time.", true,
            SystemResponseCode.FAILED_RETRY_INIT), FAILURE_FROM_CARD_NETWORK("501", null, "Failure from card network",
            "Error by card network while generating token", true, SystemResponseCode.FAILURE_FROM_CARD_NETWORK), ERROR_WHILE_GENERATING_TOKEN_FROM_CARD_NETWORK(
            "501", null, "Error connecting with card network", "Error while generating token from card network.", true,
            SystemResponseCode.ERROR_WHILE_GENERATING_TOKEN_FROM_CARD_NETWORK), CARD_NOT_ELIGIBLE("501", null,
            "Card not eligible", "Card not eligible.", true, SystemResponseCode.CARD_NOT_ELIGIBLE), CARD_VERIFICATION_FAILED_BY_NETWORK(
            "501", null, "Invalid card details", "Card verification failed by network.", true,
            SystemResponseCode.CARD_VERIFICATION_FAILED_BY_NETWORK), CARD_NOT_ALLOWED_BY_NETWORK("501", null,
            "Card not allowed by network", "Card not allowed by network.", true,
            SystemResponseCode.CARD_NOT_ALLOWED_BY_NETWORK), TRID_NOT_CONFIGURED("501", null,
            "TRID not configured at card network", "TRID not configured", true, SystemResponseCode.TRID_NOT_CONFIGURED), BAD_REQUEST(
            "400", null, "Request parameters are not valid", "Request parameters are not valid", true,
            SystemResponseCode.BAD_REQUEST),

    INVALID_UPI_NUMBER("516", null, null, "Incorrect format of UPI Number", false,
            SystemResponseCode.INVALID_UPI_NUMBER), LINK_PAYMENT_IN_PROCESS(
            "5057",
            null,
            "LINK_PAYMENT_IN_PROCESS",
            "A payment on this link is already under process. If any amount was deducted it shall be adjusted once the payment is confirmed. Please wait for some time or try again later.",
            true, SystemResponseCode.LINK_PAYMENT_IN_PROCESS), LINK_PAYMENT_ALREADY_PROCESSED("5055", null,
            "LINK_PAYMENT_ALREADY_PROCESSED",
            "The Link is already Paid. Please reach out to the merchant in case of any query.", true,
            SystemResponseCode.LINK_PAYMENT_ALREADY_PROCESSED), TXN_AMT_AND_PAID_AMT_EXCEEDS_TOTAL_PAYMENT_AMT(
            "9015",
            null,
            "TXN_AMT_AND_PAID_AMT_EXCEEDS_TOTAL_PAYMENT_AMT",
            "You are trying to make a payment which exceeds the total payment amount allowed on this link. Try making another payment not exceeding the total payment amount. Please reach out to the merchant in case of any query.",
            true, SystemResponseCode.TXN_AMT_AND_PAID_AMT_EXCEEDS_TOTAL_PAYMENT_AMT),

    TOTAL_PAYMENT_AMOUNT_LIMIT_REACHED(
            "9016",
            null,
            "TOTAL_PAYMENT_AMOUNT_LIMIT_REACHED",
            "Total payment amount allowed on this link is reached. Please reach out to the merchant in case of any query.",
            true, SystemResponseCode.TOTAL_PAYMENT_AMOUNT_LIMIT_REACHED);

    private String code;
    private String alipayResultCode;
    private String alipayResultMsg;
    private String message;
    private boolean responseToMerchant;
    private SystemResponseCode systemResponseCode;
    private String cardServiceResponseCode;
    private String cardServiceResponseMsg;

    public SystemResponseCode getSystemResponseCode() {
        return systemResponseCode;
    }

    public String getCode() {
        return code;
    }

    public String getAlipayResultCode() {
        return alipayResultCode;
    }

    public String getAlipayResultMsg() {
        return alipayResultMsg;
    }

    public String getMessage() {
        return message;
    }

    public boolean isResponseToMerchant() {
        return responseToMerchant;
    }

    public String getCardServiceResponseCode() {
        return cardServiceResponseCode;
    }

    public String getCardServiceResponseMsg() {
        return cardServiceResponseMsg;
    }

    public static ResponseConstants fetchResponseConstantByCode(String alipayCode) {
        if (StringUtils.isNotBlank(alipayCode)) {
            for (ResponseConstants constants : ResponseConstants.values()) {
                if (alipayCode.equals(constants.getAlipayResultCode())) {
                    return constants;
                }
            }
        }
        return null;
    }

    public static ResponseConstants fetchResponseConstantByName(String responseConstant) {
        if (StringUtils.isNotBlank(responseConstant)) {
            for (ResponseConstants constant : ResponseConstants.values()) {
                if (constant.name().equals(responseConstant)) {
                    return constant;
                }
            }
        }
        return null;
    }

    public static ResponseConstants fetchResponseConstantByCardServiceRespCode(String respCode) {
        if (StringUtils.isNotBlank(respCode)) {
            for (ResponseConstants constants : ResponseConstants.values()) {
                if (respCode.equals(constants.getCardServiceResponseCode())) {
                    return constants;
                }
            }
        }
        return null;
    }

    ResponseConstants(String code, String alipayResultCode, String alipayResultMsg, String message,
                      boolean responseToMerchant) {
        this.code = code;
        this.alipayResultCode = alipayResultCode;
        this.message = message;
        this.alipayResultMsg = alipayResultMsg;
        this.responseToMerchant = responseToMerchant;
    }

    ResponseConstants(String code, String alipayResultCode, String alipayResultMsg, String message,
                      boolean responseToMerchant, SystemResponseCode systemResponseCode) {
        this.code = code;
        this.alipayResultCode = alipayResultCode;
        this.message = message;
        this.alipayResultMsg = alipayResultMsg;
        this.responseToMerchant = responseToMerchant;
        this.systemResponseCode = systemResponseCode;
    }

    ResponseConstants(String code, String cardServiceResponseCode, String cardServiceResponseMsg, String message,
                      SystemResponseCode systemResponseCode) {
        this.code = code;
        this.cardServiceResponseCode = cardServiceResponseCode;
        this.message = message;
        this.cardServiceResponseMsg = cardServiceResponseMsg;
        this.systemResponseCode = systemResponseCode;
    }

}
