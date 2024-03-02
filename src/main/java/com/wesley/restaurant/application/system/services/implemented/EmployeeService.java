package com.wesley.restaurant.application.system.services.implemented;

import com.wesley.restaurant.application.system.entity.Employee;
import com.wesley.restaurant.application.system.repository.EmployeeRepository;
import com.wesley.restaurant.application.system.services.IEmployeeService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employer ID " + employeeId + " not found"));
    }

    @Override
    public void deleteById(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        if (optionalEmployee.isPresent()) {
            Employee employeeToDelete = optionalEmployee.get();
            employeeRepository.delete(employeeToDelete);
        } else {
            throw new RuntimeException("Employee with ID " + employeeId + " not found");
        }
    }

    @Override
    public UserDetails findByEmail(String email) {
        return this.employeeRepository.findByEmail(email);
    }
}
