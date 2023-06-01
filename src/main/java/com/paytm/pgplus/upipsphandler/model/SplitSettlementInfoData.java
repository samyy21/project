package com.paytm.pgplus.upipsphandler.model;

import com.paytm.pgplus.Annotations.MaskToStringBuilder;
import com.paytm.pgplus.enums.SplitMethod;
import com.paytm.pgplus.enums.SplitTypeEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

public class SplitSettlementInfoData implements Serializable {
    private static final long serialVersionUID = -2976081328252174482L;
    private SplitMethod splitMethod;
    private List<SplitInfoData> splitInfo;
    private SplitTypeEnum splitType;
    private String postTxnSplitTimeout;

    public SplitSettlementInfoData() {
    }

    public SplitMethod getSplitMethod() {
        return this.splitMethod;
    }

    public void setSplitMethod(SplitMethod splitMethod) {
        this.splitMethod = splitMethod;
    }

    public List<SplitInfoData> getSplitInfo() {
        return this.splitInfo;
    }

    public void setSplitInfo(List<SplitInfoData> splitInfo) {
        this.splitInfo = splitInfo;
    }

    public String toString() {
        return (new MaskToStringBuilder(this)).toString();
    }

    public SplitTypeEnum getSplitType() {
        return this.splitType;
    }

    public void setSplitType(String splitType) {
        if (StringUtils.isNotBlank(splitType)) {
            this.splitType = SplitTypeEnum.getSplitType(splitType);
        } else {
            this.splitType = SplitTypeEnum.AT_TXN;
        }

    }

    public String getPostTxnSplitTimeout() {
        return this.postTxnSplitTimeout;
    }

    public void setPostTxnSplitTimeout(String postTxnSplitTimeout) {
        this.postTxnSplitTimeout = postTxnSplitTimeout;
    }
}

