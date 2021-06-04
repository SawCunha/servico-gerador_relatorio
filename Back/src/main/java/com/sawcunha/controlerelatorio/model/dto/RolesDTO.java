package com.sawcunha.controlerelatorio.model.dto;

import com.sawcunha.controlerelatorio.enums.eTypeRole;

import javax.persistence.*;
import java.io.Serializable;

public class RolesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private eTypeRole typeRole;

    private eTypeRole levelRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public eTypeRole getTypeRole() {
        return typeRole;
    }

    public void setTypeRole(eTypeRole typeRole) {
        this.typeRole = typeRole;
    }

    public eTypeRole getLevelRole() {
        return levelRole;
    }

    public void setLevelRole(eTypeRole levelRole) {
        this.levelRole = levelRole;
    }

}
