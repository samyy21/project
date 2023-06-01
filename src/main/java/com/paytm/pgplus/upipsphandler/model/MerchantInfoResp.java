package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class MerchantInfoResp implements Serializable {

    private String merDispname;
    private String merBusName;
    private String merLogoUrl;

    @JsonProperty("P2P_Disabled")
    private boolean p2pDisabled;

}