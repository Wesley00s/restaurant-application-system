package com.wesley.restaurant.application.system.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final SecurityFilter securityFilter;

    public SecurityConfig(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/client-register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/request/post-request").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.POST, "/api/ingredient").hasRole("CHEF")
                        .requestMatchers(HttpMethod.POST, "api/item").hasRole("CHEF")
                        .requestMatchers(HttpMethod.POST, "/api/item").hasRole("CHEF")
                        .requestMatchers(HttpMethod.POST, "/api/ingredient").hasRole("CHEF")
                        .requestMatchers(HttpMethod.DELETE, "api/item/").hasRole("CHEF")
                        .requestMatchers(HttpMethod.DELETE, "api/ingredient/").hasRole("CHEF")
                        .requestMatchers(HttpMethod.POST, "/auth/employee-register").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/table").hasRole("CHEF")
                        .requestMatchers(HttpMethod.POST, "/api/employee").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "api/employee/").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "api/client/").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(this.securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
