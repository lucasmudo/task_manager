package com.lucasassismudo.task_manager_springboot.dto.responses;

import com.lucasassismudo.task_manager_springboot.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;

    private Long userId;

    private UserRole userRole;

}
