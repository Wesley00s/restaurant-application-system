package com.wesley.restaurant.application.system.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(nullable = false, unique = true)
    private String itemName;

    @Column(nullable = false)
    private BigDecimal itemPrice;

    @Column(nullable = false)
    private String itemDesc;

    @Column(nullable = false)
    @OneToMany(mappedBy = "item", cascade = {CascadeType.ALL, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Ingredient> ingredients;

    public Item(Long itemId, String itemName, BigDecimal itemPrice, String itemDesc, List<Ingredient> ingredients) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDesc = itemDesc;
        this.ingredients = ingredients;
    }
    public Item(String itemName, BigDecimal itemPrice, String itemDesc, List<Ingredient> ingredients) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDesc = itemDesc;
        this.ingredients = ingredients;
    }

    public Item() {
    }

    public Item(Long itemId) {
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        ingredient.setItem(this);
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemDesc='" + itemDesc + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
