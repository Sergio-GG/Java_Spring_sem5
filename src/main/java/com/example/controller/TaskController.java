package com.example.controller;

import com.example.model.Task;
import com.example.model.TaskStatus;
import com.example.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }
    @GetMapping("/{status}")
    public List<Task> getTasksByStatus(TaskStatus taskStatus){
        return taskService.getTasksByStatus(taskStatus);
    }
    @GetMapping("/update")
    public Task updateTaskStatus(Long id, TaskStatus taskStatus){
        return taskService.updateTaskById(id, taskStatus);
    }
    @GetMapping("/remove")
    public void deleteTask(Long id){
        taskService.removeTask(id);
    }
}
