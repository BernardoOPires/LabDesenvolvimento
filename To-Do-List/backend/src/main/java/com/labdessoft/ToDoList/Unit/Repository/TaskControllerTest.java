package com.labdessoft.ToDoList.Unit.Controller;

import com.labdessoft.ToDoList.controller.TaskController;
import com.labdessoft.ToDoList.entity.Task;
import com.labdessoft.ToDoList.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {
    @Mock
    private TaskService taskService;
    
    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    public void setup() {
        Task task = new Task("Descrição da tarefa", false);
        when(taskService.findAll()).thenReturn(Collections.singletonList(task));
    }

    @Test
    @DisplayName("Deve retornar todas as tarefas")
    public void shouldGetAllTasks() {
        ResponseEntity<List<Task>> response = taskController.getAllTasks();
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals("Descrição da tarefa", response.getBody().get(0).getDescription());
    }
}
