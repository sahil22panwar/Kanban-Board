package com.notification.service;

import com.notification.model.Notification;
import com.notification.model.User;
import com.notification.repository.NotificationRepository;
import com.notification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    @Autowired
   NotificationRepository notificationRepository;
    @Autowired
    UserRepository userRepository;
    public String saveSpaceNotification(Notification notifi) {

        Notification notification = new Notification();

        UUID uuid=UUID.randomUUID();
        String id = String.valueOf(uuid);
        System.out.println(" 26 "+id);

        notification.setNotificationId(id);
        notification.setEmail(notifi.getEmail());
        notification.setSpaceName(notifi.getSpaceName());

        User user = userRepository.findByEmail(notifi.getCreaterName());
        System.out.println(user.getName() +"    "+user.getName());
        if (user != null){
            notification.setCreaterName(user.getName());

            System.out.println(notification);
            notificationRepository.save(notification);
        }
        return " Save Notification";
    }

    public String saveTaskNotification(Notification notification) {
        Notification notifi = new Notification();

        UUID uuid=UUID.randomUUID();
        String id = String.valueOf(uuid);
        System.out.println(" 74 "+id);

        notifi.setNotificationId(id);
        notifi.setEmail(notification.getEmail());
        notifi.setSpaceName(notification.getSpaceName());
        notifi.setTaskName(notification.getTaskName());
        notifi.setAssignedTo("  ASSIGNED TO  ");
        notifi.setTaskAssign(notification.getTaskAssign());
        notifi.setTaskStatus(notification.getTaskStatus());

        User user = userRepository.findByEmail(notification.getEmail());
        User user1 = userRepository.findByEmail(notification.getTaskAssign());
        System.out.println(" user :"+user +"  "+user1);

        notifi.setCreaterName(user.getName());
        notifi.setAssinedName(user1.getName());

        System.out.println(notifi);
        notificationRepository.save(notifi);

        notifi.setEmail(notification.getTaskAssign());
        System.out.println(notifi);
        notificationRepository.save(notifi);

        return "Save Task Notification ";
    }

    public String deleteSpecifBYId(String id) {

        notificationRepository.deleteById(id);
        System.out.println("Delete successfully ");
        return "Delete successfully";
    }

    public  String deleteAllNotificationBYEmail(String email){
        System.out.println("inside deleteAllNotificationBYEmailAndId");
        List<Notification> notification = notificationRepository.findAll();
        System.out.println("86 : "+notification);

        for (Notification n: notification){
            if (n.getEmail().equals(email)){
                notificationRepository.deleteById(n.getNotificationId());
            }
        }
        return "Deleted All Notification";
    }


    public List<Notification> getAllNotification() {
        return notificationRepository.findAll();
    }

    public List<Notification> getNotificationLoginUser(String email) {
        System.out.println("getNotificationLoginUser() in service");
        List<Notification> list=new LinkedList<>();

        List<Notification> notificationList=notificationRepository.findAll();

        list = notificationList.stream().filter((p)->p.getEmail().equals(email)).collect(Collectors.toList());

        Collections.reverse(list);
        System.out.println(list);
        return list;
    }



}