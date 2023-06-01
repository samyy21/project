package com.paytm.pgplus.upipsphandler.model;

import com.paytm.pgplus.payloadvault.theia.request.PaymentRequestBean;
import com.paytm.pgplus.biz.workflow.model.WorkFlowRequestBean;

import java.io.Serializable;

public class EMIPayMethodDTO extends BasePayMethodDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1605536932764685909L;

    public EMIPayMethodDTO() {
    }

    public EMIPayMethodDTO(PaymentRequestBean paymentRequestBean, WorkFlowRequestBean workFlowRequestBean) {
        super(paymentRequestBean, workFlowRequestBean);
    }

}

