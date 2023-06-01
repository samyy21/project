package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.facade.fluxnet.models.request.SuccessRateQueryRequest;
import com.paytm.pgplus.facade.fluxnet.models.response.SuccessRateQueryResponse;
import com.paytm.pgplus.upipsphandler.model.SuccessRateCacheModel;
import com.paytm.pgplus.upipsphandler.model.SuccessRateQueryResponseBean;

public interface ISuccessRateQueryService {

//    SuccessRateQueryResponseBean getSuccessRatesForPayMethod(SuccessRateQueryRequestBean successRateQueryRequest);

    SuccessRateQueryResponseBean getSuccessRatesForPayMethod();

//    SuccessRateQueryResponseBean mapFacadeResponseToTheiaResponseModel(
//            SuccessRateQueryResponse facadeSuccessRateResponse);
//
//    SuccessRateQueryRequest mapRequestBeanToFacadeRequest(SuccessRateQueryRequestBean successRateQueryRequest);

    SuccessRateCacheModel getSuccessRateModelFromCache();

    void setSuccessRateModelInCache(SuccessRateCacheModel successRatesCacheModel);

//    SuccessRateCacheModel checkAndFetchSuccessRateModel();

}
