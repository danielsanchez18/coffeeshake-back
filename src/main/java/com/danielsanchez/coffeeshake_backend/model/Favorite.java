package com.danielsanchez.coffeeshake_backend.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "favorite")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idFavorite;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    public Favorite() { }

    public Favorite(UUID idFavorite, User user, Product product) {
        this.idFavorite = idFavorite;
        this.user = user;
        this.product = product;
    }

    public UUID getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(UUID idFavorite) {
        this.idFavorite = idFavorite;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
