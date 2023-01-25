package com.niit.service;

import com.niit.domain.*;

import java.util.List;
import java.util.Optional;

public interface IFavoriteService {
    Favorite saveFavorite(Favorite favorite);

    Cart saveCart(Cart cart);

    Order saveOrder(Order order);

    List<Favorite> getFavoriteList();

    List<Cart> getCartList();

    List<Order> getOrderList();

    Favorite getByEmail(String email);

    Optional<Order> getOrderByEmail(String email);

    Optional<Cart> getCartByEmail(String email);

    Favorite addFavourite(Favorite favorite, String email);


    Order addOrder(Order order, String email);


    Favorite saveRestaurantToFavorites(RestaurantList restaurantList, String email);

    List<RestaurantList> getAllRestaurantFromFavorites(String email);

    Favorite deleteRestaurantFromFavorites(String email, int restaurant);


    Cart saveMenuToCart(MenuList menuList, String email);

    List<MenuList> getAllMenusFromCart(String email);

    Cart deleteMenuFromCart(String email, String foodItemName);


    Order saveMenuToOrder(MenuList menuList, String email);

    List<MenuList> getAllMenusFromOrder(String email);

    Order deleteMenuFromOrder(String email, String foodItemName);
}
