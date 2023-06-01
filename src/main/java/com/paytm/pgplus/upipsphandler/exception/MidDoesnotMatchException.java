package com.paytm.pgplus.upipsphandler.exception;

import com.paytm.pgplus.upipsphandler.enums.common.ResultCode;
import com.paytm.pgplus.upipsphandler.model.common.ResultInfo;

public class MidDoesnotMatchException extends BaseException {

    private static final long serialVersionUID = -8345749389329942042L;

    public MidDoesnotMatchException(ResultInfo resultInfo) {
        super(resultInfo);
    }

    public MidDoesnotMatchException(ResultInfo resultInfo, Throwable throwable) {
        super(throwable, resultInfo);
    }

    public MidDoesnotMatchException() {
        super();
    }

    public static MidDoesnotMatchException getException() {
        return new MidDoesnotMatchException(OfflinePaymentUtils.resultInfo(ResultCode.MID_DOES_NOT_MATCH));
    }

    public static MidDoesnotMatchException getException(Throwable throwable) {
        return new MidDoesnotMatchException(OfflinePaymentUtils.resultInfo(ResultCode.MID_DOES_NOT_MATCH), throwable);
    }

}
