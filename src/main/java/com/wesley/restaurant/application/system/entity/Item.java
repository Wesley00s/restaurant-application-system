package com.wesley.restaurant.application.system.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

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

    public Item(Long itemId, String itemName, BigDecimal itemPrice, String itemDesc) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDesc = itemDesc;
    }
    public Item(String itemName, BigDecimal itemPrice, String itemDesc) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDesc = itemDesc;
    }

    public Item() {

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
}
