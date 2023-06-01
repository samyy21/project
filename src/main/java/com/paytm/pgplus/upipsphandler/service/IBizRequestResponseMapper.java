package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.biz.workflow.model.WorkFlowResponseBean;
import com.paytm.pgplus.cashier.cachecard.model.SavedCardRequest;
import com.paytm.pgplus.payloadvault.theia.request.PaymentRequestBean;
import com.paytm.pgplus.upipsphandler.exception.TheiaDataMappingException;
import com.paytm.pgplus.biz.workflow.model.WorkFlowRequestBean;

public interface IBizRequestResponseMapper {

    WorkFlowRequestBean mapWorkFlowRequestData(PaymentRequestBean requestData) throws TheiaDataMappingException;

    void mapWorkFlowResponseToSession(PaymentRequestBean requestData, WorkFlowResponseBean responseData,
                                      SavedCardRequest savedCardRequest);
    void mapWorkFlowResponseToSession(PaymentRequestBean requestData, WorkFlowResponseBean responseData);

}
