package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Ingredient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record IngredientDto (
        @NotEmpty(message = "Ingredient name may be not empty")  String ingredientName,
        @NotNull(message = "Quantity in stock may be not empty") Integer quantityInStock
) {
    public Ingredient toEntity() {
        return new Ingredient(
                this.ingredientName,
                this.quantityInStock
        );
    }
}
