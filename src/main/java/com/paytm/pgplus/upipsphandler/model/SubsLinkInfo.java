package com.paytm.pgplus.upipsphandler.model;

import java.io.Serializable;

public class SubsLinkInfo implements Serializable {
    private static final long serialVersionUID = -4241127238835501567L;
    private String subsLinkId;
    private String plan;
    private String renewDate;
    private String subscriptionExpiryDate;
    private String subscriptionStartDate;
    private String renewalAmount;
    private String subscriptionMaxAmount;
    private String subsFreq;
    private String subsFreqUnit;
    private String subsLink;

    public SubsLinkInfo() {
    }

    public String getSubsLinkId() {
        return this.subsLinkId;
    }

    public void setSubsLinkId(String subsLinkId) {
        this.subsLinkId = subsLinkId;
    }

    public String getPlan() {
        return this.plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getRenewDate() {
        return this.renewDate;
    }

    public void setRenewDate(String renewDate) {
        this.renewDate = renewDate;
    }

    public String getSubscriptionExpiryDate() {
        return this.subscriptionExpiryDate;
    }

    public void setSubscriptionExpiryDate(String subscriptionExpiryDate) {
        this.subscriptionExpiryDate = subscriptionExpiryDate;
    }

    public String getSubscriptionStartDate() {
        return this.subscriptionStartDate;
    }

    public void setSubscriptionStartDate(String subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public String getRenewalAmount() {
        return this.renewalAmount;
    }

    public void setRenewalAmount(String renewalAmount) {
        this.renewalAmount = renewalAmount;
    }

    public String getSubscriptionMaxAmount() {
        return this.subscriptionMaxAmount;
    }

    public void setSubscriptionMaxAmount(String subscriptionMaxAmount) {
        this.subscriptionMaxAmount = subscriptionMaxAmount;
    }

    public String getSubsFreq() {
        return this.subsFreq;
    }

    public void setSubsFreq(String subsFreq) {
        this.subsFreq = subsFreq;
    }

    public String getSubsFreqUnit() {
        return this.subsFreqUnit;
    }

    public void setSubsFreqUnit(String subsFreqUnit) {
        this.subsFreqUnit = subsFreqUnit;
    }

    public String getSubsLink() {
        return this.subsLink;
    }

    public void setSubsLink(String subsLink) {
        this.subsLink = subsLink;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SubsLinkInfo{");
        sb.append("subsLinkId='").append(this.subsLinkId).append('\'');
        sb.append(", plan='").append(this.plan).append('\'');
        sb.append(", renewDate='").append(this.renewDate).append('\'');
        sb.append(", subscriptionExpiryDate='").append(this.subscriptionExpiryDate).append('\'');
        sb.append(", subscriptionStartDate='").append(this.subscriptionStartDate).append('\'');
        sb.append(", renewalAmount='").append(this.renewalAmount).append('\'');
        sb.append(", subscriptionMaxAmount='").append(this.subscriptionMaxAmount).append('\'');
        sb.append(", subsFreq='").append(this.subsFreq).append('\'');
        sb.append(", subsFreqUnit='").append(this.subsFreqUnit).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

