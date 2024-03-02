package com.wesley.restaurant.application.system.services;

import com.wesley.restaurant.application.system.entity.Client;
import com.wesley.restaurant.application.system.entity.Request;
import com.wesley.restaurant.application.system.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface IClientService {
    Client save(Client client);
    Client findById(Long clientId);
    void deleteById(Long clientId);
    UserDetails findByEmail(String email);
}
