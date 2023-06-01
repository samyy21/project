package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.biz.mapping.models.MappingMerchantData;
import com.paytm.pgplus.pgproxycommon.models.GenericCoreResponseBean;
import com.paytm.pgplus.upipsphandler.exception.PaymentRequestValidationException;

public interface IMerchantMappingService {

    MappingMerchantData getMappingMerchantData(String id) throws PaymentRequestValidationException;

    GenericCoreResponseBean<MappingMerchantData> fetchMerchanData(String mId);

}
