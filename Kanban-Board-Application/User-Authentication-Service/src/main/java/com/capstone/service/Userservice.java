package com.capstone.service;

import com.capstone.model.User;

import java.util.List;

public interface Userservice {
    public User registerUser(User user);
    public List<User> getAllUsers();
}
