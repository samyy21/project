package com.paytm.pgplus.upipsphandler.service.helper;

import com.google.common.base.Splitter;
import com.paytm.pgplus.biz.utils.ConfigurationUtil;
import com.paytm.pgplus.biz.utils.Ff4jUtils;
import com.paytm.pgplus.facade.user.models.UserDetails;
import com.paytm.pgplus.facade.user.models.UserPreference;
import com.paytm.pgplus.facade.user.models.response.GetUserPreferenceResponse;
import com.paytm.pgplus.facade.user.services.IUserPreferenceService;
import com.paytm.pgplus.logging.ExtendedLogger;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service("upsHelp")
public class UPSHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.paytm.pgplus.theia.nativ.UPSHelper.class);
    private static final ExtendedLogger EXT_LOGGER = ExtendedLogger.create(com.paytm.pgplus.theia.nativ.UPSHelper.class);
    @Autowired
    private IUserPreferenceService userPreferenceService;
    @Autowired
    private Environment env;
    @Autowired
    private Ff4jUtils ff4jUtils;

    public UPSHelper() {
    }

    public void updateUserPostpaidAccStatusFromUPS(UserDetails userDetails) {
        List<UserPreference> userPreferences = this.getUserPostpaidDetailsFromUPS(userDetails.getUserId());
        if (userPreferences != null) {
            String oneClickActivateStatus = null;
            Optional<UserPreference> userEligibileForPostpaidOnboarding = userPreferences.stream().filter((preference) -> {
                return "ocl.lending.postpaid.pg_onboarding_activated_flow".equals(preference.getKey());
            }).findFirst();
            if (userEligibileForPostpaidOnboarding.isPresent()) {
                if (StringUtils.isNotBlank(((UserPreference)userEligibileForPostpaidOnboarding.get()).getValue())) {
                    oneClickActivateStatus = ((UserPreference)userEligibileForPostpaidOnboarding.get()).getValue();
                } else {
                    LOGGER.error("User postpaid onboarding preference received as blank from UPS for userId: {}", userDetails.getUserId());
                }
            }

            String postpaidCreditLimit = null;
            Optional<UserPreference> userPostpaidCreditLimit = userPreferences.stream().filter((preference) -> {
                return "ocl.lending.postpaid.pg_onboarding_approved_limit".equals(preference.getKey());
            }).findFirst();
            if (userPostpaidCreditLimit.isPresent()) {
                if (StringUtils.isNotBlank(((UserPreference)userPostpaidCreditLimit.get()).getValue())) {
                    postpaidCreditLimit = ((UserPreference)userPostpaidCreditLimit.get()).getValue();
                } else {
                    LOGGER.error("User postpaid credit limit received as blank from UPS for userId: {}", userDetails.getUserId());
                }
            }

            Boolean isTxnBeforeExpiry = false;
            Optional<UserPreference> userOneClickActivateExpiry = userPreferences.stream().filter((preference) -> {
                return "ocl.lending.postpaid.pg_onboarding_expiry".equals(preference.getKey());
            }).findFirst();
            if (userOneClickActivateExpiry.isPresent()) {
                isTxnBeforeExpiry = this.validateOnceClickExpiry(((UserPreference)userOneClickActivateExpiry.get()).getValue());
            }

            if (StringUtils.isNotBlank(oneClickActivateStatus) && !"INACTIVE".equalsIgnoreCase(oneClickActivateStatus) && isTxnBeforeExpiry) {
                userDetails.setUserEligibileForPostPaidOnboarding(true);
                userDetails.setPostpaidCreditLimit(postpaidCreditLimit);
                userDetails.setPostpaidOnboardingStageMsg(this.getPostPaidOnboardingStageMsg(oneClickActivateStatus, postpaidCreditLimit));
            }

            Optional<UserPreference> userPostpaidStatus = userPreferences.stream().filter((preference) -> {
                return "ocl.lending.postpaid.account_status".equals(preference.getKey());
            }).findFirst();
            if (userPostpaidStatus.isPresent()) {
                String postpaidStatus = ((UserPreference)userPostpaidStatus.get()).getValue();
                if (StringUtils.isNotBlank(postpaidStatus)) {
                    userDetails.setPaytmCCEnabled(StringUtils.equals(postpaidStatus, "active"));
                } else {
                    LOGGER.error("User postpaid status received as blank from UPS for userId: {}", userDetails.getUserId());
                }
            }

        }
    }

    private String getPostPaidOnboardingStageMsg(String oneClickActivateStatus, String postpaidCreditLimit) {
        String onbordingActivtedFlowMsg = ConfigurationUtil.getTheiaProperty("onbording.activeted.flow.value");
        Map<String, String> onbordingActivtedFlowMap = new HashMap();
        if (StringUtils.isNotEmpty(onbordingActivtedFlowMsg)) {
            onbordingActivtedFlowMap = this.splitToMap(onbordingActivtedFlowMsg);
        }

        String message = (String)((Map)onbordingActivtedFlowMap).get(StringUtils.lowerCase(oneClickActivateStatus));
        if (StringUtils.isEmpty(message)) {
            message = (String)((Map)onbordingActivtedFlowMap).get("default");
        }

        message = this.updateCreditLimitInMessage(oneClickActivateStatus, postpaidCreditLimit, message);
        return message;
    }

    private String updateCreditLimitInMessage(String oneClickActivateStatus, String postpaidCreditLimit, String message) {
        if (StringUtils.isNotEmpty(message) && message.contains("{credit_limit}")) {
            if (StringUtils.isNotBlank(postpaidCreditLimit)) {
                message = message.replace("{credit_limit}", postpaidCreditLimit);
            } else if ("2-click".equalsIgnoreCase(StringUtils.lowerCase(oneClickActivateStatus)) || "default".equalsIgnoreCase(StringUtils.lowerCase(oneClickActivateStatus))) {
                message = message.replace("{credit_limit}", "60,000");
            }
        }

        return message;
    }

    private Map<String, String> splitToMap(String messages) {
        return Splitter.on("|").withKeyValueSeparator(":").split(messages);
    }

    public List<UserPreference> getUserPostpaidDetailsFromUPS(String userId) {
        if (StringUtils.isBlank(userId)) {
            LOGGER.error("userId cannot be blank");
            return null;
        } else {
            List<String> preferencesList = new ArrayList();
            preferencesList.add("ocl.lending.postpaid.account_status");
            preferencesList.add("ocl.lending.postpaid.pg_onboarding_activated_flow");
            preferencesList.add("ocl.lending.postpaid.pg_onboarding_approved_limit");
            preferencesList.add("ocl.lending.postpaid.pg_onboarding_expiry");

            try {
                GetUserPreferenceResponse userPreferenceResponse = this.userPreferenceService.getUserPreference(userId, preferencesList, ConfigurationUtil.getTheiaProperty("ups.jwt.client.id"), this.env.getProperty("ups.jwt.secret.key"));
                if (this.isValidGetUserPrefResponse(userPreferenceResponse)) {
                    return userPreferenceResponse.getResponse().getPreferences();
                }

                LOGGER.info("Recieved invalid Postpaid user preference response from UPS: {}", userPreferenceResponse);
            } catch (Exception var5) {
                LOGGER.error("Exception occurred while fetching User Postpaid status from UPS {}", var5);
            }

            return null;
        }
    }

    private boolean isValidGetUserPrefResponse(GetUserPreferenceResponse userPreferenceResponse) {
        return userPreferenceResponse != null && userPreferenceResponse.getStatusInfo() != null && "SUCCESS".equals(userPreferenceResponse.getStatusInfo().getStatus()) && userPreferenceResponse.getResponse() != null && CollectionUtils.isNotEmpty(userPreferenceResponse.getResponse().getPreferences());
    }

    public void updateUserPostpaidAccStatusFromUPS(String mid, UserDetails userDetails) {
        if (this.ff4jUtils.isFeatureEnabledOnMid(mid, "theia.enableGetUserPostpaidStatusFromUPS", false)) {
            EXT_LOGGER.customInfo("Fetching user postpaid details from UPS");
            this.updateUserPostpaidAccStatusFromUPS(userDetails);
        }

    }
//
//    public String getUserPostpaidAccStatusFromUPS(String userId) {
//        List<UserPreference> userPreferences = this.getUserPostpaidDetailsFromUPS(userId);
//        if (userPreferences != null) {
//            Optional<UserPreference> userPostpaidStatus = userPreferences.stream().filter((preference) -> {
//                return "ocl.lending.postpaid.account_status".equals(preference.getKey());
//            }).findFirst();
//            return (String)userPostpaidStatus.map(UserPreference::getValue).orElse(null);
//        } else {
//            return null;
//        }
//    }

    private Boolean validateOnceClickExpiry(String oneClickExpiry) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate oneClickExpiryDate = LocalDate.parse(oneClickExpiry, formatter);
            LocalDate currentDate = LocalDate.now();
            if (currentDate.isBefore(oneClickExpiryDate)) {
                return true;
            }
        } catch (Exception var5) {
            LOGGER.error("Unable to validate oneClickActivateExpiry : ", var5);
            return false;
        }

        return false;
    }
}
