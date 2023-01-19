package com.niit.service;

import com.niit.configuration.MessageDTO;
import com.niit.domain.MenuList;
import com.niit.domain.Restaurant;
import com.niit.domain.User;
import com.niit.exception.MenuListNotFoundException;
import com.niit.exception.RestaurantNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IRestaurantService  {

    User registerUser(User user);

    User updateUser(User user, String email);

    Optional<User> getUserById(String email);

    List<User> getUsers();

    Optional<User> getUserByEmail(String email);

    Restaurant saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    Restaurant getByRestaurantName(String name);

    Optional<Restaurant> getRestaurantById(int restaurantId);

    List<Restaurant> getByLocation(String location);

    List<Restaurant> getByRating(double rating);


    //    two methods
    Restaurant saveRestaurantMenuToList(MenuList menuList, int restaurantId) throws RestaurantNotFoundException;

    List<MenuList> getAllRestaurantMenu(int restaurantId) throws RestaurantNotFoundException;

    Restaurant deleteRestaurantMenuFromList(int restaurantId, String foodItemName) throws RestaurantNotFoundException, MenuListNotFoundException;

    boolean deleteRestaurants(int id);

    Restaurant updateRestaurant(Restaurant restaurant, int id);

    List<Restaurant> getRestaurantsGreaterthan(double rating);

    List<Restaurant> getRestaurantsLessThan(double rating);

    List<Restaurant> getRestaurantByFoodItemName(String foodItemName);

    List<Restaurant> getRestaurantByCuisine(String cuisine);

    List<Restaurant> getRestaurantByPrice(int price);

    MessageDTO sendMessage(MessageDTO messageDTO);

  




}
