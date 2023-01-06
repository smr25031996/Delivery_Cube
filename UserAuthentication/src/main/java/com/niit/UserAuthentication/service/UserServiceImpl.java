/*
 * Author Name: Jaival
 * Date: 06-01-2023
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.Admin;
import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.exception.AdminNotFoundException;
import com.niit.UserAuthentication.exception.UserNotFoundException;
import com.niit.UserAuthentication.repository.AdminRepository;
import com.niit.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;
    private AdminRepository adminRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws UserNotFoundException {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public Admin findByAdminEmailAndPassword(String email, String password) throws AdminNotFoundException {
        Admin admin = adminRepository.findAdminByEmailAndPassword(email, password);
        if (admin == null) {
            throw new AdminNotFoundException();
        }
        return admin;
    }
}
