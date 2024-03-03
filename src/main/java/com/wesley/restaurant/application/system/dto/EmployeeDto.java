package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Address;
import com.wesley.restaurant.application.system.entity.Employee;
//import com.wesley.restaurant.application.system.enumeration.Occupancy;
//import com.wesley.restaurant.application.system.enumeration.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record EmployeeDto (
        @NotEmpty(message = "Employee name may be not empty") String employeeName,
        @NotEmpty(message = "Employee number phone may be not empty") String numberPhone,
        @NotEmpty(message = "Employee email may be not empty") @Email(message = "Email invalid") String email,
        @NotEmpty(message = "Employee password may be not empty") String password,
        @NotEmpty(message = "Employee CPF may be not empty") @CPF(message = "Invalid CPF") String cpf,
        @NotEmpty(message = "Employee city may be not empty") String city,
        @NotEmpty(message = "Employee street may be not empty") String street,
        @NotEmpty(message = "Employee zipcode may be not empty") String zipCode,
        LocalDate hiringDate
) {
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
}