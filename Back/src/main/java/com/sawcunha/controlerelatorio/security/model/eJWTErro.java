package com.sawcunha.controlerelatorio.security.model;

public enum eJWTErro {
    EXPIRED(1), SIGNING_ERRO(2), VERIFIER_ERRO(3), NOT_HAS_TOKEN(4), GENERIC(0);

    private final int cod;

    eJWTErro(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }
}
