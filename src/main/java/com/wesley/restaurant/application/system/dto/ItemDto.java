package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Item;

import java.math.BigDecimal;

public class ItemDto {
    private final String itemName;
    private final BigDecimal itemPrice;
    private final String itemDesc;

    public ItemDto(String itemName, BigDecimal itemPrice, String itemDesc) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDesc = itemDesc;
    }

    public Item toEntity() {
        return new Item(
                this.itemName,
                this.itemPrice,
                this.itemDesc
        );
    }

}
