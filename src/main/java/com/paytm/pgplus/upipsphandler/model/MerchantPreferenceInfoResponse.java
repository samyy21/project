package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paytm.pgplus.cache.util.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantPreferenceInfoResponse implements KeyGen, Serializable {

    private static final long serialVersionUID = 5670606078576818786L;

    private MappingServiceResultInfo resultInfo;
    private String merchantId;

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MerchantPreferenceInfo implements Serializable {

        private static final long serialVersionUID = -5670606078576818786L;

        private String prefType;

        private String prefStatus;

        private String prefValue;

    }

    private List<MerchantPreferenceInfo> merchantPreferenceInfos;

    @Override
    public String generateCacheKey() {
        return Constants.MERCHANT_PERFRENCE_INFO_RESPONSE + CACHE_KEY_DELIMITER + this.merchantId;
    }

    public static String generateCacheKey(String paytmMerchantId) {
        return Constants.MERCHANT_PERFRENCE_INFO_RESPONSE + CACHE_KEY_DELIMITER + paytmMerchantId;
    }

}
