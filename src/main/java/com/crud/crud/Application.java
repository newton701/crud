package com.crud.crud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title = "Product API",version = "2.0",description = "product microservice"))
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
