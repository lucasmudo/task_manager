package com.lucasassismudo.task_manager_springboot.services.employee;

import com.lucasassismudo.task_manager_springboot.dto.TaskDto;

import java.util.List;

public interface EmployeeService {
    List<TaskDto> getTasksByUserId();

    TaskDto updateTaskStatus(Long id, String status);
}
