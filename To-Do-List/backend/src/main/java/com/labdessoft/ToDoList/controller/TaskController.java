package com.labdessoft.ToDoList.controller;

import com.labdessoft.ToDoList.entity.Task;
import com.labdessoft.ToDoList.service.TaskService;
// import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    // @Operation(summary = "Pegar tarefa por ID")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
        return ResponseEntity.ok(task);
    }

    @GetMapping
    // @Operation(summary = "Listar todas as tarefas")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.findAll();
        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    // @Operation(summary = "Adicionar uma nova tarefa")
    public ResponseEntity<Task> createTask(@RequestBody Task newTask) {
        Task task = taskService.createTask(newTask);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    // @Operation(summary = "Atualizar uma tarefa existente")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task updatedTask = taskService.updateTask(id, taskDetails);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    // @Operation(summary = "Deletar uma tarefa")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/toggle-status")
    // @Operation(summary = "Alterar o status de uma tarefa")
    public ResponseEntity<Task> toggleTaskStatus(@PathVariable Long id) {
        Task task = taskService.toggleTaskStatus(id);
        return ResponseEntity.ok(task);
    }
}
