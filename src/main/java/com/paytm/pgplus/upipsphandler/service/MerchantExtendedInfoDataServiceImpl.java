package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.cache.model.MerchantExtendedInfoResponse;
import com.paytm.pgplus.facade.utils.JsonMapper;
import com.paytm.pgplus.upipsphandler.exception.PaymentRequestValidationException;
import com.paytm.pgplus.upipsphandler.model.TheiaMerchantExtendedDataResponse;
import com.paytm.pgplus.upipsphandler.preredis.impl.PreRedisCacheHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("merchantExtendedInfoDataService")
public class MerchantExtendedInfoDataServiceImpl implements IMerchantExtendedInfoDataService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MerchantExtendedInfoDataServiceImpl.class);

    @Autowired
    private PreRedisCacheHelper preRedisCacheHelper;

    @Override
    public TheiaMerchantExtendedDataResponse getMerchantExtendedInfoData(String merchantid) {
        try {
            MerchantExtendedInfoResponse merchantExtendedInfoResponse = preRedisCacheHelper
                    .getMerchantExtendedData(merchantid);
            LOGGER.debug("MerchantExtendedInfoResponse received : {}", merchantExtendedInfoResponse);
            if (merchantExtendedInfoResponse != null) {
                TheiaMerchantExtendedDataResponse theiaMerchantExtendedDataResponse = JsonMapper.convertValue(
                        merchantExtendedInfoResponse, TheiaMerchantExtendedDataResponse.class);
                return theiaMerchantExtendedDataResponse;
            }
        } catch (Exception errorCause) {
            LOGGER.error(errorCause.getMessage());
            throw new PaymentRequestValidationException(
                    "Error while fetching merchantContract Detail from guava cache", errorCause);
        }
        return null;
    }

    @Override
    public TheiaMerchantExtendedDataResponse getMerchantExtendedInfoDataFromClientId(String merchantId, String clientId) {
        try {
            MerchantExtendedInfoResponse merchantExtendedInfoResponse = preRedisCacheHelper
                    .getMerchantExtendedDataFromClientId(merchantId, clientId);
            LOGGER.debug("MerchantExtendedInfoResponse received : {}", merchantExtendedInfoResponse);
            if (merchantExtendedInfoResponse != null) {
                TheiaMerchantExtendedDataResponse theiaMerchantExtendedDataResponse = JsonMapper.convertValue(
                        merchantExtendedInfoResponse, TheiaMerchantExtendedDataResponse.class);
                return theiaMerchantExtendedDataResponse;
            }
        } catch (Exception errorCause) {
            LOGGER.error(errorCause.getMessage());
            throw new PaymentRequestValidationException(
                    "Errgaor while fetching merchantContract Detail from guava cache using ClientId", errorCause);
        }
        return null;
    }


}

