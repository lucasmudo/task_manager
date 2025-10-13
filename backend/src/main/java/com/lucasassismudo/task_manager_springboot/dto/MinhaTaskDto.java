package com.lucasassismudo.task_manager_springboot.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MinhaTaskDto {
    private Long id;

    private String description;

    private LocalDate creationDate;

    private LocalDate expirationDate;
}
