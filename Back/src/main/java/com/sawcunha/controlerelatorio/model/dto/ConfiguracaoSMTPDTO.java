package com.sawcunha.controlerelatorio.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ConfiguracaoSMTPDTO {

    private Long id;

    @NotNull
    @NotEmpty
    private String smtp;

    @NotNull
    @Size(max = 65535)
    private Integer porta;

    @NotNull
    @NotEmpty
    private String usuario;

    @NotNull
    @NotEmpty
    private String senha;

    private boolean utilizaTLS;

    private String senhaTexto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isUtilizaTLS() {
        return utilizaTLS;
    }

    public void setUtilizaTLS(boolean utilizaTLS) {
        this.utilizaTLS = utilizaTLS;
    }

    public String getSenhaTexto() {
        return senhaTexto;
    }

    public void setSenhaTexto(String senhaTexto) {
        this.senhaTexto = senhaTexto;
    }
}
