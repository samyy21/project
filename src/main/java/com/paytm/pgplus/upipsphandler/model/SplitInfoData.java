package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paytm.pgplus.Annotations.MaskToStringBuilder;
import com.paytm.pgplus.models.Money;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class SplitInfoData implements Serializable {
    private static final long serialVersionUID = -4659654568296196035L;
    private String mid;
    private String partnerId;
    private Money amount;
    private String percentage;
    private List<GoodsInfo> goods;
    private List<ShippingInfo> shippingInfo;
    private String extendInfo;

    public SplitInfoData() {
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getPartnerId() {
        return this.partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public Money getAmount() {
        return this.amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public String getPercentage() {
        return this.percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public List<GoodsInfo> getGoods() {
        return this.goods;
    }

    public void setGoods(List<GoodsInfo> goods) {
        this.goods = goods;
    }

    public List<ShippingInfo> getShippingInfo() {
        return this.shippingInfo;
    }

    public void setShippingInfo(List<ShippingInfo> shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public String getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(String extendInfo) {
        this.extendInfo = extendInfo;
    }

    public String toString() {
        return (new MaskToStringBuilder(this)).toString();
    }
}

