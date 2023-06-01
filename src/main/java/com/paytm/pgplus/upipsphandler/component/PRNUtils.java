package com.paytm.pgplus.upipsphandler.component;

import com.paytm.pgplus.theia.redis.ITheiaTransactionalRedisUtil;
import com.paytm.pgplus.upipsphandler.enums.EventNameEnum;
import com.paytm.pgplus.upipsphandler.service.IMerchantPreferenceService;
import com.paytm.pgplus.upipsphandler.service.ITicketQueryServiceImpl;
import com.paytm.pgplus.upipsphandler.utils.EventUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PRNUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(PRNUtils.class);

    private static final String PRN = "PRN";

    @Autowired
    @Qualifier("ticketQueryServiceImpl")
    private ITicketQueryServiceImpl ticketQueryServiceImpl;

    @Autowired
    @Qualifier("merchantPreferenceService")
    private IMerchantPreferenceService merchantPreferenceService;

    @Autowired
    private ITheiaTransactionalRedisUtil theiaTransactionalRedisUtil;

    public boolean checkIfPRNEnabled(String paytmMID) {
        return merchantPreferenceService.isPRNEnabled(paytmMID)
                || merchantPreferenceService.isDynamicQR2FAEnabledWithPCF(paytmMID);
    }

    public String fetchPRN(String paytmMid, String acquirementId) {

        EventUtils.pushTheiaEvents(EventNameEnum.PRN_REQUESTED);
        String prnFromCache = fetchPRNFromCache(acquirementId);

        if (StringUtils.isNotBlank(prnFromCache)) {
            EventUtils.pushTheiaEvents(EventNameEnum.PRN_RECIEVED);
            return prnFromCache;
        }

        return ticketQueryServiceImpl.fetchTicketQueryPRN(paytmMid, acquirementId);
    }

    private String fetchPRNFromCache(String acquirementId) {

        String key = new StringBuilder(PRN).append("_").append(acquirementId).toString();

        String prnValue = (String) theiaTransactionalRedisUtil.get(key);

        if (prnValue != null) {
            theiaTransactionalRedisUtil.del(key);
        }

        return prnValue;
    }
}
