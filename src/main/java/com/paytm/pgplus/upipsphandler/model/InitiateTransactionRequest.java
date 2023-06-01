package com.paytm.pgplus.upipsphandler.model;

import com.paytm.pgplus.request.InitiateTransactionRequestBody;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paytm.pgplus.request.SecureRequestHeader;

import java.io.Serializable;

public class InitiateTransactionRequest implements Serializable {
    @JsonProperty("head")
    private SecureRequestHeader head;
    @JsonProperty("body")
    private InitiateTransactionRequestBody body;
    private static final long serialVersionUID = 6183126127771924331L;

    public InitiateTransactionRequest() {
    }

    public SecureRequestHeader getHead() {
        return this.head;
    }

    public void setHead(SecureRequestHeader head) {
        this.head = head;
    }

    public InitiateTransactionRequestBody getBody() {
        return this.body;
    }

    public void setBody(InitiateTransactionRequestBody body) {
        this.body = body;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TransactionRequest [head=");
        builder.append(this.head);
        builder.append(", body=");
        builder.append(this.body);
        builder.append("]");
        return builder.toString();
    }
}

