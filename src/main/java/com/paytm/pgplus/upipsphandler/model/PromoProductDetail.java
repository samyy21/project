package com.paytm.pgplus.upipsphandler.model;

import java.io.Serializable;
import java.util.List;

public class PromoProductDetail implements Serializable {
    private static final long serialVersionUID = 1245276931776319806L;
    private String id;
    private String merchantId;
    private String verticalId;
    private List<String> categoryIds;
    private String brandId;
    private String model;

    public PromoProductDetail() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getVerticalId() {
        return this.verticalId;
    }

    public void setVerticalId(String verticalId) {
        this.verticalId = verticalId;
    }

    public List<String> getCategoryIds() {
        return this.categoryIds;
    }

    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public String getBrandId() {
        return this.brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

