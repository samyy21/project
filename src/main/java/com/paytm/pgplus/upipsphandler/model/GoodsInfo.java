package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paytm.pgplus.models.Money;

import java.io.Serializable;

public class GoodsInfo implements Serializable {
    private static final long serialVersionUID = -6353697627145444440L;
    @JsonProperty("merchantGoodsId")
    private String merchantGoodsId;
    @JsonProperty("merchantShippingId")
    private String merchantShippingId;
    @JsonProperty("snapshotUrl")
    private String snapshotUrl;
    @JsonProperty("description")
    private String description;
    @JsonProperty("category")
    private String category;
    @JsonProperty("quantity")
    private String quantity;
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("price")
    private Money price;
    @JsonProperty("extendInfo")
    private ExtendInfo extendInfo;

    public GoodsInfo() {
    }

    public String getMerchantGoodsId() {
        return this.merchantGoodsId;
    }

    public void setMerchantGoodsId(String merchantGoodsId) {
        this.merchantGoodsId = merchantGoodsId;
    }

    public String getMerchantShippingId() {
        return this.merchantShippingId;
    }

    public void setMerchantShippingId(String merchantShippingId) {
        this.merchantShippingId = merchantShippingId;
    }

    public String getSnapshotUrl() {
        return this.snapshotUrl;
    }

    public void setSnapshotUrl(String snapshotUrl) {
        this.snapshotUrl = snapshotUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Money getPrice() {
        return this.price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public ExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(ExtendInfo extendInfo) {
        this.extendInfo = extendInfo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GoodsInfo{");
        sb.append("merchantGoodsId='").append(this.merchantGoodsId).append('\'');
        sb.append(", merchantShippingId='").append(this.merchantShippingId).append('\'');
        sb.append(", snapshotUrl='").append(this.snapshotUrl).append('\'');
        sb.append(", description='").append(this.description).append('\'');
        sb.append(", category='").append(this.category).append('\'');
        sb.append(", quantity='").append(this.quantity).append('\'');
        sb.append(", unit='").append(this.unit).append('\'');
        sb.append(", price=").append(this.price);
        sb.append(", extendInfo=").append(this.extendInfo);
        sb.append('}');
        return sb.toString();
    }
}

