package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnhancedCashierLocalalizedText implements Serializable {

    private static final long serialVersionUID = -8041644663254815134L;

    private String lang;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

}