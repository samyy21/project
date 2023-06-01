package com.paytm.pgplus.upipsphandler.enums;

public enum MappingServiceResultCode {
    SUCCESS("00000", "S", "Success"), NOT_FOUND("00001", "F", "Entry is not available "), MULTIPLE_AVAILABLE("00002",
            "F", "More than one entity available "), PARAM_MISSING("00003", "F",
            "One or more mandatory parameters is/are missing"), SYSTEM_ERROR("00004", "F", "System error"), DB_ERROR(
            "00005", "F", "Error in Database"), CACHE_ERROR("00006", "F", "Error in caching data"), ALIPAY_ERROR(
            "00007", "F", "Error in alipay api"), DUPLICATE_ENTRY("00008", "S", "Duplicate entry in DB"), ID_DOES_NOT_EXIST(
            "00009", "F", "Id doesn't exist"), JSON_ERROR("00010", "F", "error in generating json from object"), AUTH_ERROR(
            "00011", "F", "error from oauth side"), FAIL("00012", "f", "failure"), PARAM_INLEGAL("00013", "f",
            "param inlegal"), DUPLICATE_ENTRY_AT_ALIPAY("00008", "S", "Duplicate entry in ALIPAY"), RESPONSE_BLANK(
            "00014", "F", "No response from alipay"), QUERY_TIMEOUT("00015", "F", "Query Timed Out"), ACQUIRING_NOT_FOUND(
            "00016", "F", "Acquiring does not exist"), CONTRACT_NOT_FOUND("00017", "F", "Contract does not exist"), BANK_CODE_DOES_NOT_EXIST(
            "00018", "F", "Bank Code doesn't exist"), BENEFICIARY_NAME_NULL("00019", "F",
            "Beneficiary Name doesn't exist"), PG2_ERROR("20", "F", "Error in fund core api");

    private String resultCode;
    private String status;
    private String message;

    private MappingServiceResultCode(String resultCode, String status, String message) {
        this.resultCode = resultCode;
        this.status = status;
        this.message = message;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
