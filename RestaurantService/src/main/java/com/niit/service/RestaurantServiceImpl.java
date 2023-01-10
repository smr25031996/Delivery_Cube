/*
 *Author Name :P.Hemanth Sai Teja
 *Date:06-01-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.service;

import com.niit.domain.Restaurant;
import com.niit.domain.User;
import com.niit.proxy.UserProxy;
import com.niit.repository.RestaurantRepository;
import com.niit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements IRestaurantService{
    private RestaurantRepository restaurantRepository;
    private UserRepository userRepository;

    private UserProxy userProxy;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, UserRepository userRepository, UserProxy userProxy) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.userProxy = userProxy;
    }

    @Override
    public User registerUser(User user) {
        userProxy.saveUser(user);
        return userRepository.save(user);
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getByRestaurantName(String name) {
        return restaurantRepository.findByRestaurantName(name);
    }

    @Override
    public Optional<Restaurant> getRestaurantById(int id) {
        return restaurantRepository.findById(id);

    }

    @Override
    public List<Restaurant> getByLocation(String location) {
        return restaurantRepository.findByLocation(location);
    }

    @Override
    public List<Restaurant> getByRating(double rating) {
        return restaurantRepository.findByRating(rating);
    }

    @Override
    public boolean deleteRestaurants(int id) {
        restaurantRepository.deleteById(id);
         return true;
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant, int id) {
        Optional<Restaurant> existingRestaurant = restaurantRepository.findById(id);
        if (existingRestaurant.isEmpty()) {
            return null;
        }
        Restaurant restaurant1 = existingRestaurant.get();
        if (restaurant.getRestaurantName() != null) {
            restaurant1.setRestaurantName(restaurant.getRestaurantName());
        }
        if (restaurant.getLocation() != null) {
            restaurant1.setLocation(restaurant.getLocation());
        }
        if (restaurant.getRating() != 0) {
            restaurant1.setRating(restaurant.getRating());
        }

        if (restaurant.getMenuList() != null) {
            restaurant1.setMenuList(restaurant.getMenuList());
        }

        return restaurantRepository.save(restaurant1);
    }

    @Override
    public List<Restaurant> getRestaurantsGreaterthan(double rating) {
        return restaurantRepository.findByRatingGreaterThan(rating);
    }

    @Override
    public List<Restaurant> getRestaurantsLessThan(double rating) {
        return restaurantRepository.findByRatingLessThan(rating);
    }

    @Override
    public List<Restaurant> getRestaurantByFoodItemName(String foodItemName) {
        return restaurantRepository.findAllRestaurantFoodItemName(foodItemName);
    }

    @Override
    public List<Restaurant> getRestaurantByCuisine(String cuisine) {
        return restaurantRepository.findAllRestaurantCuisine(cuisine);
    }

    @Override
    public List<Restaurant> getRestaurantByPrice(int price) {
        return restaurantRepository.findAllRestaurantPrice(price);
    }


}
