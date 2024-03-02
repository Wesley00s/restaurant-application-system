package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    UserDetails findByEmail(String email);
}
