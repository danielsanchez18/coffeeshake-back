package com.danielsanchez.coffeeshake_backend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idCategory;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    public Category() { }

    public Category(UUID idCategory, String name, Set<Product> products) {
        this.idCategory = idCategory;
        this.name = name;
        this.products = products;
    }

    public UUID getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(UUID idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
