package com.paytm.pgplus.upipsphandler.model;

import com.paytm.pgplus.upipsphandler.enums.MappingServiceResultCode;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MappingServiceResultInfo implements Serializable {

    public MappingServiceResultInfo(MappingServiceResultCode mappingServiceResultCode) {
        this.resultCode = mappingServiceResultCode.getResultCode();
        this.resultStatus = mappingServiceResultCode.getStatus();
        this.messaage = mappingServiceResultCode.getMessage();
    }

    public MappingServiceResultInfo(String resultMsg) {
        this.resultCode = MappingServiceResultCode.FAIL.getResultCode();
        this.resultStatus = MappingServiceResultCode.FAIL.getStatus();
        this.messaage = resultMsg;
    }

    private static final long serialVersionUID = 6471824859196729115L;

    private String resultCode;
    private String resultStatus;
    private String messaage;

    /**
     * @param resultCode2
     */
    public void setResultCode(MappingServiceResultCode mappingServiceResultCode) {
        this.resultCode = mappingServiceResultCode.getResultCode();
        this.resultStatus = mappingServiceResultCode.getStatus();
        this.messaage = mappingServiceResultCode.getMessage();
    }

    public void setResultCodeOnly (String resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultCodeAndMessage(MappingServiceResultCode mappingServiceResultCode, String msg) {
        this.resultCode = mappingServiceResultCode.getResultCode();
        this.resultStatus = mappingServiceResultCode.getStatus();
        this.messaage = msg;
    }

}
