package com.paytm.pgplus.upipsphandler.model;

import com.paytm.pgplus.common.enums.EPayMethod;
import com.paytm.pgplus.common.model.nativ.NativeConsultDetails;
import com.paytm.pgplus.response.BaseResponseBody;

import java.util.Map;

public class FetchPcfDetailResponseBody extends BaseResponseBody {

    private Map<EPayMethod, NativeConsultDetails> consultDetails;

    public Map<EPayMethod, NativeConsultDetails> getConsultDetails() {
        return consultDetails;
    }

    public void setConsultDetails(Map<EPayMethod, NativeConsultDetails> consultDetails) {
        this.consultDetails = consultDetails;
    }
}
