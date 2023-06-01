package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.beans.ConstructorProperties;
import java.io.Serializable;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class TwoFAConfig implements Serializable {
    private static final long serialVersionUID = 8388042567319327L;
    private String passCodeToken;
    private String platform;
    private String appVersion;
    private Boolean twoFARequired;
    private String addMoneyTxnId;
    private String p2mFlow;
    private String twoFAPasscode;
    @JsonIgnore
    private boolean fastForwardRequest;

    public String getPassCodeToken() {
        return this.passCodeToken;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public Boolean getTwoFARequired() {
        return this.twoFARequired;
    }

    public String getAddMoneyTxnId() {
        return this.addMoneyTxnId;
    }

    public String getP2mFlow() {
        return this.p2mFlow;
    }

    public String getTwoFAPasscode() {
        return this.twoFAPasscode;
    }

    public boolean isFastForwardRequest() {
        return this.fastForwardRequest;
    }

    public void setPassCodeToken(String passCodeToken) {
        this.passCodeToken = passCodeToken;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public void setTwoFARequired(Boolean twoFARequired) {
        this.twoFARequired = twoFARequired;
    }

    public void setAddMoneyTxnId(String addMoneyTxnId) {
        this.addMoneyTxnId = addMoneyTxnId;
    }

    public void setP2mFlow(String p2mFlow) {
        this.p2mFlow = p2mFlow;
    }

    public void setTwoFAPasscode(String twoFAPasscode) {
        this.twoFAPasscode = twoFAPasscode;
    }

    public void setFastForwardRequest(boolean fastForwardRequest) {
        this.fastForwardRequest = fastForwardRequest;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof TwoFAConfig)) {
            return false;
        } else {
            TwoFAConfig other = (TwoFAConfig)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$passCodeToken = this.getPassCodeToken();
                Object other$passCodeToken = other.getPassCodeToken();
                if (this$passCodeToken == null) {
                    if (other$passCodeToken != null) {
                        return false;
                    }
                } else if (!this$passCodeToken.equals(other$passCodeToken)) {
                    return false;
                }

                Object this$platform = this.getPlatform();
                Object other$platform = other.getPlatform();
                if (this$platform == null) {
                    if (other$platform != null) {
                        return false;
                    }
                } else if (!this$platform.equals(other$platform)) {
                    return false;
                }

                Object this$appVersion = this.getAppVersion();
                Object other$appVersion = other.getAppVersion();
                if (this$appVersion == null) {
                    if (other$appVersion != null) {
                        return false;
                    }
                } else if (!this$appVersion.equals(other$appVersion)) {
                    return false;
                }

                label78: {
                    Object this$twoFARequired = this.getTwoFARequired();
                    Object other$twoFARequired = other.getTwoFARequired();
                    if (this$twoFARequired == null) {
                        if (other$twoFARequired == null) {
                            break label78;
                        }
                    } else if (this$twoFARequired.equals(other$twoFARequired)) {
                        break label78;
                    }

                    return false;
                }

                label71: {
                    Object this$addMoneyTxnId = this.getAddMoneyTxnId();
                    Object other$addMoneyTxnId = other.getAddMoneyTxnId();
                    if (this$addMoneyTxnId == null) {
                        if (other$addMoneyTxnId == null) {
                            break label71;
                        }
                    } else if (this$addMoneyTxnId.equals(other$addMoneyTxnId)) {
                        break label71;
                    }

                    return false;
                }

                Object this$p2mFlow = this.getP2mFlow();
                Object other$p2mFlow = other.getP2mFlow();
                if (this$p2mFlow == null) {
                    if (other$p2mFlow != null) {
                        return false;
                    }
                } else if (!this$p2mFlow.equals(other$p2mFlow)) {
                    return false;
                }

                label57: {
                    Object this$twoFAPasscode = this.getTwoFAPasscode();
                    Object other$twoFAPasscode = other.getTwoFAPasscode();
                    if (this$twoFAPasscode == null) {
                        if (other$twoFAPasscode == null) {
                            break label57;
                        }
                    } else if (this$twoFAPasscode.equals(other$twoFAPasscode)) {
                        break label57;
                    }

                    return false;
                }

                if (this.isFastForwardRequest() != other.isFastForwardRequest()) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof TwoFAConfig;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $passCodeToken = this.getPassCodeToken();
        result = result * 59 + ($passCodeToken == null ? 43 : $passCodeToken.hashCode());
        Object $platform = this.getPlatform();
        result = result * 59 + ($platform == null ? 43 : $platform.hashCode());
        Object $appVersion = this.getAppVersion();
        result = result * 59 + ($appVersion == null ? 43 : $appVersion.hashCode());
        Object $twoFARequired = this.getTwoFARequired();
        result = result * 59 + ($twoFARequired == null ? 43 : $twoFARequired.hashCode());
        Object $addMoneyTxnId = this.getAddMoneyTxnId();
        result = result * 59 + ($addMoneyTxnId == null ? 43 : $addMoneyTxnId.hashCode());
        Object $p2mFlow = this.getP2mFlow();
        result = result * 59 + ($p2mFlow == null ? 43 : $p2mFlow.hashCode());
        Object $twoFAPasscode = this.getTwoFAPasscode();
        result = result * 59 + ($twoFAPasscode == null ? 43 : $twoFAPasscode.hashCode());
        result = result * 59 + (this.isFastForwardRequest() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "TwoFAConfig(passCodeToken=" + this.getPassCodeToken() + ", platform=" + this.getPlatform() + ", appVersion=" + this.getAppVersion() + ", twoFARequired=" + this.getTwoFARequired() + ", addMoneyTxnId=" + this.getAddMoneyTxnId() + ", p2mFlow=" + this.getP2mFlow() + ", twoFAPasscode=" + this.getTwoFAPasscode() + ", fastForwardRequest=" + this.isFastForwardRequest() + ")";
    }

    public TwoFAConfig() {
    }

    @ConstructorProperties({"passCodeToken", "platform", "appVersion", "twoFARequired", "addMoneyTxnId", "p2mFlow", "twoFAPasscode", "fastForwardRequest"})
    public TwoFAConfig(String passCodeToken, String platform, String appVersion, Boolean twoFARequired, String addMoneyTxnId, String p2mFlow, String twoFAPasscode, boolean fastForwardRequest) {
        this.passCodeToken = passCodeToken;
        this.platform = platform;
        this.appVersion = appVersion;
        this.twoFARequired = twoFARequired;
        this.addMoneyTxnId = addMoneyTxnId;
        this.p2mFlow = p2mFlow;
        this.twoFAPasscode = twoFAPasscode;
        this.fastForwardRequest = fastForwardRequest;
    }
}

