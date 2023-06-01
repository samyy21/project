package com.paytm.pgplus.upipsphandler.enums;

public enum EventNameEnum {

    ZERO_SR_BIN_USED("ZERO_SR_BIN_USED", "insta",
            "transaction with BIN is initiated for which we are observing blanket failures"), ZERO_SR_BIN_FETCHED(
            "ZERO_SR_BIN_FETCHED", "theia", "User is trying to use a card bin observing blaket faliure"), PUSH_TO_RETRY_QUEUE(
            "PUSH_TO_RETRY_QUEUE", "insta", "push insta-command to retry-queue"), ASSIST_DISABLE("ASSIST_DISABLE",
            "PaytmAssist", "paytm assist is disabled on user app"), NO_SMS_PERMISSION("NO_SMS_PERMISSION",
            "PaytmAssist", "sms permission is disabled on user app"), ASSIST_NOT_POPPED("ASSIST_NOT_POPPED",
            "PaytmAssist", "paytm assist doesn't popped"), SMS_NOT_DETECTED("SMS_NOT_DETECTED", "PaytmAssist",
            "sms not detected"), OTP_NOT_SUBMITTED("OTP_NOT_SUBMITTED", "PaytmAssist",
            "otp not submitted through assist"), BACK_BUTTON_CLICKED("BACK_BUTTON_CLICKED", "PaytmAssist",
            "back button has been pressed"), SUCCESSFULLY_OTP_SUBMITTED("SUCCESSFULLY_OTP_SUBMITTED", "PaytmAssist",
            "successfully otp submitted"), ORDER_CREATE_INITIATED("ORDER_CREATE_INITIATED", "theia",
            "Order create has been initiated using createOrder or createOrderAndPay alipay api"), INTERNAL_PAYMENT_RETRY(
            "INTERNAL_PAYMENT_RETRY", "theia", "Payment Retry"), BANK_RESPONSE_RECEIVED("BANK_RESPONSE_RECEIVED",
            "insta", "Response Received from Bank"), ORDER_INITIATED("ORDER_INITIATED", "theia",
            "Entry point for initiate order."), CHECKSUM_VALIDATION_FAILED("CHECKSUM_VALIDATION_FAILED", "theia",
            "Checksum validation failed after order initiation."), PROMO_VALIDATION_FAILED("PROMO_VALIDATION_FAILED",
            "theia", "Promo validation failed."), PAYMENT_LINK_CREATION("PAYMENT_LINK_CREATION", "linkService",
            "Entry point for payment link creation."), PAYMENT_LINK_FETCH_QR("PAYMENT_LINK_FETCH_QR", "linkService",
            "Payment link QR creation."), PAYMENT_LINK_FAILURE("PAYMENT_LINK_FAILURE", "linkService",
            "Failure in Payment link."), PAYMENT_LINK_TXN_TOKEN_GENERATION("PAYMENT_LINK_TXN_TOKEN_GENERATION", "linkService",
            "Txn Token generation in Payment link."), PAYMENT_LINK_OTP_CONSULT("PAYMENT_LINK_OTP_CONSULT", "linkService",
            "OTP consult Payment link."), PAYMENT_LINK_PAYMENT_CONSULT("PAYMENT_LINK_PAYMENT_CONSULT", "linkService",
            "Payment Consult in Payment link."), PAYMENT_LINK_STATUS_UPDATE("PAYMENT_LINK_STATUS_UPDATE", "linkService",
            "Status update in Payment link."), PAYMENT_LINK_EXPIRED("PAYMENT_LINK_EXPIRED", "linkService",
            "Entry Point For Payment Link Expiry. "), PAYMENT_LINK_ARCHIVED("PAYMENT_LINK_ARCHIVED", "linkService",
            "Entry Point For Payment Link Archival. "), PAYMENT_LINK_UPDATED("PAYMNENT_LINK_UPDATED", "linkService",
            "Payment link has been updated."), PAYMENT_LINK_RESEND_NOTIFICATION("PAYMENT_LINK_RESEND_NOTIFICATION",
            "linkService", "Resend Notification for link service."), USER_RETRY_INITIATED("USER_RETRY_INITIATED",
            "theia", "User Retry Initiated."), POST_PAID_CHECK_BALANCE("POST_PAID_CHECK_BALANCE", "theia",
            "Entry point for Post Paid CheckBalance."), PAYMENT_LINK_FETCH_TRANSACTION(
            "PAYMENT_LINK_FETCH_TRANSACTION", "linkService", "Fetch Transaction list for link servive."), PAYMENT_LINK_FETCHED(
            "PAYMENT_LINK_FETCHED", "linkService", "Entry Point For Payment Link Fetch. "), POST_PAID_ON_BOARDING(
            "POST_PAID_ON_BOARDING", "theia", "Post paid onboarding flag for UI"), POST_PAID_ON_BOARDING_TRANSACTION(
            "POST_PAID_ON_BOARDING_TRANSACTION", "Insta", "postpaid onboarding Transaction flag"), PAYEMNT_LINK_PREVIEW_GENERATED(
            "PAYEMNT_LINK_PREVIEW_GENERATED", "linkService", "Preview is generated for payment link invoice"), LINK_BASED_PAYEMNT_INITIATED(
            "LINK_BASED_PAYEMNT_INITIATED", "theia", "Link based payment initiated"), LINK_BASED_PAYMENT_COMPLETED(
            "LINK_BASED_PAYMENT_COMPLETED", "theia", "Link based payment completed"), LINK_BASED_PAYMENT_LOGIN(
            "LINK_BASED_PAYMENT_LOGIN", "theia", "Link based payment login successfull"), PAYMENT_LINK_CLICKED(
            "PAYMENT_LINK_CLICKED", "linkService", "Payment link is clicked"), PAYMENT_LINK_VALIDATE_OTP(
            "PAYMENT_LINK_VALIDATE_OTP", "linkService", "Payment link validate otp"), VALIDATE_ACCOUNT_OR_VPA(
            "VALIDATE_ACCOUNT_OR_VPA", "refundService", "Api to validate account number and VPA"), API_RESPONSE_TIME(
            "API_RESPONSE_TIME", "common", "Api response time"), NATIVE_JSON_REQUEST_INITIATED(
            "NATIVE_JSON_REQUEST_INITIATED", "theia", "Native Json Request Initiated"), AMOUNT_MISMATCH(
            "AMOUNT_MISMATCH", "theia", "Amount in request is diff from ammount from QR Service"), NATIVE_JSON_RESPONSE(
            "NATIVE_JSON_RESPONSE", "theia", "NativeJsonResponse of payment status"), NATIVE_ENHANCED(
            "NATIVE_ENHANCED", "theia", "Native enhance cashier event"), EMANDATE_CREATE_REQUEST(
            "EMANDATE_CREATE_REQUEST", "subscriptionService", "E-Mandate Create Request"), EMANDATE_PROCESSED_EVENT(
            "EMANDATE_PROCESSED_EVENT", "subscriptionService", "E-Mandate Processed Event from NPCI"), SMS_USER_AVAILABLE_TOKEN(
            "SMS_USER_AVAILABLE_TOKEN", "common", "User Available Token"), SMS_FAILURE_RATE_TOPIC(
            "SMS_FAILURE_RATE_TOPIC", "common", "Rate of SMS on particular topic"), PAYMENT_FOR_NATIVE_MF(
            "PAYMENT_FOR_NATIVE_MF", "theia", "PAYMENT_FOR_NATIVE_MF"), ORDER_CREATED_FOR_REQUEST_TYPE(
            "ORDER_CREATED_FOR_REQUEST_TYPE", "theia", "ORDER_CREATED_FOR_REQUEST_TYPE"), PAYMENT_MODE_WITH_STATUS(
            "PAYMENT_MODE_WITH_STATUS", "theia", "PAYMENT_MODE_WITH_STATUS"), CORPORATE_ADVANCE_DEPOSIT_AVAILABLE(
            "CORPORATE_ADVANCE_DEPOSIT_AVAILABLE", "theia", "Corporate Advance Deposit Available for User"), REQUEST_WITH_PAYMENT_MODE(
            "REQUEST_WITH_PAYMENT_MODE", "theia", "REQUEST_WITH_PAYMENT_MODE"), NATIVE_JSON_RESPONSE_TIME(
            "NATIVE_JSON_RESPONSE_TIME", "theia", "NativeJsonResponse time payment status and bankForm"), NATIVE_ERROR(
            "NATIVE_ERROR", "theia", "Native Exception"), NATIVE_API_RESPONSE("NATIVE_API_RESPONSE", "theia",
            "Api response for Native controllers."), LOGIN_COOKIE_VALIDATION_SUCCESS("LOGIN_COOKIE_VALIDATION_SUCCESS",
            "theia", "Login via cookie validation is successful"), AUTOLOGIN_NOT_ENABLED("AUTOLOGIN_NOT_ENABLED",
            "theia", "Pg Auto Login is not enabled on merchant"), COOKIE_DECRYPTION_ERROR("COOKIE_DECRYPTION_ERROR",
            "theia", "Exception occurred while decrypting cookie"), SSO_COOKIE_VALIDATION_EXCEPTION(
            "SSO_COOKIE_VALIDATION_EXCEPTION", "theia",
            "Exception occurred while validating SSO Token for login via cookie"), COOKIE_PG_LOGIN_SUCCESS(
            "COOKIE_PG_LOGIN_SUCCESS", "theia", "Cookie pg_login added Successfully"), NATIVE("NATIVE", "theia",
            "Native Transaction."), NATIVE_JSON_REQUEST_SUPPORTED("NATIVE_JSON_REQUEST_SUPPORTED", "theia",
            "nativeJsonRequestSupported"), FINAL_FORM_STATUS("FINAL_FORM_STATUS", "insta", "Final Form Status"), FINAL_TRANSACTION_STATUS(
            "FINAL_TRANSACTION_STATUS", "insta", "Final Transaction Status"), SQ_RETRY_FINAL_TRANSACTION_STATUS(
            "SQ_RETRY_FINAL_TRANSACTION_STATUS", "insta", "SQ Retry Final Transaction Status"), FINAL_SQ_STATUS(
            "FINAL_SQ_STATUS", "insta", "Final SQ Status"), FINAL_REFUND_STATUS("FINAL_REFUND_STATUS", "insta",
            "Final Refund Status"), ORIG_REFUND_STATUS("ORIG_REFUND_STATUS", "insta", "Orig Refund Status"), OFFLINE_PAYMENT_REQUEST(
            "OFFLINE_PAYMENT_REQUEST", "theia", "OFFLINE_PAYMENT_REQUEST"), OFFLINE_PAYMENT_REQUEST_CACHED(
            "OFFLINE_PAYMENT_REQUEST_CACHED", "theia", "Offline Payment Request from App Cache"), ONLINE_ENHANCED_PAYMENT_REQUEST(
            "ONLINE_ENHANCED_PAYMENT_REQUEST", "theia", "ONLINE_ENHANCED_PAYMENT_REQUEST"), ONLINE_NATIVE_PAYMENT_REQUEST(
            "ONLINE_NATIVE_PAYMENT_REQUEST", "theia", "ONLINE_NATIVE_PAYMENT_REQUEST"), ONLINE_NATIVEPLUS_PAYMENT_REQUEST(
            "ONLINE_NATIVEPLUS_PAYMENT_REQUEST", "theia", "ONLINE_NATIVEPLUS_PAYMENT_REQUEST"), ONLINE_NATIVE_AND_NATIVEPLUS_PAYMENT_REQUEST(
            "ONLINE_NATIVE_AND_NATIVEPLUS_PAYMENT_REQUEST", "theia", "ONLINE_NATIVE_AND_NATIVEPLUS_PAYMENT_REQUEST"), OFFLINE_FETCHPAYMENTOPTIONS(
            "OFFLINE_FETCHPAYMENTOPTIONS", "theia", "OFFLINE_FETCHPAYMENTOPTIONS"), ONLINE_FETCHPAYMENTOPTIONS(
            "ONLINE_FETCHPAYMENTOPTIONS", "theia", "ONLINE_FETCHPAYMENTOPTIONS"), SMS_REQUEST("SMS_REQUEST",
            "communication-gateway", "Sms request is properly generated for handlers or not"), SMS_RESPONSE(
            "SMS_RESPONSE", "communication-gateway", "Sms response is successful or not"), FF4J_READ_TIMEOUT(
            "FF4J_READ_TIMEOUT", "pgp-ff4j-client", "Getting read timeout while accessing ff4j-web"), FF4J_CONNECTION_TIMEOUT(
            "FF4J_CONNECTION_TIMEOUT", "pgp-ff4j-client", "Getting connection timeout out while accessing ff4j-web"), FF4J_CLIENT_EXCEPTION(
            "FF4J_CLIENT_EXCEPTION", "pgp-ff4j-client", "Getting exception while accessing ff4j-web"), REQUEST_BANK_FORM(
            "REQUEST_BANK_FORM", "theia", "request to fetch bank form"), MERCHANT_LIMIT_BREACHED(
            "MERCHANT_LIMIT_BREACHED", "theia", "merchant limit breached"), INTERNATIONAL_CARD_PAYMENT(
            "INTERNATIONAL_CARD_PAYMENT", "theia", "Received International Card Payment"), AUTH_STATUS("AUTH_STATUS",
            "theia", "AUTH_STATUS"), CLIENT_ID_NOT_SUPPORTED_FOR_PAYTM_SCOPE("CLIENT_ID_NOT_SUPPORTED_FOR_PAYTM_SCOPE",
            "theia", "Client ID not supported for PAYTM scope"), FETCH_QR_PAYMENT_DETAILS("FETCH_QR_PAYMENT_DETAILS",
            "theia", "Response sent by fetchQRPaymentDetails API"), FETCH_QR_PAYMENT_DETAILS_V2(
            "FETCH_QR_PAYMENT_DETAILS_V2", "theia", "Response sent by fetchQRPaymentDetailsV2 API"), RESPONSE_CODE_SENT(
            "RESPONSE_CODE_SENT", "theia", "Response code sent to merchant"), DYNAMIC_QR_PAYMENT("DYNAMIC_QR_PAYMENT",
            "theia", "DYNAMIC_QR_PAYMENT"), DYNAMIC_QR_GENERATED("DYNAMIC_QR_GENERATED", "theia",
            "DYNAMIC_QR_GENERATED"), PRN_REQUESTED("PRN_REQUESTED", "theia", "PRN_REQUESTED"), PRN_RECIEVED(
            "PRN_RECIEVED", "theia", "PRN_RECIEVED"), PRN_VALIDATION_REQUESTED("PRN_VALIDATION_REQUESTED", "theia",
            "PRN_VALIDATION_REQUESTED"), PRN_VALIDATED("PRN_VALIDATED", "theia", "PRN_VALIDATED"), SPECIFIC_BEAN_VALIDATION(
            "SPECIFIC_BEAN_VALIDATION", "theia", "SPECIFIC_BEAN_VALIDATION"), LEGACY_BEAN_VALIDATION(
            "LEGACY_BEAN_VALIDATION", "theia", "LEGACY_BEAN_VALIDATION"), WRONG_WEBSITE_DYNAMIC_QR(
            "WRONG_WEBSITE_DYNAMIC_QR", "theia", "WRONG_WEBSITE_DYNAMIC_QR"), TXNINFO_CODE_SENT("TXNINFO_CODE_SENT",
            "theia", "Txn info code sent to merchant"), ERROR_CODE_SENT("ERROR_CODE_SENT", "theia",
            "Error code sent to merchant"), INSTA_REDIRECT_CHANNEL_CONFIG_UPDATE(
            "INSTA_REDIRECT_CHANNEL_CONFIG_UPDATE", "insta", "Update channel config in insta-redirect"), INSTA_REDIRECT_STATUS(
            "INSTA_REDIRECT_STATUS", "insta", "Insta redirect response"), ONE_CLICK_SUPPORTED("ONE_CLICK_SUPPORTED",
            "theia", "ONE_CLICK_SUPPORTED"), INVALID_CANCEL_TRANSACTION_REQUEST("INVALID_CANCEL_TRANSACTION_REQUEST",
            "theia", "INVALID_CANCEL_TRANSACTION_REQUEST"), CARD_VALIDATION("CARD_VALIDATION", "theia",
            "response from cyber Source"), OPGSP_REFUND_REPORT_TOPIC("OPGSP_REFUND_REPORT_TOPIC", "scheduler",
            "OPGSP Refund Report"), OPGSP_CHARGEBACK_REPORT_TOPIC("OPGSP_CHARGEBACK_REPORT_TOPIC", "scheduler",
            "OPGSP Chargeback Report"), INVALID_LINK_SCREEN_LOAD("INVALID_LINK_SCREEN_LOAD", "linkService",
            "Invalid/Expired Link Screen"), MOBILE_BINDING_ENABLED("MOBILE_BINDING_ENABLED", "linkService",
            "Mobile_binding_enabled"), MOBILE_BINDING_NUMBER_SUBMITTED("MOBILE_BINDING_NUMBER_SUBMITTED",
            "linkService", "User clicks Verify"), PARTAIL_PAYMENT_ENABLED("PARTAIL_PAYMENT_ENABLED", "linkService",
            "User selects partial Payment"), PARTIAL_PAYMENT_SUBMITTED("PARTIAL_PAYMENT_SUBMITTED", "linkService",
            "User proceeds to payment"), PARTIAL_PAYMENT_COMPLETES_PAYMENT("PARTIAL_PAYMENT_COMPLETES_PAYMENT",
            "linkService", "Partial payment is completed"), SKIP_LOGIN_SUBMITTED("SKIP_LOGIN_SUBMITTED", "linkService",
            "User proceeds to pay"), SKIP_LOGIN_COMPLETES_PAYMENT("SKIP_LOGIN_COMPLETES_PAYMENT", "linkService",
            "User completes payment"), PAYMENT_FORM_SUBMITTED("PAYMENT_FORM_SUBMITTED", "linkService",
            "User proceeds to pay"), FORM_LINK("FORM_LINK", "linkService", "form_link"), PAYMENT_FORM_LINK_CREATED(
            "PAYMENT_FORM_LINK_CREATED", "linkService", "Payment Link Successfully created"), CLICK_PROCEED(
            "CLICK_PROCEED", "linkService", "User clicks proceed to pay"), DOWNLOAD_INVOICE("DOWNLOAD_INVOICE",
            "linkService", "Download Invoice"), PAYMENT_FORM_OPENED("PAYMENT_FORM_OPENED", "linkService",
            "Payment Form opened"), PAYMENT_USING_SAVED_CARD("PAYMENT_USING_SAVED_CARD", "theia",
            "payment using saved card"), TASK_WAITING_TIME("TASK_WAITING_TIME", "theia", "Task waiting time"), SEND_MESSAGE_FOR_APP_INVOKE(
            "SEND_MESSAGE_FOR_APP_INVOKE", "theia", "Sending Message to Invoke Paytm app"), AUTO_APP_INVOKE("SPPV2",
            "theia", "AutoAppInvoke Applink redirection"), FMIV2("FMIV2", "theia",
            "Fetch Merchant Info v2 called by invoked app"), VAN_API_RESPONSE("VAN_API_RESPONSE", "vanService",
            "VAN API Response"), VAN_BIZ_ERROR("VAN_BIZ_ERROR", "vanService", "VAN Biz error"), VAN_CLIENT_ERROR(
            "VAN_CLIENT_ERROR", "vanService", "VAN Client Error"), VISA_SINGLE_CLICK_PAYMENT(
            "VISA_SINGLE_CLICK_PAYMENT", "insta", "Important events in visa single click payment"), CREATE_ORDER_AND_PAY_FAILED(
            "CREATE_ORDER_AND_PAY_FAILED", "theia", "Create Order and Pay failed"), CREATE_ORDER_FAILED(
            "CREATE_ORDER_FAILED", "theia", "Create Order failed"), DCC_ISO_MISMATCH_EVENT("DCC_ISO_MISMATCH_EVENT",
            "insta", "ISO CURRENCY MISMATCH IN DCC"), PENNY_DROP_EVENT("PENNY_DROP_EVENT", "Savedcard",
            "user account validate penny drop event"), USE_INVESTMENT_AS_FUNDING_SOURCE(
            "USE_INVESTMENT_AS_FUNDING_SOURCE", "theia", "Investment as a funding source is used as paymode"), PAY_API_INITIATED(
            "PAY_API_INITIATED", "theia", "Pay Api has been initiated"), RENEW_PRENOTIFY_EVENT("RENEW_PRENOTIFY",
            "subscriptionService", "Prenotify event for renewal"), CANCEL_EVENT("SUBS_CANCEL", "subscriptionService",
            "Subscription cancel event"), COP_KAFKA_ERROR("COP_KAFKA_ERROR", "theia",
            "Error While sending Cop Request of DWH Kafka Topic"), PAY_KAFKA_ERROR("PAY_KAFKA_ERROR", "theia",
            "Error While sending Pay Request of DWH Kafka Topic"), INVALID_RESPONSE_RECEIVED_FROM_PPBL_BANK_MANDATE(
            "INVALID_RESPONSE_RECEIVED_FROM_PPBL_BANK_MANDATE", "insta",
            "Invalid response received from PPBL in Bank Mandate Status Query"), AOA_PAY_KAFKA_ERROR(
            "AOA_PAY_KAFKA_ERROR", "theia", "Error While sending Pay Request of DWH Kafka Topic"), AOA_COP_KAFKA_ERROR(
            "AOA_COP_KAFKA_ERROR", "theia", "Error While sending Cop Request of DWH Kafka Topic"), INSTA_UI_DIRECT(
            "INSTA_UI_DIRECT", "insta", "otp htm page created by insta ui"), CHECKOUT_PROMO_FAILED(
            "CHECKOUT_PROMO_FAILED", "theia", "checkout promo failed"), COFT_CONSENT("COFT_CONSENT", "insta",
            "single page consent for coft"), COFT_TRANSACTION("COFT_TRANSACTION", "insta",
            "event log for coft transaction"), TRAFFIC_DISTRIBUTION("TRAFFIC_DISTRIBUTION", "theia",
            "Traffic Distribution for Pg2.0"), FAILURE_LOG_KAFKA_ERROR("FAILURE_LOG_KAFKA_ERROR", "theia",
            "Error While sending Failure log Request of DWH Kafka Topic"), VALIDATE_UPI("VALIDATE_UPI", "theia",
            "Validate UPI Number or VPA"), UPI_PSP_PAYER_PSP_NAME("UPI_PSP_PAYER_PSP_NAME", "theia",
            "UPI PSP - Payer PSP Name"), UPI_PSP_ORDER_PAY("UPI_PSP_ORDER_PAY", "theia",
            "Order Pay in UPI PSP");

    private String eventName;
    private String eventSource;
    private String description;

    EventNameEnum(String eventName, String eventSource, String description) {
        this.eventName = eventName;
        this.eventSource = eventSource;
        this.description = description;
    }

    public static EventNameEnum getEventsByName(String eventName) {
        for (EventNameEnum le : values()) {
            if (le.getEventName().equalsIgnoreCase(eventName))
                return le;
        }
        return null;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventSource() {
        return eventSource;
    }

    public String getDescription() {
        return description;
    }
}
