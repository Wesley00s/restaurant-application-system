package com.wesley.restaurant.application.system.services.implemented;

import com.wesley.restaurant.application.system.entity.Employee;
import com.wesley.restaurant.application.system.repository.EmployeeRepository;
import com.wesley.restaurant.application.system.services.IEmployeeService;

import java.util.Optional;

public class EmployeeService implements IEmployeeService {
    private EmployeeRepository employeeRepository;

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
}
