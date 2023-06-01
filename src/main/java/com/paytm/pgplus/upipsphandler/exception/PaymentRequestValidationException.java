package com.paytm.pgplus.upipsphandler.exception;

import com.paytm.pgplus.pgproxycommon.enums.ResponseConstants;
import com.paytm.pgplus.upipsphandler.enums.offline.ResultCode;
import com.paytm.pgplus.upipsphandler.model.common.ResultInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class PaymentRequestValidationException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 5399788248815280987L;

    private ResponseConstants responseConstants;
    private ResultCode resultCode;
    private ResultInfo resultInfo;

    public PaymentRequestValidationException() {
    }

    /**
     * @param message
     */
    public PaymentRequestValidationException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public PaymentRequestValidationException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public PaymentRequestValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public PaymentRequestValidationException(String message, ResponseConstants responseConstants) {
        super(message);
        this.responseConstants = responseConstants;
    }

    /**
     * @param cause
     */
    public PaymentRequestValidationException(Throwable cause, ResponseConstants responseConstants) {
        super(cause);
        this.responseConstants = responseConstants;
    }

    /**
     * @param message
     * @param cause
     */
    public PaymentRequestValidationException(String message, Throwable cause, ResponseConstants responseConstants) {
        super(message, cause);
        this.responseConstants = responseConstants;
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public PaymentRequestValidationException(String message, Throwable cause, boolean enableSuppression,
                                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PaymentRequestValidationException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public PaymentRequestValidationException(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    public ResponseConstants getResponseConstants() {
        return responseConstants;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public ResultInfo getResultInfo() {
        return resultInfo;
    }
}

