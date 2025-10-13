package com.lucasassismudo.task_manager_springboot.services.task;

import com.lucasassismudo.task_manager_springboot.dto.MinhaTaskDto;
import com.lucasassismudo.task_manager_springboot.entities.MinhaTask;
import com.lucasassismudo.task_manager_springboot.repositories.MinhaTaskRepository;
import com.lucasassismudo.task_manager_springboot.dto.request.CreateTaskRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final MinhaTaskRepository minhaTaskRepository;

    @Override
    public MinhaTaskDto createTask(CreateTaskRequest createTaskRequest){
        MinhaTask minhaTask = new MinhaTask();

//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        minhaTask.setCreationDate(LocalDate.now());
        minhaTask.setDescription(createTaskRequest.getDescription());
        minhaTask.setExpirationDate(createTaskRequest.getExpirationDate());

        MinhaTask createdMinhaTask = minhaTaskRepository.save(minhaTask);
        return createdMinhaTask.getTaskDto();
    }

    @Override
    public boolean taskDescriptionAlreadyExists(String description) {
        return minhaTaskRepository.getFirstByDescription(description).isPresent();
    }

}
