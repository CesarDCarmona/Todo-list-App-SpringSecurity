package com.ccarmona.todolistapp.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ccarmona.todolistapp.entities.UserEntity;
import com.ccarmona.todolistapp.repositories.IUserRepository;

@Service
public class CustomUser implements UserDetailsService{

    private IUserRepository userRepository;

    public CustomUser(IUserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        UserEntity user = userRepository.findByUsername(username);
        List<String> roles = new ArrayList<String>();
        roles.add("ADMIN");
                
        if(user != null){
            return new User(user.getUsername(), user.getPassword()
                ,roles.stream().map((rol)-> new SimpleGrantedAuthority("ADMIN")).collect(Collectors.toList()));
        }else{
            throw new UsernameNotFoundException("Usuario no valido");
        }
         
    }
        
}
