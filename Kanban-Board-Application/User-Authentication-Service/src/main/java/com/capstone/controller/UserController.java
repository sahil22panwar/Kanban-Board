package com.capstone.controller;

import com.capstone.exception.UserNotFoundException;
import com.capstone.model.User;
import com.capstone.service.JwtSecurityTokenGeneratorImpl;
import com.capstone.service.UserserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    UserserviceImpl userservice;

    @Autowired
    JwtSecurityTokenGeneratorImpl jwtSecurityTokenGenerator;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        userservice.registerUser(user);
        return new ResponseEntity<String>("User Created",HttpStatus.OK);
    }

//    @PutMapping("/password/{email}/{pass}")
    @PostMapping("/password/{email}/{pass}")
    public ResponseEntity<?> changePassword(@PathVariable String email,@PathVariable String pass){
        System.out.println("========= Inside the change method controller ==============");
        System.out.println("change paasword : "+pass);
        return new ResponseEntity<String>(userservice.changePassword(email,pass),HttpStatus.OK);
    }

    @GetMapping("/protected/allUser")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userservice.getAllUsers(),HttpStatus.OK);
    }

    //email and password
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws UserNotFoundException {
        ResponseEntity responseEntity;
        try{
            User user1 = userservice.findByUseremailAndPasswordCheck(user.getEmail(),user.getPassword());
            System.out.println("Check user name and Password");
            System.out.println(user1.getEmail()+" cheking it is corect or not  "+user1.getPassword());
            if (user1.getEmail().equals(user.getEmail()) && user1.getPassword().equals(user.getPassword())){
                //Creating a token
                Map<String,String> tokenMap =jwtSecurityTokenGenerator.generateToken(user1);
                responseEntity = new ResponseEntity<>(tokenMap,HttpStatus.OK);
            }else {
                responseEntity = new ResponseEntity<>("Invalid User",HttpStatus.NOT_FOUND);
                //throw new UserNotFoundException();
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            responseEntity =new ResponseEntity<>("User is not present", HttpStatus.NOT_FOUND);
        }catch (Exception ee){
            ee.printStackTrace();
            responseEntity =new ResponseEntity<>("Some Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}