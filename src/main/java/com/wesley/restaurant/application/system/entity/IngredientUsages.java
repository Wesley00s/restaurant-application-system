package com.wesley.restaurant.application.system.entity;

import jakarta.persistence.*;

@Entity
public class IngredientUsages {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usageId;
    @JoinColumn(nullable = false, name = "ingredient_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "item_id")
    private Item item;

    public IngredientUsages(Ingredient ingredient, Item item) {
        this.ingredient = ingredient;
        this.item = item;
    }
    public IngredientUsages(Long usageId, Ingredient ingredient, Item item) {
        this.usageId = usageId;
        this.ingredient = ingredient;
        this.item = item;
    }

    public IngredientUsages() {

    }

    public Long getUsageId() {
        return usageId;
    }

    public void setUsageId(Long usageId) {
        this.usageId = usageId;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
