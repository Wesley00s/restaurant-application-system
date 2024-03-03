package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Item;

import java.math.BigDecimal;

public record ItemView (
      String itemName,
      BigDecimal itemPrice,
      String itemDesc
) {
    public ItemView(Item item) {
        this (
                item.getItemName(),
                item.getItemPrice(),
                item.getItemDesc()
        );
    }
}
