package com.wesley.restaurant.application.system.controller;

import com.wesley.restaurant.application.system.dto.ItemDto;
import com.wesley.restaurant.application.system.dto.ItemView;
import com.wesley.restaurant.application.system.entity.IngredientUsages;
import com.wesley.restaurant.application.system.entity.Item;
import com.wesley.restaurant.application.system.repository.IngredientRepository;
import com.wesley.restaurant.application.system.repository.IngredientUsagesRepository;
import com.wesley.restaurant.application.system.services.implemented.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    private final ItemService itemService;
    private final IngredientRepository ingredientRepository;
    private final IngredientUsagesRepository ingredientUsagesRepository;

    public ItemController(ItemService itemService, IngredientRepository ingredientRepository, IngredientUsagesRepository ingredientUsagesRepository) {
        this.itemService = itemService;
        this.ingredientRepository = ingredientRepository;
        this.ingredientUsagesRepository = ingredientUsagesRepository;
    }

    @PostMapping
    public ResponseEntity<String> saveItem(@RequestBody ItemDto itemDto) {
        try {
            Item itemDtoEntity = itemDto.toEntity(ingredientRepository);

            if (itemDtoEntity == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid item data");
            }
            itemDtoEntity.getIngredients().forEach(ingredient -> {
                this.ingredientUsagesRepository.save(new IngredientUsages(ingredient, itemDtoEntity));
            });

            Item savedItem = this.itemService.save(itemDtoEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body("Item " + savedItem.getItemDesc() + " saved!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving item: " + e.getMessage());
        }
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
            this.itemService.delete(id);
    }
}
