package com.lucasassismudo.task_manager_springboot.repositories;

import com.lucasassismudo.task_manager_springboot.entities.MinhaTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MinhaTaskRepository extends JpaRepository<MinhaTask, Long> {
    Optional<MinhaTask> getFirstByDescription(String description);
}
