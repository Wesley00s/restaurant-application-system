package com.wesley.restaurant.application.system.services;

import com.wesley.restaurant.application.system.entity.Ingredient;

import java.util.List;

public interface IIngredientsService {
    Ingredient save(Ingredient ingredient);
    Ingredient findById(Long ingredientId);
    List<Ingredient> findAllIngredients();
    List<Ingredient> findAllIngredientsByItem(Long itemId);
    void deleteById(Long ingredientId);
    void saveAll(List<Ingredient> ingredients);
}
