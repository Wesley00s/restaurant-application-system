package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    @Query(value = "SELECT i.* FROM ingredient i " +
            "INNER JOIN ingredient_usages iu " +
            "ON i.ingredient_id = iu.ingredient_id " +
            "WHERE iu.item_id = ?1", nativeQuery = true)
    List<Ingredient> findIngredientsByItem(Long itemId);
}