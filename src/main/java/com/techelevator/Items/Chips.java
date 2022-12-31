package com.techelevator.Items;

import java.math.BigDecimal;

public class Chips extends Item{
    public Chips(String itemSlot, String name, BigDecimal price, String type, int quantity) {
        super(itemSlot, name, price, type, quantity);
    }
    @Override
    public String getMessage(){
        return "Crunch, Crunch, Yum!";
    }
}
