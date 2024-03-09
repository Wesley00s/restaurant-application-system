package com.wesley.restaurant.application.system.service;

import com.wesley.restaurant.application.system.repository.ClientRepository;
import com.wesley.restaurant.application.system.repository.EmployeeRepository;
import com.wesley.restaurant.application.system.services.implemented.AuthorizationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorizationServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private AuthorizationService authorizationService;

    @Test
    public void loadUserByUsername_ClientExists_ShouldReturnClientUserDetails() {
        // Arrange
        String username = "client@example.com";
        UserDetails clientUserDetails = new UserDetails() {}; // Mocked ClientUserDetails
        when(clientRepository.findByEmail(username)).thenReturn(clientUserDetails);

        // Act
        UserDetails userDetails = authorizationService.loadUserByUsername(username);

        // Assert
        assertNotNull(userDetails);
        assertEquals(clientUserDetails, userDetails);

        // Verify that clientRepository.findByEmail(username) was called
        verify(clientRepository, times(1)).findByEmail(username);
        // Verify that employeeRepository.findByEmail(username) was NOT called
        verify(employeeRepository, never()).findByEmail(username);
    }

    @Test
    public void loadUserByUsername_EmployeeExists_ShouldReturnEmployeeUserDetails() {
        // Arrange
        String username = "employee@example.com";
        EmployeeUserDetails employeeUserDetails = new EmployeeUserDetails(); // Mocked EmployeeUserDetails
        when(employeeRepository.findByEmail(username)).thenReturn(employeeUserDetails);

        // Act
        UserDetails userDetails = authorizationService.loadUserByUsername(username);

        // Assert
        assertNotNull(userDetails);
        assertEquals(employeeUserDetails, userDetails);

        // Verify that employeeRepository.findByEmail(username) was called
        verify(employeeRepository, times(1)).findByEmail(username);
        // Verify that clientRepository.findByEmail(username) was NOT called
        verify(clientRepository, never()).findByEmail(username);
    }

    @Test
    public void loadUserByUsername_UserDoesNotExist_ShouldThrowUsernameNotFoundException() {
        // Arrange
        String username = "nonexistent@example.com";
        when(clientRepository.findByEmail(username)).thenReturn(null);
        when(employeeRepository.findByEmail(username)).thenReturn(null);

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> authorizationService.loadUserByUsername(username));

        // Verify that clientRepository.findByEmail(username) was called
        verify(clientRepository, times(1)).findByEmail(username);
        // Verify that employeeRepository.findByEmail(username) was called
        verify(employeeRepository, times(1)).findByEmail(username);
    }
}
