package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paytm.pgplus.models.Money;
import com.paytm.pgplus.upipsphandler.enums.EmiType;
import com.paytm.pgplus.upipsphandler.model.common.Bank;
import com.paytm.pgplus.upipsphandler.model.marker.EmiChannelMarker;

import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmiChannel extends Bank implements EmiChannelMarker {

    /**
     *
     */
    private static final long serialVersionUID = -5520476332863897423L;

    private List<EMIChannelInfo> emiChannelInfos;

    @JsonIgnore
    private List<EMIChannelInfo> emiHybridChannelInfos;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Money minAmount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Money maxAmount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EmiType emiType;

    public EmiChannel() {
    }

    public EmiChannel(List<EMIChannelInfo> emiChannelInfos) {
        this.emiChannelInfos = emiChannelInfos;
    }

    public List<EMIChannelInfo> getEmiChannelInfos() {
        return emiChannelInfos;
    }

    public void setEmiChannelInfos(List<EMIChannelInfo> emiChannelInfo) {
        this.emiChannelInfos = emiChannelInfo;
    }

    public void setEmiHybridChannelInfos(List<EMIChannelInfo> emiHybridChannelInfos) {
        this.emiHybridChannelInfos = emiHybridChannelInfos;
    }

    public List<EMIChannelInfo> getEmiHybridChannelInfos() {
        return emiHybridChannelInfos;
    }

    public Money getMinAmount() {
        return this.minAmount;
    }

    public Money getMaxAmount() {
        return this.maxAmount;
    }

    public void setMinAmount(Money minAmount) {
        this.minAmount = minAmount;
    }

    public void setMaxAmount(Money maxAmount) {
        this.maxAmount = maxAmount;
    }

    public EmiType getEmiType() {
        return emiType;
    }

    public void setEmiType(EmiType emiType) {
        this.emiType = emiType;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EmiChannel [emiChannelInfos=");
        builder.append(emiChannelInfos);
        builder.append(", emiHybridChannelInfos=");
        builder.append(emiHybridChannelInfos);
        builder.append(", minAmount=");
        builder.append(minAmount);
        builder.append(", maxAmount=");
        builder.append(maxAmount);
        builder.append(", emiType=");
        builder.append(emiType);
        builder.append("]");
        return builder.toString();
    }
}

