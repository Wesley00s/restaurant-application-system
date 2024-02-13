package com.wesley.restaurant.application.system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private String numberPhone;

    @Column(nullable = false, unique = true) @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true) @CPF
    private String cpf;

    @Column(nullable = false) @Embedded
    private Address address;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST},
            mappedBy = "client")
    private List<Request> requests;

    public Client(String clientName, String numberPhone, String email, String password, String cpf, Address address) {
        this.clientName = clientName;
        this.numberPhone = numberPhone;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.address = address;
    }
    public Client(Long clientId, String clientName, String numberPhone, String email, String password, String cpf, Address address) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.numberPhone = numberPhone;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.address = address;
    }

    public Client() {

    }

    public Client(Long clientId) {
    }

    public long getClientId() {
        return clientId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
