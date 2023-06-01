package com.paytm.pgplus.upipsphandler.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class UserDefinedFields implements Serializable {
    private static final long serialVersionUID = 7507573572538503251L;
    private String udf1;
    private String udf2;
    private String udf3;
    private String udf4;
    private String udf5;

    public String getUdf1() {
        return this.udf1;
    }

    public void setUdf1(String udf1) {
        this.udf1 = udf1;
    }

    public String getUdf2() {
        return this.udf2;
    }

    public void setUdf2(String udf2) {
        this.udf2 = udf2;
    }

    public String getUdf3() {
        return this.udf3;
    }

    public void setUdf3(String udf3) {
        this.udf3 = udf3;
    }

    public String getUdf4() {
        return this.udf4;
    }

    public void setUdf4(String udf4) {
        this.udf4 = udf4;
    }

    public String getUdf5() {
        return this.udf5;
    }

    public void setUdf5(String udf5) {
        this.udf5 = udf5;
    }

    public UserDefinedFields() {
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserDefinedFields [udf1=").append(this.udf1).append(", udf2=").append(this.udf2).append(", udf3=").append(this.udf3).append(", udf4=").append(this.udf4).append(", udf5=").append(this.udf5).append("]");
        return builder.toString();
    }
}

