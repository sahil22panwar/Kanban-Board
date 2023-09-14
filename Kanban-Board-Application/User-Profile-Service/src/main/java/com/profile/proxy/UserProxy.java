package com.profile.proxy;

import com.profile.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USER-AUTHENTICATION-SERVICE",url = "localhost:8081")
public interface UserProxy {
    @PostMapping("/api/v1/register")
    public ResponseEntity<String> saveUser(@RequestBody User user);
}