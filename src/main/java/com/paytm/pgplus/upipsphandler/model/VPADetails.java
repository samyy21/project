package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class VPADetails implements Serializable {

    private static final long serialVersionUID = -7643826411056759958L;

    @ApiModelProperty(required = true)
    @NotBlank
    private String vpa;

    public VPADetails() {
    }

    public String getVpa() {
        return this.vpa;
    }

    public void setVpa(String vpa) {
        this.vpa = vpa;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VPADetails{");
        sb.append("vpa='").append(vpa).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
