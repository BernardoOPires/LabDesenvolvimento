package com.labdessoft.ToDoList.Unit.service;

import com.labdessoft.ToDoList.entity.Task;
import com.labdessoft.ToDoList.Mock.TaskMock;
import com.labdessoft.ToDoList.repository.TaskRepository;
import com.labdessoft.ToDoList.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//
//
//CORRIGA ESSE TESTE E APLIQUE EM TODOS OS METODOS
//
//

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    TaskRepository taskRepository;
    
    private TaskService taskService;

    @BeforeEach
    public void setup() {
        taskService = new TaskService(taskRepository);
        Pageable pageable = PageRequest.of(0, 5, Sort.by(
            Sort.Order.asc("name"),
            Sort.Order.desc("id")
        ));
        Mockito.lenient().when(taskRepository.findAll(pageable)).thenReturn(TaskMock.createTasks());
    }

    @Test
    @DisplayName("Deve retornar todas as tarefas")
    public void shouldListAllTasks() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by(
            Sort.Order.asc("name"),
            Sort.Order.desc("id")
        ));
        Page<Task> tasks = taskService.listAll(pageable);
        assertNotNull(tasks);
        assertEquals(1, tasks.getTotalPages());
        assertEquals(2, tasks.getNumberOfElements());
    }
}
