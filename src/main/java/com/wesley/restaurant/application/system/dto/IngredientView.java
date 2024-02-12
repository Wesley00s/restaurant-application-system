package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Ingredient;

import java.io.Serializable;

public class IngredientView implements Serializable {
    private final String ingredientName;
    private final Integer quantityInStock;

    public IngredientView(String ingredientName, Integer quantityInStock) {
        this.ingredientName = ingredientName;
        this.quantityInStock = quantityInStock;
    }

    public IngredientView(Ingredient ingredient) {
        this (
                ingredient.getIngredientName(),
                ingredient.getQuantityInStock()
        );
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }
}