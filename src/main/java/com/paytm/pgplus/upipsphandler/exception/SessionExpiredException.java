package com.paytm.pgplus.upipsphandler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class SessionExpiredException extends RuntimeException {

    private static final long serialVersionUID = -8608026187806131884L;

    /**
     *
     */
    public SessionExpiredException() {
        super();
    }

    /**
     * @param message
     */
    public SessionExpiredException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public SessionExpiredException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public SessionExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public SessionExpiredException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

