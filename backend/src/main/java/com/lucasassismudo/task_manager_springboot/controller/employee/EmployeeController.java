package com.lucasassismudo.task_manager_springboot.controller.employee;

import com.lucasassismudo.task_manager_springboot.dto.TaskDto;
import com.lucasassismudo.task_manager_springboot.services.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getTasksByUserId(){
        return ResponseEntity.ok(employeeService.getTasksByUserId());
    }
}
