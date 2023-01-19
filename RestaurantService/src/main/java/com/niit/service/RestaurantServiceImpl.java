/*
 *Author Name :P.Hemanth Sai Teja
 *Date:06-01-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.service;

import com.niit.configuration.MessageDTO;
import com.niit.configuration.Producer;
import com.niit.domain.MenuList;
import com.niit.domain.Restaurant;
import com.niit.domain.User;
import com.niit.exception.MenuListNotFoundException;
import com.niit.exception.RestaurantNotFoundException;
import com.niit.proxy.UserProxy;
import com.niit.repository.RestaurantRepository;
import com.niit.repository.UserRepository;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements IRestaurantService{
    private RestaurantRepository restaurantRepository;
    private UserRepository userRepository;

    private UserProxy userProxy;
    private  Optional<User> favoriteUser;

    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;

    @Autowired
    Producer producer;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, UserRepository userRepository, UserProxy userProxy, Optional<User> favoriteUser,RabbitTemplate rabbitTemplate,DirectExchange directExchange) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.userProxy = userProxy;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
        this.favoriteUser= favoriteUser;
    }

    @Override
    public User registerUser(User user) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setEmail(user.getEmail());
        if(userRepository.findById(user.getEmail()).isPresent())
        {
           favoriteUser=getUserByEmail(user.getEmail());
            if (user.getEmail().equals(favoriteUser.get().getEmail())) {
                System.out.println("Invalid email: " + user.getEmail());
            } else {
               userRepository.save(user);
                System.out.println("saved user in mongo");
                producer.sendMessage(messageDTO);
            }

        } else {
            userRepository.save(user);
            System.out.println("saved user in mongo");
            producer.sendMessage(messageDTO);
        }

        userProxy.saveUser(user);
        return user;
    }

    @Override
    public User updateUser(User user, String email) {
        Optional<User> existingUser = userRepository.findById(email);
        if (existingUser.isEmpty()) {
            return null;
        }
        User user1 = existingUser.get();
        if (user.getFirstName() != null) {
            user1.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            user1.setLastName(user.getLastName());
        }
        if (user.getPhone() != 0) {
            user1.setPhone(user.getPhone());
        }

        if (user.getProfileImage() != null) {
            user1.setProfileImage(user.getProfileImage());
        }
        if (user.getStreet() != null) {
            user1.setStreet(user.getStreet());
        }
        if (user.getState() != null) {
            user1.setState(user.getState());
        }
        if (user.getCity() != null) {
            user1.setCity(user.getCity());
        }
        if (user.getZip() != null) {
            user1.setZip(user.getZip());
        }
        return userRepository.save(user1);
    }

    @Override
    public Optional<User> getUserById(String email) {
        return userRepository.findById(email);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {

        Optional<User> user=userRepository.findById(email);

        System.out.println(" user data fetched from client request---"+user.get().toString());
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setEmail(user.get().getEmail());
        producer.sendMessage(messageDTO);
        return user;
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

    @Override
    public MessageDTO sendMessage(MessageDTO messageDTO) {
        producer.sendMessage(messageDTO);
        return messageDTO;
    }


    @Override
    public Restaurant saveRestaurantMenuToList(MenuList menuList, int restaurantId) throws RestaurantNotFoundException {
        if (restaurantRepository.findById(restaurantId).isEmpty()) {

            throw new RestaurantNotFoundException();
        }
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        if (restaurant.getMenuList() == null) {
            System.out.println("In repo " + restaurantId);
            restaurant.setMenuList(Collections.singletonList(menuList));
        } else {
            List<MenuList> menuLists = restaurant.getMenuList();
            menuLists.add(menuList);
            restaurant.setMenuList(menuLists);
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<MenuList> getAllRestaurantMenu(int restaurantId) throws RestaurantNotFoundException {
        if (restaurantRepository.findById(restaurantId).isEmpty()) {
            throw new RestaurantNotFoundException();
        }
        return restaurantRepository.findById(restaurantId).get().getMenuList();
    }

    @Override
    public Restaurant deleteRestaurantMenuFromList(int restaurantId, String foodItemName) throws RestaurantNotFoundException, MenuListNotFoundException {
        boolean foodItemIsPresent = false;
        if (restaurantRepository.findById(restaurantId).isEmpty()) {
            throw new RestaurantNotFoundException();
        }
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        List<MenuList> menuLists = restaurant.getMenuList();
        foodItemIsPresent = menuLists.removeIf(x -> x.getFoodItemName().equals(foodItemName));
        if (!foodItemIsPresent) {
            throw new MenuListNotFoundException();
        }
        restaurant.setMenuList(menuLists);
        return restaurantRepository.save(restaurant);
    }


}
