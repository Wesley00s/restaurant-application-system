package com.wesley.restaurant.application.system.controller;

import com.wesley.restaurant.application.system.dto.ClientDTO;
import com.wesley.restaurant.application.system.dto.ClientView;
import com.wesley.restaurant.application.system.entity.Client;
import com.wesley.restaurant.application.system.services.implemented.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    private ResponseEntity<ClientView> findById(@PathVariable Long id) {
        Client user = this.clientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ClientView(user));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteClient(@PathVariable Long id) {
        this.clientService.deleteById(id);
    }
}