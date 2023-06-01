package com.paytm.pgplus.upipsphandler.exception;

import com.paytm.pgplus.upipsphandler.model.common.ResultInfo;
import com.paytm.pgplus.upipsphandler.enums.NativeValidationExceptionType;
import com.paytm.pgplus.upipsphandler.enums.common.ResultCode;
import org.apache.commons.lang3.StringUtils;

public class SubscriptionValidationException extends BaseException {

    public SubscriptionValidationException() {
        super();
    }

    public SubscriptionValidationException(ResultInfo resultInfo) {
        super(resultInfo);
    }

    public static SubscriptionValidationException getException(String message) {
        ResultCode rc = ResultCode.SUBSCRIPTION_VALIDATION_FAILURE;
        ResultInfo resultInfo = new ResultInfo(rc.getResultStatus(), rc.getResultCodeId(), rc.getCode(),
                rc.getResultMsg());
        if (StringUtils.isNotBlank(message)) {
            resultInfo.setResultMsg(message);
        }
        return new SubscriptionValidationException(resultInfo);
    }

    @Override
    public NativeValidationExceptionType getNativeValidationType() {
        return NativeValidationExceptionType.Native_Subscription_Exception;
    }
}

