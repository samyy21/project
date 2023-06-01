/**
 *
 *
 */
package com.paytm.pgplus.upipsphandler.service.impl;

import com.paytm.pgplus.biz.core.model.request.ExtendedInfoRequestBean;
import com.paytm.pgplus.biz.enums.DirectChannelBank;
import com.paytm.pgplus.cache.model.MerchantExtendedInfoResponse;
import com.paytm.pgplus.cache.model.PaytmProperty;
import com.paytm.pgplus.common.enums.ETerminalType;
import com.paytm.pgplus.common.enums.TxnState;
import com.paytm.pgplus.common.model.EnvInfoRequestBean;
import com.paytm.pgplus.enums.EChannelId;
import com.paytm.pgplus.models.UltimateBeneficiaryDetails;
import com.paytm.pgplus.transactionlogger.annotation.Loggable;
import com.paytm.pgplus.upipsphandler.component.UPITransactionInfo;
import com.paytm.pgplus.upipsphandler.constants.TheiaConstant;
import com.paytm.pgplus.upipsphandler.exception.TheiaServiceException;
import com.paytm.pgplus.upipsphandler.model.*;
import com.paytm.pgplus.upipsphandler.model.common.LoginInfo;
import com.paytm.pgplus.upipsphandler.preredis.impl.PreRedisCacheHelper;
import com.paytm.pgplus.upipsphandler.service.IConfigurationDataService;
import com.paytm.pgplus.upipsphandler.service.IMerchantPreferenceService;
import com.paytm.pgplus.upipsphandler.service.ITheiaSessionDataService;
import com.paytm.pgplus.upipsphandler.utils.EnvInfoUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @createdOn 29-Mar-2016
 * @author kesari
 */
@Service("theiaSessionDataService")
public class TheiaSessionDataServiceImpl implements ITheiaSessionDataService {
    private static final long serialVersionUID = 6506202840967640486L;
    private static final Logger LOGGER = LoggerFactory.getLogger(TheiaSessionDataServiceImpl.class);

    private static final String DEFAULT_WAP_CHANNEL = "WAP";
    private static final String DEFAULT_WEB_CHANNEL = "WEB";
    private static final String DEFAULT_POST_CON_THEME = "merchant3";

    @Autowired
    @Qualifier("merchantPreferenceService")
    private IMerchantPreferenceService merchantPreferenceService;

    @Autowired
    private PreRedisCacheHelper preRedisCacheHelper;

    @Autowired
    @Qualifier("configurationDataService")
    private IConfigurationDataService configurationDataService;


    @Loggable(logLevel = Loggable.DEBUG, state = TxnState.SESSION_FETCH_TXNINFO)
    @Override
    public TransactionInfo getTxnInfoFromSession(HttpServletRequest request) {
        return getTxnInfoFromSession(request, false);
    }
    @Override
    public void setEnvInfoRequestBean(HttpServletRequest request, EnvInfoRequestBean envInfo) {
        HttpSession session = request.getSession();

        if (session == null) {
            throw new TheiaServiceException("Unable to set EnvInfoRequestBean due to the Session does not exist");
        }

        if (null == session.getAttribute(TheiaConstant.SessionDataAttributes.envInfo.name())) {
            session.setAttribute(TheiaConstant.SessionDataAttributes.envInfo.name(), envInfo);
        }
    }

    @Override
    public EntityPaymentOptionsTO getEntityPaymentOptions(HttpServletRequest request) {
        return getEntityPaymentOptions(request, false);
    }

    @Override
    public ExtendedInfoRequestBean geExtendedInfoRequestBean(HttpServletRequest request) {
        return geExtendedInfoRequestBean(request, false);
    }

    @Loggable(logLevel = Loggable.DEBUG, state = TxnState.SESSION_FETCH_CARD_INFO)
    @Override
    public CardInfo getCardInfoFromSession(HttpServletRequest request) {
        return getCardInfoFromSession(request, false);
    }

