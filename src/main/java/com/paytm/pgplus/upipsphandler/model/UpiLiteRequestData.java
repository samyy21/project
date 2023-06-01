package com.paytm.pgplus.upipsphandler.model;

import java.io.Serializable;

public class UpiLiteRequestData implements Serializable {
    private static final long serialVersionUID = 5202147632608118308L;
    private String lrn;
    private String arqc;
    private String isSecurityShieldAcquired;
    private String lastSecurityShieldUpdateTime;

    public UpiLiteRequestData() {
    }

    public String getLrn() {
        return this.lrn;
    }

    public void setLrn(String lrn) {
        this.lrn = lrn;
    }

    public String getArqc() {
        return this.arqc;
    }

    public void setArqc(String arqc) {
        this.arqc = arqc;
    }

    public String getIsSecurityShieldAcquired() {
        return this.isSecurityShieldAcquired;
    }

    public void setIsSecurityShieldAcquired(String isSecurityShieldAcquired) {
        this.isSecurityShieldAcquired = isSecurityShieldAcquired;
    }

    public String getLastSecurityShieldUpdateTime() {
        return this.lastSecurityShieldUpdateTime;
    }

    public void setLastSecurityShieldUpdateTime(String lastSecurityShieldUpdateTime) {
        this.lastSecurityShieldUpdateTime = lastSecurityShieldUpdateTime;
    }

    public String toString() {
        return "UpiLiteRequestData{lrn='" + this.lrn + '\'' + ", arqc='" + this.arqc + '\'' + ", isSecurityShieldAcquired='" + this.isSecurityShieldAcquired + '\'' + ", lastSecurityShieldUpdateTime='" + this.lastSecurityShieldUpdateTime + '\'' + '}';
    }
}

