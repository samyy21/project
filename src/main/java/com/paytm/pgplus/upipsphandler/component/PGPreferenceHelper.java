package com.paytm.pgplus.upipsphandler.component;

import com.paytm.pgplus.biz.utils.BizConstant;
import com.paytm.pgplus.biz.utils.Ff4jUtils;
import com.paytm.pgplus.upipsphandler.service.IMerchantPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PGPreferenceHelper {

    @Autowired
    private Ff4jUtils ff4jUtils;

    @Autowired
    @Qualifier("merchantPreferenceService")
    private IMerchantPreferenceService merchantPreferenceService;

    public boolean checkPgAutologinEnabledFlag(String mid) {

        boolean isPgAutoLoginEnabled = !merchantPreferenceService.isPgAutoLoginDisabled(mid, false);

        if (!ff4jUtils
                .isFeatureEnabledOnMid(mid, BizConstant.Ff4jFeature.DISABLE_CHECKING_AUTOLOGIN_ENABLE_PREF, false)) {
            isPgAutoLoginEnabled = merchantPreferenceService.isPgAutoLoginEnabled(mid, true);
        }
        return isPgAutoLoginEnabled;
    }
}

