package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.biz.core.model.oauth.UserDetailsBiz;
import com.paytm.pgplus.upipsphandler.model.*;
import com.paytm.pgplus.upipsphandler.model.common.NativeInitiateRequest;
import com.paytm.pgplus.request.InitiateTransactionRequest;
import com.paytm.pgplus.request.InitiateTransactionRequestBody;

public interface INativeValidationService {

    NativePersistData validate(NativeInitiateRequest request);

    void validate(InitiateTransactionRequest request);

//    void validateTxnAmount(String amount);
//
//    void validateTxnAmountForSubscription(String amount);
//
    UserDetailsBiz validateSSOToken(String paytmSsoToken);

    UserDetailsBiz getUserDetails(InitiateTransactionRequestBody body);

//    void validateChecksum(InitiateTransactionRequest request);

    CreateAccessTokenServiceRequest validateAccessToken(NativeCashierInfoRequest request);

    InitiateTransactionRequestBody validateTxnToken(String txnToken);
//
    void validateMidOrderId(String mid, String orderId);
//
//    void validateMidOrderIdinRequest(String mid, String orderId, String bodyMid, String bodyOrderId);
//
//    boolean validatePromoCode(InitiateTransactionRequest request);
//
//    void validateUpdateTxnDetail(UpdateTransactionDetailRequest request);
//
    UserDetailsBiz validateLoginViaCookie(String mid);

    void validateMid(String mid);

//    boolean validateTransid(String transId, String txnToken);
//
//    void validateRiskDoViewRequest(String txnToken);
//
//    void validateRiskDoVerifyRequest(String txnToken);
//
//    RiskVerifierPayload validateRiskVerifierToken(String token);
//
    public UserDetailsBiz validateSSOToken(String paytmSsoToken, String mid);
//
//    public boolean validateRequest(TokenType tokenType, String token, Object reqBody, String mid);

}
