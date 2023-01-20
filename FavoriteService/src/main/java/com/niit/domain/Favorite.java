package com.niit.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Favorite {
    @Id
    private String email;
    private List<RestaurantList> restaurantList;
    public Favorite(String email, List<RestaurantList> restaurantList) {
        this.email = email;
        this.restaurantList = restaurantList;
    }

    public Favorite() {
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RestaurantList> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<RestaurantList> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "email='" + email + '\'' +
                ", restaurantList=" + restaurantList +
                '}';
    }
}
