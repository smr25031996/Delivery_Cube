package com.niit.service;

import com.niit.configuration.MessageDTO;
import com.niit.domain.Restaurant;
import com.niit.domain.User;

import java.util.List;
import java.util.Optional;

public interface IRestaurantService  {

    User registerUser(User user);

    User updateUser(User user, String email);

    List<User> getUsers();
    Optional<User> getUserByEmail(String email);

    Restaurant saveRestaurant(Restaurant restaurant);
    List<Restaurant> getAllRestaurants();
    Restaurant getByRestaurantName(String name);
    Optional<Restaurant> getRestaurantById(int id);
   List< Restaurant> getByLocation(String location);
    List<Restaurant> getByRating(double rating);

  boolean  deleteRestaurants(int id);
    Restaurant updateRestaurant(Restaurant restaurant, int id);

    List<Restaurant> getRestaurantsGreaterthan(double rating);
    List<Restaurant> getRestaurantsLessThan(double rating);
    List<Restaurant> getRestaurantByFoodItemName(String foodItemName);
    List<Restaurant> getRestaurantByCuisine(String cuisine);
    List<Restaurant> getRestaurantByPrice(int price);

    MessageDTO sendMessage(MessageDTO messageDTO);

  




}
