package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytm.pgplus.facade.exception.FacadeCheckedException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class JsonMapper {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectMapper getterAccessOM = new ObjectMapper();

    static {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        TimeZone timeZone = TimeZone.getTimeZone("IST");
        sdf.setTimeZone(timeZone);
        objectMapper.setDateFormat(sdf);
        getterAccessOM.setDateFormat(sdf);
        // SimpleModule module = new SimpleModule();
        // module.addDeserializer(Date.class, new DateDeserializer());
        // module.addSerializer(Date.class, new DateSerializer());
        // objectMapper.registerModule(module);
        objectMapper.setTimeZone(TimeZone.getTimeZone("IST"));
        getterAccessOM.setTimeZone(TimeZone.getTimeZone("IST"));
        // objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        getterAccessOM.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // for Jackson version 2.X
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        getterAccessOM.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        getterAccessOM.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
    }

    public static String mapObjectToJson(final Object object) throws FacadeCheckedException {
        try {
            if (object != null) {
                final String resultString = objectMapper.writeValueAsString(object);
                return resultString;
            }
            return null;
        } catch (final IOException e) {
            throw new FacadeCheckedException(e);
        }
    }

    public static <T> T mapJsonToObject(final String jsonObject, final Class<T> clazz) throws FacadeCheckedException {
        try {
            final T returnValue = objectMapper.readValue(jsonObject, clazz);
            return returnValue;
        } catch (final Exception e) {
            throw new FacadeCheckedException(e);
        }
    }

    public static <T> T readValue(String fromValue, TypeReference<?> typeReference) throws IOException {
        return (T) objectMapper.readValue(fromValue, typeReference);
    }
}