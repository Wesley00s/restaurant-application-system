package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Address;
import com.wesley.restaurant.application.system.entity.Employee;
import com.wesley.restaurant.application.system.enumeration.Occupancy;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EmployeeDto {
    @NotEmpty(message = "Employee name may be not empty")
    private final String employeeName;
    private final Occupancy occupancy;
    private final LocalDate hiringDate;
    @NotEmpty(message = "Employee email may be not empty")
    @Email(message = "Email invalid")
    private final String email;
    @NotEmpty(message = "Employee password may be not empty")
    private final String password;
    @NotEmpty(message = "Employee city may be not empty")
    private final String city;
    @NotEmpty(message = "Employee street may be not empty")
    private final String street;
    @NotEmpty(message = "Employee zipcode may be not empty")
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
