package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.*;
import com.wesley.restaurant.application.system.enumeration.Occupancy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RequestDto {
    private final Long clientId;
    private final String clientName;
    private final String numberPhone;
    private final String email;
    private final String password;
    private final String cpf;
    private final String city;
    private final String street;
    private final String zipCode;
    private final Long itemId;
    private final String itemName;
    private final BigDecimal itemPrice;
    private final String itemDesc;
    private final Long tableId;
    private final Integer tableCapacity;
    private final Boolean available;
    private final Long employeeId;
    private final String employeeName;
    private final Occupancy occupancy;
    private final LocalDate hiringDate;
    private final String emailEmployee;
    private final String passwordEmployee;
    private final String cityEmployee;
    private final String streetEmployee;
    private final String zipCodeEmployee;

    public RequestDto(
            Long clientId,
            String clientName,
            String numberPhone,
            String email,
            String password,
            String cpf,
            String city,
            String street,
            String zipCode,
            Long itemId,
            String itemName,
            BigDecimal itemPrice,
            String itemDesc,
            Long tableId,
            Integer tableCapacity,
            Boolean available, Long employeeId,
            String employeeName,
            Occupancy occupancy,
            LocalDate hiringDate,
            String emailEmployee,
            String passwordEmployee,
            String cityEmployee,
            String streetEmployee,
            String zipCodeEmployee
    ) {
        this.clientId = clientId;

        this.clientName = clientName;
        this.numberPhone = numberPhone;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDesc = itemDesc;
        this.tableId = tableId;
        this.tableCapacity = tableCapacity;
        this.available = available;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.occupancy = occupancy;
        this.hiringDate = hiringDate;
        this.emailEmployee = emailEmployee;
        this.passwordEmployee = passwordEmployee;
        this.cityEmployee = cityEmployee;
        this.streetEmployee = streetEmployee;
        this.zipCodeEmployee = zipCodeEmployee;
    }

    public Request toEntity() {
         return new Request(
                 new Client(
                        this.clientId,
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
                ),
                new Item(
                        this.itemId,
                        this.itemName,
                        this.itemPrice,
                        this.itemDesc
                ),
                new EatingTable(
                        this.tableId,
                        this.tableCapacity,
                        this.available
                ),
                new Employee(
                        this.employeeId,
                        this.employeeName,
                        this.occupancy,
                        this.hiringDate,
                        this.emailEmployee,
                        this.passwordEmployee,
                        new Address(
                                this.cityEmployee,
                                this.streetEmployee,
                                this.zipCodeEmployee
                        )
                )
        );
    }
}