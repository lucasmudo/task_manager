package com.lucasassismudo.task_manager_springboot.repositories;

import com.lucasassismudo.task_manager_springboot.dto.TaskDto;
import com.lucasassismudo.task_manager_springboot.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
     List<Task> findAllByTitleContaining(String title);

     List<Task> findAllByUserId(Long userId);
}
