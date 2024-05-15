package com.labdessoft.ToDoList.service;

import com.labdessoft.ToDoList.entity.Task;
import com.labdessoft.ToDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Optional;  
import java.util.List;  
import java.util.stream.Collectors;  
import java.util.Comparator;  

import java.time.LocalDate;  
import org.springframework.web.bind.annotation.Schema;  


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Schema(name = "O tipo e data ja são passados pelo objeto task")
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id n encontrado"));
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.getCompleted());
        task.setStartDate(taskDetails.getStartDate());
        task.setDueDate(taskDetails.getDueDate());
        task.setType(taskDetails.getType());
        task.setPriority(taskDetails.getPriority());

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id n encontrado"));
        taskRepository.delete(task);
    }

    public Task toggleTaskStatus(Long id) {
        Task task = findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id n encontrado"));
        task.setCompleted(!task.getCompleted());
        return taskRepository.save(task);
    }

    public List<Task> findAllOrderByPriority() {
        return taskRepository.findAll().stream()
                .sorted(Comparator.comparing(Task::getPriority))//cannot fnd symbol
                .collect(Collectors.toList());//cannot fnd symbol
    }

}
