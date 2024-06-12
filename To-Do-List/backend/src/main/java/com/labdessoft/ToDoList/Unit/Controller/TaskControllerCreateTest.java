// package com.labdessoft.ToDoList.Unit.Controller;

// import com.labdessoft.ToDoList.controller.TaskController;
// import com.labdessoft.ToDoList.entity.Task;
// import com.labdessoft.ToDoList.service.TaskService;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import static org.mockito.Mockito.*;
// import static org.junit.jupiter.api.Assertions.*;
// //
// //
// //CORRIGA ESSE TESTE E APLIQUE EM TODOS OS METODOS
// //
// //
// @ExtendWith(MockitoExtension.class)
// public class TaskControllerCreateTest {

//     @Mock
//     private TaskService taskService;

//     @InjectMocks
//     private TaskController taskController;

//     private Task task;

//     @BeforeEach
//     public void setup() {
//         task = new Task("Nova tarefa", false);
//         when(taskService.createTask(any(Task.class))).thenReturn(task);
//     }

//     @Test
//     @DisplayName("Deve criar uma nova tarefa")
//     public void shouldCreateTask() {
//         ResponseEntity<Task> response = taskController.createTask(task);
//         assertNotNull(response.getBody());
//         assertEquals(HttpStatus.CREATED, response.getStatusCode());
//         assertEquals("Nova tarefa", response.getBody().getDescription());
//     }
// }
