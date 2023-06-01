package com.paytm.pgplus.upipsphandler.exception;

import com.paytm.pgplus.upipsphandler.enums.common.ResultCode;
import com.paytm.pgplus.upipsphandler.model.common.ResultInfo;

public class OperationNotSupportedException extends BaseException {

    private static final long serialVersionUID = -1413749389329942042L;

    public OperationNotSupportedException(ResultInfo resultInfo) {
        super(resultInfo);
    }

    public OperationNotSupportedException(ResultInfo resultInfo, Throwable throwable) {
        super(throwable, resultInfo);
    }

    public OperationNotSupportedException() {
        super();
    }

    public static OperationNotSupportedException getException() {
        return new OperationNotSupportedException(OfflinePaymentUtils.resultInfo(ResultCode.OPERATAION_NOT_SUPPORTED));
    }

    public static OperationNotSupportedException getException(Throwable throwable) {
        return new OperationNotSupportedException(OfflinePaymentUtils.resultInfo(ResultCode.OPERATAION_NOT_SUPPORTED),
                throwable);
    }

}

