package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TheiaMerchantExtendedDataResponse {
    private String merchantId;
    private Map<String, String> extendedInfo;

    @JsonProperty(value = "merchantId")
    public String getMerchantId() {
        return merchantId;
    }

    @JsonProperty(value = "extendedInfo")
    public Map<String, String> getExtendedInfo() {
        return extendedInfo;
    }

}

