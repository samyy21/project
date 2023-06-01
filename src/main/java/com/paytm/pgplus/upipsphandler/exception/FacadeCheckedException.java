package com.paytm.pgplus.upipsphandler.exception;

public class FacadeCheckedException extends Exception {
    private static final long serialVersionUID = -3714349158264926392L;

    private Object entity;

    private int responseCode;

    /**
     *
     */
    public FacadeCheckedException() {
        super();
    }

    /**
     * @param message
     */
    public FacadeCheckedException(final String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public FacadeCheckedException(final Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public FacadeCheckedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public FacadeCheckedException(final String message, final Throwable cause, final boolean enableSuppression,
                                  final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FacadeCheckedException(final Object entity, final int responseCode) {
        this.responseCode = responseCode;
        this.entity = entity;
    }

}

