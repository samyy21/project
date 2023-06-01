package com.paytm.pgplus.upipsphandler.preredis.impl;

import com.paytm.pgplus.cache.model.MerchantExtendedInfoResponse;
import com.paytm.pgplus.upipsphandler.utils.ConfigurationUtil;
import com.paytm.pgplus.upipsphandler.model.common.MerchantPreferenceStore;
import com.paytm.pgplus.upipsphandler.preredis.IPreRedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PreRedisCacheHelper {

    @Autowired
    @Qualifier("preRedisCacheServiceImpl")
    private IPreRedisCacheService preRedisCacheServiceImpl;

    private boolean isCacheFLowRequired(String mid) {
        boolean cacheRequired;
        String cacheFlowMids = ConfigurationUtil.getProperty("cache.flow.mids", "NONE");
        if ("NONE".equalsIgnoreCase(cacheFlowMids)) {
            cacheRequired = false;
        } else if ("ALL".equalsIgnoreCase(cacheFlowMids)) {
            cacheRequired = true;
        } else {
            String[] mids = cacheFlowMids.split(",");
            List<String> midList = Arrays.asList(mids);
            cacheRequired = midList.contains(mid);
        }
        return cacheRequired;
    }

    public MerchantExtendedInfoResponse getMerchantExtendedData(String mid) {
        boolean isCacheRequired = isCacheFLowRequired(mid);
        if (isCacheRequired) {
            return preRedisCacheServiceImpl.getMerchantExtendedDataByCache(mid);
        }
        return preRedisCacheServiceImpl.getMerchantExtendedDataWithoutCache(mid);
    }

    public MerchantPreferenceStore getMerchantPreferenceStore(String mid) {
        boolean isCacheRequired = isCacheFLowRequired(mid);
        if (isCacheRequired) {
            return preRedisCacheServiceImpl.getMerchantPreferenceStoreByCache(mid);
        }
        return preRedisCacheServiceImpl.getMerchantPreferenceStoreWithoutCache(mid);
    }

    public MerchantExtendedInfoResponse getMerchantExtendedDataFromClientId(String mid, String clientId) {
        boolean isCacheRequired = isCacheFLowRequired(mid);
        if (isCacheRequired) {
            return preRedisCacheServiceImpl.getMerchantExtendedDataFromClientIdByCache(mid, clientId);
        }
        return preRedisCacheServiceImpl.getMerchantExtendedDataFromClientIdWithoutCache(mid, clientId);
    }
}
