package com.niit.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Cart {
    @Id
    private String email;
    private List<RestaurantList> restaurantList;


    public Cart() {
    }


    public Cart(String email, List<RestaurantList> restaurantList) {
        this.email = email;
        this.restaurantList = restaurantList;
    }

    public List<RestaurantList> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<RestaurantList> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "email='" + email + '\'' +
                ", restaurantList=" + restaurantList +
                '}';
    }
}
