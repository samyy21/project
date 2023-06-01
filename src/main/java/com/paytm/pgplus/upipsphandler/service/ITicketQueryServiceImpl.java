package com.paytm.pgplus.upipsphandler.service;

public interface ITicketQueryServiceImpl {

    String fetchTicketQueryPRN(String paytmMerchantId, String acquirementId);

}