package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Address;
import com.wesley.restaurant.application.system.entity.Employee;
import com.wesley.restaurant.application.system.enumeration.Occupancy;

import java.time.LocalDate;

public class EmployeeDto {
    private final String employeeName;
    private final Occupancy occupancy;
    private final LocalDate hiringDate;
    private final String email;
    private final String password;
    private final String city;
    private final String street;
    private final String zipCode;

    public EmployeeDto(String employeeName, Occupancy occupancy, LocalDate hiringDate, String email, String password, String city, String street, String zipCode) {
        this.employeeName = employeeName;
        this.occupancy = occupancy;
        this.hiringDate = hiringDate;
        this.email = email;
        this.password = password;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public Employee toEntity() {
        return new Employee(
                this.employeeName,
                this.occupancy,
                this.hiringDate,
                this.email,
                this.password,
                new Address(
                        this.city,
                        this.street,
                        this.zipCode
                )
        );
    }
}
