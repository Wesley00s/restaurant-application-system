package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Request;
import com.wesley.restaurant.application.system.enumeration.Occupancy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RequestView {

    private final Long clientId;
    private final Long itemId;
    private final Long tableId;
    private final Long employeeId;

    public RequestView(
            Long clientId,
            Long itemId,
            Long tableId,
            Long employeeId
    ) {
        this.clientId = clientId;
        this.itemId = itemId;
        this.tableId = tableId;
        this.employeeId = employeeId;
    }

    public RequestView(Request request) {
        this (
                request.getClient().getClientId(),
                request.getItem().getItemId(),
                request.getEatingTable().getTableId(),
                request.getEmployee().getEmployeeId()
        );
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getItemId() {
        return itemId;
    }

    public Long getTableId() {
        return tableId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }
}
