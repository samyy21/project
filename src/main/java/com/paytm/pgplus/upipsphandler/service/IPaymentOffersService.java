package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.facade.paymentpromotion.models.response.PromoServiceResponseBase;
import com.paytm.pgplus.upipsphandler.model.ApplyPromoRequest;
import com.paytm.pgplus.upipsphandler.model.ApplyPromoResponse;

public interface IPaymentOffersService {

    ApplyPromoResponse applyPromo(ApplyPromoRequest request, String version, String referenceId);

//    FetchAllPaymentOffersResponse fetchAllPaymentOffers(FetchAllPaymentOffersRequest request, String referenceId);

    PromoServiceResponseBase getApplyPromoResponse(ApplyPromoRequest request, String referenceId);

//    ApplyItemLevelPromoResponse applyItemLevelPromo(ApplyPromoRequest request, String referenceId);
//
//    FetchUserIdResponse fetchUserId(FetchUserIdRequest fetchUserIdRequest, String referenceId) throws Exception;

}
