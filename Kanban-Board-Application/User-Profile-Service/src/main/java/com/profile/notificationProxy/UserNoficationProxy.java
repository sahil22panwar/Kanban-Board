package com.profile.notificationProxy;


import com.profile.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "NOTIFICATION-SERVICE",url = "localhost:8088")
public interface UserNoficationProxy {

    @PostMapping("/api/notification/register")
    public String register(User user);
}