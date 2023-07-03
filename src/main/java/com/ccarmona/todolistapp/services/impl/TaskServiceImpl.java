package com.ccarmona.todolistapp.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ccarmona.todolistapp.dtos.TaskDTO;
import com.ccarmona.todolistapp.entities.TaskEntity;
import com.ccarmona.todolistapp.exceptions.ResourceNotFoundException;
import com.ccarmona.todolistapp.repositories.ITaskRespository;
import com.ccarmona.todolistapp.services.ITaskService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements ITaskService {

    private ITaskRespository taskRespository;

    private ModelMapper modelMapper;

    
    @Override
    public TaskDTO addTask(TaskDTO taskDTO) {
        // TODO Auto-generated method stub

        TaskEntity task = modelMapper.map(taskDTO, TaskEntity.class);

        TaskEntity saveTask = taskRespository.save(task);

        return modelMapper.map(saveTask, TaskDTO.class);
    }

    @Override
    public TaskDTO completedTask(Integer id) {
        // TODO Auto-generated method stub
        TaskEntity task = taskRespository.findById(id)
                            .orElseThrow(()-> new ResourceNotFoundException("No se encontró tarea con id:" + id));

        task.setCompleted(Boolean.TRUE);    
        TaskEntity saveTask = taskRespository.save(task);
        
        return modelMapper.map(saveTask, TaskDTO.class);
    }

    @Override
    public void deleteTask(Integer id) {
        // TODO Auto-generated method stub
        TaskEntity task = taskRespository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("No se encontró tarea con id:" + id));

        taskRespository.deleteById(id);                    

    }

    @Override
    public List<TaskDTO> getAllTask() {
        // TODO Auto-generated method stub
        List<TaskEntity> tasks = taskRespository.findAll();
        
        return tasks.stream().map((task) -> modelMapper.map(task, TaskDTO.class))
                    .collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTask(Integer id) {
        // TODO Auto-generated method stub
        TaskEntity task = taskRespository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("No se encontró tarea con id:" + id));

        return modelMapper.map(task, TaskDTO.class);
    }
    
}
