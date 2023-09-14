package com.capstone.service;

import com.capstone.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public Map<String, String> generateToken(User user);
}
