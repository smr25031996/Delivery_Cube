package com.niit.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Cart {
    @Id
    private String email;
    private List<MenuList> menuLists;

    public Cart(String email, List<MenuList> menuLists) {
        this.email = email;
        this.menuLists = menuLists;
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" + "email='" + email + '\'' + ", menuLists=" + menuLists + '}';
    }

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
}
