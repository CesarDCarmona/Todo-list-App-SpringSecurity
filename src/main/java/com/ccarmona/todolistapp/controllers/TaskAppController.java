package com.ccarmona.todolistapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskAppController {
    
    @GetMapping("/")
    public String Default(){
        return "Index";
    }

    @GetMapping("/Index")
    public String Index(){
        return "Index";
    }
 

    @GetMapping("/tasks")
    public String Tasks(){
        return "tasks2";
    }

}
