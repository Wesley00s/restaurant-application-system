package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.EatingTable;

public class EatingTableView {
    private final Long tableId;
    private final Integer tableCapacity;
    private final Boolean available;

    public EatingTableView(Long tableId, Integer tableCapacity, Boolean available) {
        this.tableId = tableId;
        this.tableCapacity = tableCapacity;
        this.available = available;
    }

    public EatingTableView(EatingTable eatingTable) {
        this (
            eatingTable.getTableId(),
            eatingTable.getTableCapacity(),
            eatingTable.isAvailable()
        );
    }

    public Long getTableId() {
        return tableId;
    }

    public Integer getTableCapacity() {
        return tableCapacity;
    }

    public Boolean getAvailable() {
        return available;
    }
}
