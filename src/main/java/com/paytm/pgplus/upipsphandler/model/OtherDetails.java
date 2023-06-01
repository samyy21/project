package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OtherDetails implements Serializable {
    private static final long serialVersionUID = 1689992000489388832L;
    private String rowname;
    private String rowvalue;

    public OtherDetails() {
    }

    public String getRowname() {
        return this.rowname;
    }

    public void setRowname(String rowname) {
        this.rowname = rowname;
    }

    public String getRowvalue() {
        return this.rowvalue;
    }

    public void setRowvalue(String rowvalue) {
        this.rowvalue = rowvalue;
    }

    public String toString() {
        return "OtherDetails [rowname=" + this.rowname + ", rowvalue=" + this.rowvalue + "]";
    }
}

