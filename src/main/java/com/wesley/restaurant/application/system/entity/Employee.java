package com.wesley.restaurant.application.system.entity;

import com.wesley.restaurant.application.system.enumeration.Occupancy;
import jakarta.persistence.*;

import java.sql.DataTruncation;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(nullable = false)
    private String employeeName;

    @Column(nullable = false)
    private Occupancy occupancy;

    @Column(nullable = false)
    private LocalDate hiringDate;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Address employeeAddress;

    public Employee(Long employeeId, String employeeName, Occupancy occupancy, LocalDate hiringDate, String email, String password, Address employeeAddress) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.occupancy = occupancy;
        this.hiringDate = hiringDate;
        this.email = email;
        this.password = password;
        this.employeeAddress = employeeAddress;
    }

    public Employee(String employeeName, Occupancy occupancy, LocalDate hiringDate, String email, String password, Address employeeAddress) {
        this.employeeName = employeeName;
        this.occupancy = occupancy;
        this.hiringDate = hiringDate;
        this.email = email;
        this.password = password;
        this.employeeAddress = employeeAddress;
    }

    public Employee() {

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Occupancy getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(Occupancy occupancy) {
        this.occupancy = occupancy;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Address getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(Address employeeAddress) {
        this.employeeAddress = employeeAddress;
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
}
