package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Employee;

import java.time.LocalDate;

public class EmployeeView {
    private final Long employeeId;
    private final String userName;
    private final String numberPhone;
    private final String email;
    private final String password;
    private final String cpf;
    private final String city;
    private final String street;
    private final String zipCode;
    private final LocalDate hiringDate;

    public EmployeeView(Long employeeId, String userName, String numberPhone, String email, String password, String cpf, String city, String street, String zipCode, LocalDate hiringDate) {
        this.employeeId = employeeId;
        this.userName = userName;
        this.numberPhone = numberPhone;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.hiringDate = hiringDate;
    }

    public EmployeeView(Employee employee) {
        this (
                employee.getUserId(),
                employee.getUserName(),
                employee.getNumberPhone(),
                employee.getEmail(),
                employee.getPassword(),
                employee.getCpf(),
                employee.getAddress().getCity(),
                employee.getAddress().getStreet(),
                employee.getAddress().getZipCode(),
                employee.getHiringDate()
        );
    }

    public String getUserName() {
        return userName;
    }


    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getCpf() {
        return cpf;
    }

    public Long getEmployeeId() {
        return employeeId;
    }
}
