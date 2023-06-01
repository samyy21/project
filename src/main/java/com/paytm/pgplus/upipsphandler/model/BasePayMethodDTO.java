package com.paytm.pgplus.upipsphandler.model;

import com.paytm.pgplus.payloadvault.theia.request.PaymentRequestBean;
import com.paytm.pgplus.biz.workflow.model.WorkFlowRequestBean;

import java.io.Serializable;

public class BasePayMethodDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2942605783880620940L;

    protected PaymentRequestBean paymentRequestBean;

    protected WorkFlowRequestBean workFlowRequestBean;

    public BasePayMethodDTO() {

    }

    public BasePayMethodDTO(PaymentRequestBean paymentRequestBean, WorkFlowRequestBean workFlowRequestBean) {
        this.paymentRequestBean = paymentRequestBean;
        this.workFlowRequestBean = workFlowRequestBean;
    }

    public PaymentRequestBean getPaymentRequestBean() {
        return paymentRequestBean;
    }

    public WorkFlowRequestBean getWorkFlowRequestBean() {
        return workFlowRequestBean;
    }

}

