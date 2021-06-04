package com.sawcunha.controlerelatorio.security.model;

import org.springframework.security.core.Authentication;

import java.util.Optional;

public class JwtValidation {

    private Optional<Authentication> authenticationOptional;
    private boolean valid;
    private eJWTErro jwtErro;
    private String aaa;

    public JwtValidation() {
        this.authenticationOptional = Optional.empty();
    }

    public Optional<Authentication> getAuthenticationOptional() {
        return authenticationOptional;
    }

    public void setAuthenticationOptional(Authentication authenticationOptional) {
        this.authenticationOptional = Optional.of(authenticationOptional);
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public eJWTErro getJwtErro() {
        return jwtErro;
    }

    public void setJwtErro(eJWTErro jwtErro) {
        this.jwtErro = jwtErro;
        this.setValid(false);
    }

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }
}
