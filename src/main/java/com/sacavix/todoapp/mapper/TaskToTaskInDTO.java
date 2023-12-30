package com.sacavix.todoapp.mapper;

import com.sacavix.todoapp.persistence.entity.Task;
import com.sacavix.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

@Component
public class TaskToTaskInDTO implements IMapper<Task, TaskInDTO>{
    @Override
    public TaskInDTO map(Task in) {
        TaskInDTO taskInDTO = new TaskInDTO();
        taskInDTO.setTitle(in.getTitle());
        taskInDTO.setDescription(in.getDescription());
        taskInDTO.setEta(in.getEta());
        return taskInDTO;
    }
}
