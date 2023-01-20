package com.niit.service;

import com.niit.domain.Cart;
import com.niit.domain.Favorite;
import com.niit.domain.Order;
import com.niit.domain.RestaurantList;
import com.niit.repository.CartRepository;
import com.niit.repository.FavoriteRepository;
import com.niit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Order> getOrderByEmail(String email) {
        return orderRepository.findById(email);
    }

    @Override
    public Optional<Cart> getCartByEmail(String email) {
        return cartRepository.findById(email);
    }

    @Override
    public Favorite addFavourite(Favorite favorite, String email) {
        Optional<Favorite> existingFavourite = favoriteRepository.findById(email);
        if (existingFavourite.isEmpty()) {
            return null;
        }
        Favorite favorite1 = existingFavourite.get();
        if (favorite.getEmail() != null) {
            favorite1.setEmail(favorite.getEmail());
        }
        if (favorite.getRestaurantList() != null) {
            favorite1.setRestaurantList(favorite.getRestaurantList());
        }


        return favoriteRepository.save(favorite1);
    }

    @Override
    public Cart addToCart(Cart cart, String email) {
        Optional<Cart> existingCart = cartRepository.findById(email);
        if (existingCart.isEmpty()) {
            return null;
        }
        Cart cart1 = existingCart.get();
        if (cart.getEmail() != null) {
            cart1.setEmail(cart.getEmail());
        }
        if (cart.getRestaurantList() != null) {
            cart1.setRestaurantList(cart.getRestaurantList());
        }


        return cartRepository.save(cart1);
    }

    @Override
    public Order addOrder(Order order, String email) {
        Optional<Order> existingOrder = orderRepository.findById(email);
        if (existingOrder.isEmpty()) {
            return null;
        }
        Order order1 = existingOrder.get();
        if (order.getEmail() != null) {
            order1.setEmail(order.getEmail());
        }

        if (order.getRestaurantLists() != null) {
            order1.setRestaurantLists(order.getRestaurantLists());
        }
        if (order.getTotalBill() == 0) {
            order1.setTotalBill(order.getTotalBill());
        }

        return orderRepository.save(order1);
    }

    @Override
    public Favorite saveRestaurantToFavorites(RestaurantList restaurantList, String email) {
        if (favoriteRepository.findById(email).isEmpty()) {
            System.out.println("no favorites");

        }
        Favorite favorite = favoriteRepository.findByEmail(email);
        if (favorite.getRestaurantList() == null) {
            System.out.println("In repo " + email);
            favorite.setRestaurantList(Collections.singletonList(restaurantList));
        } else {
            List<RestaurantList> restaurantLists = favorite.getRestaurantList();
            restaurantLists.add(restaurantList);
            favorite.setRestaurantList(restaurantLists);
        }
        return favoriteRepository.save(favorite);
    }

    @Override
    public List<RestaurantList> getAllRestaurantFromFavorites(String email) {
        if (favoriteRepository.findById(email).isEmpty()) {
            System.out.println("list is empty");
        }
        return favoriteRepository.findById(email).get().getRestaurantList();
    }

    @Override
    public Favorite deleteRestaurantFromFavorites(String email, int restaurant) {
        boolean foodItemIsPresent = false;
        if (favoriteRepository.findById(email).isEmpty()) {
        }
        Favorite favorite = favoriteRepository.findById(email).get();
        List<RestaurantList> restaurantList = favorite.getRestaurantList();
        foodItemIsPresent = restaurantList.removeIf(x -> x.getRestaurantId() == (restaurant));
        if (!foodItemIsPresent) {
            System.out.println("list is empty");
        }
        favorite.setRestaurantList(restaurantList);
        return favoriteRepository.save(favorite);
    }

    @Override
    public Cart saveRestaurantToCart(RestaurantList restaurantList, String email) {
        if (cartRepository.findById(email).isEmpty()) {
            System.out.println("no favorites");

        }
        Cart cart = cartRepository.findByEmail(email);
        if (cart.getRestaurantList() == null) {
            System.out.println("In repo " + email);
            cart.setRestaurantList(Collections.singletonList(restaurantList));
        } else {
            List<RestaurantList> restaurantLists = cart.getRestaurantList();
            restaurantLists.add(restaurantList);
            cart.setRestaurantList(restaurantLists);
        }
        return cartRepository.save(cart);
    }

    @Override
    public List<RestaurantList> getAllRestaurantFromCart(String email) {
        if (cartRepository.findById(email).isEmpty()) {
            System.out.println("list is empty");
        }
        return cartRepository.findById(email).get().getRestaurantList();
    }

    @Override
    public Cart deleteRestaurantFromCart(String email, int restaurant) {
        boolean ifResatuarantIsPresent = false;
        if (cartRepository.findById(email).isEmpty()) {
        }
        Cart cart = cartRepository.findById(email).get();
        List<RestaurantList> restaurantList = cart.getRestaurantList();
        ifResatuarantIsPresent = restaurantList.removeIf(x -> x.getRestaurantId() == (restaurant));
        if (!ifResatuarantIsPresent) {
            System.out.println("list is empty");
        }
        cart.setRestaurantList(restaurantList);
        return cartRepository.save(cart);
    }
}



