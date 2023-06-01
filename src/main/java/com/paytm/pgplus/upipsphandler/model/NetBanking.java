package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paytm.pgplus.upipsphandler.model.common.Bank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NetBanking extends Bank {

    private static final long serialVersionUID = 1071165806624704160L;
}
