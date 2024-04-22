package com.labdessoft.ToDoList.controller;

import com.labdessoft.ToDoList.entity.Tasks;
import com.labdessoft.ToDoList.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/id")
    @Operation(summary = "Pegar por id")
    public ResponseEntity<Task> buscarPorId(@PathVariable Long id) {
        Task taskOptional = TaskRepository.findById(id);
        if (taskOptional != null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return taskOptional.get();
    }

    @GetMapping("/Lista-Tarefas")
    @Operation(summary = "Lista todas as tarefas da lista")
    public ResponseEntity<Task> listAll() {
        // try {
        //     List<Tasks> taskList = new ArrayList<Tasks>();
        //     taskRepository.findAll().forEach(taskList::add);
        //     if (taskList.isEmpty()) {
        //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        //     }
        //     return new ResponseEntity<>(taskList, HttpStatus.OK);
        // } catch (Exception e) {//
        //     return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        // }
    }

    @GetMapping("/Adicionar-Tarefas")
    @Operation(summary = "Adiciona uma tarefa a lista")
    public ResponseEntity<Tasks> addTask(@RequestBody Tasks newTask) {
        Tasks task = taskRepository.save(newTask);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping("/Deletar-Tarefas")
    @Operation(summary = "Deleta uma tarefa da lista")
    public ResponseEntity<Task> deletarPorId(@PathVariable Long id) {
        Task taskOptional = TaskRepository.findById(id);
        if (taskOptional != null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return taskOptional.get();
    }

    @GetMapping("/Editar-Tarefas")
    @Operation(summary = "Edita uma tarefa da lista")
    public ResponseEntity<Tasks> editTask(@PathVariable Long id, @RequestBody Tasks taskDetails) {
        var taskOptional = taskRepository.findById(id);
        if (taskOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        task.setId(id);
        task.setDescription(taskDetails);
        return taskRepository.save(task);
    }
    }

   
