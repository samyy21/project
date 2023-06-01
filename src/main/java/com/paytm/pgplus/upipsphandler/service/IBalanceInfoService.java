package com.paytm.pgplus.upipsphandler.service;

public interface IBalanceInfoService<Req, ServReq, Res> {

    Res fetchBalance(Req req, ServReq servReq);

}
