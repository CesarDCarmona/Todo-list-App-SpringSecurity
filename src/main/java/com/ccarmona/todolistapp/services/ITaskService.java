package com.ccarmona.todolistapp.services;

import java.util.List;

import com.ccarmona.todolistapp.dtos.TaskDTO;

public interface ITaskService {
    
    List<TaskDTO> getAllTask();

    TaskDTO getTask(Integer Id);

    TaskDTO addTask(TaskDTO taskDTO);

    TaskDTO completedTask(Integer id);

    void deleteTask(Integer id);
}
