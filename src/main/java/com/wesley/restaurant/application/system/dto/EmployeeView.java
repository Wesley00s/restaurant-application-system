package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Address;
import com.wesley.restaurant.application.system.entity.Employee;
import com.wesley.restaurant.application.system.enumeration.Occupancy;

import java.time.LocalDate;

public class EmployeeView {
    private final String employeeName;
    private final Occupancy occupancy;
    private final LocalDate hiringDate;
    private final String email;
    private final String password;
    private final String city;
    private final String street;
    private final String zipCode;

    public EmployeeView(String employeeName, Occupancy occupancy, LocalDate hiringDate, String email, String password, String city, String street, String zipCode) {
        this.employeeName = employeeName;
        this.occupancy = occupancy;
        this.hiringDate = hiringDate;
        this.email = email;
        this.password = password;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public EmployeeView(Employee employee) {
        this (
                employee.getEmployeeName(),
                employee.getOccupancy(),
                employee.getHiringDate(),
                employee.getEmail(),
                employee.getPassword(),
                employee.getEmployeeAddress().getCity(),
                employee.getEmployeeAddress().getStreet(),
                employee.getEmployeeAddress().getZipCode()
        );
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Occupancy getOccupancy() {
        return occupancy;
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
}
