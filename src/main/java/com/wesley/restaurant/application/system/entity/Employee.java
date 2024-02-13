package com.wesley.restaurant.application.system.entity;

import com.wesley.restaurant.application.system.enumeration.Occupancy;
import jakarta.persistence.*;

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
    private Address employeeAddress;

    protected Employee(String employeeName, Occupancy occupancy, LocalDate hiringDate, Address employeeAddress) {
        this.employeeName = employeeName;
        this.occupancy = occupancy;
        this.hiringDate = hiringDate;
        this.employeeAddress = employeeAddress;
    }

    public Employee() {

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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
}
