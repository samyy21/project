//package com.paytm.pgplus.upipsphandler.preredis.impl;
//
//import com.google.common.cache.CacheBuilder;
//import com.google.common.cache.CacheStats;
//import org.springframework.cache.guava.GuavaCacheManager;
//import com.paytm.pgplus.common.config.ConfigurationUtil;
//import com.paytm.pgplus.upipsphandler.constants.TheiaConstant.CacheConstant;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//@EnableCaching
//public class CacheConfigForRedisKeys {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(CacheConfigForRedisKeys.class);
//
//    private static GuavaCacheManager cacheManager;
//
//    @Bean
//    @Primary
//    public static CacheManager timeoutCacheManager() {
//        cacheManager = new GuavaCacheManager(CacheConstant.REDIS_KEYS_CACHE);
//        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder
//                .newBuilder()
//                .maximumSize(Long.parseLong(ConfigurationUtil.getProperty(CacheConstant.MAXIMUM_SIZE, "1000")))
//                .expireAfterWrite(Long.parseLong(ConfigurationUtil.getProperty(CacheConstant.EXPIRY_TIME, "3")),
//                        TimeUnit.SECONDS).recordStats();
//        cacheManager.setCacheBuilder(cacheBuilder);
//        return cacheManager;
//    }
//
//    public static GuavaCache getCache() {
//        if (cacheManager == null) {
//            LOGGER.info("cacheManager found null. Initializing !");
//            timeoutCacheManager();
//        }
//        return (GuavaCache) cacheManager.getCache(CacheConstant.REDIS_KEYS_CACHE);
//    }
//
//    public static CacheStats getStats() {
//        return getCache().getNativeCache().stats();
//    }
//
//    public static Long getCacheSize() {
//        return getCache().getNativeCache().size();
//    }
//}
//
