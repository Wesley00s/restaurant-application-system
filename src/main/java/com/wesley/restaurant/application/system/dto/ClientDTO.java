package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Address;
import com.wesley.restaurant.application.system.entity.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

public record ClientDTO(
        @NotEmpty(message = "Client name may be not empty") String clientName,
        @NotEmpty(message = "Client number phone may be not empty") String numberPhone,
        @NotEmpty(message = "Client email may be not empty") @Email(message = "Invalid email") String email,
        @NotEmpty(message = "Client password may be not empty") String password,
        @NotEmpty(message = "Client CPF may be not empty") @CPF(message = "Invalid CPF") String cpf,
        @NotEmpty(message = "Client city may be not empty") String city,
        @NotEmpty(message = "Client street may be not empty") String street,
        @NotEmpty(message = "Client zipcode may be not empty") String zipCode
) {
    public Client toEntity() {
        return new Client(
                this.clientName,
                this.numberPhone,
                this.email,
                this.password,
                this.cpf,
                new Address(
                        this.city,
                        this.street,
                        this.zipCode
                )
        );
    }
}