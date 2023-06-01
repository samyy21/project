package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paytm.pgplus.upipsphandler.model.common.Bank;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class UPI extends Bank {
    private static final long serialVersionUID = -4218899145811039088L;

    public UPI() {
    }
}
