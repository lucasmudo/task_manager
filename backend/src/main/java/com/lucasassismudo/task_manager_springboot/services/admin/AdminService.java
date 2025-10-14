package com.lucasassismudo.task_manager_springboot.services.admin;

import com.lucasassismudo.task_manager_springboot.dto.TaskDto;
import com.lucasassismudo.task_manager_springboot.dto.UserDto;

import java.util.List;

public interface AdminService {

    List<UserDto> getUsers();

    TaskDto createTask(TaskDto taskDto);

    List<TaskDto> getAllTasks();

    void deleteTask(Long id);

    TaskDto getTaskById(Long id);

    TaskDto updateTask(Long id, TaskDto taskDto);

    List<TaskDto> searchTaskByTitle(String title);
}
