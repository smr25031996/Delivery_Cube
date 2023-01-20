package com.niit.domain;

import org.springframework.data.annotation.Id;

public class MenuList {
    @Id
    private String foodItemName;
    private String cuisine;
    private int price;
    private int quantity;

    public MenuList(String foodItemName, String cuisine, int price, int quantity) {
        this.foodItemName = foodItemName;
        this.cuisine = cuisine;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "MenuList{" +
                "foodItemName='" + foodItemName + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public MenuList() {
    }
}
