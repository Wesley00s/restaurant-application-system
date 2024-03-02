package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.Client;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    UserDetails findByEmail(String email);
}
