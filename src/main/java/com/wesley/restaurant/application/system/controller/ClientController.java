package com.wesley.restaurant.application.system.controller;

import com.wesley.restaurant.application.system.dto.ClientDto;
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

    @PostMapping
    private ResponseEntity<String> saveClient(@RequestBody @Valid ClientDto clientDto) {
         Client savedClient = this.clientService.save(clientDto.toEntity());
         return ResponseEntity.status(HttpStatus.CREATED)
                 .body("Client " + savedClient.getEmail() + " saved!");
    }

    @GetMapping("/{id}")
    private ResponseEntity<ClientView> findById(@PathVariable Long id) {
        Client client = this.clientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ClientView(client));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteClient(@PathVariable Long id) {
        this.clientService.deleteById(id);
    }
}
