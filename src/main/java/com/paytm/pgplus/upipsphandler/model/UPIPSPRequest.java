package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Santosh chourasia
 *
 */
@JsonIgnoreProperties
public class UPIPSPRequest {

    @NotNull(message = "Header passed in the request is null")
    @Valid
    private UPIPSPHeader header;
    @NotNull(message = "Body passed in the request is null")
    @Valid
    private UPIPSPBody body;

    public UPIPSPHeader getHeader() {
        return header;
    }

    public void setHeader(UPIPSPHeader header) {
        this.header = header;
    }

    public UPIPSPBody getBody() {
        return body;
    }

    public void setBody(UPIPSPBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return new MaskToStringBuilder(this).toString();
    }

}
