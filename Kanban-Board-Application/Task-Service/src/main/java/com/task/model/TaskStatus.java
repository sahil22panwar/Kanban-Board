package com.task.model;

import lombok.*;
import org.apache.catalina.User;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public enum TaskStatus{
    TO_BE_DONE,
    IN_PROGRESS,
    COMPLETED;
}

