package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@ApiModel(value = "VpaValidateRequest", description = "Request for validating vpa")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VpaValidateRequest implements Serializable {

    private static final long serialVersionUID = -8032687710814805135L;
    @JsonProperty("head")
    private TokenRequestHeader head;

    @JsonProperty("body")
    private VpaValidateRequestBody body;

    public TokenRequestHeader getHead() {
        return head;
    }

    public void setHead(TokenRequestHeader head) {
        this.head = head;
    }

    public VpaValidateRequestBody getBody() {
        return body;
    }

    public void setBody(VpaValidateRequestBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("head", head).append("body", body).toString();
    }

}

