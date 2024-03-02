package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Address;
import com.wesley.restaurant.application.system.entity.Client;
import com.wesley.restaurant.application.system.entity.User;
import com.wesley.restaurant.application.system.enumeration.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

public class ClientDto {

    @NotEmpty(message = "Client name may be not empty")
    private String clientName;
    @NotEmpty(message = "Client number phone may be not empty")
    private String numberPhone;
    @NotEmpty(message = "Client email may be not empty")
    @Email(message = "Invalid email")
    private String email;
    @NotEmpty(message = "Client password may be not empty")
    private String password;
    @NotEmpty(message = "Client CPF may be not empty")
    @CPF(message = "Invalid CPF")
    private String cpf;
    @NotEmpty(message = "Client city may be not empty")
    private String city;
    @NotEmpty(message = "Client street may be not empty")
    private String street;
    @NotEmpty(message = "Client zipcode may be not empty")
    private String zipCode;

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
                )
       );
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}