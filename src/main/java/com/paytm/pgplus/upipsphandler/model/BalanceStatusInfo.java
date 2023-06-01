package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceStatusInfo extends StatusInfo {

    /**
     *
     */
    private static final long serialVersionUID = 872234347671231L;

    private String userAccountExist;
    private String merchantAccept;

    public BalanceStatusInfo(String userAccountExist, String merchantAccept, String status, String msg) {
        super(status, msg);
        this.userAccountExist = userAccountExist;
        this.merchantAccept = merchantAccept;
    }

    public String getUserAccountExist() {
        return userAccountExist;
    }

    public void setUserAccountExist(String userAccountExist) {
        this.userAccountExist = userAccountExist;
    }

    public String getMerchantAccept() {
        return merchantAccept;
    }

    public void setMerchantAccept(String merchantAccept) {
        this.merchantAccept = merchantAccept;
    }

}
