package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.biz.workflow.model.WorkFlowResponseBean;
import com.paytm.pgplus.upipsphandler.model.CashierInfoRequest;

public interface ICustomBeanMapper<T> {

    T getCashierInfoResponse(WorkFlowResponseBean workFlowResponseBean, CashierInfoRequest cashierInfoRequest);

    T getCashierInfoResponse(WorkFlowResponseBean workFlowResponseBean, CashierInfoRequest cashierInfoRequest,
            boolean disableWallet);

}
