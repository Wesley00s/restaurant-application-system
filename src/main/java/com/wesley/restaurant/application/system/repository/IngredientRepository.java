package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
