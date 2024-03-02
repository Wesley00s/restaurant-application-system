package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.Ingredient;
import com.wesley.restaurant.application.system.entity.IngredientUsages;
import com.wesley.restaurant.application.system.entity.Item;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT * FROM ingredient" +
            " INNER JOIN ingredient_usages " +
            "ON ingredient.ingredient_id = ingredient_usages.ingredient_id " +
            "WHERE ingredient_usages.item_id = ?1", nativeQuery = true)
    List<Ingredient> findAllByItemIdIs (Long itemId);
}
