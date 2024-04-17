package com.labdessoft.ToDoList.entity;

import java.util.Iterator;
import java.util.List;



public class TaskList {
    List<Tasks> list;

    public void TaskList() {

    }

    public void TaskList(List<Tasks> list) {
        this.list = list;
    }

    public void addTask(Tasks task) {
        list.add(task);
    }

    public void removeTask(int id) {
        for (Iterator<Tasks> iterator = list.iterator(); iterator.hasNext();) {
            Tasks task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public void EditTask(int id, String newText) {
        for (Iterator<Tasks> iterator = list.iterator(); iterator.hasNext();) {
            Tasks task = iterator.next();
            if (task.getId() == id) {
                task.text = newText;
                break;
            }
        }
    }
}
