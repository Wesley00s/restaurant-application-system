package com.wesley.restaurant.application.system.services.implemented;

import com.wesley.restaurant.application.system.entity.Ingredient;
import com.wesley.restaurant.application.system.entity.IngredientUsages;
import com.wesley.restaurant.application.system.entity.Item;
import com.wesley.restaurant.application.system.repository.IngredientRepository;
import com.wesley.restaurant.application.system.repository.ItemRepository;
import com.wesley.restaurant.application.system.services.IItemService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements IItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return this.itemRepository.save(item);
    }

    @Override
    @Transactional
    public Item findById(Long itemId) {
        return this.itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("ID " + itemId + " not found"));
    }

    @Override
    public List<Item> findAllItems() {
        return this.itemRepository.findAll();
    }

    @Override
    public void delete(Long itemId) {
        Optional<Item> optionalItem = this.itemRepository.findById(itemId);

        if (optionalItem.isPresent()) {
            Item itemToDelete = optionalItem.get();
            this.itemRepository.delete(itemToDelete);
        } else {
            throw new RuntimeException("Item with ID " + itemId + " not found");
        }
    }
}