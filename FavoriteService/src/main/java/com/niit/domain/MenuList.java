package com.niit.domain;

public class MenuList {
    private String foodItemName;
    private int price;
    private int quantity;


    @Override
    public String toString() {
        return "MenuList{" +
                "foodItemName='" + foodItemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
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

    public MenuList(String foodItemName, int price, int quantity) {
        this.foodItemName = foodItemName;
        this.price = price;
        this.quantity = quantity;
    }

    public MenuList() {
    }
}
