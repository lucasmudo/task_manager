package com.lucasassismudo.task_manager_springboot.services.task;

import com.lucasassismudo.task_manager_springboot.dto.MinhaTaskDto;
import com.lucasassismudo.task_manager_springboot.dto.request.CreateTaskRequest;

public interface TaskService {

    MinhaTaskDto createTask(CreateTaskRequest createTaskRequest);

    boolean taskDescriptionAlreadyExists(String description);
}
