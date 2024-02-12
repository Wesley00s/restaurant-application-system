package com.wesley.restaurant.application.system.controller;

import com.wesley.restaurant.application.system.dto.EmployeeDto;
import com.wesley.restaurant.application.system.dto.EmployeeView;
import com.wesley.restaurant.application.system.entity.Employee;
import com.wesley.restaurant.application.system.services.implemented.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    private ResponseEntity<String> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        Employee employee = this.employeeService.save(employeeDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Employee " + employee.getEmail() + " saved!");
    }

    @GetMapping("/{id}")
    private ResponseEntity<EmployeeView> findById(@PathVariable Long id) {
        Employee employee = this.employeeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new EmployeeView(employee));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(@PathVariable Long id) {
        this.employeeService.deleteById(id);
    }
}
