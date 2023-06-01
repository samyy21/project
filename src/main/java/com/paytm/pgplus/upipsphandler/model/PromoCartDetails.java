package com.paytm.pgplus.upipsphandler.model;

import java.io.Serializable;
import java.util.List;

public class PromoCartDetails implements Serializable {
    private static final long serialVersionUID = -589035192173487142L;
    private List<PromoItemDetail> items;

    public PromoCartDetails() {
    }

    public List<PromoItemDetail> getItems() {
        return this.items;
    }

    public void setItems(List<PromoItemDetail> items) {
        this.items = items;
    }
}

