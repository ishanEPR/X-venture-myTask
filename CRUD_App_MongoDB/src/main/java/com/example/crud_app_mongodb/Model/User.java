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

  //swagger 2.0  @ApiModelProperty(notes ="user id",name = "id",required = true)
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String telephone;



}
