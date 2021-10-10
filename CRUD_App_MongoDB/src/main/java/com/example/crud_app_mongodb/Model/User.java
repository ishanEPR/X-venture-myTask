package com.example.crud_app_mongodb.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String telephone;



}
