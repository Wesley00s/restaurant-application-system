package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Client;

public class ClientView {
    private Long clientId;
    private String clientName;
    private String numberPhone;
    private String email;
    private String password;
    private String cpf;
    private String city;
    private String street;
    private String zipCode;

    public ClientView() {}

    public ClientView(Long clientId, String clientName, String numberPhone, String email, String password, String cpf, String city, String street, String zipCode) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.numberPhone = numberPhone;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public ClientView(Client client) {
        this(
            client.getClientId(),
            client.getClientName(),
            client.getNumberPhone(),
            client.getEmail(),
            client.getPassword(),
            client.getCpf(),
            client.getAddress().getCity(),
            client.getAddress().getStreet(),
            client.getAddress().getZipCode()
        );
    }

    public Long getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }
}
