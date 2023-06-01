package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paytm.pgplus.upipsphandler.enums.TokenType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestHeader extends BaseHeader {

    /**
     *
     */
    private static final long serialVersionUID = -2276386631764189639L;

    @ApiModelProperty(required = true)
    @NotBlank(message = "This will be option for native payments")
    private String token;

    @NotNull(message = "This will be option for native payments")
    private TokenType tokenType;

    private String requestTimestamp;

    public RequestHeader() {

    }

    public RequestHeader(BaseHeader baseHeader) {
        super(baseHeader.getMid(), baseHeader.getClientId(), baseHeader.getVersion(), baseHeader.getRequestId());
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public String getRequestTimestamp() {
        return requestTimestamp;
    }

    public void setRequestTimestamp(String requestTimestamp) {
        this.requestTimestamp = requestTimestamp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RequestHeader{");
        sb.append(", tokenType=").append(tokenType);
        sb.append(", requestTimestamp='").append(requestTimestamp).append('\'');
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}

