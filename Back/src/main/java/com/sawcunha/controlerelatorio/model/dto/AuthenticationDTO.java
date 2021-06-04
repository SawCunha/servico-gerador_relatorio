package com.sawcunha.controlerelatorio.model.dto;

import java.io.Serializable;

public class AuthenticationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;

    public AuthenticationDTO() {
    }

    public AuthenticationDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthenticationDTO{" +
                "token='" + token + '\'' +
                '}';
    }
}
