package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Item;

import java.math.BigDecimal;

public class ItemView {
    private final String itemName;
    private final BigDecimal itemPrice;
    private final String itemDesc;

    public ItemView(String itemName, BigDecimal itemPrice, String itemDesc) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDesc = itemDesc;
    }

    public ItemView(Item item) {
        this (
                item.getItemName(),
                item.getItemPrice(),
                item.getItemDesc()
        );
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public String getItemDesc() {
        return itemDesc;
    }
}
