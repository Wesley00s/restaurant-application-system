package com.wesley.restaurant.application.system.controller;

import com.wesley.restaurant.application.system.dto.IngredientDto;
import com.wesley.restaurant.application.system.dto.IngredientView;
import com.wesley.restaurant.application.system.entity.Ingredient;
import com.wesley.restaurant.application.system.services.implemented.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    private ResponseEntity<String> saveIngredient(@RequestBody IngredientDto ingredientDto) {
        Ingredient ingredient = this.ingredientService.save(ingredientDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ingredient " + ingredient.getIngredientName() + " saved!");
    }

    @GetMapping("/{id}")
    private ResponseEntity<IngredientView> findById(@PathVariable Long id) {
        Ingredient ingredient = this.ingredientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new IngredientView(ingredient));
    }

    @GetMapping("/all-ingredients")
    private ResponseEntity<List<IngredientView>> findAllIngredients() {
        List<IngredientView> ingredientViews = this.ingredientService.findAllIngredients().stream()
                .map(IngredientView::new)
                .toList();

        return ResponseEntity.status(HttpStatus.OK)
                .body(ingredientViews);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(@PathVariable Long id) {
        this.ingredientService.deleteById(id);
    }
}
