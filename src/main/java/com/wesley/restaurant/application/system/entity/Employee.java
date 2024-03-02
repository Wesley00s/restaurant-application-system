package com.wesley.restaurant.application.system.entity;

import com.wesley.restaurant.application.system.enumeration.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "employee_id")
public class Employee extends User {
    @Column(nullable = false)
    private LocalDate hiringDate;

    public Employee(String userName, String numberPhone, String email, String password, String cpf, Address address, LocalDate hiringDate) {
        super(userName, numberPhone, email, password, cpf, address, Role.WAITER);
        this.hiringDate = hiringDate;
    }
    public Employee(Long employeeId, String userName, String numberPhone, String email, String password, String cpf, Address address, LocalDate hiringDate) {
        super(employeeId, userName, numberPhone, email, password, cpf, address, Role.WAITER);
        this.hiringDate = hiringDate;
    }

    public Employee() {

    }

    public Employee(Long employeeId) {
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.getRole().equals(Role.ADMIN)) return List.of(
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_CHEF"),
                new SimpleGrantedAuthority("ROLE_WAITER"),
                new SimpleGrantedAuthority("ROLE_CLIENT")

        );

        else if (this.getRole().equals(Role.CHEF)) return List.of(
                new SimpleGrantedAuthority("ROLE_CHEF"),
                new SimpleGrantedAuthority("ROLE_WAITER"),
                new SimpleGrantedAuthority("ROLE_CLIENT")
        );

         return List.of(
                new SimpleGrantedAuthority("ROLE_WAITER"),
                new SimpleGrantedAuthority("ROLE_CLIENT")
        );
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
