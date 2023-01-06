/*
 * Author Name: Jaival
 * Date: 06-01-2023
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.niit.UserAuthentication.controller;

import com.niit.UserAuthentication.domain.Admin;
import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.exception.AdminNotFoundException;
import com.niit.UserAuthentication.exception.UserNotFoundException;
import com.niit.UserAuthentication.service.IUserService;
import com.niit.UserAuthentication.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private ResponseEntity responseEntity;
    private IUserService iUserService;

    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(IUserService iUserService, SecurityTokenGenerator securityTokenGenerator) {
        this.iUserService = iUserService;
        this.securityTokenGenerator = securityTokenGenerator;
    }


    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(iUserService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/fetch")
    public ResponseEntity<?> fetchUser() {
        return new ResponseEntity<>(iUserService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) throws UserNotFoundException {

        Map<String, String> map = null;
        try {
            User userObj = iUserService.findByEmailAndPassword(user.getEmail(), user.getPassword());
            if (userObj.getEmail().equals(user.getEmail())) {
                map = securityTokenGenerator.generateToken(user);
            }
            responseEntity = new ResponseEntity(map, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/adminlogin")
    public ResponseEntity loginAdmin(@RequestBody Admin admin) throws AdminNotFoundException {

        Map<String, String> map = null;
        try {
            Admin admin1 = iUserService.findByAdminEmailAndPassword(admin.getEmail(), admin.getPassword());
            if (admin1.getEmail().equals(admin.getEmail())) {
                map = securityTokenGenerator.generateToken1(admin);
            }
            responseEntity = new ResponseEntity(map, HttpStatus.OK);
        } catch (AdminNotFoundException e) {
            throw new AdminNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
