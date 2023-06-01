package com.paytm.pgplus.upipsphandler.exception.common;

import com.paytm.pgplus.upipsphandler.constants.ResultCode;
import com.paytm.pgplus.upipsphandler.exception.OfflinePaymentUtils;
import com.paytm.pgplus.upipsphandler.model.common.ResultInfo;
import lombok.Data;

@Data
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -7729054899007907873L;

    private ResultInfo resultInfo;
    private ResultCode resultCode;

    //    public BaseException(ResultInfo resultInfo) {
//        super(resultInfo.getResultMsg());
//        this.resultInfo = resultInfo;
//    }
//
    public BaseException(com.paytm.pgplus.upipsphandler.constants.ResultCode resultcode) {
        super(resultcode.getResultMsg());
        this.resultCode = resultcode;
    }

    public BaseException() {
        super(ResultCode.UNKNOWN_ERROR.getResultMsg());
        this.resultInfo = OfflinePaymentUtils.resultInfo(com.paytm.pgplus.upipsphandler.enums.common.ResultCode.UNKNOWN_ERROR);
    }
}
