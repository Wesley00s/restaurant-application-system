package com.wesley.restaurant.application.system.services;

import com.wesley.restaurant.application.system.entity.Ingredient;

public interface IIngredientsService {
    Ingredient save(Ingredient ingredient);
    Ingredient findById(Long ingredientId);
    void deleteById(Long ingredientId);
}
