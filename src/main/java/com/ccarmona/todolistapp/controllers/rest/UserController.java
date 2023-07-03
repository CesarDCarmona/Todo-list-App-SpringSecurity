package com.ccarmona.todolistapp.controllers.rest;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccarmona.todolistapp.dtos.UserDTO;
import com.ccarmona.todolistapp.exceptions.ResourceNotFoundException;
import com.ccarmona.todolistapp.services.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
    name="API REST User",
    description ="API REST para módulo de Usuarios, permite alta y consulta"
)
@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {
    
    private IUserService userService;

    @Operation(
        summary ="Busca usuario",
        description= "Rest Api para buscar usuario por username"
    )
    @ApiResponse(
        responseCode = "200,404",
        description = "200 en caso usuario correcto, 404 de no ser valido"
    )
    @GetMapping()
    public ResponseEntity<UserDTO> findByUsername(@RequestParam("user") String username){
        
        UserDTO userDTO = userService.findByUsername(username);
        
        return ResponseEntity.ok(userDTO);
    }

    @Operation(
        summary ="Agregar usuario",
        description= "Rest Api para agregar usuario"
    )
    @ApiResponse(
        responseCode = "201",
        description = "201 Created"
    )
    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        UserDTO saveDto = userService.addUser(userDTO);
        return new ResponseEntity<UserDTO>(saveDto, HttpStatus.CREATED);
    }

    


}
