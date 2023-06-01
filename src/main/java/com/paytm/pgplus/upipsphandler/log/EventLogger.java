package com.paytm.pgplus.upipsphandler.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytm.pgplus.upipsphandler.enums.EventNameEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.StringJoiner;

public class EventLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger("EVENT_LOGGER");

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static final long DEFALUT_EVENT_VALUE = 1L;
    private static final String DEFAULT_PARAM_STRING = "";

    public static void pushEventLog(String merchantId, String orderId, EventNameEnum eventNameEnum, long value,
                                    Map<String, String> metaData) {

        String eventInfo = eventLogBuilder(merchantId, orderId, eventNameEnum.getEventName(), value, metaData);
        LOGGER.info(eventInfo);
    }
    public static void pushEventLog(String merchantId, String orderId, EventNameEnum eventNameEnum, Map<String, String> metaData) {
        String eventInfo = eventLogBuilder(merchantId, orderId, eventNameEnum.getEventName(), 1L, metaData);
        LOGGER.info(eventInfo);
    }

    private static String convertToJSONSting(Map<String, String> metaData) {

        try {
            return objectMapper.writeValueAsString(metaData);
        } catch (Exception e) {
            LOGGER.error("Problem while pushing events for {}", metaData);
        }

        return DEFAULT_PARAM_STRING;
    }

    private static String eventLogBuilder(String mid, String orderId, String msg, long value,
            Map<String, String> metaData) {
        StringJoiner eventInfo = new StringJoiner(",");
        String metaDataJSONSting = DEFAULT_PARAM_STRING;
        SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        Date date = new Date();
        if (metaData != null)
            metaDataJSONSting = convertToJSONSting(metaData);
        eventInfo.add(mid != null ? mid : DEFAULT_PARAM_STRING).add(orderId != null ? orderId : DEFAULT_PARAM_STRING)
                .add(msg).add(String.valueOf(value)).add(now.format(date)).add(metaDataJSONSting);

        return eventInfo.toString();
    }

    public static void logResponseCode(String apiName, EventNameEnum eventNameEnum, String responseCode,
                                       String responseMsg) {
        LOGGER.info("{},\"api\":\"{}\",\"responseCode\":\"{}\",\"responseMsg\":\"{}\"", eventNameEnum, apiName,
                responseCode, responseMsg);
    }


}
