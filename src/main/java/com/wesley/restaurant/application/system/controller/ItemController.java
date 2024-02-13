package com.wesley.restaurant.application.system.controller;

import com.wesley.restaurant.application.system.dto.ItemDto;
import com.wesley.restaurant.application.system.dto.ItemView;
import com.wesley.restaurant.application.system.entity.Item;
import com.wesley.restaurant.application.system.services.implemented.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    private ResponseEntity<String> saveItem(@RequestBody ItemDto itemDto) {
        Item item = this.itemService.save(itemDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Item " + item.getItemDesc() + " saved!");
    }

    @GetMapping("/{id}")
    private ResponseEntity<ItemView> findById(@PathVariable Long id) {
        Item item = this.itemService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ItemView(item));
    }

    @GetMapping("/all-items")
    private ResponseEntity<List<ItemView>> findAllItems() {
        List<ItemView> itemViews = this.itemService.findAllItems().stream()
                .map(ItemView::new)
                .toList();
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemViews);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(@PathVariable Long id) {
        this.itemService.findById(id);
    }
}
