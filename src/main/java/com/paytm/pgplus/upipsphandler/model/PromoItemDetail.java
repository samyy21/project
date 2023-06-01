package com.paytm.pgplus.upipsphandler.model;

import com.paytm.pgplus.models.PromoProductDetail;

import java.io.Serializable;

public class PromoItemDetail implements Serializable {
    private static final long serialVersionUID = -7221997834782443623L;
    private String id;
    private String promocode;
    private Integer amount;
    private com.paytm.pgplus.models.PromoProductDetail productDetail;

    public PromoItemDetail() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPromocode() {
        return this.promocode;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public com.paytm.pgplus.models.PromoProductDetail getProductDetail() {
        return this.productDetail;
    }

    public void setProductDetail(PromoProductDetail productDetail) {
        this.productDetail = productDetail;
    }
}

