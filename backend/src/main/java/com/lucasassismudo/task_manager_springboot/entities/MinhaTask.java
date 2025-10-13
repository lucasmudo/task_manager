package com.lucasassismudo.task_manager_springboot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucasassismudo.task_manager_springboot.dto.MinhaTaskDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class MinhaTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate expirationDate;

    public boolean isExpired(){
        if (expirationDate.isEqual(LocalDate.now())){
            System.out.println("Task is due today at ");
            return false;
        }
        LocalDate today = LocalDate.now();

        if (expirationDate.isBefore(today)){
            System.out.println("Task is expired!");
            return true;
        } else {
            System.out.println("Task expires in " + expirationDate.toString());
            return false;
        }
    }


    public MinhaTaskDto getTaskDto() {
        MinhaTaskDto minhaTaskDto = new MinhaTaskDto();
        minhaTaskDto.setId(id);
        minhaTaskDto.setDescription(description);
        minhaTaskDto.setCreationDate(creationDate);
        minhaTaskDto.setExpirationDate(expirationDate);
        return minhaTaskDto;
    }
}
