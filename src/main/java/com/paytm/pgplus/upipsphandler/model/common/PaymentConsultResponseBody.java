package com.paytm.pgplus.upipsphandler.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.paytm.pgplus.response.ResultInfo;

import java.io.Serializable;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentConsultResponseBody implements Serializable {
    private static final long serialVersionUID = -3794593335019527498L;
    private com.paytm.pgplus.response.ResultInfo resultInfo;

    public PaymentConsultResponseBody() {
    }

    public com.paytm.pgplus.response.ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof com.paytm.pgplus.common.model.link.PaymentConsultResponseBody)) {
            return false;
        } else {
            PaymentConsultResponseBody other = (PaymentConsultResponseBody)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$resultInfo = this.getResultInfo();
                Object other$resultInfo = other.getResultInfo();
                if (this$resultInfo == null) {
                    if (other$resultInfo != null) {
                        return false;
                    }
                } else if (!this$resultInfo.equals(other$resultInfo)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.paytm.pgplus.common.model.link.PaymentConsultResponseBody;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $resultInfo = this.getResultInfo();
        result = result * 59 + ($resultInfo == null ? 43 : $resultInfo.hashCode());
        return result;
    }

    public String toString() {
        return "PaymentConsultResponseBody(resultInfo=" + this.getResultInfo() + ")";
    }
}

