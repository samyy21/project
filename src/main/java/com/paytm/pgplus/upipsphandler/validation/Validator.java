package com.paytm.pgplus.upipsphandler.validation;

import com.paytm.pgplus.upipsphandler.exception.TheiaServiceException;

public interface Validator<T> {

    void validate(T obj) throws TheiaServiceException;
}
