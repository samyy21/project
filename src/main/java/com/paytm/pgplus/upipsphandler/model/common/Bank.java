package com.paytm.pgplus.upipsphandler.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paytm.pgplus.localisationProcessor.annotation.LocaleField;
import com.paytm.pgplus.upipsphandler.enums.BankDisplayNames;
import com.paytm.pgplus.upipsphandler.model.PayChannelBase;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Bank extends PayChannelBase {

    private static final long serialVersionUID = 334126587466226356L;

    @JsonProperty("channelCode")
    private String instId;

    @JsonProperty("channelName")
    @LocaleField(localeEnum = BankDisplayNames.class, methodName = "getBankName")
    private String instName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("channelDisplayName")
    private String instDispCode;

    public Bank() {
    }

    public String getInstId() {
        return this.instId;
    }

    public String getInstName() {
        return this.instName;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public String getInstDispCode() {
        return instDispCode;
    }

    public void setInstDispCode(String instDispCode) {
        this.instDispCode = instDispCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bank{");
        sb.append("instId='").append(instId).append('\'');
        sb.append(", instName='").append(instName).append('\'');
        sb.append(", instDispCode='").append(instDispCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
