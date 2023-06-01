package com.paytm.pgplus.upipsphandler.service.impl;

import com.paytm.pgplus.biz.workflow.model.WorkFlowRequestBean;
import com.paytm.pgplus.biz.workflow.service.IWorkFlow;
import com.paytm.pgplus.upipsphandler.enums.TokenType;
import com.paytm.pgplus.upipsphandler.enums.common.ResultCode;
import com.paytm.pgplus.upipsphandler.exception.RequestValidationException;
import com.paytm.pgplus.upipsphandler.model.CashierInfoContainerRequest;
import com.paytm.pgplus.upipsphandler.model.CashierInfoRequest;
import com.paytm.pgplus.upipsphandler.service.helper.BasePayviewConsultService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service("userLoggedInLitePayviewConsultService")
public class UserLoggedInLitePayviewConsultService extends BasePayviewConsultService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasePayviewConsultService.class);

    @Autowired
    @Qualifier("userLoggedInLitePayviewConsultWorkflow")
    private IWorkFlow userLoggedInWorkflow;

    @Override
    public void validate(CashierInfoContainerRequest cashierInfoContainerRequest) throws RequestValidationException {
        super.validate(cashierInfoContainerRequest);
        CashierInfoRequest cashierInfoRequest = cashierInfoContainerRequest.getCashierInfoRequest();
        if (!isSSOToken(cashierInfoRequest.getHead().getTokenType())) {
            LOGGER.error("Request validation failed... {}", "SSO Token is mandatory");
            throw RequestValidationException.getException(ResultCode.REQUEST_PARAMS_VALIDATION_EXCEPTION);
        }
    }

//    @Override
//    protected void makeBackwardCompatibleHttpServletRequest(HttpServletRequest httpServletRequest,
//            CashierInfoRequest request) {
//        super.makeBackwardCompatibleHttpServletRequest(httpServletRequest, request);
//        if (StringUtils.isNotBlank(request.getHead().getToken())) {
//            httpServletRequest.setAttribute(TheiaConstant.RequestParams.SSO_TOKEN, request.getHead().getToken());
//        }
//    }

    @Override
    public IWorkFlow fetchWorkflow(final WorkFlowRequestBean workFlowRequestBean) {
        return userLoggedInWorkflow;
    }

    private boolean isSSOToken(TokenType tokenType) {
        return TokenType.SSO.equals(tokenType);
    }

}