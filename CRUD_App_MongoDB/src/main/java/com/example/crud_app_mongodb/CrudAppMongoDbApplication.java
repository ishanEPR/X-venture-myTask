package com.example.crud_app_mongodb;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class CrudAppMongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudAppMongoDbApplication.class, args);
    }

}
