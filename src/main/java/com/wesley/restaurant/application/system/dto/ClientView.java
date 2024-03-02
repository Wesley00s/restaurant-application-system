package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Client;
import com.wesley.restaurant.application.system.entity.User;
import com.wesley.restaurant.application.system.enumeration.Role;

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
    private Role role;

    public ClientView() {}

    public ClientView(Long clientId, String clientName, String numberPhone, String email, String password, String cpf, String city, String street, String zipCode, Role role) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.numberPhone = numberPhone;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.role = role;
    }

    public ClientView(Client client) {
        this(
            client.getUserId(),
            client.getUserName(),
            client.getNumberPhone(),
            client.getEmail(),
            client.getPassword(),
            client.getCpf(),
            client.getAddress().getCity(),
            client.getAddress().getStreet(),
            client.getAddress().getZipCode(),
            client.getRole()
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

    public Role getRole() {
        return role;
    }
}
