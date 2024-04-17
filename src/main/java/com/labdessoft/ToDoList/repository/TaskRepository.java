package com.labdessoft.ToDoList.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.labdessoft.ToDoList.entity.Tasks;
public interface TaskRepository extends JpaRepository<Tasks, Long> {
}