package com.niit.service;

import com.niit.domain.Cart;
import com.niit.domain.Favorite;
import com.niit.domain.Order;

import java.util.List;

public interface IFavoriteService {
    Favorite saveFavorite(Favorite favorite);

    Cart saveCart(Cart cart);

    Order saveOrder(Order order);

    List<Favorite> getFavoriteList();

    List<Cart> getCartList();

    List<Order> getOrderList();

    Favorite getByEmail(String email);

    Favorite addFavourite(Favorite favorite, String email);

}
