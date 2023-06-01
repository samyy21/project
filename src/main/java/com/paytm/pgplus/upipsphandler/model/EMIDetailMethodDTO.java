package com.paytm.pgplus.upipsphandler.model;

import com.paytm.pgplus.cache.model.EMIDetailList;

import java.io.Serializable;

public class EMIDetailMethodDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3151864549341965612L;
    private EMIDetailList emiDetailList;
    private Long emiPlanId;
    private String bankCode;

    public EMIDetailMethodDTO() {

    }

    public EMIDetailMethodDTO(EMIDetailList emiDetailList) {
        super();
        this.emiDetailList = emiDetailList;
    }

    public EMIDetailList getEmiDetailList() {
        return emiDetailList;
    }

    public void setEmiDetailList(EMIDetailList emiDetailList) {
        this.emiDetailList = emiDetailList;
    }

    public Long getEmiPlanId() {
        return emiPlanId;
    }

    public void setEmiPlanId(Long emiPlanId) {
        this.emiPlanId = emiPlanId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
}
