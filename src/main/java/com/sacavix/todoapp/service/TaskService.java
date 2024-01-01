package com.sacavix.todoapp.service;

import com.sacavix.todoapp.exceptions.ToDoException;
import com.sacavix.todoapp.mapper.TaskInDTOToTask;
import com.sacavix.todoapp.persistence.entity.Task;
import com.sacavix.todoapp.persistence.entity.TaskStatus;
import com.sacavix.todoapp.persistence.repository.TaskRepository;
import com.sacavix.todoapp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    public List<Task> findAll(){
        return this.repository.findAll();
    }

    public List<Task> findAllByStatus(TaskStatus taskStatus){
        return this.repository.findAllByTaskStatus(taskStatus);
    }

    @Transactional
    public void markAsFinished(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoException("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }

    public void deleteTask(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoException("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}