    @Loggable(logLevel = Loggable.DEBUG, state = TxnState.SESSION_FETCH_TXNCONFIG)
    @Override
    public TransactionConfig getTxnConfigFromSession(HttpServletRequest request) {
        return getTxnConfigFromSession(request, false);
    }

    @Override
    public TransactionConfig getTxnConfigFromSession(HttpServletRequest request, boolean createNew) {
        HttpSession session = request.getSession();
        String txnConfigVal = TheiaConstant.SessionDataAttributes.txnConfig.name();

        if (session == null) {
            throw new TheiaServiceException("TransactionConfig does not available due to the session not exist");
        }

        TransactionConfig txnConfig = session.getAttribute(txnConfigVal) == null ? null : TransactionConfig.class
                .cast(session.getAttribute(txnConfigVal));
        if ((txnConfig == null) && createNew) {
            txnConfig = new TransactionConfig();
            session.setAttribute(txnConfigVal, txnConfig);
        }

        if (txnConfig == null) {
            LOGGER.error("TxnConfig fetched from session is null");
        }
        return txnConfig;
    }

    @Loggable(logLevel = Loggable.DEBUG, state = TxnState.SESSION_FETCH_WALLET_INFO)
    @Override
    public WalletInfo getWalletInfoFromSession(HttpServletRequest request) {
        return getWalletInfoFromSession(request, false);
    }

    @Override
    public String getChannel(HttpServletRequest request, boolean ignoreRequestChannelId) {
        String channel = getAttributeOrParameter(request, TheiaConstant.RequestParams.CHANNEL_ID);
        UserAgentInfo userAgentInfo = new UserAgentInfo(request);

        if (ignoreRequestChannelId) {
            channel = null;
        }

        if (userAgentInfo.detectSmartphone() || StringUtils.equals(ETerminalType.WAP.getTerminal(), channel)) {
            channel = DEFAULT_WAP_CHANNEL;
        }

        if (StringUtils.isNotBlank(channel)) {
            return channel;
        } else {
            ETerminalType terminalType = EnvInfoUtil.getTerminalType(request);
            switch (terminalType) {
                case APP:
                case WAP:
                    channel = DEFAULT_WAP_CHANNEL;
                    break;
                case SYSTEM:
                case WEB:
                default:
                    channel = DEFAULT_WEB_CHANNEL;
                    break;
            }
        }
        return channel;
    }
    private String getAttributeOrParameter(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return StringUtils.isNotBlank(paramValue) ? paramValue : request.getAttribute(paramName) != null ? request
                .getAttribute(paramName).toString() : null;
    }

    @Override
    public WalletInfo getWalletInfoFromSession(HttpServletRequest request, boolean createNew) {
        HttpSession session = request.getSession();
        String walletInfoVal = TheiaConstant.SessionDataAttributes.walletInfo.name();

        if (session == null) {
            throw new TheiaServiceException("WalletInfo does not available due to the session not exist");
        }

        WalletInfo walletInfo = session.getAttribute(walletInfoVal) == null ? null : WalletInfo.class.cast(session
                .getAttribute(walletInfoVal));
        if ((walletInfo == null) && createNew) {
            walletInfo = new WalletInfo();
            session.setAttribute(walletInfoVal, walletInfo);
        }
        if (walletInfo == null) {
            LOGGER.error("WalletInfo fetched from session is null");
        }
        return walletInfo;
    }
    @Override
    public void setUPITransactionInfoInSession(HttpServletRequest request, UPITransactionInfo upiTransactionInfo) {
        HttpSession session = request.getSession();

        if (session == null) {
            throw new TheiaServiceException("Unable to set UPITransactionInfo due to the Session does not exist");
        }

        session.setAttribute(TheiaConstant.SessionDataAttributes.upiTransactionInfo.name(), upiTransactionInfo);
    }

