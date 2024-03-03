package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Ingredient;

public record IngredientViewList (
        String ingredientName,
        Integer quantityInStock
){
    public IngredientViewList(Ingredient ingredient) {
        this (
                ingredient.getIngredientName(),
                ingredient.getQuantityInStock()
        );
    }
}
