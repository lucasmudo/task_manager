package com.lucasassismudo.task_manager_springboot.controller.task;

import com.lucasassismudo.task_manager_springboot.dto.MinhaTaskDto;
import com.lucasassismudo.task_manager_springboot.dto.request.CreateTaskRequest;
import com.lucasassismudo.task_manager_springboot.services.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody CreateTaskRequest createTaskRequest){
        if (taskService.taskDescriptionAlreadyExists(createTaskRequest.getDescription())){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Task description already exists");
        }
        MinhaTaskDto createdTask = taskService.createTask(createTaskRequest);
        if (createdTask == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task couldn't be created");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }
}
