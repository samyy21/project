package com.paytm.pgplus.upipsphandler.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BalanceInfoServiceRequest {

    private String mid;
    private String ssoToken;
    private String paymentMode;
    private String txnToken;

}
