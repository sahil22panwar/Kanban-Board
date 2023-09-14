package com.task.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Notification {
    @Id
    private String notificationId;
    private String email;
    private String spaceName;
    private String taskName;
    private String assignedTo;
    private String taskAssign;

    private String createrName;
    private String assinedName;
    private String taskStatus;

    public Notification(String spaceName, List<String> email, List<Task> taskList) {
    }
}