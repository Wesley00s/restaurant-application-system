package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
