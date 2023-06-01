package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.biz.workflow.model.WorkFlowRequestBean;
import com.paytm.pgplus.promo.service.client.model.PromoCodeResponse;

public interface IPromoHelper {

//    public PromoCodeResponse applyPromoCode(WorkFlowRequestBean workFlowRequestBean, String transId, String txnAmount);

    public PromoCodeResponse validatePromoCode(String promoCode, String mid);

//    public PromoCodeResponse validatePromoCodePaymentMode(String paytmMid, String txntype, String promoCode,
//                                                          String cardNo, String bankCode);
//
//    public PromoCodeResponse updatePromoCode(WorkFlowRequestBean workFlowRequestBean, String transId, String txnAmount);
//
//    public PromoCodeResponse validatePromoCodePaymentMode(NativePromoCodeDetailRequest serviceReq);
}

