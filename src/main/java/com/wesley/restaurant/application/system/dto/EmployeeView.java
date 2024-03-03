package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Employee;

import java.time.LocalDate;

public record EmployeeView(
        Long employeeId,
        String userName,
        String numberPhone,
        String email,
        String password,
        String cpf,
        String city,
        String street,
        String zipCode,
        LocalDate hiringDate
) {
    public EmployeeView(Employee employee) {
        this(
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
}