package com.paytm.pgplus.upipsphandler.exception;

import com.paytm.pgplus.upipsphandler.enums.NativeValidationExceptionType;
import com.paytm.pgplus.upipsphandler.enums.common.ResultCode;
import com.paytm.pgplus.upipsphandler.model.common.ResultInfo;

public class FetchMerchantInfoException extends BaseException {

    private static final long serialVersionUID = -1413749389329942042L;

    public FetchMerchantInfoException(ResultInfo resultInfo) {
        super(resultInfo);
    }

    public FetchMerchantInfoException(ResultInfo resultInfo, Throwable throwable) {
        super(throwable, resultInfo);
    }

    public FetchMerchantInfoException() {
        super();
    }

    public static FetchMerchantInfoException getException() {
        return new FetchMerchantInfoException(OfflinePaymentUtils.resultInfo(ResultCode.FETCH_MERCHANT_INFO_EXCEPTION));
    }

    public static FetchMerchantInfoException getException(Throwable throwable) {
        return new FetchMerchantInfoException(OfflinePaymentUtils.resultInfo(ResultCode.FETCH_MERCHANT_INFO_EXCEPTION),
                throwable);
    }

    @Override
    public NativeValidationExceptionType getNativeValidationType() {
        return NativeValidationExceptionType.Native_MerchantInfo_Fetching_Exception;
    }

}
