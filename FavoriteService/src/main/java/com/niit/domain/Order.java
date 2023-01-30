package com.niit.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
public class Order {

    @Id
    private String email;
    private List<MenuList> menuList;
    private int totalPrice;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Order(String email, List<MenuList> menuList, int totalPrice) {
        this.email = email;
        this.menuList = menuList;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "email='" + email + '\'' +
                ", menuList=" + menuList +
                ", totalPrice=" + totalPrice +
                '}';
    }



    public List<MenuList> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuList> menuList) {
        this.menuList = menuList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order() {
    }
}
