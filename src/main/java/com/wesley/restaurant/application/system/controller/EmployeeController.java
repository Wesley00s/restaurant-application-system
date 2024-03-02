package com.wesley.restaurant.application.system.controller;

import com.wesley.restaurant.application.system.dto.EmployeeDto;
import com.wesley.restaurant.application.system.dto.EmployeeView;
import com.wesley.restaurant.application.system.entity.Employee;
import com.wesley.restaurant.application.system.services.implemented.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
//    @PreAuthorize("hasRole('MANAGERS')")
    public ResponseEntity<String> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        Employee employee = this.employeeService.save(employeeDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Employee " + employee.getEmail() + " saved!");
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('MANAGERS', 'USERS')")
    public ResponseEntity<EmployeeView> findById(@PathVariable Long id) {
        Employee employee = this.employeeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new EmployeeView(employee));
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('MANAGERS')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        this.employeeService.deleteById(id);
    }
}
