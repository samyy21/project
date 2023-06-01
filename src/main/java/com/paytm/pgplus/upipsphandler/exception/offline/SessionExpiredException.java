package com.paytm.pgplus.upipsphandler.exception.offline;

import com.paytm.pgplus.upipsphandler.enums.common.ResultCode;
import com.paytm.pgplus.upipsphandler.exception.BaseException;
import com.paytm.pgplus.upipsphandler.exception.OfflinePaymentUtils;
import com.paytm.pgplus.upipsphandler.model.common.ResultInfo;

public class SessionExpiredException extends BaseException {

    private static final long serialVersionUID = -182923295003098054L;

    public SessionExpiredException(ResultInfo resultInfo) {
        super(resultInfo);
    }

    public SessionExpiredException() {
        super();
    }

    public static SessionExpiredException getException() {
        return new SessionExpiredException(OfflinePaymentUtils.resultInfo(ResultCode.SESSION_EXPIRED_EXCEPTION));
    }

    public static SessionExpiredException getException(ResultCode resultCode) {
        return new SessionExpiredException(OfflinePaymentUtils.resultInfo(resultCode));
    }
}

