package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.Admin;
import com.niit.UserAuthentication.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> generateToken(User user);

    Map<String, String> generateToken1(Admin admin);
}
