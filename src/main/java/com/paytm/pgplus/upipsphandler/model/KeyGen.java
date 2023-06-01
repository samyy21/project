package com.paytm.pgplus.upipsphandler.model;

import java.io.Serializable;

public interface KeyGen extends Serializable {

    abstract String generateCacheKey();

    String CACHE_KEY_DELIMITER = "_";
    String QUERY_STRING_SEPARATOR = "/";
    String QUESTION_MARK = "?";
    String EQUALS = "=";
}
