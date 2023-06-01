package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paytm.pgplus.common.model.DccPageForm;
import com.paytm.pgplus.common.model.DccPaymentDetail;

import java.io.Serializable;
import java.util.Map;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class DccPageData implements Serializable {
    private static final long serialVersionUID = -8847630996969711837L;
    private String pageType;
    private DccPageForm forms = new DccPageForm();
    private Map<String, Object> displayField;
    private DccPaymentDetail dccPaymentDetails;

    public DccPageData() {
    }

    public String getPageType() {
        return this.pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public DccPageForm getForms() {
        return this.forms;
    }

    public void setForms(DccPageForm forms) {
        this.forms = forms;
    }

    public DccPaymentDetail getDccPaymentDetails() {
        return this.dccPaymentDetails;
    }

    public void setDccPaymentDetails(DccPaymentDetail dccPaymentDetails) {
        this.dccPaymentDetails = dccPaymentDetails;
    }

    public void setDisplayField(Map<String, Object> displayField) {
        this.displayField = displayField;
    }

    public Map<String, Object> getDisplayField() {
        return this.displayField;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DccPageData {");
        sb.append("pageType=").append(this.pageType);
        sb.append(", forms=").append(this.forms);
        sb.append(", displayField=").append(this.displayField);
        sb.append(", dccPaymentDetails=").append(this.dccPaymentDetails);
        sb.append('}');
        return sb.toString();
    }
}
