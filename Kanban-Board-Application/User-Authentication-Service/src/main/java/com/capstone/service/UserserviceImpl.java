package com.capstone.service;

import com.capstone.exception.UserNotFoundException;
import com.capstone.model.User;
import com.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserserviceImpl implements Userservice {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User findByUseremailAndPasswordCheck(String useremail, String password) throws UserNotFoundException {
        User user = userRepository.findByEmailAndPassword(useremail,password);
        if(user == null){
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String changePassword(String email, String pass) {
        User user = userRepository.findByEmail(email);
        System.out.println("=========================================");
        if (user.getEmail().equals(email)){
            String ok = user.getPassword();
            user.setPassword(pass);
            System.out.println(user.getEmail()+"  email And Passs word  "+user.getPassword());
            System.out.println("=========================================");
            userRepository.save(user);
        }
        return "passWord Update";
    }



}