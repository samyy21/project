package com.paytm.pgplus.upipsphandler.service;

public interface IRequestProcessor<Req, Res> {

    /**
     * This method need to implement to process request and generate response.
     *
     * @param request
     * @return
     * @throws Exception
     */
    public Res process(Req request) throws Exception;

}
