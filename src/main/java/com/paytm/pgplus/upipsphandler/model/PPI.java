package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PPI extends BalanceChannel {

    private static final long serialVersionUID = -1841771049100481693L;

    public PPI(AccountInfo balanceInfo) {
        super(balanceInfo);
    }

    public PPI() {
    }

}
