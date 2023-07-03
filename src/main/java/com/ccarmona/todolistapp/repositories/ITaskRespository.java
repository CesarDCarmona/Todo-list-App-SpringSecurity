package com.ccarmona.todolistapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ccarmona.todolistapp.entities.TaskEntity;


public interface ITaskRespository extends JpaRepository<TaskEntity,Integer>{
    
}
