package com.paytm.pgplus.upipsphandler.enums;

public enum NativeValidationExceptionType {
    Native_Request_Validation_Exception("NVC-001", "Native_Request_Validation_Exception", ""), Native_Merchant_Velocity_Breach_Exception(
            "NVC-002", "Native_Merchant_Velocity_Breach_Exception", ""), Native_Duplicate_Payment_Request_Exception(
            "NVC-003", "Native_Duplicate_Payment_Request_Exception", ""), Native_OrderId_Generation_Exception(
            "NVC-004", "Native_OrderId_Generation_Exception", ""),

    Native_Exception_Occurred_While_Processing_API("NVC-004", "Native_Exception_Occurred_While_Processing_API", ""), Native_Payment_Request_Processing_Exception(
            "NVC-006", "Native_Payment_Request_Processing_Exception", ""), Native_Bin_Detail_Fetching_Exception(
            "NVC-006", "Native_Bin_Detail_Fetching_Exception", ""), Native_Passcode_Validation_Exception("NVC-007",
            "Native_Passcode_Validation_Exception", ""), Native_Qr_Validation_Exception("NVC-007",
            "Native_Qr_Validation_Exception", ""),

    Native_MerchantInfo_Fetching_Exception("NVC-008", "Native_MerchantInfo_Fetching_Exception", ""), Native_ProfileVPA_Fetching_Exception(
            "NVC-009", "Native_ProfileVPA_Fetching_Exception", ""), Native_Unhandled_Exception("NVC-010",
            "Native_Unhandled_Exception", ""), Native_Subscription_Exception("NVC-011",
            "Native_Subscription_Exception", "");

    String errorCode;
    String type;
    String message;

    NativeValidationExceptionType(String errorCode, String type, String message) {
        this.errorCode = errorCode;
        this.type = type;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

}
