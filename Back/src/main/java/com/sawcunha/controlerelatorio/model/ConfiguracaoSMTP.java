package com.sawcunha.controlerelatorio.model;

import javax.persistence.*;

@Entity
@Table(name = "ConfiguracaoSMTP")
public class ConfiguracaoSMTP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDConfiguracaoSMTP")
    private Long id;

    @Column(name = "SMTP")
    private String smtp;

    @Column(name = "Porta")
    private Integer porta;

    @Column(name = "Usuario")
    private String usuario;

    @Column(name = "Senha")
    private String senha;

    @Column(name = "UtilizaTLS")
    private boolean utilizaTLS;

    @Transient
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
