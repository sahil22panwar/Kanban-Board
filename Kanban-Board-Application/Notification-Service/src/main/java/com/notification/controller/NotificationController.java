package com.notification.controller;

import com.notification.model.Notification;
import com.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Notification")
//@CrossOrigin (origins = "http://localhost:4200")

public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @PostMapping("/saveNotification")
    public ResponseEntity<String> saveSpaceNotification(@RequestBody Notification notification){
        return new ResponseEntity<String>(notificationService.saveSpaceNotification(notification), HttpStatus.CREATED);
    }

    @PostMapping("/saveTaskNotification")
    public ResponseEntity<String> saveTaskNotification(@RequestBody Notification notification){
        return new ResponseEntity<String>(notificationService.saveTaskNotification(notification),HttpStatus.CREATED);
    }
    @GetMapping("/getNotificationLoginUser/{email}")
    public ResponseEntity<?> getNotificationLoginUser(@PathVariable String email){
        return new ResponseEntity<>(notificationService.getNotificationLoginUser(email),HttpStatus.OK);
    }

    @GetMapping("/getAllNotification")
    public ResponseEntity<?> getAllNotification(){
        return new ResponseEntity<>(notificationService.getAllNotification(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSpecifBYId(@PathVariable String id){
        return new ResponseEntity<>(notificationService.deleteSpecifBYId(id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllNotificationBYEmail/{email}")
    public ResponseEntity<?> deleteAllNotificationBYEmail(@PathVariable String email){
        return new ResponseEntity<>(notificationService.deleteAllNotificationBYEmail(email),HttpStatus.OK);
    }

}