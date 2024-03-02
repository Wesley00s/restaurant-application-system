package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RequestDto {
    private Long clientId;
    private final String clientName;
    private final String numberPhone;
    private final String email;
    private final String password;
    private final String cpf;
    private final String city;
    private final String street;
    private final String zipCode;
    private Long itemId;
    private final String itemName;
    private final BigDecimal itemPrice;
    private final String itemDesc;
    private final List<Ingredient> ingredients;
    private Long tableId;
    private final Integer tableCapacity;
    private final Boolean available;
    private Long employeeId;
    private final String employeeName;
    private final String numberPhoneEmployee;
    private final LocalDate hiringDate;
    private final String emailEmployee;
    private final String passwordEmployee;
    private final String cpfEmployee;
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
            List<Ingredient> ingredients,
            Long tableId,
            Integer tableCapacity,
            Boolean available,
            Long employeeId,
            String employeeName,
            String numberPhoneEmployee,
            LocalDate hiringDate,
            String emailEmployee,
            String passwordEmployee,
            String cpfEmployee,
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
        this.ingredients = ingredients;
        this.tableId = tableId;
        this.tableCapacity = tableCapacity;
        this.available = available;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.numberPhoneEmployee = numberPhoneEmployee;
        this.hiringDate = hiringDate;
        this.emailEmployee = emailEmployee;
        this.passwordEmployee = passwordEmployee;
        this.cpfEmployee = cpfEmployee;
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
                        this.itemDesc,
                        this.ingredients
                ),
                new EatingTable(
                        this.tableId,
                        this.tableCapacity,
                        this.available
                ),
                 new Employee(
                         this.employeeId,
                         this.employeeName,
                         this.numberPhoneEmployee,
                         this.emailEmployee,
                         this.passwordEmployee,
                         this.cpfEmployee,
                         new Address(
                                 this.cityEmployee,
                                 this.streetEmployee,
                                 this.zipCodeEmployee
                         ),
                         this.hiringDate
                 )
        );
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}