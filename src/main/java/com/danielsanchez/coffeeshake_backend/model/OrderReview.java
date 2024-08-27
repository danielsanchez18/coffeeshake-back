package com.danielsanchez.coffeeshake_backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "review_order")
public class OrderReview {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idReview;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    private int qualification;
    private String comment;
    private LocalDateTime date;

    public OrderReview() { }

    public OrderReview(UUID idReview, Order order, User user, int qualification, String comment, LocalDateTime date) {
        this.idReview = idReview;
        this.order = order;
        this.user = user;
        this.qualification = qualification;
        this.comment = comment;
        this.date = date;
    }

    public UUID getIdReview() {
        return idReview;
    }

    public void setIdReview(UUID idReview) {
        this.idReview = idReview;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
