package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.cashier.cachecard.model.SavedCardRequest;
import com.paytm.pgplus.upipsphandler.exception.TheiaServiceException;

import javax.servlet.http.HttpServletRequest;

public interface IRetryPaymentService {

    boolean processPaymentRequest(HttpServletRequest requestData, SavedCardRequest savedCardRequest)
            throws TheiaServiceException;

}
