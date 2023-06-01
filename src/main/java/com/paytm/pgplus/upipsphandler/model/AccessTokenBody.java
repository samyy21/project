package com.paytm.pgplus.upipsphandler.model;

public class AccessTokenBody {

    private String token;
    private boolean idempotent;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isIdempotent() {
        return idempotent;
    }

    public void setIdempotent(boolean idempotent) {
        this.idempotent = idempotent;
    }
}

