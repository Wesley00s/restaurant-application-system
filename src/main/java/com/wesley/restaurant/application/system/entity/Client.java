package com.wesley.restaurant.application.system.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private String numberPhone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false) @Embedded
    private Address address;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST},
            mappedBy = "client")
    private List<Item> items;

    public Client(long clientId, String clientName, String numberPhone, String email, String cpf, Address address) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.numberPhone = numberPhone;
        this.email = email;
        this.cpf = cpf;
        this.address = address;
    }

    public Client() {

    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
