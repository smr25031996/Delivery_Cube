package com.niit.service;

import com.niit.domain.*;
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
    public Order addOrder(Order order, String email) {
        return null;
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
    public Cart saveMenuToCart(MenuList menuList, String email) {
        if (cartRepository.findById(email).isEmpty()) {
            System.out.println("no items found");

        }
        Cart cart = cartRepository.findByEmail(email);
        if (cart.getMenuList() == null) {
            System.out.println("In repo " + email);
            cart.setMenuList(Collections.singletonList(menuList));
        } else {
            List<MenuList> menuLists = cart.getMenuList();
            menuLists.add(menuList);
            cart.setMenuList(menuLists);
        }
        return cartRepository.save(cart);
    }

    @Override
    public List<MenuList> getAllMenusFromCart(String email) {
        if (cartRepository.findById(email).isEmpty()) {
            System.out.println("list is empty");
        }
        return cartRepository.findById(email).get().getMenuList();
    }

    @Override
    public Cart deleteMenuFromCart(String email, String foodItemName) {
        boolean foodItemIsPresent = false;
        if (orderRepository.findById(email).isEmpty()) {
        }
        Cart cart = cartRepository.findById(email).get();
        List<MenuList> menuLists = cart.getMenuList();
        foodItemIsPresent = menuLists.removeIf(x -> x.getFoodItemName().equals(foodItemName));
        if (!foodItemIsPresent) {
            System.out.println("list is empty");
        }
        cart.setMenuList(menuLists);
        return cartRepository.save(cart);
    }

    @Override
    public Order saveMenuToOrder(MenuList menuList, String email) {
        if (orderRepository.findById(email).isEmpty()) {
            System.out.println("no Orders found");

        }
        Order order = orderRepository.findByEmail(email);
        if (order.getMenuList() == null) {
            System.out.println("In repo " + email);
            order.setMenuList(Collections.singletonList(menuList));
        } else {
            List<MenuList> menuLists = order.getMenuList();
            menuLists.add(menuList);
            order.setMenuList(menuLists);
        }
        return orderRepository.save(order);
    }

    @Override
    public List<MenuList> getAllMenusFromOrder(String email) {
        if (orderRepository.findById(email).isEmpty()) {
            System.out.println("list is empty");
        }
        return orderRepository.findById(email).get().getMenuList();
    }

    @Override
    public Order deleteMenuFromOrder(String email, String foodItemName) {
        boolean foodItemIsPresent = false;
        if (orderRepository.findById(email).isEmpty()) {
        }
        Order order = orderRepository.findById(email).get();
        List<MenuList> menuLists = order.getMenuList();
        foodItemIsPresent = menuLists.removeIf(x -> x.getFoodItemName().equals(foodItemName));
        if (!foodItemIsPresent) {
            System.out.println("list is empty");
        }
        order.setMenuList(menuLists);
        return orderRepository.save(order);
    }
}



