package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Client;
import com.wesley.restaurant.application.system.entity.User;
import com.wesley.restaurant.application.system.enumeration.Role;
public record ClientView (
        Long clientId,
        String clientName,
        String numberPhone,
        String email,
        String password,
        String cpf,
        String city,
        String street,
        String zipCode,
        Role role
) {
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
}
