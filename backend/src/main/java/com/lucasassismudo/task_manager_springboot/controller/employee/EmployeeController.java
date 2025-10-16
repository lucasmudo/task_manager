package com.lucasassismudo.task_manager_springboot.controller.employee;

import com.lucasassismudo.task_manager_springboot.dto.TaskDto;
import com.lucasassismudo.task_manager_springboot.services.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeController {
    private final EmployeeService employeeService;


    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getTasksByUserId(){
        return ResponseEntity.ok(employeeService.getTasksByUserId());
    }

    @PutMapping("/task/{id}/{status}")
    public ResponseEntity<TaskDto> updateTaskStatus(@PathVariable Long id, @PathVariable String status){
        TaskDto updatedTask = employeeService.updateTaskStatus(id, status);
        if (updatedTask == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updatedTask);
    }
}
