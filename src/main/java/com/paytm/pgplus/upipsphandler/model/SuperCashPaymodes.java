package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paytm.pgplus.facade.supercashoffers.models.SuperCashPayModeResponse;
import com.paytm.pgplus.upipsphandler.enums.PIIPayModes;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuperCashPaymodes implements Serializable {
    private static final long serialVersionUID = 8151123084872389358L;

    private PIIPayModes paymode;
    private List<SuperCashPayModeResponse> offers;
}
