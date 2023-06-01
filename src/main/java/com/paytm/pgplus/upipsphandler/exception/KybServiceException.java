package com.paytm.pgplus.upipsphandler.exception;

import com.paytm.pgplus.pgproxycommon.enums.ResponseConstants;

public class KybServiceException extends RuntimeException {
    private static final long serialVersionUID = -5787881417493617493L;
    private ResponseConstants responseConstants;

    public KybServiceException(ResponseConstants responseConstants) {
        super(responseConstants.getMessage());
        this.responseConstants = responseConstants;
    }

    public KybServiceException() {
        super(ResponseConstants.SYSTEM_ERROR.getMessage());
        this.responseConstants = ResponseConstants.SYSTEM_ERROR;
    }

    public KybServiceException(Throwable throwable, ResponseConstants responseConstants) {
        super(throwable);
        this.responseConstants = responseConstants;
    }

    public ResponseConstants getResponseConstants() {
        return responseConstants;
    }

}

