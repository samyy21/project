package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.beans.ConstructorProperties;
import java.io.Serializable;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class PayerAccountDetails implements Serializable {
    private String accountNumber;
    private String ifsc;
    private String accountName;

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getIfsc() {
        return this.ifsc;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public PayerAccountDetails() {
    }

    @ConstructorProperties({"accountNumber", "ifsc", "accountName"})
    public PayerAccountDetails(String accountNumber, String ifsc, String accountName) {
        this.accountNumber = accountNumber;
        this.ifsc = ifsc;
        this.accountName = accountName;
    }
}
