package com.paytm.pgplus.upipsphandler.exception;

import com.paytm.pgplus.upipsphandler.enums.common.ResultCode;
import com.paytm.pgplus.upipsphandler.model.common.ResultInfo;

public class OrderIdDoesnotMatchException extends BaseException {

    private static final long serialVersionUID = -7639749389329942042L;

    public OrderIdDoesnotMatchException(ResultInfo resultInfo) {
        super(resultInfo);
    }

    public OrderIdDoesnotMatchException(ResultInfo resultInfo, Throwable throwable) {
        super(throwable, resultInfo);
    }

    public OrderIdDoesnotMatchException() {
        super();
    }

    public static OrderIdDoesnotMatchException getException() {
        return new OrderIdDoesnotMatchException(OfflinePaymentUtils.resultInfo(ResultCode.ORDER_ID_DOES_NOT_MATCH));
    }

    public static OrderIdDoesnotMatchException getException(Throwable throwable) {
        return new OrderIdDoesnotMatchException(OfflinePaymentUtils.resultInfo(ResultCode.ORDER_ID_DOES_NOT_MATCH),
                throwable);
    }

}