package com.wesley.restaurant.application.system.services;

import com.wesley.restaurant.application.system.entity.Client;

public interface IClientService {
    Client save(Client client);
    Client findById(Long clientId);
    void deleteById(Long clientId);
}
