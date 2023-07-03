package com.ccarmona.todolistapp.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ccarmona.todolistapp.dtos.UserDTO;
import com.ccarmona.todolistapp.entities.UserEntity;
import com.ccarmona.todolistapp.exceptions.ResourceNotFoundException;
import com.ccarmona.todolistapp.repositories.IUserRepository;
import com.ccarmona.todolistapp.services.IUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService{
    
    private IUserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;

    

    // public UserServiceImpl(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
    //     this.userRepository = userRepository;
    //     this.passwordEncoder = passwordEncoder;
    // }

    @Override
    public UserDTO findByUsername(String username) {
        // TODO Auto-generated method stub
        
        UserEntity user = userRepository.findByUsername(username);

        if (user ==null) {
            throw new ResourceNotFoundException("Usuario no valido: " + username);
        }

        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        // TODO Auto-generated method stub
        UserEntity user = modelMapper.map(userDTO,UserEntity.class);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UserEntity saveUser = userRepository.save(user);

        return modelMapper.map(saveUser, UserDTO.class);
    }

    
     
}
