package com.paytm.pgplus.upipsphandler.model;

import com.paytm.pgplus.models.PromoItemOffer;

import java.io.Serializable;
import java.util.List;

public class PromoCartOfferDetail implements Serializable {
    private static final long serialVersionUID = 6127245585965850045L;
    private List<PromoItemOffer> itemOffers;

    public PromoCartOfferDetail() {
    }

    public List<PromoItemOffer> getItemOffers() {
        return this.itemOffers;
    }

    public void setItemOffers(List<PromoItemOffer> itemOffers) {
        this.itemOffers = itemOffers;
    }
}

