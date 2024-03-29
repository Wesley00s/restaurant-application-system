package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.EatingTable;
import jakarta.validation.constraints.NotNull;

public class EatingTableDto {
    private final Long tableId;
    @NotNull(message = "Table capacity may be not null")
    private Integer tableCapacity;
    private Boolean available;

    public EatingTableDto(Long tableId, Integer tableCapacity, Boolean available) {
        this.tableId = tableId;
        this.tableCapacity = tableCapacity;
        this.available = available;
    }

    public EatingTable toEntity() {
        return new EatingTable(
                this.tableId,
                this.tableCapacity,
                this.available
        );
    }


    public Integer getTableCapacity() {
        return tableCapacity;
    }

    public void setTableCapacity(Integer tableCapacity) {
        this.tableCapacity = tableCapacity;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
