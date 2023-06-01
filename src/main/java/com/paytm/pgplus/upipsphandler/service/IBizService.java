package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.biz.workflow.model.WorkFlowRequestBean;
import com.paytm.pgplus.biz.workflow.model.WorkFlowResponseBean;
import com.paytm.pgplus.pgproxycommon.models.GenericCoreResponseBean;
import com.paytm.pgplus.biz.workflow.service.IWorkFlow;

import java.io.Serializable;

public interface IBizService extends Serializable {

    GenericCoreResponseBean<WorkFlowResponseBean> processWorkFlow(WorkFlowRequestBean workFlowRequestBean,
                                                                  IWorkFlow workFlow);

}
