package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Ingredient;
import com.wesley.restaurant.application.system.entity.IngredientUsages;
import com.wesley.restaurant.application.system.entity.Item;

public class IngredientUsagesDto {
    private final Long usageId;
    private final Ingredient ingredient;
    private final Item item;


    public IngredientUsagesDto(Long usageId, Ingredient ingredient, Item item) {
        this.usageId = usageId;
        this.ingredient = ingredient;
        this.item = item;
    }

    public IngredientUsages toEntity() {
        return new IngredientUsages(
                this.usageId,
                this.ingredient,
                this.item
        );
    }
}
