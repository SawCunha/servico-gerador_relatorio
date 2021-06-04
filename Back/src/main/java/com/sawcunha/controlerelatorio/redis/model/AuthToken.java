package com.sawcunha.controlerelatorio.redis.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

@Component
public class AuthToken implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;
    private UUID uuid;

    public AuthToken(String token, UUID uuid) {
        this.token = token;
        this.uuid = uuid;
    }

    public AuthToken() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "AuthToken{" +
                "token='" + token + '\'' +
                ", uuid=" + uuid +
                '}';
    }
}
