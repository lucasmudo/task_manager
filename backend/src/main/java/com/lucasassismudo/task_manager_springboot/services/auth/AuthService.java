package com.lucasassismudo.task_manager_springboot.services.auth;

import com.lucasassismudo.task_manager_springboot.dto.request.SignupRequest;
import com.lucasassismudo.task_manager_springboot.dto.UserDto;

public interface AuthService {
    UserDto signupUser(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}
