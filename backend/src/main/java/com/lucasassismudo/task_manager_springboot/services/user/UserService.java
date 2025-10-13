package com.lucasassismudo.task_manager_springboot.services.user;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserDetailsService userDetailsService();
}
