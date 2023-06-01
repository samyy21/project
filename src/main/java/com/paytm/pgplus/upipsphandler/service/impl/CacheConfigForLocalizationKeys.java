package com.paytm.pgplus.upipsphandler.service.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheStats;
import com.paytm.pgplus.common.config.ConfigurationUtil;
import com.paytm.pgplus.upipsphandler.constants.TheiaConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.guava.GuavaCacheManager;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfigForLocalizationKeys {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheConfigForLocalizationKeys.class);

    private static GuavaCacheManager cacheManager;

    @Bean
    public static CacheManager localizationCacheManager() {
        cacheManager = new GuavaCacheManager(TheiaConstant.CacheConstant.LOCALIZATION_KEYS_CACHE);
        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder
                .newBuilder()
                .maximumSize(Long.parseLong(ConfigurationUtil.getProperty(TheiaConstant.CacheConstant.MAXIMUM_SIZE, "20")))
                .expireAfterWrite(Long.parseLong(ConfigurationUtil.getProperty(TheiaConstant.CacheConstant.EXPIRY_TIME, "24")),
                        TimeUnit.HOURS).recordStats();
        cacheManager.setCacheBuilder(cacheBuilder);
        return cacheManager;
    }

    public static GuavaCache getCache() {
        if (cacheManager == null) {
            LOGGER.info("cacheManager found null. Initializing !");
            localizationCacheManager();
        }
        return (GuavaCache) cacheManager.getCache(TheiaConstant.CacheConstant.LOCALIZATION_KEYS_CACHE);
    }

    public static CacheStats getStats() {
        return getCache().getNativeCache().stats();
    }

    public static Long getCacheSize() {
        return getCache().getNativeCache().size();
    }
}
