package com.lucasassismudo.task_manager_springboot.repositories;

import com.lucasassismudo.task_manager_springboot.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
