package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paytm.pgplus.Annotations.Mask;
import com.paytm.pgplus.Annotations.MaskToStringBuilder;
import com.paytm.pgplus.models.Money;

import java.io.Serializable;

public class ShippingInfo implements Serializable {
    private static final long serialVersionUID = -3127494875741842790L;
    @JsonProperty("merchantShippingId")
    private String merchantShippingId;
    @JsonProperty("trackingNo")
    private String trackingNo;
    @JsonProperty("carrier")
    private String carrier;
    @JsonProperty("chargeAmount")
    private Money chargeAmount;
    @JsonProperty("countryName")
    private String countryName;
    @JsonProperty("stateName")
    private String stateName;
    @JsonProperty("cityName")
    private String cityName;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("address2")
    private String address2;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("mobileNo")
    @Mask
    private String mobileNo;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("email")
    private String email;

    public ShippingInfo() {
    }

    public String getMerchantShippingId() {
        return this.merchantShippingId;
    }

    public void setMerchantShippingId(String merchantShippingId) {
        this.merchantShippingId = merchantShippingId;
    }

    public String getTrackingNo() {
        return this.trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Money getChargeAmount() {
        return this.chargeAmount;
    }

    public void setChargeAmount(Money chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return (new MaskToStringBuilder(this)).toString();
    }
}
