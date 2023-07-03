package com.ccarmona.todolistapp.dtos;

import lombok.Data;

@Data
public class UserInvalidDTO {
    
        
    private int status;

    private String message;

    public UserInvalidDTO() {
        this.status= 401;
        this.message= "Usuario no Valido";
    }
}
