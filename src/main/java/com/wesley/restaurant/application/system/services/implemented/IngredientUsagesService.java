package com.wesley.restaurant.application.system.services.implemented;

import com.wesley.restaurant.application.system.entity.IngredientUsages;
import com.wesley.restaurant.application.system.repository.IngredientUsagesRepository;
import com.wesley.restaurant.application.system.repository.ItemRepository;
import com.wesley.restaurant.application.system.services.IIngredientUsagesService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientUsagesService implements IIngredientUsagesService {
    private final IngredientUsagesRepository ingredientUsagesRepository;

    public IngredientUsagesService(IngredientUsagesRepository ingredientUsagesRepository) {
        this.ingredientUsagesRepository = ingredientUsagesRepository;
    }

    @Override
    public IngredientUsages save(IngredientUsages ingredientUsages) {
        return this.ingredientUsagesRepository.save(ingredientUsages);
    }

    @Override
    public IngredientUsages findById(Long id) {
        Optional<IngredientUsages> ingredientUsages = this.ingredientUsagesRepository.findById(id);
        if (ingredientUsages.isPresent())
            return ingredientUsages.get();
        else
            throw new RuntimeException("Ingredient with id " + id + " not found.");
    }

    @Override
    public void updateStockForItem(Long itemId) {
        this.ingredientUsagesRepository.updateStockForItem(itemId);
    }
}
