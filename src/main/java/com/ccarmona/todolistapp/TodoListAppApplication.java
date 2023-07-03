package com.ccarmona.todolistapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info (title = "Todo-Apllication API Documentation"
		,description = "Documentacion de Apis"
		,version ="v1.0"
		,contact= @Contact (
				name = "César Carmona",
				email = "cicinhocarmona06@gmail.com"
				 
		)
	))
public class TodoListAppApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoListAppApplication.class, args);
	}

}
