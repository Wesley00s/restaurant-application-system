package com.wesley.restaurant.application.system.controller;

import com.wesley.restaurant.application.system.dto.RequestDto;
import com.wesley.restaurant.application.system.dto.RequestView;
import com.wesley.restaurant.application.system.entity.Client;
import com.wesley.restaurant.application.system.entity.Item;
import com.wesley.restaurant.application.system.entity.Request;
import com.wesley.restaurant.application.system.services.implemented.ClientService;
import com.wesley.restaurant.application.system.services.implemented.ItemService;
import com.wesley.restaurant.application.system.services.implemented.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/request")
public class RequestController {
    private final RequestService requestService;
    private final ClientService clientService;
    private final ItemService itemService;

    public RequestController(RequestService requestService, ClientService clientService, ItemService itemService) {
        this.requestService = requestService;
        this.clientService = clientService;
        this.itemService = itemService;
    }

    @PostMapping("/post-request")
    private ResponseEntity<String> saveRequest(@RequestBody RequestDto requestDto) {
        Request request = requestDto.toEntity();
        Client client = clientService.findById(request.getClient().getClientId());
        Item item = itemService.findById(request.getItem().getItemId());

        request.setClient(client);
        request.setItem(item);
        this.requestService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Requests created successfully");
    }

    @GetMapping("/{clientId}/{requestId}")
    private ResponseEntity<RequestView> findById(@PathVariable Long clientId, @PathVariable UUID requestId) {
        Client client = clientService.findById(clientId);
        Request request = this.requestService.findById(requestId);
        if (client == request.getClient()) {
            RequestView requestView = new RequestView(
                    request.getClient().getClientId(),
                    request.getItem().getItemId(),
                    request.getEatingTable().getTableId(),
                    request.getEmployee().getEmployeeId()
            );

            return ResponseEntity.status(HttpStatus.OK)
                    .body(requestView);
        } else {
            throw new RuntimeException("Pls, contact admin");
        }
    }

    @DeleteMapping("/{requestId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@PathVariable UUID requestId) {
            this.requestService.deleteById(requestId);
    }
}
