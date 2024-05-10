package com.example.service;

import com.example.model.Task;
import com.example.model.TaskStatus;
import com.example.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    // Получение всех задач
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    // Получение задачи по ID
    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }
    // Получение задач по TaskStatus
    public List<Task> getTasksByStatus(TaskStatus taskStatus){
        List<Task> taskList = taskRepository.findAll();
        List<Task> newList = null;
        for(Task task: taskList){
            if(task.getTaskStatus() == taskStatus){
                newList.add(task);
            }
        }
        return newList;
    }
    // Изменение задачи по TaskStatus
    public Task updateTaskById(Long id, TaskStatus taskStatus){
        Task task = taskRepository.findById(id).orElse(null);
        assert task != null;
        task.setTaskStatus(taskStatus);
        return taskRepository.save(task);
    }
    // Создание новой задачи
    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    // Удаление задачи
    public void removeTask(Long id){
        taskRepository.deleteById(id);
    }
}
