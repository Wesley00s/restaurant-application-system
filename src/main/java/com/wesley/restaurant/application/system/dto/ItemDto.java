package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.entity.Item;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ItemDto {
    @NotEmpty(message = "Item name may be not empty")
    private final String itemName;
    @NotNull(message = "Item price may be not null")
    private final BigDecimal itemPrice;
    @NotEmpty(message = "Item description may be not empty")
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
