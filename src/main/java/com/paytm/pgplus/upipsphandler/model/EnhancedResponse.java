package com.paytm.pgplus.upipsphandler.model;

import com.paytm.pgplus.cashier.refund.model.BaseResponse;
import com.paytm.pgplus.response.ResponseHeader;

public class EnhancedResponse extends BaseResponse {

    private static final long serialVersionUID = -8711881765332301625L;

    ResponseHeader head;
    EnhancedResponseBody body;

    public EnhancedResponse(ResponseHeader head, EnhancedResponseBody body) {
        this.head = head;
        this.body = body;
    }

    public EnhancedResponse(EnhancedResponseBody body) {
        this.body = body;
        this.head = new ResponseHeader();
    }

    public EnhancedResponse() {
        this.head = new ResponseHeader();
    }

    public ResponseHeader getHead() {
        return head;
    }

    public void setHead(ResponseHeader head) {
        this.head = head;
    }

    public EnhancedResponseBody getBody() {
        return body;
    }

    public void setBody(EnhancedResponseBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "EnhancedResponse{" + "head=" + head + ", body=" + body + '}';
    }
}

