package com.paytm.pgplus.upipsphandler.model;


import com.paytm.pgplus.common.enums.ETerminalType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EnvInfoRequestBean extends com.paytm.pgplus.common.model.EnvInfoRequestBean implements Serializable {
    private static final long serialVersionUID = 1312321312312315L;
    private String clientIp;
    private ETerminalType terminalType;
    private String sessionId;
    private String tokenId;
    private String websiteLanguage;
    private String osType;
    private String appVersion;
    private String sdkVersion;
    private String clientKey;
    private String orderTerminalType;
    private String orderOsType;
    private String merchantAppVersion;
    private String browserUserAgent;
    private Map<String, String> extendInfo = new HashMap();
    private String orderTerminalId;
    private String deviceId;
    private String latitude;
    private String longitude;
    private String userAgent;
    private String screenResolution;
    private String deviceModel;
    private String browserType;
    private String browserVersion;
    private String deviceManufacturer;
    private String language;
    private String deviceIMEI;
    private String timeZone;
    private String routerMac;
    private String deviceType;
    private String productCode;
    private String osVersion;
    private String hybridPlatform;
    private String hybridPlatformVersion;
    private String gender;
    private String ICCIDNumber;
    private String platform;
    private String merchantType;

    public EnvInfoRequestBean() {
    }

    public String getBrowserUserAgent() {
        return this.browserUserAgent;
    }

    public void setBrowserUserAgent(String browserUserAgent) {
        this.browserUserAgent = browserUserAgent;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTokenId() {
        return this.tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getWebsiteLanguage() {
        return this.websiteLanguage;
    }

    public void setWebsiteLanguage(String websiteLanguage) {
        this.websiteLanguage = websiteLanguage;
    }

    public String getOsType() {
        return this.osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getOrderTerminalType() {
        return this.orderTerminalType;
    }

    public void setOrderTerminalType(String orderTerminalType) {
        this.orderTerminalType = orderTerminalType;
    }

    public String getOrderOsType() {
        return this.orderOsType;
    }

    public void setOrderOsType(String orderOsType) {
        this.orderOsType = orderOsType;
    }

    public String getMerchantAppVersion() {
        return this.merchantAppVersion;
    }

    public void setMerchantAppVersion(String merchantAppVersion) {
        this.merchantAppVersion = merchantAppVersion;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public ETerminalType getTerminalType() {
        return this.terminalType;
    }

    public void setTerminalType(ETerminalType terminalType) {
        this.terminalType = terminalType;
    }

    public String getOrderTerminalId() {
        return this.orderTerminalId;
    }

    public void setOrderTerminalId(String orderTerminalId) {
        this.orderTerminalId = orderTerminalId;
    }

    public EnvInfoRequestBean(String clientIp, ETerminalType terminalType) {
        this.clientIp = clientIp;
        this.terminalType = terminalType;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getScreenResolution() {
        return this.screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getBrowserType() {
        return this.browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getBrowserVersion() {
        return this.browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    public void setDeviceManufacturer(String deviceManufacturer) {
        this.deviceManufacturer = deviceManufacturer;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDeviceIMEI() {
        return this.deviceIMEI;
    }

    public void setDeviceIMEI(String deviceIMEI) {
        this.deviceIMEI = deviceIMEI;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getRouterMac() {
        return this.routerMac;
    }

    public void setRouterMac(String routerMac) {
        this.routerMac = routerMac;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getHybridPlatform() {
        return this.hybridPlatform;
    }

    public void setHybridPlatform(String hybridPlatform) {
        this.hybridPlatform = hybridPlatform;
    }

    public String getHybridPlatformVersion() {
        return this.hybridPlatformVersion;
    }

    public void setHybridPlatformVersion(String hybridPlatformVersion) {
        this.hybridPlatformVersion = hybridPlatformVersion;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getICCIDNumber() {
        return this.ICCIDNumber;
    }

    public void setICCIDNumber(String ICCIDNumber) {
        this.ICCIDNumber = ICCIDNumber;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(Map<String, String> extendInfo) {
        this.extendInfo = extendInfo;
    }

    public String getMerchantType() {
        return this.merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EnvInfoRequestBean [clientIp=").append(this.clientIp).append(", terminalType=").append(this.terminalType).append(", sessionId=").append(this.sessionId).append(", tokenId=").append(this.tokenId).append(", websiteLanguage=").append(this.websiteLanguage).append(", osType=").append(this.osType).append(", appVersion=").append(this.appVersion).append(", sdkVersion=").append(this.sdkVersion).append(", clientKey=").append(this.clientKey).append(", orderTerminalType=").append(this.orderTerminalType).append(", orderOsType=").append(this.orderOsType).append(", orderTerminalId=").append(this.orderTerminalId).append(", merchantAppVersion=").append(this.merchantAppVersion).append(", browserUserAgent=").append(",deviceId =").append(this.deviceId).append("  ,latitude=").append(this.latitude).append("  ,longitude=").append(this.longitude).append("  ,versionCode=").append("  ,userAgent=").append(this.userAgent).append("  ,screenResolution=").append(this.screenResolution).append("  ,deviceModel=").append(this.deviceModel).append("  ,browserType=").append(this.browserType).append("  ,browserVersion=").append(this.browserVersion).append("  ,deviceManufacturer=").append(this.deviceManufacturer).append("  ,language=").append(this.language).append("  ,deviceIMEI=").append(this.deviceIMEI).append("  ,timeZone=").append(this.timeZone).append("  ,routerMac=").append(this.routerMac).append("  ,deviceType=").append(this.deviceType).append("  ,productCode=").append(this.productCode).append("  ,osVersion=").append(this.osVersion).append("  ,hybirdPlatform=").append(this.hybridPlatform).append("  ,hybirdPlatformVersion=").append(this.hybridPlatformVersion).append("  ,gender=").append(this.gender).append("  ,ICCIDNumber=").append(this.ICCIDNumber).append("  ,platform=").append(this.platform).append(" ,merchantType").append(this.merchantType).append(", extendInfo=").append(this.extendInfo).append("]");
        return builder.toString();
    }
}

