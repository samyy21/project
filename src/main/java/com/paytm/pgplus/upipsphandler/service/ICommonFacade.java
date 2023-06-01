package com.paytm.pgplus.upipsphandler.service;

import com.paytm.pgplus.biz.core.model.oauth.UserDetailsBiz;
import com.paytm.pgplus.enums.EChannelId;
import com.paytm.pgplus.upipsphandler.model.BalanceInfo;
import com.paytm.pgplus.upipsphandler.model.SuccessRateCacheModel;

import java.util.List;

public interface ICommonFacade {

    String getLogoName(String bankId, EChannelId eChannelId);

//    String getLogoName(BankInfoData bankInfoData, EChannelId eChannelId);
//
//    boolean hasLowSuccessRate(String bankName, String payMethod);

    BalanceInfo getPaytmBankBalanceInfo(UserDetailsBiz userDetailsBiz);
//
    public String getLogoUrl(String cardScheme, EChannelId channelId);

    boolean hasLowSuccessRate(String bankName, String payMethod, SuccessRateCacheModel successRateCacheModel);
//
//    public List<BankInfoData> getBankInfoDataListFromBankCodes(List<String> bankCodeList);

    String getLogoNameV1(String bankId);

    String getLogoName(String imageName);

    String getLogoNameV2(String bankId);

    String getBaseIconUrl();

    String getBankLogo(String bankCode);
}
