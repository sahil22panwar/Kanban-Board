package com.notification.repository;

import com.notification.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,String>{
//    @Override
//    List<Notification> findAll();

    Notification findByEmail(String email);
}