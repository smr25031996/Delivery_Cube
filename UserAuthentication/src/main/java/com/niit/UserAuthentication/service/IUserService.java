package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {
    User saveUser(User user);

    List<User> getAllUser();

    User findByEmailAndPassword(String email, String password) throws UserNotFoundException;

}
