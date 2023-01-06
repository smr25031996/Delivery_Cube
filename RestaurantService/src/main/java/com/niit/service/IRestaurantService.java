package com.niit.service;

import com.niit.domain.Restaurant;

import java.util.List;
import java.util.Optional;

public interface IRestaurantService  {
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







}
