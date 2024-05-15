package com.labdessoft.ToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.labdessoft.ToDoList.entity.Task;
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}