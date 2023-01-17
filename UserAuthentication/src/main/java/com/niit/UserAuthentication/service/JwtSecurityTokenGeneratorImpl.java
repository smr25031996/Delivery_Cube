/*
 * Author Name: Jaival
 * Date: 13-12-2022
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Map<String, Object> generateToken(User user) {

        String jwtToken = null;

        jwtToken = Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        Map<String, Object> map = new HashMap<>();
        map.put("token", jwtToken);
        map.put("message", "User Successfully logged in");
        map.put("user",userRepository.findById(user.getEmail()));
        return map;
    }
}

