package com.wesley.restaurant.application.system.controller;

import com.wesley.restaurant.application.system.dto.RequestDto;
import com.wesley.restaurant.application.system.dto.RequestView;
import com.wesley.restaurant.application.system.entity.*;
import com.wesley.restaurant.application.system.services.implemented.*;
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
    private final IngredientUsagesService ingredientUsagesService;

    public RequestController(RequestService requestService, ClientService clientService, ItemService itemService, IngredientUsagesService ingredientUsagesService) {
        this.requestService = requestService;
        this.clientService = clientService;
        this.itemService = itemService;
        this.ingredientUsagesService = ingredientUsagesService;
    }

    @PostMapping("/post-request")
    private ResponseEntity<String> saveRequest(@RequestBody RequestDto requestDto) {
        Request request = requestDto.toEntity();
        Client client = clientService.findById(request.getClient().getUserId());
        Item item = itemService.findById(request.getItem().getItemId());

        if (!hasEnoughStock(item)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Not enough stock for the requested item");
        }

        this.ingredientUsagesService.updateStockForItem(item.getItemId());
        request.setClient(client);
        request.setItem(item);
        this.requestService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Request created successfully.");
    }

    private boolean hasEnoughStock(Item item) {
        return item.getIngredients().stream().allMatch(ingredient ->
                ingredient.getQuantityInStock() >= 1
        );
    }


    @GetMapping("/{clientId}/{requestId}")
    private ResponseEntity<RequestView> findById(@PathVariable Long clientId, @PathVariable UUID requestId) {
        Client client = clientService.findById(clientId);
        Request request = this.requestService.findById(requestId);
        if (client == request.getClient()) {
            RequestView requestView = new RequestView(
                    request.getClient().getUserId(),
                    request.getItem().getItemId(),
                    request.getEatingTable().getTableId(),
                    request.getEmployee().getUserId()
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
