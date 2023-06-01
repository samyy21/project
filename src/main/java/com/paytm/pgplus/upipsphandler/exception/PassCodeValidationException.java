package com.paytm.pgplus.upipsphandler.exception;

import com.paytm.pgplus.upipsphandler.model.common.ResultInfo;
import com.paytm.pgplus.upipsphandler.enums.NativeValidationExceptionType;
import com.paytm.pgplus.upipsphandler.enums.common.ResultCode;

public class PassCodeValidationException extends BaseException {

    private static final long serialVersionUID = -159427680210783622L;

    public PassCodeValidationException(ResultInfo resultInfo) {
        super(resultInfo);
    }

    public PassCodeValidationException() {
        super();
    }

    public static PassCodeValidationException getException() {
        return new PassCodeValidationException(OfflinePaymentUtils.resultInfo(ResultCode.INVALID_PASS_CODE));
    }

    public static PassCodeValidationException getException(ResultCode resultCode) {
        return new PassCodeValidationException(OfflinePaymentUtils.resultInfo(resultCode));
    }

    public static PassCodeValidationException getException(ResultInfo resultInfo) {
        return new PassCodeValidationException(resultInfo);
    }

    @Override
    public NativeValidationExceptionType getNativeValidationType() {
        return NativeValidationExceptionType.Native_Passcode_Validation_Exception;
    }
}

