package com.task.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Space {

    @Id
    private String spaceName;
    //private String email;
   private List<String> email;
    private List<Task> taskList;
}