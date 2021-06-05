package com.sawcunha.controlerelatorio.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_message_erro")
public class MessageErro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message_erro")
    private Long id;

    @Column(name = "identifier")
    private Integer identifier;

    @Column(name = "status")
    private Integer status;

    @Column(name = "message")
    private String message;

    @Column(name = "reason")
    private String reason;

    public MessageErro() {
        this.status = 418;
        this.message = "Realmente não foi possivel validar as coisas aqui";
        this.reason = "Não possui erros configurados nessa aplicação";
    }

    public MessageErro(Integer status, String message, String reason) {
        this.status = status;
        this.message = message;
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
