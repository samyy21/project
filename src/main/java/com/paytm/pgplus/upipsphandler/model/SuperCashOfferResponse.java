package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuperCashOfferResponse implements Serializable {

    private static final long serialVersionUID = 6939579615272226540L;

    private SuperCashOfferResponseBody body;
    private Boolean status;
    private String error;

}
