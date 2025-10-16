package com.lucasassismudo.task_manager_springboot.services.employee;

import com.lucasassismudo.task_manager_springboot.dto.TaskDto;
import com.lucasassismudo.task_manager_springboot.entities.Task;
import com.lucasassismudo.task_manager_springboot.entities.User;
import com.lucasassismudo.task_manager_springboot.repositories.TaskRepository;
import com.lucasassismudo.task_manager_springboot.utils.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServieImpl implements EmployeeService{

    private final TaskRepository taskRepository;

    private final JwtUtil jwtUtil;

    @Override
    public List<TaskDto> getTasksByUserId() {
        User user = jwtUtil.getLoggedInUser();
        if (user != null){
           return taskRepository.findAllByUserId(user.getId())
                    .stream()
                    .sorted(Comparator.comparing(Task::getDueDate).reversed())
                    .map(Task::getTaskDto)
                    .collect(Collectors.toList());
        }
        throw new EntityNotFoundException("User not found!");
    }
}
