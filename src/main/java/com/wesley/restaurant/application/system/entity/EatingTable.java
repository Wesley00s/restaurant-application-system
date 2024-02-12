package com.wesley.restaurant.application.system.entity;

import jakarta.persistence.*;

@Entity
public class EatingTable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;

    @Column(nullable = false)
    private Integer tableCapacity;


    private Boolean available;

    public EatingTable(Long tableId, Integer tableCapacity, Boolean available) {
        this.tableId = tableId;
        this.tableCapacity = tableCapacity;
        this.available = available;
    }

    public EatingTable() {

    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Integer getTableCapacity() {
        return tableCapacity;
    }

    public void setTableCapacity(Integer tableCapacity) {
        this.tableCapacity = tableCapacity;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
