package com.paytm.pgplus.upipsphandler.model;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

public class FetchQrDetailsV2Filter {
    public FetchQrDetailsV2Filter() {
    }

    public boolean equals(Object obj) {
        return StringUtils.equals("v2", MDC.get("version"));
    }
}
