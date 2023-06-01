package com.paytm.pgplus.upipsphandler.exception;


import com.paytm.pgplus.pgproxycommon.enums.ResponseConstants;
import com.paytm.pgplus.request.InitiateTransactionRequestBody;
import com.paytm.pgplus.upipsphandler.enums.common.ResultCode;
import com.paytm.pgplus.upipsphandler.model.common.ResultInfo;

public class NativeFlowException extends BaseException {

    private static final long serialVersionUID = 4697534848610837660L;

    private boolean isHTMLResponse;
    private boolean isRedirectEnhanceFlow;
    private boolean isNativeJsonRequest;
    private InitiateTransactionRequestBody orderDetail;

    private NativeRetryInfo retryInfo;

    // message set here will go in callback
    private String customCallbackMsg;

    private NativeFlowException(ExceptionBuilder builder) {
        super(builder.resultInfo);
        this.isHTMLResponse = builder.isHTMLResponse;
        this.isRedirectEnhanceFlow = builder.isRedirectEnhanceFlow;
        this.retryInfo = builder.retryInfo;
        this.orderDetail = builder.orderDetail;
        this.isNativeJsonRequest = builder.isNativeJsonRequest;
        this.customCallbackMsg = builder.customCallbackMsg;
    }

    public static class ExceptionBuilder {

        InitiateTransactionRequestBody orderDetail;
        private boolean isHTMLResponse;
        private boolean isRedirectEnhanceFlow;
        private NativeRetryInfo retryInfo;
        private ResultInfo resultInfo;
        private boolean isNativeJsonRequest;
        private String customCallbackMsg;

        public ExceptionBuilder(ResultCode resultCode) {
            this.resultInfo = OfflinePaymentUtils.resultInfo(resultCode);
            // default response type is HTML, unless set to false which is JSON
            this.isHTMLResponse = true;
            this.retryInfo = new NativeRetryInfo(false, "");
        }

        /*
         * this is written to convert ResponseConstants to ResultCode format, as
         * there are instances where ResponseConstant is thrown in Exceptions
         * and some places ResultCode:(
         */
        public ExceptionBuilder(ResponseConstants responseConstant) {
            this.resultInfo = OfflinePaymentUtils.resultInfo(null);
            if (responseConstant != null) {
                this.resultInfo.setResultCodeId(responseConstant.getCode());
                this.resultInfo.setResultMsg(responseConstant.getMessage());
                this.resultInfo.setResultCode(responseConstant.getAlipayResultMsg());
            }
            // default response type is HTML, unless set to false which is JSON
            this.isHTMLResponse = true;
            this.retryInfo = new NativeRetryInfo(false, "");
        }

        public ExceptionBuilder(ResultInfo resultInfo) {
            this.resultInfo = OfflinePaymentUtils.resultInfo(null);
            if (resultInfo != null) {
                this.resultInfo = resultInfo;
                // default response type is HTML, unless set to false which is
                // JSON
                this.isHTMLResponse = true;
                this.retryInfo = new NativeRetryInfo(false, "");
            }
        }

        public ExceptionBuilder(String resultCode, String resultMessage, String resultStatus) {
            this.resultInfo = new ResultInfo(resultStatus, resultCode, resultMessage);
            this.isHTMLResponse = false;
            this.retryInfo = new NativeRetryInfo(false, "");
        }

        public ExceptionBuilder isHTMLResponse(boolean isHTMLResponse) {
            this.isHTMLResponse = isHTMLResponse;
            return this;
        }

        public ExceptionBuilder isRedirectEnhanceFlow(boolean redirectEnhanceFlow) {
            if (!this.isHTMLResponse) {
                this.isRedirectEnhanceFlow = redirectEnhanceFlow;
            }
            return this;
        }

        public ExceptionBuilder isRetryAllowed(boolean retryAllowed) {
            this.retryInfo.setRetryAllowed(retryAllowed);
            return this;
        }

        public ExceptionBuilder setRetryMsg(String msg) {
            this.retryInfo.setRetryMessage(msg);
            return this;
        }

        public ExceptionBuilder setRetryInfo(NativeRetryInfo retryInfo) {
            this.retryInfo = retryInfo;
            return this;
        }

        public ExceptionBuilder setMsg(String msg) {
            this.resultInfo.setResultMsg(msg);
            return this;
        }

        public ExceptionBuilder setOrderDetail(InitiateTransactionRequestBody initiateTransactionRequestBody) {
            this.orderDetail = initiateTransactionRequestBody;
            return this;
        }

        public ExceptionBuilder isNativeJsonRequest(boolean isNativeJsonRequest) {
            this.isNativeJsonRequest = isNativeJsonRequest;
            return this;
        }

        public ExceptionBuilder setResultInfo(ResultInfo resultInfo) {
            this.resultInfo = resultInfo;
            return this;
        }

        public ExceptionBuilder setCustomCallbackMsg(String customCallbackMsg) {
            this.customCallbackMsg = customCallbackMsg;
            return this;
        }

        public NativeFlowException build() {
            return new NativeFlowException(this);
        }
    }

}
