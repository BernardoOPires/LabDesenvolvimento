package com.labdessoft.ToDoList.Mock;

import com.labdessoft.ToDoList.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class TaskMock {

    public static Task createTask() {
        Task task = new Task();
        task.setId(1L);
        task.setDescription("Tarefa de teste");
        task.setCompleted(false);
        return task;
    }

    public static List<Task> createTaskList() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(createTask()); 
        Task task2 = new Task();
        task2.setId(2L);
        task2.setDescription("Outra tarefa de teste");
        task2.setCompleted(true);
        tasks.add(task2);
        return tasks;
    }

    public static Page<Task> createTasksPage(Pageable pageable) {
        List<Task> tasks = createTaskList();
        return new PageImpl<>(tasks, pageable, tasks.size());
    }
}
