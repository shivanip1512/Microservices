package com.springboot.restfulwebservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Boot Rest API documentation", 
								description = "Spring Boot Rest API documentation", 
								version = "1.0.0-SNAPSHOT", 
								contact = @Contact(
											name = "Shivani",
											email = "coder@gmail.com",
											url = "https://shivanip1512.github.io/"),
								license = @License(
										 	name = "Apache 2.0",
										 	url = "https://shivanip1512.github.io/license")
								), 
					externalDocs = @ExternalDocumentation(
										description = "Spring boot User Management documentation",
										url = "https://shivanip1512.github.io/user_management.html")
				  )
public class RestfulWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebserviceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
