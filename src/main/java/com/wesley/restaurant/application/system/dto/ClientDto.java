package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Address;
import com.wesley.restaurant.application.system.entity.Client;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

public class ClientDto {

    @NotEmpty(message = "Client name may be not empty")
    private final String clientName;
    @NotEmpty(message = "Client number phone may be not empty")
    private final String numberPhone;
    @NotEmpty(message = "Client email may be not empty")
    @Email(message = "Invalid email")
    private final String email;
    @NotEmpty(message = "Client password may be not empty")
    private final String password;
    @NotEmpty(message = "Client CPF may be not empty")
    @CPF(message = "Invalid CPF")
    private final String cpf;
    @NotEmpty(message = "Client city may be not empty")
    private final String city;
    @NotEmpty(message = "Client street may be not empty")
    private final String street;
    @NotEmpty(message = "Client zipcode may be not empty")
    private final String zipCode;

    public ClientDto(String clientName, String numberPhone, String email, String password, String cpf, String city, String street, String zipCode) {
        this.clientName = clientName;
        this.numberPhone = numberPhone;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

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
                ));
    }
}