    @Override
    public void setUPIAccepted(HttpServletRequest request, boolean status) {
        request.getSession(false).setAttribute(TheiaConstant.ResponseConstants.UPI_ACCEPTED, status);
    }

    @Override
    public MerchantInfo getMerchantInfoFromSession(HttpServletRequest request, boolean createNew) {
        HttpSession session = request.getSession();
        String merchantInfoVal = TheiaConstant.SessionDataAttributes.merchInfo.name();

        if (session == null) {
            throw new TheiaServiceException("MerchantInfo does not available due to the session not exist");
        }

        MerchantInfo merchInfo = session.getAttribute(merchantInfoVal) == null ? null : MerchantInfo.class.cast(session
                .getAttribute(merchantInfoVal));
        if ((merchInfo == null) && createNew) {
            merchInfo = new MerchantInfo();
            session.setAttribute(merchantInfoVal, merchInfo);
        }
        if (merchInfo == null) {
            LOGGER.error("MerchantInfo fetched from session is null");
        }
        return merchInfo;
    }

    @Override
    public SavingsAccountInfo getSavingsAccountInfoFromSession(HttpServletRequest request, boolean createNew) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new TheiaServiceException("SavingsAccountInfo is not available due to session not exist");
        }
        SavingsAccountInfo savingsAccountInfo = session
                .getAttribute(TheiaConstant.SessionDataAttributes.savingsAccountInfo.name()) == null ? null
                : (SavingsAccountInfo) session.getAttribute(TheiaConstant.SessionDataAttributes.savingsAccountInfo
                .name());

        if ((savingsAccountInfo == null) && createNew) {
            savingsAccountInfo = new SavingsAccountInfo();
            session.setAttribute(TheiaConstant.SessionDataAttributes.savingsAccountInfo.name(), savingsAccountInfo);
        }
        if (savingsAccountInfo == null) {
            LOGGER.error("SavingsAccountInfo fetched from session is null");
        }
        return savingsAccountInfo;

    }
    @Override
    public RetryPaymentInfo getRetryPaymentInfoFromSession(HttpServletRequest request, boolean createNew) {
        HttpSession session = request.getSession();
        String retryPaymentInfoVal = TheiaConstant.SessionDataAttributes.retryPaymentInfo.name();

        if (session == null) {
            throw new TheiaServiceException("RetryPaymentInfo does not available due to the session not exist");
        }

        RetryPaymentInfo retryPaymentInfo = session.getAttribute(retryPaymentInfoVal) == null ? null
                : RetryPaymentInfo.class.cast(session.getAttribute(retryPaymentInfoVal));

        if ((retryPaymentInfo == null) && createNew) {
            retryPaymentInfo = new RetryPaymentInfo();
            session.setAttribute(retryPaymentInfoVal, retryPaymentInfo);
        }
        if (retryPaymentInfo == null) {
            LOGGER.error("RetryPaymentInfo fetched from session is null");
        }
        return retryPaymentInfo;
    }

    @Override
    public CardInfo getCardInfoFromSession(HttpServletRequest request, boolean createNew) {
        HttpSession session = request.getSession();
        String cardInfoVal = TheiaConstant.SessionDataAttributes.cardInfo.name();

        if (session == null) {
            throw new TheiaServiceException("CardInfo does not available due to the session not exist");
        }

        CardInfo cardInfo = session.getAttribute(cardInfoVal) == null ? null : CardInfo.class.cast(session
                .getAttribute(cardInfoVal));
        if ((cardInfo == null) && createNew) {
            cardInfo = new CardInfo();
            session.setAttribute(cardInfoVal, cardInfo);
        }
        if (cardInfo == null) {
            LOGGER.error("CardInfo fetched from session is null");
        }
        return cardInfo;
    }

    @Override
    public DigitalCreditInfo getDigitalCreditInfoFromSession(HttpServletRequest request, boolean createNew) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new TheiaServiceException("DigitalCreditInfo is not available due to session not exist");
        }
        DigitalCreditInfo digitalCreditInfo = session
                .getAttribute(TheiaConstant.SessionDataAttributes.digitalCreditInfo.name()) == null ? null
                : (DigitalCreditInfo) session
                .getAttribute(TheiaConstant.SessionDataAttributes.digitalCreditInfo.name());

        if ((digitalCreditInfo == null) && createNew) {
            digitalCreditInfo = new DigitalCreditInfo();
            session.setAttribute(TheiaConstant.SessionDataAttributes.digitalCreditInfo.name(), digitalCreditInfo);
        }
        if (digitalCreditInfo == null) {
            LOGGER.error("DigitalCreditInfo fetched from session is null");
        }
        return digitalCreditInfo;
    }

    @Override
    public MessageInfo getMessageInfoFromSession(HttpServletRequest request, boolean createNew) {
        HttpSession session = request.getSession();
        if (session == null) {
            throw new TheiaServiceException("Session does not exist");
        }
        MessageInfo messageInfo = session.getAttribute(TheiaConstant.SessionDataAttributes.messageInfo.name()) == null ? null
                : (MessageInfo) session.getAttribute(TheiaConstant.SessionDataAttributes.messageInfo.name());

        if ((messageInfo == null) && createNew) {
            messageInfo = new MessageInfo();
            session.setAttribute(TheiaConstant.SessionDataAttributes.messageInfo.name(), messageInfo);
        }

        if (messageInfo == null) {
            LOGGER.error("MessageInfo fetched from session is null");
        }
        return messageInfo;
    }

    public TransactionInfo getTxnInfoFromSession(HttpServletRequest request, boolean createNew) {
        HttpSession session = request.getSession();
        String txnInfoVal = TheiaConstant.SessionDataAttributes.txnInfo.name();

        if (session == null) {
            throw new TheiaServiceException("TxnInfo does not available due to the session not exist");
        }

        TransactionInfo txnInfo = session.getAttribute(txnInfoVal) == null ? null : TransactionInfo.class.cast(session
                .getAttribute(txnInfoVal));
        if ((txnInfo == null) && createNew) {
            txnInfo = new TransactionInfo(request);
            session.setAttribute(txnInfoVal, txnInfo);
        }

        if (txnInfo == null) {
            LOGGER.error("txnInfo fetched from session is null");
        }

        return txnInfo;
    }
    public ExtendedInfoRequestBean geExtendedInfoRequestBean(HttpServletRequest request, boolean createNew) {
        HttpSession session = request.getSession();
        String extendedInfoVal = TheiaConstant.SessionDataAttributes.extendedInfo.name();

        if (session == null) {
            throw new TheiaServiceException("ExtendedInfoRequestBean does not available due to the session not exist");
        }

        ExtendedInfoRequestBean extendedInfo = session.getAttribute(extendedInfoVal) == null ? null
                : ExtendedInfoRequestBean.class.cast(session.getAttribute(extendedInfoVal));
        if ((extendedInfo == null) && createNew) {
            extendedInfo = new ExtendedInfoRequestBean();
            session.setAttribute(extendedInfoVal, extendedInfo);
        }

        if (extendedInfo == null) {
            LOGGER.error("ExtendedInfo fetched from session is null");
        }
        return extendedInfo;
    }

    @Override
    public void setExtendedInfoRequestBean(HttpServletRequest request, ExtendedInfoRequestBean extendedInfoRequestBean) {
        HttpSession session = request.getSession();

        if (session == null) {
            throw new TheiaServiceException("Unable to set ExtendedInfoRequestBean due to the Session does not exist");
        }

        if (null == session.getAttribute(TheiaConstant.SessionDataAttributes.extendedInfo.name())) {
            session.setAttribute(TheiaConstant.SessionDataAttributes.extendedInfo.name(), extendedInfoRequestBean);
        }
    }

    @Override
    public LoginInfo getLoginInfoFromSession(HttpServletRequest request, boolean createNew) {
        HttpSession session = request.getSession();
        String loginInfoVal = TheiaConstant.SessionDataAttributes.loginInfo.name();

        if (session == null) {
            throw new TheiaServiceException("LoginInfo does not available due to the session does not exist");
        }

        LoginInfo loginInfo = session.getAttribute(loginInfoVal) == null ? null : LoginInfo.class.cast(session
                .getAttribute(loginInfoVal));
        if ((loginInfo == null) && createNew) {
            loginInfo = new LoginInfo();
            session.setAttribute(loginInfoVal, loginInfo);
        }

        if (loginInfo == null) {
            LOGGER.error("LoginInfo fetched from session is null");
        }
        return loginInfo;
    }

    @Override
    public EntityPaymentOptionsTO getEntityPaymentOptions(HttpServletRequest request, boolean createNew) {
        HttpSession session = request.getSession();
        return getEntityPaymentOptions(session, createNew);

    }

    public EntityPaymentOptionsTO getEntityPaymentOptions(HttpSession session, boolean createNew) {

        String entityPaymentOptionsVal = TheiaConstant.SessionDataAttributes.entityInfo.name();

        if (session == null) {
            throw new TheiaServiceException("EntityPaymentOptionsTO does not available due to the session not exist");
        }

        EntityPaymentOptionsTO entityPaymentOptionInfo = session.getAttribute(entityPaymentOptionsVal) == null ? null
                : EntityPaymentOptionsTO.class.cast(session.getAttribute(entityPaymentOptionsVal));

        if ((entityPaymentOptionInfo == null) && createNew) {
            entityPaymentOptionInfo = new EntityPaymentOptionsTO();
            session.setAttribute(entityPaymentOptionsVal, entityPaymentOptionInfo);
        }

        if (entityPaymentOptionInfo == null) {
            LOGGER.error("EntityPaymentInfo fetched from session is null");
        }
        return entityPaymentOptionInfo;
    }

    @Override
    public SarvatraVPAMapInfo getSarvatraVPAInfoFromSession(HttpServletRequest request, boolean createNew) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new TheiaServiceException("sarvatraVpainfo is not available due to session not exist");
        }
        SarvatraVPAMapInfo sarvatraVpainfo = session.getAttribute(TheiaConstant.SessionDataAttributes.sarvatraVpainfo
                .name()) == null ? null : (SarvatraVPAMapInfo) session
                .getAttribute(TheiaConstant.SessionDataAttributes.sarvatraVpainfo.name());

        if ((sarvatraVpainfo == null) && createNew) {
            sarvatraVpainfo = new SarvatraVPAMapInfo();
            session.setAttribute(TheiaConstant.SessionDataAttributes.sarvatraVpainfo.name(), sarvatraVpainfo);
        }
        return sarvatraVpainfo;
    }

    @Override
    public boolean isDirectChannelEnabled(String bankCode, String cardType, Set<String> directServiceInsts,
                                          boolean appendInstsAndCardType, Set<String> supportAtmPins) {
        try {
            if (appendInstsAndCardType) {
                directServiceInsts = directServiceInsts.stream().map(s -> s + "@" + cardType)
                        .collect(Collectors.toSet());
            }

            if (supportAtmPins == null) {
                LOGGER.info("SupportAtmPins field is null, returning false");
                return false;
            }
            for (DirectChannelBank directChannel : DirectChannelBank.values()) {
                if (bankCode.equals(directChannel.getBankCode())
                        && directServiceInsts.contains(directChannel + "@" + cardType)
                        && supportAtmPins.contains(directChannel.toString())) {
                    return true;
                }
            }

        } catch (Exception e) {
            LOGGER.error("Error while fetching or parsing direct-channels list", e.getMessage());
        }
        return false;
    }
}