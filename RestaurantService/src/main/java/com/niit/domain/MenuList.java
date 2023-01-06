/*
 *Author Name :P.Hemanth Sai Teja
 *Date:06-01-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.domain;

public class MenuList {
    private String foodItemName;
    private String cuisine ;
    private int price;

    public MenuList() {
    }

    public MenuList(String foodItemName, String cuisine, int price) {
        this.foodItemName = foodItemName;
        this.cuisine = cuisine;
        this.price = price;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuList{" +
                "foodItemName='" + foodItemName + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", price=" + price +
                '}';
    }
}
