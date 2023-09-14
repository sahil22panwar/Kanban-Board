package com.profile.controller;

import com.profile.exception.UserException;
import com.profile.model.User;
import com.profile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> register(@RequestBody User user){
        return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }

    @PutMapping("/updateNumber/{email}/{number}")
    public ResponseEntity<?> updateMobile(@PathVariable String email,@PathVariable String number) throws UserException {
        return new ResponseEntity<List<User>>(userService.updateMobile(email,number),HttpStatus.CREATED);
    }

    @GetMapping("/userName/{email}")
    public ResponseEntity<?> getUserName(@PathVariable String email){
        return new ResponseEntity<>(userService.getUserName(email),HttpStatus.OK);
    }

    @GetMapping("/retrieve/{email}")
    public ResponseEntity<?> getUserDetail(@PathVariable String email){
        System.out.println("***********  getUserDetail ************");
        System.out.println(email);
        return new ResponseEntity<User>(userService.getUserDetail(email),HttpStatus.OK);
    }

    @GetMapping("/displayAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }


}