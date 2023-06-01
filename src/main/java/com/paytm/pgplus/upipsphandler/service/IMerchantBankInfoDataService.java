package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.upipsphandler.model.BankInfoData;

import java.util.List;

public interface IMerchantBankInfoDataService {

    BankInfoData getBankInfo(String bankId);

//    public List<BankInfoData> getBankInfoDataListFromBankCodes(List<String> bankCodeList);

}