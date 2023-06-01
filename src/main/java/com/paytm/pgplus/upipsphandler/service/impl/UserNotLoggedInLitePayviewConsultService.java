package com.paytm.pgplus.upipsphandler.service.impl;

import com.paytm.pgplus.biz.workflow.model.WorkFlowRequestBean;
import com.paytm.pgplus.biz.workflow.service.IWorkFlow;
import com.paytm.pgplus.enums.TokenType;
import com.paytm.pgplus.upipsphandler.exception.RequestValidationException;
import com.paytm.pgplus.upipsphandler.model.CashierInfoContainerRequest;
import com.paytm.pgplus.upipsphandler.service.ICommonFacade;
import com.paytm.pgplus.upipsphandler.service.helper.BasePayviewConsultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service("userNotLoggedInLitePayviewConsultService")
public class UserNotLoggedInLitePayviewConsultService extends BasePayviewConsultService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasePayviewConsultService.class);

    @Autowired
    @Qualifier("userNotLoggedInLitePayviewConsultWorkFlow")
    private IWorkFlow userNotLoggedInWorkflow;

    @Autowired
    @Qualifier("commonFacade")
    private ICommonFacade commonFacade;

    @Override
    public void validate(CashierInfoContainerRequest cashierInfoContainerRequest) throws RequestValidationException {
        super.validate(cashierInfoContainerRequest);

    }

//    @Override
//    protected void makeBackwardCompatibleHttpServletRequest(HttpServletRequest httpServletRequest,
//            CashierInfoRequest request) {
//        super.makeBackwardCompatibleHttpServletRequest(httpServletRequest, request);
//    }

    @Override
    public IWorkFlow fetchWorkflow(final WorkFlowRequestBean workFlowRequestBean) {
        return userNotLoggedInWorkflow;
    }

    private boolean isSSOToken(TokenType tokenType) {
        return TokenType.SSO.equals(tokenType);
    }

}