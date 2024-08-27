package com.danielsanchez.coffeeshake_backend.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idRole;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<UserRole> userRoles = new HashSet<>();

    public Role() {
    }

    public Role(UUID idRole, String name, Set<UserRole> userRoles) {
        this.idRole = idRole;
        this.name = name;
        this.userRoles = userRoles;
    }

    public UUID getIdRole() {
        return idRole;
    }

    public void setIdRole(UUID idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
