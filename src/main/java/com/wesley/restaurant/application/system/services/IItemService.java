package com.wesley.restaurant.application.system.services;

import com.wesley.restaurant.application.system.entity.Item;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IItemService {
    Item save(Item item);
    Item findById(Long itemId);
    List<Item> findAllItems();
    void delete(Long itemId);
}
