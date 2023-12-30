package com.sacavix.todoapp.controller;

import com.sacavix.todoapp.persistence.entity.Task;
import com.sacavix.todoapp.persistence.entity.TaskStatus;
import com.sacavix.todoapp.service.TaskService;
import com.sacavix.todoapp.service.dto.TaskInDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
        return this.taskService.createTask(taskInDTO);

    }

    @GetMapping
    public List<Task> findAll(){
        return this.taskService.findAll();
    }

    @GetMapping("/findAllByStatus/{status}")
    public List<Task> findAllByStatus(@PathVariable TaskStatus status){
        return this.taskService.findAllByStatus(status);
    }
}
