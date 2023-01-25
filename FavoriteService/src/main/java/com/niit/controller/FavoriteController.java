package com.niit.controller;

import com.niit.domain.*;
import com.niit.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
public class FavoriteController {
    private final IFavoriteService iFavoriteService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public FavoriteController(IFavoriteService iFavoriteService) {
        this.iFavoriteService = iFavoriteService;
    }


    @PostMapping("/saveFavorite/{email}")
    public ResponseEntity<?> saveFavorite(@RequestBody Favorite favorite, @PathVariable String email) {
        return new ResponseEntity<>(iFavoriteService.saveFavorite(favorite), HttpStatus.CREATED);
    }

    @PostMapping("/saveCart")
    public ResponseEntity<?> saveCart(@RequestBody Cart cart) {
        return new ResponseEntity<>(iFavoriteService.saveCart(cart), HttpStatus.CREATED);
    }

    @PostMapping("/saveOrder")
    public ResponseEntity<?> saveOrder(@RequestBody Order order) {
        return new ResponseEntity<>(iFavoriteService.saveOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("/getFavorite")
    public ResponseEntity<?> getFavorite() {
        return new ResponseEntity<>(iFavoriteService.getFavoriteList(), HttpStatus.OK);
    }

    @GetMapping("/getCart")
    public ResponseEntity<?> getCart() {
        return new ResponseEntity<>(iFavoriteService.getCartList(), HttpStatus.OK);
    }

    @GetMapping("/getOrder")
    public ResponseEntity<?> getOrder() {
        return new ResponseEntity<>(iFavoriteService.getOrderList(), HttpStatus.OK);
    }

    @PutMapping("/addFavorite/{email}")
    public ResponseEntity<?> addFavorite(@RequestBody Favorite favorite, @PathVariable String email) {
        return new ResponseEntity<>(iFavoriteService.addFavourite(favorite, email), HttpStatus.ACCEPTED);
    }

    @PutMapping("/addOrder/{email}")
    public ResponseEntity<?> addOrder(@RequestBody Order order, @PathVariable String email) {
        return new ResponseEntity<>(iFavoriteService.addOrder(order, email), HttpStatus.ACCEPTED);
    }




    @PostMapping("/favorite/addRestaurant/{email}")
    public ResponseEntity<?> saveMenuToRestaurant(@RequestBody RestaurantList restaurantList, @PathVariable String email) {
//        try {
        System.out.println("email " + email);

        responseEntity = new ResponseEntity<>(iFavoriteService.saveRestaurantToFavorites(restaurantList, email), HttpStatus.CREATED);
//        } catch (RestaurantNotFoundException e) {
//            System.out.println(e);
//            throw new RestaurantNotFoundException();
//        }

        return responseEntity;
    }

    @GetMapping("/favorite/restaurants/{email}")
    public ResponseEntity<?> getAllMenusFromRestaurant(@PathVariable String email) {
//        try {
        System.out.println("email " + email);
        responseEntity = new ResponseEntity<>(iFavoriteService.getAllRestaurantFromFavorites(email), HttpStatus.OK);
//        } catch (RestaurantNotFoundException e) {
//            throw new RestaurantNotFoundException();
//        }
        return responseEntity;
    }


    @DeleteMapping("/restaurantList/{email}/{restaurantId}")
    public ResponseEntity<?> deleteRestaurantFromFavorites(@PathVariable String email, @PathVariable int restaurantId) {
//        try {
        responseEntity = new ResponseEntity<>(iFavoriteService.deleteRestaurantFromFavorites(email, restaurantId), HttpStatus.OK);
//        } catch (RestaurantNotFoundException | MenuListNotFoundException m) {
//            throw new MenuListNotFoundException();
//        }
        return responseEntity;
    }


    @PostMapping("/cart/addMenu/{email}")
    public ResponseEntity<?> saveMenuToCart(@RequestBody MenuList menuList, @PathVariable String email) {
//        try {
        System.out.println("email " + email);

        responseEntity = new ResponseEntity<>(iFavoriteService.saveMenuToCart(menuList, email), HttpStatus.CREATED);
//        } catch (RestaurantNotFoundException e) {
//            System.out.println(e);
//            throw new RestaurantNotFoundException();
//        }

        return responseEntity;
    }

    @GetMapping("/cart/menus/{email}")
    public ResponseEntity<?> getAllMenusFromCart(@PathVariable String email) {
//        try {
        System.out.println("email " + email);
        responseEntity = new ResponseEntity<>(iFavoriteService.getAllMenusFromCart(email), HttpStatus.OK);
//        } catch (RestaurantNotFoundException e) {
//            throw new RestaurantNotFoundException();
//        }
        return responseEntity;
    }


    @DeleteMapping("/menuList/{email}/{foodItemName}")
    public ResponseEntity<?> deleteMenuProductFromList(@PathVariable String email, @PathVariable String foodItemName) {
//        try {
        responseEntity = new ResponseEntity<>(iFavoriteService.deleteMenuFromCart(email, foodItemName), HttpStatus.OK);
//        } catch (RestaurantNotFoundException | MenuListNotFoundException m) {
//            throw new MenuListNotFoundException();
//        }
        return responseEntity;
    }


    @PostMapping("/order/{email}")
    public ResponseEntity<?> saveMenuToOrder(@RequestBody MenuList menuList, @PathVariable String email) {
//        try {
        System.out.println("email " + email);

        responseEntity = new ResponseEntity<>(iFavoriteService.saveMenuToOrder(menuList, email), HttpStatus.CREATED);
//        } catch (RestaurantNotFoundException e) {
//            System.out.println(e);
//            throw new RestaurantNotFoundException();
//        }

        return responseEntity;
    }

    @GetMapping("/order/menus/{email}")
    public ResponseEntity<?> getAllMenusFromOrder(@PathVariable String email) {
//        try {
        System.out.println("email " + email);
        responseEntity = new ResponseEntity<>(iFavoriteService.getAllMenusFromOrder(email), HttpStatus.OK);
//        } catch (RestaurantNotFoundException e) {
//            throw new RestaurantNotFoundException();
//        }
        return responseEntity;
    }


    @DeleteMapping("/menus/{email}/{foodItemName}")
    public ResponseEntity<?> deleteMenuProductFromOrder(@PathVariable String email, @PathVariable String foodItemName) {
//        try {
        responseEntity = new ResponseEntity<>(iFavoriteService.deleteMenuFromOrder(email, foodItemName), HttpStatus.OK);
//        } catch (RestaurantNotFoundException | MenuListNotFoundException m) {
//            throw new MenuListNotFoundException();
//        }
        return responseEntity;
    }

}
