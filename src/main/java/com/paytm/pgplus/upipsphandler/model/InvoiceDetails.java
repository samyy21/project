package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoiceDetails implements Serializable {
    private static final long serialVersionUID = 7715774981811759935L;
    private List<String> headerName;
    private List<List<String>> itemDetails;
    private List<OtherDetails> taxDetails;
    private List<OtherDetails> otherDetails;

    public InvoiceDetails() {
    }

    public List<String> getHeaderName() {
        return this.headerName;
    }

    public void setHeaderName(List<String> headerName) {
        this.headerName = headerName;
    }

    public List<List<String>> getItemDetails() {
        return this.itemDetails;
    }

    public void setItemDetails(List<List<String>> itemDetails) {
        this.itemDetails = itemDetails;
    }

    public List<OtherDetails> getTaxDetails() {
        return this.taxDetails;
    }

    public void setTaxDetails(List<OtherDetails> taxDetails) {
        this.taxDetails = taxDetails;
    }

    public List<OtherDetails> getOtherDetails() {
        return this.otherDetails;
    }

    public void setOtherDetails(List<OtherDetails> otherDetails) {
        this.otherDetails = otherDetails;
    }
}

