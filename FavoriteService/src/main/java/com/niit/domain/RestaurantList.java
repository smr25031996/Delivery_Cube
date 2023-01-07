package com.niit.domain;

public class RestaurantList {
    private String restaurantName;
    private String location;
    private String cuisine;

    @Override
    public String toString() {
        return "RestaurantList{" +
                "restaurantName='" + restaurantName + '\'' +
                ", location='" + location + '\'' +
                ", cuisine='" + cuisine + '\'' +
                '}';
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public RestaurantList(String restaurantName, String location, String cuisine) {
        this.restaurantName = restaurantName;
        this.location = location;
        this.cuisine = cuisine;
    }

    public RestaurantList() {
    }
}

