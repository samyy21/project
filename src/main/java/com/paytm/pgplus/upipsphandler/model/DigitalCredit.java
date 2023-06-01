package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DigitalCredit extends BalanceChannel {

    private static final long serialVersionUID = -1508497003305821099L;

    public DigitalCredit(AccountInfo balanceInfo) {
        super(balanceInfo);
    }

    public DigitalCredit() {
    }

}