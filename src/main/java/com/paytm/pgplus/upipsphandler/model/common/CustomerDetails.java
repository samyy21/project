package com.paytm.pgplus.upipsphandler.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class CustomerDetails implements Serializable {
    private static final long serialVersionUID = 7507573572538503251L;
    private String customerName;
    private String customerEmail;
    private String customerMobile;

    public CustomerDetails() {
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerMobile() {
        return this.customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CustomerDetails [customerName=").append(this.customerName).append(", customerEmail=").append(this.customerEmail).append(", customerMobile=").append(this.customerMobile).append("]");
        return builder.toString();
    }
}

