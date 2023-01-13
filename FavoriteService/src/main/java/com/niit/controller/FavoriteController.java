package com.niit.controller;

import com.niit.domain.Cart;
import com.niit.domain.Favorite;
import com.niit.domain.Order;
import com.niit.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
public class FavoriteController {
    private final IFavoriteService iFavoriteService;

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

    @PutMapping("/addCart/{email}")
    public ResponseEntity<?> addCart(@RequestBody Cart cart, @PathVariable String email) {
        return new ResponseEntity<>(iFavoriteService.addToCart(cart, email), HttpStatus.ACCEPTED);
    }


}
