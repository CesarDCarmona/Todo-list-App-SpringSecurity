package com.ccarmona.todolistapp.controllers.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccarmona.todolistapp.dtos.DeleteResponseDTO;
import com.ccarmona.todolistapp.dtos.TaskDTO;
import com.ccarmona.todolistapp.services.ITaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;


@Tag(
    name="API REST Task",
    description ="API REST para módulo de Tareas, permite alta,consulta,eliminación y marcar tarea completada"
)
@RestController
@RequestMapping("api/v1/task")
@AllArgsConstructor
public class TaskController {
    
    private ITaskService taskService;

    @Operation(
        summary ="Obtener Tareas",
        description= "Rest Api para todas las tareas"
    )
    @ApiResponse(
        responseCode = "200",
        description = "200 Ok"
    )
     @GetMapping("getAll")
    public ResponseEntity<List<TaskDTO>> getAllTask (){
        List<TaskDTO> taskList  = taskService.getAllTask(); 
        return ResponseEntity.ok(taskList);
    }

    @Operation(
        summary ="Busca tarea",
        description= "Rest Api para buscar tarea por identificador"
    )
    @ApiResponse(
        responseCode = "200",
        description = "200 Ok"
    )
    @GetMapping("/getByid/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable int id){
        TaskDTO getTaskDTO = taskService.getTask(id);
        return ResponseEntity.ok(getTaskDTO);
    }

    @Operation(
        summary ="Agrega Tarea",
        description= "Rest Api para agregar una tarea"
    )
    @ApiResponse(
        responseCode = "201",
        description = "201 Created"
    )
    @PostMapping("/addTask")
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO){
        TaskDTO saveDto = taskService.addTask(taskDTO);
        return new ResponseEntity<>(saveDto,HttpStatus.CREATED);
    
    }

    @Operation(
        summary ="Completar Tarea",
        description= "Rest Api para marcar como completada una tarea"
    )
    @ApiResponse(
        responseCode = "200",
        description = "200 Ok"
    )
    @PatchMapping("/completedTask/{id}")
    public ResponseEntity<TaskDTO> completedTask(@PathVariable int id){
        TaskDTO updateTask = taskService.completedTask(id);
        return new ResponseEntity<>(updateTask, HttpStatus.OK);
    }

    @Operation(
        summary ="Eliminar Tarea",
        description= "Rest Api para eliminar una tarea"
    )
    @ApiResponse(
        responseCode = "200",
        description = "200 Ok"
    )
    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<DeleteResponseDTO> deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
        DeleteResponseDTO deleteTask = new DeleteResponseDTO();

        return ResponseEntity.ok(deleteTask);
    }
}
