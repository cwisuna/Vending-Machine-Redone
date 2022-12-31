package com.techelevator.Items;

import java.math.BigDecimal;

public class Item {
    //instance variables
    private String itemSlot;
    private String name;
    private BigDecimal price;
    private String type;
    private int quantity;

    //getters & setters
    public String getItemSlot() {
        return itemSlot;
    }

    public void setItemSlot(String itemSlot) {
        this.itemSlot = itemSlot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //constructor
    public Item(String itemSlot, String name, BigDecimal price, String type, int quantity) {
        this.itemSlot = itemSlot;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public String getMessage(){
        return "";
    };
    public void removeItem(){
        this.quantity -= 1;
    }


}
