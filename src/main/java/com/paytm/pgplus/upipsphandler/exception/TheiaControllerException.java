package com.paytm.pgplus.upipsphandler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class TheiaControllerException extends RuntimeException {

    private static final long serialVersionUID = -6402700046545677381L;

    /**
     * @param message
     */
    public TheiaControllerException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public TheiaControllerException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public TheiaControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public TheiaControllerException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

