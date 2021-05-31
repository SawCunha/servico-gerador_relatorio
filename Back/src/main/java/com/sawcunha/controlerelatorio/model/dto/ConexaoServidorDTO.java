package com.sawcunha.controlerelatorio.model.dto;

import com.sawcunha.controlerelatorio.enums.eTipoDatabase;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class ConexaoServidorDTO {

    private Long id;

    @NotNull
    private UUID identificador;

    @NotNull
    @NotEmpty
    @NotBlank

    private String ip;

    @NotNull
    @Size(max = 65535)
    private Integer porta;

    @NotNull
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
