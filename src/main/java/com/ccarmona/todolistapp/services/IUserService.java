package com.ccarmona.todolistapp.services;

import com.ccarmona.todolistapp.dtos.UserDTO;


public interface IUserService {
    
    UserDTO findByUsername(String username); 
    

    UserDTO addUser(UserDTO userDTO);
}
