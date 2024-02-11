package com.wesley.restaurant.application.system.services.implemented;

import com.wesley.restaurant.application.system.entity.Ingredient;
import com.wesley.restaurant.application.system.repository.IngredientRepository;
import com.wesley.restaurant.application.system.services.IIngredientsService;

import java.util.Optional;

public class IngredientService implements IIngredientsService {
    private IngredientRepository ingredientRepository;

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient findById(Long ingredientId) {
        return ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new RuntimeException("Ingredient with ID " + ingredientId + " not fond"));
    }

    @Override
    public void deleteById(Long ingredientId) {
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(ingredientId);

        if (optionalIngredient.isPresent()) {
            Ingredient ingredientToDelete = optionalIngredient.get();
            ingredientRepository.delete(ingredientToDelete);
        } else {
            throw new RuntimeException("Ingredient with ID " + ingredientId + " not found");
        }
    }
}
