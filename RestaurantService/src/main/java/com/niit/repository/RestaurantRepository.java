package com.niit.repository;

import com.niit.domain.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, Integer> {


    Restaurant findByRestaurantId(int restaurantId);

    List<Restaurant> findByRatingGreaterThan(double rating);

    List<Restaurant> findByRatingLessThan(double rating);


    Restaurant findByRestaurantName(String name);

    List<Restaurant> findByLocation(String location);

    List<Restaurant> findByRating(double rating);

    @Query("{'menuList.foodItemName': {$in:[?0]}}")
    List<Restaurant>
    findAllRestaurantFoodItemName(String foodItemName);

    @Query("{'menuList.cuisine': {$in:[?0]}}")
    List<Restaurant>
    findAllRestaurantCuisine(String cuisine);

    @Query("{'menuList.price': {$in:[?0]}}")
    List<Restaurant>
    findAllRestaurantPrice(int price);

}
