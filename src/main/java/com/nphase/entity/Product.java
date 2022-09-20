package com.nphase.entity;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final BigDecimal pricePerUnit;
    private final int quantity;
    private final CategoryType category;

    private Product(String name, BigDecimal pricePerUnit, int quantity, CategoryType category) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public CategoryType getCategory() {
        return category;
    }

    public static Product createDrink(String name, BigDecimal pricePerUnit, int quantity) {
        return new Product(name, pricePerUnit, quantity, CategoryType.DRINKS);
    }

    public static Product createFood(String name, BigDecimal pricePerUnit, int quantity) {
        return new Product(name, pricePerUnit, quantity, CategoryType.FOOD);
    }
}
