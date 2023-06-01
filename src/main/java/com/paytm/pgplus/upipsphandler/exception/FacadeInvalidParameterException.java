/**
 *
 */
package com.paytm.pgplus.upipsphandler.exception;

/**
 * @author vaishakh
 *
 */
public class FacadeInvalidParameterException extends FacadeCheckedException {

    /**
	 *
	 */
    private static final long serialVersionUID = -3714349158264926392L;

    /**
	 *
	 */
    public FacadeInvalidParameterException() {
        super();
    }

    /**
     * @param message
     */
    public FacadeInvalidParameterException(final String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public FacadeInvalidParameterException(final Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public FacadeInvalidParameterException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public FacadeInvalidParameterException(final String message, final Throwable cause,
                                           final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
