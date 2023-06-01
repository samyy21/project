package com.paytm.pgplus.upipsphandler.exception;


import com.paytm.pgplus.upipsphandler.enums.common.ResultCode;
import com.paytm.pgplus.upipsphandler.model.common.ResultInfo;

public class FetchBalanceInfoException extends BaseException {

    private static final long serialVersionUID = -1413749389329942042L;

    public FetchBalanceInfoException(ResultInfo resultInfo) {
        super(resultInfo);
    }

    public FetchBalanceInfoException(ResultInfo resultInfo, Throwable throwable) {
        super(throwable, resultInfo);
    }

    public FetchBalanceInfoException() {
        super();
    }

    public static FetchBalanceInfoException getException() {
        return new FetchBalanceInfoException(OfflinePaymentUtils.resultInfo(ResultCode.FETCH_BALANCE_INFO_EXCEPTION));
    }

    public static FetchBalanceInfoException getException(Throwable throwable) {
        return new FetchBalanceInfoException(OfflinePaymentUtils.resultInfo(ResultCode.FETCH_BALANCE_INFO_EXCEPTION),
                throwable);
    }

}

