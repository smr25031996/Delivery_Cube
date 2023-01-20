/*
 *Author Name :P.Hemanth Sai Teja
 *Date:06-01-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.controller;

import com.niit.domain.Image;
import com.niit.domain.MenuList;
import com.niit.domain.Restaurant;
import com.niit.domain.User;
import com.niit.exception.MenuListNotFoundException;
import com.niit.exception.RestaurantNotFoundException;
import com.niit.repository.ImageRepository;
import com.niit.repository.UserRepository;
import com.niit.service.IRestaurantService;
import com.niit.util.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2")
public class RestaurantController {
    private IRestaurantService iRestaurantService;
    int restaurantId;
    private ResponseEntity<?> responseEntity;
    private final UserRepository userRepository;

    private ImageRepository imageRepository;

    @Autowired
    public RestaurantController(IRestaurantService iRestaurantService,
                                UserRepository userRepository, ImageRepository imageRepository) {
        this.iRestaurantService = iRestaurantService;
        this.userRepository = userRepository;
        this.imageRepository = imageRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        return new ResponseEntity<>(iRestaurantService.registerUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/userbyid/{email}")
    public ResponseEntity<?> getUserbyId(@PathVariable String email) {
        return  new ResponseEntity<>(iRestaurantService.getUserById(email), HttpStatus.OK) ;
    }

    @GetMapping("/fetchUser")
    public ResponseEntity<?> fetchUser( ){
        return  new ResponseEntity<>(iRestaurantService.getUsers(), HttpStatus.OK) ;
    }

    @PutMapping("/updateUser/{email}")
    public ResponseEntity<?> updateByEmail(@RequestBody User user, @PathVariable String email) {
        return  new ResponseEntity<>(iRestaurantService.updateUser(user,email), HttpStatus.ACCEPTED) ;
    }
    @PostMapping("/saveRestaurant")
    public ResponseEntity<?> saveRestaurant(@RequestBody Restaurant restaurant){
    return  new ResponseEntity<>(iRestaurantService.saveRestaurant(restaurant), HttpStatus.CREATED) ;
    }
    @GetMapping("/fetchAll")
    public ResponseEntity<?> fetchAll( ){
        return  new ResponseEntity<>(iRestaurantService.getAllRestaurants(), HttpStatus.OK) ;
    }


    @GetMapping("/restaurantbyname/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        return  new ResponseEntity<>(iRestaurantService.getByRestaurantName(name), HttpStatus.OK) ;
    }

    @GetMapping("/restaurantbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return  new ResponseEntity<>(iRestaurantService.getRestaurantById(id), HttpStatus.OK) ;
    }

    @GetMapping("/restaurantbylocation/{location}")
    public ResponseEntity<?> getByLocation(@PathVariable String location) {
        return  new ResponseEntity<>(iRestaurantService.getByLocation(location), HttpStatus.OK) ;
    }
    @GetMapping("/restaurantbyrating/{rating}")
    public ResponseEntity<?> getByRating(@PathVariable double rating) {
        return  new ResponseEntity<>(iRestaurantService.getByRating(rating), HttpStatus.OK) ;
    }

    @DeleteMapping("/restaurantbyid/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return  new ResponseEntity<>(iRestaurantService.deleteRestaurants(id) ,HttpStatus.CREATED);

    }

    @PutMapping("/updateRestaurant/{id}")
    public ResponseEntity<?> updateById(@RequestBody Restaurant restaurant, @PathVariable int id) {
        return  new ResponseEntity<>(iRestaurantService.updateRestaurant(restaurant,id), HttpStatus.ACCEPTED) ;
    }

    @GetMapping("/filterbyrating/{rating}")
    public ResponseEntity<?> filterByRating(@PathVariable double rating) {
        return  new ResponseEntity<>(iRestaurantService.getRestaurantsGreaterthan(rating), HttpStatus.OK) ;
    }
    @GetMapping("/filterbyLesserRating/{rating}")
    public ResponseEntity<?> filterLessRating(@PathVariable double rating) {
        return  new ResponseEntity<>(iRestaurantService.getRestaurantsLessThan(rating), HttpStatus.OK) ;
    }

    @GetMapping("/getbyfoodname/{foodname}")
    public ResponseEntity<?> getByFoodName(@PathVariable String foodname) {
        return  new ResponseEntity<>(iRestaurantService.getRestaurantByFoodItemName(foodname), HttpStatus.OK) ;
    }

    @GetMapping("/getbycuisine/{cuisinename}")
    public ResponseEntity<?> getByCuisine(@PathVariable String cuisinename) {
        return new ResponseEntity<>(iRestaurantService.getRestaurantByCuisine(cuisinename), HttpStatus.OK);
    }

    @GetMapping("/getbyprice/{price}")
    public ResponseEntity<?> getByPrice(@PathVariable int price) {
        return new ResponseEntity<>(iRestaurantService.getRestaurantByPrice(price), HttpStatus.OK);
    }


    @PostMapping("/restaurant/addMenu/{restaurantId}")
    public ResponseEntity<?> saveMenuToRestaurant(@RequestBody MenuList menuList, @PathVariable int restaurantId) throws RestaurantNotFoundException {
        try {
            System.out.println("restaurantId " + restaurantId);

            responseEntity = new ResponseEntity<>(iRestaurantService.saveRestaurantMenuToList(menuList, restaurantId), HttpStatus.CREATED);
        } catch (RestaurantNotFoundException e) {
            System.out.println(e);
            throw new RestaurantNotFoundException();
        }

        return responseEntity;
    }


    @GetMapping("/restaurant/menus/{restaurantId}")
    public ResponseEntity<?> getAllMenusFromRestaurant(@PathVariable int restaurantId) throws RestaurantNotFoundException {
        try {
            System.out.println("restaurantId " + restaurantId);
            responseEntity = new ResponseEntity<>(iRestaurantService.getAllRestaurantMenu(restaurantId), HttpStatus.OK);
        } catch (RestaurantNotFoundException e) {
            throw new RestaurantNotFoundException();
        }
        return responseEntity;
    }


    @DeleteMapping("/menuList/{restaurantId}/{foodItemName}")
    public ResponseEntity<?> deleteUserProductFromList(@PathVariable int restaurantId, @PathVariable String foodItemName)
            throws RestaurantNotFoundException, MenuListNotFoundException {
        try {
            responseEntity = new ResponseEntity<>(iRestaurantService.deleteRestaurantMenuFromList(restaurantId, foodItemName), HttpStatus.OK);
        } catch (RestaurantNotFoundException | MenuListNotFoundException m) {
            throw new MenuListNotFoundException();
        }
        return responseEntity;
    }


    @PostMapping("/upload/image")
    public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file)
            throws IOException {

        imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("Image uploaded successfully: " +
                        file.getOriginalFilename()));
    }

    @GetMapping(path = {"/get/image/info/{name}"})
    public Image getImageDetails(@PathVariable("name") String name) throws IOException {

        final Optional<Image> dbImage = imageRepository.findByName(name);

        return Image.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
    }

}
