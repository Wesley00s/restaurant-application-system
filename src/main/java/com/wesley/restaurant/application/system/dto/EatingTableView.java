package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.EatingTable;

public record EatingTableView (
        Long tableId,
        Integer tableCapacity,
        Boolean available
) {
    public EatingTableView(EatingTable eatingTable) {
        this (
            eatingTable.getTableId(),
            eatingTable.getTableCapacity(),
            eatingTable.isAvailable()
        );
    }
}
