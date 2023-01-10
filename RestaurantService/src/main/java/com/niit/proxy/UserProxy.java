package com.niit.proxy;

import com.niit.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authentication-service",url = "authentication-service:8085")
public interface UserProxy {
    @PostMapping("/api/v1/register")
    public ResponseEntity<?> saveUser(@RequestBody User user);
}
