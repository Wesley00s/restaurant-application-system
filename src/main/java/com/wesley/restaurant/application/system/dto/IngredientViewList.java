package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Ingredient;

public class IngredientViewList {

    private final String ingredientName;
    private final Integer quantityInStock;

    public IngredientViewList(String ingredientName, Integer quantityInStock) {
        this.ingredientName = ingredientName;
        this.quantityInStock = quantityInStock;
    }

    public IngredientViewList(Ingredient ingredient) {

        this.ingredientName = ingredient.getIngredientName();
        this.quantityInStock = ingredient.getQuantityInStock();
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }
}
