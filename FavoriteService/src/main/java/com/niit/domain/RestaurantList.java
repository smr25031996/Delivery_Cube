package com.niit.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class RestaurantList {
    @Id
    private int restaurantId;
    private String restaurantName;
    private String Description;
    private double rating;
    private List<MenuList> menuList;
    private String location;

    public RestaurantList() {
    }

    public RestaurantList(int restaurantId, String restaurantName, String description, double rating, List<MenuList> menuList, String location) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        Description = description;
        this.rating = rating;
        this.menuList = menuList;
        this.location = location;
    }

    @Override
    public String toString() {
        return "RestaurantList{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", Description='" + Description + '\'' +
                ", rating=" + rating +
                ", menuList=" + menuList +
                ", location='" + location + '\'' +
                '}';
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

}

