package com.danielsanchez.coffeeshake_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tables")
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idTable;

    private int tableNumber;

    private boolean enabled;

    @OneToMany(mappedBy = "tables", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();

    public Tables() { }

    public Tables(UUID idTable, int tableNumber, boolean enabled, Set<Order> orders) {
        this.idTable = idTable;
        this.tableNumber = tableNumber;
        this.enabled = enabled;
        this.orders = orders;
    }

    public UUID getIdTable() {
        return idTable;
    }

    public void setIdTable(UUID idTable) {
        this.idTable = idTable;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}
