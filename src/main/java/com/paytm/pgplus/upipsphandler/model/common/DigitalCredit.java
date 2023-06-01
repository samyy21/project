package com.paytm.pgplus.upipsphandler.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paytm.pgplus.upipsphandler.model.BalanceInfo;

import java.util.Map;

/**
 * Created by rahulverma on 1/9/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DigitalCredit extends BalanceChannel {

    private static final long serialVersionUID = -1508497003305821099L;

    private Map<String, String> extendInfo;

    public Map<String, String> getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(Map<String, String> extendInfo) {
        this.extendInfo = extendInfo;
    }

    public DigitalCredit(BalanceInfo balanceInfo) {
        super(balanceInfo);
    }

    public DigitalCredit() {
    }

}
