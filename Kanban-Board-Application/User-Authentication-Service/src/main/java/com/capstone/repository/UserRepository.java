package com.capstone.repository;

import com.capstone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
//    public User findByUseremailAndPassword(String useremail,String password);
    public User findByEmailAndPassword(String useremail, String password);
    public User findByEmail(String email);
}
