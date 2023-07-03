package com.ccarmona.todolistapp.dtos;

import lombok.Data;

@Data
public class DeleteResponseDTO {
    
    private int status;

    private String message;

    public DeleteResponseDTO() {
        this.status= 200;
        this.message= "Tarea eliminada correctamente.";
    }
}
