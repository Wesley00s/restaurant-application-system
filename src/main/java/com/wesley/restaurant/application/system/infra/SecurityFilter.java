package com.wesley.restaurant.application.system.infra;

import com.wesley.restaurant.application.system.services.implemented.ClientService;
import com.wesley.restaurant.application.system.services.implemented.EmployeeService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    TokenService tokenService;
    ClientService clientService;
    EmployeeService employeeService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if (token != null) {
            var login = tokenService.validateToken(token);
            UserDetails client = clientService.findByEmail(login);
            UserDetails employee = employeeService.findByEmail(login);

            if (client != null) {
                var authenticationClient = new UsernamePasswordAuthenticationToken(client, null, client.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationClient);
            } else if (employee != null) {
                var authenticationEmployee = new UsernamePasswordAuthenticationToken(employee, null, employee.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationEmployee);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
