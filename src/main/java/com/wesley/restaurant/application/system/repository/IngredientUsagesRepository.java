package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.IngredientUsages;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IngredientUsagesRepository extends JpaRepository<IngredientUsages, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE ingredient SET quantity_in_stock = quantity_in_stock - 1 WHERE ingredient_id IN (SELECT iu.ingredient_id FROM ingredient_usages AS iu WHERE iu.item_id = ?1)",
            nativeQuery = true)
    void updateStockForItem(@Param("itemId") Long itemId);
}
