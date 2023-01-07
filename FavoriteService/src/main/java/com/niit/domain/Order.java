package com.niit.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
public class Order {
    @Id
    private String email;
    private List<MenuList> menuLists;
    private List<RestaurantList>restaurantLists;
    private int totalBill;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MenuList> getMenuLists() {
        return menuLists;
    }

    public void setMenuLists(List<MenuList> menuLists) {
        this.menuLists = menuLists;
    }

    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }

    @Override
    public String toString() {
        return "Order{" +
                "email='" + email + '\'' +
                ", menuLists=" + menuLists +
                ", restaurantLists=" + restaurantLists +
                ", totalBill=" + totalBill +
                '}';
    }

    public List<RestaurantList> getRestaurantLists() {
        return restaurantLists;
    }

    public void setRestaurantLists(List<RestaurantList> restaurantLists) {
        this.restaurantLists = restaurantLists;
    }

    public Order(String email, List<MenuList> menuLists, List<RestaurantList> restaurantLists, int totalBill) {
        this.email = email;
        this.menuLists = menuLists;
        this.restaurantLists = restaurantLists;
        this.totalBill = totalBill;
    }

    public Order() {
    }
}
