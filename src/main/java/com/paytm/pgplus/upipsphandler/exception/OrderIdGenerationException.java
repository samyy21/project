package com.paytm.pgplus.upipsphandler.exception;


import com.paytm.pgplus.upipsphandler.enums.NativeValidationExceptionType;
import com.paytm.pgplus.upipsphandler.enums.common.ResultCode;
import com.paytm.pgplus.upipsphandler.model.common.ResultInfo;

public class OrderIdGenerationException extends BaseException {

    /**
     *
     */
    private static final long serialVersionUID = -889522805411572381L;

    public OrderIdGenerationException(ResultInfo resultInfo) {
        super(resultInfo);
    }

    public OrderIdGenerationException() {
        super();
    }

    public static OrderIdGenerationException getException() {
        return new OrderIdGenerationException(OfflinePaymentUtils.resultInfo(ResultCode.ORDER_ID_GENERATION_EXCEPTION));
    }

    public static OrderIdGenerationException getException(ResultCode resultCode) {
        return new OrderIdGenerationException(OfflinePaymentUtils.resultInfo(resultCode));
    }

    @Override
    public NativeValidationExceptionType getNativeValidationType() {
        return NativeValidationExceptionType.Native_OrderId_Generation_Exception;
    }
}

