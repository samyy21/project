package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.biz.workflow.model.WorkFlowResponseBean;
import com.paytm.pgplus.pgproxycommon.models.GenericCoreResponseBean;
import com.paytm.pgplus.biz.workflow.model.WorkFlowRequestBean;

public interface IWorkFlow {
    GenericCoreResponseBean<WorkFlowResponseBean> process(WorkFlowRequestBean var1);
}

