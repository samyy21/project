package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.upipsphandler.model.TheiaMerchantExtendedDataResponse;

public interface IMerchantExtendedInfoDataService {

    TheiaMerchantExtendedDataResponse getMerchantExtendedInfoData(String merchantid);
    TheiaMerchantExtendedDataResponse getMerchantExtendedInfoDataFromClientId(String merchantid, String clientId);
}
