package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paytm.pgplus.cashier.refund.model.BaseResponse;
import com.paytm.pgplus.response.ResponseHeader;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UPIIntentResponse extends BaseResponse {

    private static final long serialVersionUID = 5342518157678920016L;

    ResponseHeader head;
    UPIIntentResponseBody body;

    public UPIIntentResponse(ResponseHeader head, UPIIntentResponseBody body) {
        this.head = head;
        this.body = body;
    }

    public UPIIntentResponse(UPIIntentResponseBody body) {
        this.body = body;
        this.head = new ResponseHeader();
    }

    public UPIIntentResponse() {
        this.head = new ResponseHeader();
    }

    public ResponseHeader getHead() {
        return head;
    }

    public void setHead(ResponseHeader head) {
        this.head = head;
    }

    public UPIIntentResponseBody getBody() {
        return body;
    }

    public void setBody(UPIIntentResponseBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "UPIIntentResponse{" + "head=" + head + ", body=" + body + '}';
    }
}

