package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Address;
import com.wesley.restaurant.application.system.entity.Client;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;

public class ClientDto {

    private final String clientName;
    private final String numberPhone;
    private final String email;
    private final String password;
    private final String cpf;
    private final String city;
    private final String street;
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