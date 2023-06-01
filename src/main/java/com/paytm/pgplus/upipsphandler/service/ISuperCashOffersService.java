package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.upipsphandler.model.SuperCashOfferRequest;
import com.paytm.pgplus.upipsphandler.model.SuperCashOfferResponse;

public interface ISuperCashOffersService {

    SuperCashOfferResponse applySuperCash(SuperCashOfferRequest superCashOfferRequest, boolean offlineFlows);
}