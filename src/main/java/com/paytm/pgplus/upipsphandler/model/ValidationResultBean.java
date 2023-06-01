/**
 * 
 */
package com.paytm.pgplus.upipsphandler.model;


import com.paytm.pgplus.upipsphandler.enums.ResponseConstants;

/**
 * @author naman
 *
 */
public class ValidationResultBean {

    private boolean isSuccessfullyProcessed;

    private ResponseConstants responseConstant;

    public ResponseConstants getResponseConstant() {
        return responseConstant;
    }

    public boolean isSuccessfullyProcessed() {
        return isSuccessfullyProcessed;
    }

    public ValidationResultBean(ResponseConstants responseConstant) {
        this.responseConstant = responseConstant;
    }

    public ValidationResultBean(boolean isSuccessfullyProcessed) {
        this.isSuccessfullyProcessed = isSuccessfullyProcessed;
    }

    @Override
    public String toString() {
        return "ValidationResultBean [isSuccessfullyProcessed=" + isSuccessfullyProcessed + ", responseConstant="
                + responseConstant + "]";
    }

}
