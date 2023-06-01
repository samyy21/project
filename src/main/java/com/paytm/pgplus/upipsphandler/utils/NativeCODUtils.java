package com.paytm.pgplus.upipsphandler.utils;

import com.paytm.pgplus.cache.model.PaytmProperty;
import com.paytm.pgplus.upipsphandler.constants.TheiaConstant;
import com.paytm.pgplus.upipsphandler.service.IConfigurationDataService;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("nativeCodUtils")
public class NativeCODUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(NativeCODUtils.class);

    @Autowired
    @Qualifier("configurationDataService")
    private IConfigurationDataService configurationDataService;

    public String getMinimumCodAmount() {

        PaytmProperty paytmProperty = configurationDataService
                .getPaytmProperty(TheiaConstant.ExtraConstants.COD_MIN_AMOUNT);
        if ((paytmProperty != null) && NumberUtils.isNumber(paytmProperty.getValue())) {
            return paytmProperty.getValue();
        }

        LOGGER.info("Error in fetching property : {} ", TheiaConstant.ExtraConstants.COD_MIN_AMOUNT);
        return null;
    }

}
