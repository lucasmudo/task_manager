package com.lucasassismudo.task_manager_springboot.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateTaskRequest {
    private String description;

    private LocalDate expirationDate;
}
