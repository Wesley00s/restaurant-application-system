package com.wesley.restaurant.application.system.services.implemented;

import com.wesley.restaurant.application.system.entity.Client;
import com.wesley.restaurant.application.system.entity.Item;
import com.wesley.restaurant.application.system.repository.ItemRepository;
import com.wesley.restaurant.application.system.services.IItemService;

import java.util.List;
import java.util.Optional;

public class ItemService implements IItemService {
    private ItemRepository itemRepository;
    private ClientService clientService;

    @Override
    public Item save(Item item) {
        Client client = clientService.findById(item.getClient().getClientId());
        if (client == null)
            return null;
        return this.itemRepository.save(item);
    }

    @Override
    public Item findById(Long itemId) {
        return this.itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("ID" + itemId + "not found"));
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

    public List<Item> findAlLByClient(Long clientId) {
        return itemRepository.findAlLByClient(clientId);
    }
}