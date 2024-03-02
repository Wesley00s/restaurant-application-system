package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Ingredient;
import com.wesley.restaurant.application.system.entity.Request;

import java.util.List;
import java.util.stream.LongStream;

public class RequestView {

    private final Long clientId;
    private final Long itemId;
    private final Long tableId;
    private final Long employeeId;

    private List<Ingredient> ingredients;

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
                request.getClient().getUserId(),
                request.getItem().getItemId(),
                request.getEatingTable().getTableId(),
                request.getEmployee().getUserId()
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
