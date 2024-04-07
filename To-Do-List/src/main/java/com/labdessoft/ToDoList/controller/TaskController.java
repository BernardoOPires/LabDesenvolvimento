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

    @GetMapping("/Lista-Tarefas")
    @Operation(summary = "Lista todas as tarefas da lista")
    public ResponseEntity<List<Task>> listAll() {
try{
List<Tasks> taskList = new ArrayList<Tasks>();
taskRepository.findAll().forEach(taskList::add);
if(taskList.isEmpty()){
return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
return null;
// return new ResponseEntity<>(taskList, HttpStatus.OK);
} catch (Exception e) {
return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
}
}


    @GetMapping("/Adicionar-tarfea")
    @Operation(summary = "Adiciona uma tarefa a lista")
    public void AddTask() {
    //corrigir quando tiver tempo
    }

    @GetMapping("/Deleterar-tarefa")
    @Operation(summary = "Deleta uma tarefa da lista")
    public void DelTask(Tasks task) {
        try{
        taskRepository.delete(task);
        }catch (Exception e) {
            
        }
    }

    @GetMapping("/Editar-tarefa")
    @Operation(summary = "Edita uma tarefa da lista")
    // public ResponseEntity<List<Task>> EditTask() {
        public void EditTask() {
       //corrigir quando tiver tempo
    }

}