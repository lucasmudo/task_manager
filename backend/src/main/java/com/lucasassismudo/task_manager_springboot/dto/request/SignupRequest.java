package com.lucasassismudo.task_manager_springboot.dto.request;

import lombok.Data;

@Data
public class SignupRequest {

    private String name;

    private String email;

    private String password;
}
