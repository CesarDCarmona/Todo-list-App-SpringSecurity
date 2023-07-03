package com.ccarmona.todolistapp.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    
    private int id;

    private String title;

    private String description;

    private boolean completed;

    private Date due_date;
}
