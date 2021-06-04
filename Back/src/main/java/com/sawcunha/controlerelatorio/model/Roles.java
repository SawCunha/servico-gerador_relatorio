package com.sawcunha.controlerelatorio.model;

import com.sawcunha.controlerelatorio.enums.eTypeRole;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private eTypeRole typeRole;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
