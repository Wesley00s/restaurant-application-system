package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Ingredient;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class IngredientDto {
    @NotEmpty(message = "Ingredient name may be not empty")
    private final String ingredientName;
    @NotNull(message = "Quantity in stock may be not empty")
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