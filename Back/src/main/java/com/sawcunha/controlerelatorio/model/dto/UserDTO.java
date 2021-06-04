package com.sawcunha.controlerelatorio.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private UUID identifier;

    private String name;

    private String username;

    private String password;

    private String email;

    private LocalDateTime create;

    private boolean active;

    private RolesDTO rolesDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreate() {
        return create;
    }

    public void setCreate(LocalDateTime create) {
        this.create = create;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public RolesDTO getRolesDTO() {
        return rolesDTO;
    }

    public void setRolesDTO(RolesDTO rolesDTO) {
        this.rolesDTO = rolesDTO;
    }
}
