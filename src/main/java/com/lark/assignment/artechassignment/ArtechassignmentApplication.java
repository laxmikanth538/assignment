package com.lark.assignment.artechassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Arttech Assignment", version = "1.0", description = "Arttech info assignment API specification document for testing"))
public class ArtechassignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtechassignmentApplication.class, args);
	}

}
