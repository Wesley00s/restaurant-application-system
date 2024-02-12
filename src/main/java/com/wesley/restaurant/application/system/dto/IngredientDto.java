package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Ingredient;
import jakarta.persistence.Column;

public class IngredientDto {
    private final String ingredientName;
    private final Integer quantityInStock;

    public IngredientDto(String ingredientName, Integer quantityInStock) {
        this.ingredientName = ingredientName;
        this.quantityInStock = quantityInStock;
    }

    public Ingredient toEntity() {
        return new Ingredient(
                this.ingredientName,
                this.quantityInStock
        );
    }
}
