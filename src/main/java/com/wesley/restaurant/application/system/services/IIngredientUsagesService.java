package com.wesley.restaurant.application.system.services;

import com.wesley.restaurant.application.system.entity.IngredientUsages;

public interface IIngredientUsagesService {
    IngredientUsages save(IngredientUsages ingredientUsages);
    IngredientUsages findById(Long id);
    void updateStockForItem(Long itemId);
}
