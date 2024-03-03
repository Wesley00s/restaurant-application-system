package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Ingredient;

import java.io.Serializable;

public record IngredientView  (
        String ingredientName,
        Integer quantityInStock
) {
    public IngredientView(Ingredient ingredient) {
        this (
                ingredient.getIngredientName(),
                ingredient.getQuantityInStock()
        );
    }
}