package com.wesley.restaurant.application.system.entity;

import com.wesley.restaurant.application.system.enumeration.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Request {
    @Id
    private final UUID idOrder = UUID.randomUUID();

    @Column(nullable = false)
    private LocalDateTime dateTimeOrder;

    @Column(nullable = false)
    private Status status;

    public Request(LocalDateTime dateTimeOrder, Status status) {
        this.dateTimeOrder = dateTimeOrder;
        this.status = status;
    }

    public Request() {

    }

    public UUID getIdOrder() {
        return idOrder;
    }

    public LocalDateTime getDateTimeOrder() {
        return dateTimeOrder;
    }

    public void setDateTimeOrder(LocalDateTime dateTimeOrder) {
        this.dateTimeOrder = dateTimeOrder;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
