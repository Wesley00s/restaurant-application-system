package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Ingredient;
import com.wesley.restaurant.application.system.entity.Item;
import com.wesley.restaurant.application.system.repository.IngredientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemDto {

    @NotEmpty(message = "Item name may be not empty")
    private String itemName;
    @NotNull(message = "Item price may be not null")
    private BigDecimal itemPrice;
    @NotEmpty(message = "Item description may be not empty")
    private String itemDesc;
    @NotEmpty(message = "Ingredients may be not empty")
    private List<Long> ingredientIds;

    public ItemDto(String itemName, BigDecimal itemPrice, String itemDesc, List<Long> ingredientIds) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDesc = itemDesc;
        this.ingredientIds = ingredientIds;
    }

    public Item toEntity(IngredientRepository ingredientRepository) {
        List<Ingredient> ingredients = ingredientIds.stream()
                .map(ingredientId -> {
                    Ingredient ingredient = ingredientRepository.findById(ingredientId).orElse(null);
                    if (ingredient == null) {
                        throw new EntityNotFoundException("Ingredient with ID " + ingredientId + " not found");
                    }
                    return ingredient;
                })
                .collect(Collectors.toList());

        return new Item(
                this.itemName,
                this.itemPrice,
                this.itemDesc,
                ingredients
        );
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public List<Long> getIngredientIds() {
        return ingredientIds;
    }
}
