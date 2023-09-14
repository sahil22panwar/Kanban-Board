package com.notification.model;

import lombok.*;
import org.springframework.data.annotation.Id;
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
    private String email;
}