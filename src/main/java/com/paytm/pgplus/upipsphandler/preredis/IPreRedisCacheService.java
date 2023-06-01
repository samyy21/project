package com.paytm.pgplus.upipsphandler.preredis;

import com.paytm.pgplus.cache.model.MerchantExtendedInfoResponse;
import com.paytm.pgplus.cache.model.MerchantPreferenceInfoResponse;
import com.paytm.pgplus.upipsphandler.model.common.MerchantPreferenceStore;

public interface IPreRedisCacheService {

    MerchantPreferenceStore getMerchantPreferenceStoreByCache(String id);
    public MerchantPreferenceStore parseResponse(MerchantPreferenceInfoResponse merchantPreferenceResponse);
    MerchantPreferenceStore getMerchantPreferenceStoreWithoutCache(String id);
    MerchantExtendedInfoResponse getMerchantExtendedDataByCache(String id);

    MerchantExtendedInfoResponse getMerchantExtendedDataWithoutCache(String id);
    MerchantExtendedInfoResponse getMerchantExtendedDataFromClientIdByCache(String id, String clientId);
    MerchantExtendedInfoResponse getMerchantExtendedDataFromClientIdWithoutCache(String id, String clientId);

}

