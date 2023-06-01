package com.paytm.pgplus.upipsphandler.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paytm.pgplus.localisationProcessor.annotation.LocaleField;
import com.paytm.pgplus.upipsphandler.enums.ResponseConstants;
import com.paytm.pgplus.upipsphandler.enums.ResultCode;
import com.paytm.pgplus.upipsphandler.enums.ResultStatus;
import com.paytm.pgplus.upipsphandler.enums.TerminalInitServiceResultCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class ResultInfo implements Serializable {
    /**
     * for serialization
     */
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "{notblank}")
    @ConstrainedValue(enumClass = ResultStatus.class)
    private String resultStatus;

    @NotBlank(message = "{notblank}")
    @Length(max = 8, message = "{lengthlimit}")
    private String resultCodeId;

    @NotBlank(message = "{notblank}")
    @Length(max = 64, message = "{lengthlimit}")
    private String resultCode;

    @Length(max = 256, message = "{lengthlimit}")
    @LocaleField(localeEnum = ResponseConstants.class, methodName = "getMessage")
    private String resultMsg;

    private Boolean isRedirect;

    public ResultInfo() {
        super();
    }

    public ResultInfo(String resultCode) {
        super();
        this.resultCode = resultCode;
    }

    public ResultInfo(String resultStatus, String resultCode, String resultMsg) {
        super();
        this.resultStatus = resultStatus;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public ResultInfo(String resultStatus, String resultCodeId, String resultCode, String resultMsg) {
        super();
        this.resultStatus = resultStatus;
        this.resultCodeId = resultCodeId;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public ResultInfo(String resultStatus, String resultCodeId, String resultCode, String resultMsg, boolean isRedirect) {
        super();
        this.resultStatus = resultStatus;
        this.resultCodeId = resultCodeId;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.isRedirect = isRedirect;
    }

    public ResultInfo(ResultCode resultCode) {
        super();
        this.resultStatus = resultCode.getResultStatus();
        this.resultCodeId = resultCode.getResultCodeId();
        this.resultCode = resultCode.getCode();
        this.resultMsg = resultCode.getResultMsg();
    }

    public ResultInfo(TerminalInitServiceResultCode terminalInitServiceResultCode) {
        super();
        this.resultCode = terminalInitServiceResultCode.getResultCode();
        this.resultCodeId = terminalInitServiceResultCode.getResultCode();
        this.resultStatus = terminalInitServiceResultCode.getStatus();
        this.resultMsg = terminalInitServiceResultCode.getMessage();
    }

    public void setTerminalInitServiceResultCode(TerminalInitServiceResultCode terminalInitServiceResultCode) {
        this.resultCode = terminalInitServiceResultCode.getResultCode();
        this.resultCodeId = terminalInitServiceResultCode.getResultCode();
        this.resultStatus = terminalInitServiceResultCode.getStatus();
        this.resultMsg = terminalInitServiceResultCode.getMessage();
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultCodeId() {
        return resultCodeId;
    }

    public void setResultCodeId(String resultCodeId) {
        this.resultCodeId = resultCodeId;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @JsonProperty("isRedirect")
    @JsonInclude(Include.NON_NULL)
    public Boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(Boolean isRedirect) {
        this.isRedirect = isRedirect;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ResultInfo [resultStatus=").append(resultStatus).append(", resultCodeId=").append(resultCodeId)
                .append(", resultCode=").append(resultCode).append(", resultMsg=").append(resultMsg)
                .append(", isRedirect=").append(isRedirect).append("]");
        return builder.toString();
    }

}
