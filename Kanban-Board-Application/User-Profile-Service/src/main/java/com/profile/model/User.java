package com.profile.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User {

    private String name;
    @Id
//    @Generated(value = "true")
    private String email;
//    private String password;
    private String mobileNumber;
    private String gender;
    @Transient
    private String password;


}