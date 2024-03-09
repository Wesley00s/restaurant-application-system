package com.wesley.restaurant.application.system.services;

import com.wesley.restaurant.application.system.repository.ClientRepository;
import com.wesley.restaurant.application.system.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService{
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    public AuthorizationService(ClientRepository clientRepository, EmployeeRepository employeeRepository) {
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails clientUser = clientRepository.findByEmail(username);
        if (clientUser != null) {
            return clientUser;
        }

        UserDetails employeeUser = employeeRepository.findByEmail(username);
        if (employeeUser != null) {
            return employeeUser;
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}

