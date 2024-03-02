package com.wesley.restaurant.application.system.services;

import com.wesley.restaurant.application.system.entity.Employee;
import org.springframework.security.core.userdetails.UserDetails;

public interface IEmployeeService {
    Employee save(Employee employee);
    Employee findById(Long employeeId);
    void deleteById(Long employeeId);
    UserDetails findByEmail(String email);

}
