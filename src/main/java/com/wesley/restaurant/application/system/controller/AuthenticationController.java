package com.wesley.restaurant.application.system.controller;

import com.wesley.restaurant.application.system.dto.AuthenticationDTO;
import com.wesley.restaurant.application.system.dto.ClientDto;
import com.wesley.restaurant.application.system.dto.EmployeeDto;
import com.wesley.restaurant.application.system.dto.LoginResponseDTO;
import com.wesley.restaurant.application.system.entity.Client;
import com.wesley.restaurant.application.system.entity.Employee;
import com.wesley.restaurant.application.system.entity.User;
import com.wesley.restaurant.application.system.infra.TokenService;
import com.wesley.restaurant.application.system.services.implemented.ClientService;
import com.wesley.restaurant.application.system.services.implemented.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    private final AuthenticationManager manager;
    private final ClientService clientService;
    private final EmployeeService employeeService;
    private final TokenService tokenService;

    @Autowired
    public AuthenticationController(AuthenticationManager manager, ClientService clientService, EmployeeService employeeService, TokenService tokenService) {
        this.manager = manager;
        this.clientService = clientService;
        this.employeeService = employeeService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthenticationDTO data) {
        System.out.println("> Into login postMapping");
        try {
            Authentication usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            var auth = this.manager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());

            return ResponseEntity.status(HttpStatus.OK)
                    .body("User successfully logged! " + new LoginResponseDTO(token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Authentication processes failed");
        }
    }

    @PostMapping("/client-register")
    public ResponseEntity<String> register(@RequestBody @Valid ClientDto data) {
        if(this.clientService.findByEmail(data.toEntity().getEmail()) != null) return ResponseEntity.badRequest().build();
        String encryptPassword = new BCryptPasswordEncoder().encode(data.toEntity().getPassword());
        Client client = data.toEntity();
        client.setPassword(encryptPassword);

        this.clientService.save(client);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Client " + client.getEmail() + " | " + client.getPassword() + "  saved!");
    }

    @PostMapping("/employee-register")
    public ResponseEntity<String> register(@RequestBody @Valid EmployeeDto data) {
        if(this.employeeService.findByEmail(data.toEntity().getEmail()) != null) return ResponseEntity.badRequest().build();
        String encryptPassword = new BCryptPasswordEncoder().encode(data.toEntity().getPassword());
        Employee employee = data.toEntity();
        employee.setPassword(encryptPassword);

        this.employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Employee " + employee.getEmail() + " | " + employee.getPassword() + "  saved!");
    }
}
