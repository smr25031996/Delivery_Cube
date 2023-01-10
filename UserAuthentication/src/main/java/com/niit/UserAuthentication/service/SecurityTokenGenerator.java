package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> generateToken(User user);

}
