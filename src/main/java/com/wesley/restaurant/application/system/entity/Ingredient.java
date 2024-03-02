package com.wesley.restaurant.application.system.entity;

import jakarta.persistence.*;

@Entity
public class Ingredient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;

    @Column(nullable = false, unique = true)
    private String ingredientName;

    @Column(nullable = false)
    private Integer quantityInStock;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Item item;

    public Ingredient(String ingredientName, Integer quantityInStock) {
        this.ingredientName = ingredientName;
        this.quantityInStock = quantityInStock;
    }

    public Ingredient(String ingredientName, Integer quantityInStock, Item item) {
        this.ingredientName = ingredientName;
        this.quantityInStock = quantityInStock;
        this.item = item;
    }

    public Ingredient(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Ingredient() {

    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", ingredientName='" + ingredientName + '\'' +
                ", quantityInStock=" + quantityInStock +
                '}';
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
