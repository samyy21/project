package com.paytm.pgplus.upipsphandler.exception;

import com.paytm.pgplus.upipsphandler.enums.NativeValidationExceptionType;
import com.paytm.pgplus.upipsphandler.enums.common.ResultCode;
import com.paytm.pgplus.upipsphandler.model.common.ResultInfo;

public class RequestValidationException extends BaseException {

    private static final long serialVersionUID = 8140856858915498528L;

    public RequestValidationException(ResultInfo resultInfo) {
        super(resultInfo);
    }

//    public RequestValidationException() {
//        super();
//    }
//
//    public RequestValidationException(Throwable throwable, ResultInfo resultInfo) {
//        super(throwable, resultInfo);
//    }

    public static RequestValidationException getException() {
        return new RequestValidationException(
                OfflinePaymentUtils.resultInfo(ResultCode.REQUEST_PARAMS_VALIDATION_EXCEPTION));
    }

    public static RequestValidationException getException(ResultCode resultCode) {
        return new RequestValidationException(OfflinePaymentUtils.resultInfo(resultCode));
    }
//
    public static RequestValidationException getException(Throwable throwable, ResultCode resultCode) {
        return new RequestValidationException(OfflinePaymentUtils.resultInfo(resultCode));
    }

    @Override
    public NativeValidationExceptionType getNativeValidationType() {
        return NativeValidationExceptionType.Native_Request_Validation_Exception;
    }

}

