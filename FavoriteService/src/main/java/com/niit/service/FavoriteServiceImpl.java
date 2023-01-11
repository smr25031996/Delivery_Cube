package com.niit.service;

import com.niit.domain.Cart;
import com.niit.domain.Favorite;
import com.niit.domain.Order;
import com.niit.repository.CartRepository;
import com.niit.repository.FavoriteRepository;
import com.niit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements IFavoriteService {
    private FavoriteRepository favoriteRepository;
    private CartRepository cartRepository;
    private OrderRepository orderRepository;

    @Autowired
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository, CartRepository cartRepository, OrderRepository orderRepository) {
        this.favoriteRepository = favoriteRepository;
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Favorite saveFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Favorite> getFavoriteList() {
        return favoriteRepository.findAll();
    }

    @Override
    public List<Cart> getCartList() {
        return cartRepository.findAll();
    }

    @Override
    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }

    @Override
    public Favorite getByEmail(String email) {
        return favoriteRepository.findByEmail(email);
    }
}
