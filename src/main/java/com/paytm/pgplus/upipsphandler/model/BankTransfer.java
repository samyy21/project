package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.paytm.pgplus.upipsphandler.model.common.Bank;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BankTransfer extends Bank {

    private static final long serialVersionUID = 262408128424636084L;

}