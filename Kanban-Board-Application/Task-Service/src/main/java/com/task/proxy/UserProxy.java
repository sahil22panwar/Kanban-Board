package com.task.proxy;

import com.task.model.Notification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "NOTIFICATION-SERVICE",url = "localhost:8088")
public interface UserProxy {
    @PostMapping("/api/Notification/saveNotification")
    public ResponseEntity<String> saveNotification(@RequestBody Notification notification);

    @PostMapping("/api/Notification/saveTaskNotification")
    public ResponseEntity<String> saveTaskNotification(@RequestBody Notification notification);
}