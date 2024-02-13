package com.wesley.restaurant.application.system.entity;

import jakarta.persistence.*;

@Entity
public class EatingTable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tableId;

    @Column(nullable = false)
    private int tableCapacity;

    private boolean available;

    public EatingTable(int tableCapacity, boolean available) {
        this.tableCapacity = tableCapacity;
        this.available = available;
    }

    public EatingTable() {

    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public int getTableCapacity() {
        return tableCapacity;
    }

    public void setTableCapacity(int tableCapacity) {
        this.tableCapacity = tableCapacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
