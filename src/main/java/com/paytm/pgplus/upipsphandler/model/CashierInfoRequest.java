package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paytm.pgplus.payloadvault.refund.request.BaseRequest;
import io.swagger.annotations.ApiModel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel(value = "CashierInfoRequest", description = "Request for cashier page rendering")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CashierInfoRequest extends BaseRequest {

    private static final long serialVersionUID = 6221848077250065146L;
    @NotNull
    @Valid
    private RequestHeader head;

    @NotNull
    @Valid
    private CashierInfoRequestBody body;

    public CashierInfoRequest(RequestHeader head, CashierInfoRequestBody body) {
        this.head = head;
        this.body = body;
    }

    public CashierInfoRequest() {
    }

    public RequestHeader getHead() {
        return head;
    }

    public void setHead(RequestHeader head) {
        this.head = head;
    }

    public CashierInfoRequestBody getBody() {
        return body;
    }

    public void setBody(CashierInfoRequestBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CashierInfoRequest{");
        sb.append("head=").append(head);
        sb.append(", body=").append(body);
        sb.append('}');
        return sb.toString();
    }
}
