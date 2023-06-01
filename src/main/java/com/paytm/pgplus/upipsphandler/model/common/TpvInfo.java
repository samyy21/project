package com.paytm.pgplus.upipsphandler.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.beans.ConstructorProperties;
import java.io.Serializable;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class TpvInfo implements Serializable {
    private static final long serialVersionUID = -175177296353682078L;
    private String accountNumber;
    private String ifscCode;
    private String status;
    private String bankName;
    private String accountHolderName;
    private String nbin;

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getIfscCode() {
        return this.ifscCode;
    }

    public String getStatus() {
        return this.status;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public String getNbin() {
        return this.nbin;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setNbin(String nbin) {
        this.nbin = nbin;
    }

    public TpvInfo() {
    }

    @ConstructorProperties({"accountNumber", "ifscCode", "status", "bankName", "accountHolderName", "nbin"})
    public TpvInfo(String accountNumber, String ifscCode, String status, String bankName, String accountHolderName, String nbin) {
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.status = status;
        this.bankName = bankName;
        this.accountHolderName = accountHolderName;
        this.nbin = nbin;
    }
}

