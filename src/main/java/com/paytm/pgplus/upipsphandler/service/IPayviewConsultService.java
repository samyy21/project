package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.biz.workflow.model.WorkFlowResponseBean;
import com.paytm.pgplus.upipsphandler.exception.RequestValidationException;
import com.paytm.pgplus.upipsphandler.model.CashierInfoContainerRequest;

public interface IPayviewConsultService {

    void validate(CashierInfoContainerRequest cashierInfoContainerRequest) throws RequestValidationException;

    WorkFlowResponseBean process(CashierInfoContainerRequest serviceRequest);
}
