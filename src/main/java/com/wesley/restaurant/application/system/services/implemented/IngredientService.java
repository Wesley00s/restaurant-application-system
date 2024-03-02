package com.wesley.restaurant.application.system.services.implemented;

import com.wesley.restaurant.application.system.entity.Ingredient;
import com.wesley.restaurant.application.system.entity.Item;
import com.wesley.restaurant.application.system.repository.IngredientRepository;
import com.wesley.restaurant.application.system.repository.ItemRepository;
import com.wesley.restaurant.application.system.services.IIngredientsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService implements IIngredientsService {
    private final IngredientRepository ingredientRepository;
    private final ItemRepository itemRepository;

    public IngredientService(IngredientRepository ingredientRepository,
                             ItemRepository itemRepository) {
        this.ingredientRepository = ingredientRepository;
        this.itemRepository = itemRepository;
    }

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
    public List<Ingredient> findAllIngredients() {
        return this.ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> findAllIngredientsByItem(Long itemId) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);

        if (optionalItem.isPresent())  {
            return ingredientRepository.findIngredientsByItem(itemId);
        } else {
            throw new RuntimeException("Item not found");
        }
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

    @Override
    public void saveAll(List<Ingredient> ingredients) {
        ingredientRepository.saveAll(ingredients);
    }
}
