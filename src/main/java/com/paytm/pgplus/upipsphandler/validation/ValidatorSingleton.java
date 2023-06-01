package com.paytm.pgplus.upipsphandler.validation;

import javax.validation.Validation;
import javax.validation.Validator;

public final class ValidatorSingleton {
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    private static volatile ValidatorSingleton validatorSingleton;

    private ValidatorSingleton() {
    }

    public static ValidatorSingleton getInstance() {
        if (validatorSingleton == null) {
            Class var0 = ValidatorSingleton.class;
            synchronized(ValidatorSingleton.class) {
                if (validatorSingleton == null) {
                    validatorSingleton = new ValidatorSingleton();
                }
            }
        }

        return validatorSingleton;
    }

    public Validator getValidator() {
        return this.validator;
    }
}

