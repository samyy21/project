package com.paytm.pgplus.upipsphandler.exception;

public class MappingServiceClientException extends Exception {

    private static final long serialVersionUID = -6368709531967840935L;

    private String errorMessage;

    public MappingServiceClientException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public MappingServiceClientException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

}
