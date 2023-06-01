package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.upipsphandler.model.MerchantOfferDetailsInput;
import com.paytm.pgplus.upipsphandler.model.MerchantOfferDetailsResponse;

public interface IMerchantOfferDetailsService {

    MerchantOfferDetailsResponse getMerchantOfferDetails(MerchantOfferDetailsInput merchantUrlInput);

}

