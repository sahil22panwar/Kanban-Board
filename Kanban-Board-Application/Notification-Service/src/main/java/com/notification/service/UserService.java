package com.notification.service;

import com.notification.model.User;
import com.notification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public String register(User user) {
        userRepository.save(user);
        return "register successfully";
    }



}