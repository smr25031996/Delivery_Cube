/*
 *Author Name :P.Hemanth Sai Teja
 *Date:06-01-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

@Document
public class Restaurant {
    @Id
    private int restaurantId;
    private String restaurantName;
    private double rating;
    private List<MenuList> menuList;
    private String location;

    public Restaurant() {
    }

    public Restaurant(int restaurantId, String restaurantName, double rating, List<MenuList> menuList, String location) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.menuList = menuList;
        this.location = location;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<MenuList> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuList> menuList) {
        this.menuList = menuList;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", rating=" + rating +
                ", menuList=" + menuList +
                ", location='" + location + '\'' +
                '}';
    }
}
