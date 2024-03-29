package com.wesley.restaurant.application.system.services.implemented;

import com.wesley.restaurant.application.system.entity.Client;
import com.wesley.restaurant.application.system.entity.EatingTable;
import com.wesley.restaurant.application.system.entity.Request;
import com.wesley.restaurant.application.system.entity.User;
import com.wesley.restaurant.application.system.repository.ClientRepository;
import com.wesley.restaurant.application.system.repository.ItemRepository;
import com.wesley.restaurant.application.system.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        return this.clientRepository.save(client);
    }

    @Override
    public Client findById(Long clientId) {
        return this.clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client with ID " + clientId + " not found"));
    }

    @Override
    public void deleteById(Long clientId) {
        this.clientRepository.deleteById(clientId);
    }

    @Override
    public UserDetails findByEmail(String email) {
        return this.clientRepository.findByEmail(email);
    }
}
