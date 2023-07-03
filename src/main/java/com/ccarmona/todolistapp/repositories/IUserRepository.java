package com.ccarmona.todolistapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccarmona.todolistapp.entities.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity,Integer>{
    
    UserEntity findByUsername(String username);
    
}
