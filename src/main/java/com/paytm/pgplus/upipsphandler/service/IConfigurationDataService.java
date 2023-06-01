package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.biz.mapping.models.EMIValidBinsData;
import com.paytm.pgplus.cache.model.PaytmProperty;

public interface IConfigurationDataService {

    PaytmProperty getPaytmProperty(String propertyName);
//
//    String getPaytmProperty(String key, String defaultValue);
//
    String getPaytmPropertyValue(String oauthClientId);

    EMIValidBinsData getEmiValidBins(String key);

//    PaytmDefaultValuesData getPaytmDefaultValues(String fieldName);
//
//    Optional<List<PaytmDefaultValuesData>> getPaytmDefaultValues(List<String> fieldNameList);
//
//    EntityIgnoreParamsDataResponse getEntityIgnoreParams(String entityId);

}
