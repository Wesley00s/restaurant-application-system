package com.wesley.restaurant.application.system.entity;

import com.wesley.restaurant.application.system.enumeration.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.wesley.restaurant.application.system.enumeration.Status.CLOSE;

@Entity
public class Request {
    @Id
    private UUID idRequest = UUID.randomUUID();

    @Column(nullable = false)
    private LocalDateTime dateTimeRequest = LocalDateTime.now();

    @Column(nullable = false)
    private Status status = CLOSE;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "tableId")
    private EatingTable eatingTable;

    @ManyToOne
    @JoinColumn(name = "employId")
    private Employee employee;

    public Request(Client client, Item item, EatingTable eatingTable, Employee employee) {
        this.client = client;
        this.item = item;
        this.eatingTable = eatingTable;
        this.employee = employee;
    }

    public Request() {

    }

    public UUID getIdRequest() {
        return idRequest;
    }

    public LocalDateTime getDateTimeRequest() {
        return dateTimeRequest;
    }

    public void setDateTimeRequest(LocalDateTime dateTimeRequest) {
        this.dateTimeRequest = dateTimeRequest;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public EatingTable getEatingTable() {
        return eatingTable;
    }

    public void setEatingTable(EatingTable eatingTable) {
        this.eatingTable = eatingTable;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
