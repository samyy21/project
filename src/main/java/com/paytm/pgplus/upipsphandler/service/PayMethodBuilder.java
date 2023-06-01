package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.upipsphandler.exception.PaymentRequestProcessingException;
import com.paytm.pgplus.upipsphandler.exception.RequestValidationException;
import com.paytm.pgplus.upipsphandler.model.BasePayMethodDTO;

public abstract class PayMethodBuilder<T extends BasePayMethodDTO> {

    protected T obj;

    public PayMethodBuilder<T> setObj(T obj) {
        this.obj = obj;
        return this;
    }

    public abstract void build() throws RequestValidationException, PaymentRequestProcessingException;

}
