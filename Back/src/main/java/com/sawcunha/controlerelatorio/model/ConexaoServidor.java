package com.sawcunha.controlerelatorio.model;

import com.sawcunha.controlerelatorio.enums.eTipoDatabase;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ConexaoServidor")
public class ConexaoServidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDConexaoServidor")
    private Long id;

    @Column(name = "Identificador")
    private UUID identificador;

    @Column(name = "IPAddress")
    private String ip;

    @Column(name = "Porta")
    private Integer porta;

    @Enumerated(EnumType.STRING)
    @Column(name = "TipoDatabase")
    private eTipoDatabase tipoDatabase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public eTipoDatabase getTipoDatabase() {
        return tipoDatabase;
    }

    public void setTipoDatabase(eTipoDatabase tipoDatabase) {
        this.tipoDatabase = tipoDatabase;
    }
}
