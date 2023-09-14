package com.profile.service;

import com.profile.exception.UserException;
import com.profile.model.User;
import com.profile.notificationProxy.UserNoficationProxy;
import com.profile.proxy.UserProxy;
import com.profile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProxy userProxy;
    @Autowired
    UserNoficationProxy userNoficationProxy;
    public String register(User user) {
        if (user != null){
            System.out.println("** Register User inside the Authentication service **");
            userProxy.saveUser(user);
        }if (user != null){
            System.out.println("** Register User inside the Notification Service **");
            userNoficationProxy.register(user);
        }
        userRepository.save(user);
        System.out.println("***** Register User *****");
        System.out.println(user);
        return "Registration Successfully Done";
    }

    public List<User> updateMobile(String email, String number) throws UserException {

       User user =  userRepository.findByEmail(email);
        if (user.getEmail().equals(email)){
            String list = user.getMobileNumber();
            user.setMobileNumber(number);
            System.out.println(user.getMobileNumber());
            System.out.println("=========================================");
            System.out.println(user);
        }
        return (List<User>) userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public String getUserName(String email) {
        User user = userRepository.findByEmail(email);

        String username = null;
        if (user.getEmail().equals(email)){
            username = user.getName();
        }
        return username;
    }

    public User getUserDetail(String email) {
        System.out.println("***** service getUserDetail");
        User user = new User();
        user = userRepository.findById(email).get();
        System.out.println(user);
        return user;
    }


}