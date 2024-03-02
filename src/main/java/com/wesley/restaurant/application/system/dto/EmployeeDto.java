package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Address;
import com.wesley.restaurant.application.system.entity.Employee;
//import com.wesley.restaurant.application.system.enumeration.Occupancy;
//import com.wesley.restaurant.application.system.enumeration.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class EmployeeDto {
    @NotEmpty(message = "Employee name may be not empty")
    private String employeeName;
    @NotEmpty(message = "Employee number phone may be not empty")
    private String numberPhone;
    @NotEmpty(message = "Employee email may be not empty")
    @Email(message = "Email invalid")
    private String email;
    @NotEmpty(message = "Employee password may be not empty")
    private String password;
    @NotEmpty(message = "Employee CPF may be not empty")
    @CPF(message = "Invalid CPF")
    private String cpf;
    @NotEmpty(message = "Employee city may be not empty")
    private String city;
    @NotEmpty(message = "Employee street may be not empty")
    private String street;
    @NotEmpty(message = "Employee zipcode may be not empty")
    private String zipCode;
    private final LocalDate hiringDate;

    public EmployeeDto(String employeeName, String numberPhone, String email, String password, String cpf, String city, String street, String zipCode, LocalDate hiringDate) {
        this.employeeName = employeeName;
        this.numberPhone = numberPhone;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.hiringDate = hiringDate;
    }

    public Employee toEntity() {
        return new Employee(
                this.employeeName,
                this.numberPhone,
                this.email,
                this.password,
                this.cpf,
                new Address(
                        this.city,
                        this.street,
                        this.zipCode
                ),
                this.hiringDate
        );
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    public LocalDate getHiringDate() {
        return hiringDate;
    }
}
