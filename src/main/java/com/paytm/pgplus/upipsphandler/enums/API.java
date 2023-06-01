package com.paytm.pgplus.upipsphandler.enums;

import com.paytm.pgplus.payloadvault.merchant.status.request.TxnStatusBaseRequest;
import com.paytm.pgplus.payloadvault.paymentservice.request.CheckBalanceRequest;
import com.paytm.pgplus.payloadvault.paymentservice.response.FBCheckBalanceResponse;
import com.paytm.pgplus.payloadvault.refund.request.RefundRequest;
import com.paytm.pgplus.payloadvault.refund.request.StatusQueryRequest;
import com.paytm.pgplus.payloadvault.theia.request.AutoDebitRequest;
import com.paytm.pgplus.payloadvault.theia.request.PayOptionsRequest;
import com.paytm.pgplus.payloadvault.theia.request.PaymentRequestBean;
import com.paytm.pgplus.request.InitiateTransactionRequestBody;
import com.paytm.pgplus.request.NativeRefundStatusRequestBody;

import java.util.HashMap;
import java.util.Map;

public enum API {
    CHECK_BALANCE("CHECK_BALANCE", CheckBalanceRequest.class, FBCheckBalanceResponse.class, "checkBalance"),
    PROCESS_TRANSACTION("PROCESS_TRANSACTION", PaymentRequestBean.class, Map.class, "processTransaction"),
    REFUND("REFUND", RefundRequest.class, Map.class, "refund"),
    REFUND_STATUS("REFUND_STATUS", StatusQueryRequest.class, Map.class, "refundStatus"),
    TXN_STATUS("TXN_STATUS", TxnStatusBaseRequest.class, Map.class, "txnStatus"),
    FACEBOOK_FAST_FORWARD("FACEBOOK_FAST_FORWARD", AutoDebitRequest.class, String.class, "facebookFastForward"),
    PAY_OPTIONS("PAY_OPTIONS", PayOptionsRequest.class, Map.class, "payOptions"),
    INITIATE_TRANSACTION("INITIATE_TRANSACTION", InitiateTransactionRequestBody.class, Map.class, "initiateTransaction"),
    NATIVE_REFUND_STATUS("NATIVE_REFUND_STATUS", NativeRefundStatusRequestBody.class, Map.class, "nativeRefundStatus");

    private String apiName;
    private Class<?> requestClass;
    private Class<?> responseClass;
    private String jsonKey;
    private static Map<String, API> JSONKEY_API_MAP = new HashMap();

    private API(String apiName, Class requestClass, Class responseClass, String jsonKey) {
        this.apiName = apiName;
        this.requestClass = requestClass;
        this.responseClass = responseClass;
        this.jsonKey = jsonKey;
    }

    public String getApiName() {
        return this.apiName;
    }

    public String getJsonKey() {
        return this.jsonKey;
    }

    public Class<?> getResponseClass() {
        return this.responseClass;
    }

    public Class<?> getRequestClass() {
        return this.requestClass;
    }

    public static API getAPIForJsonKey(String jsonKey) {
        return JSONKEY_API_MAP.get(jsonKey);
    }

    static {
        API[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            API api = var0[var2];
            JSONKEY_API_MAP.put(api.getJsonKey(), api);
        }

    }
}

