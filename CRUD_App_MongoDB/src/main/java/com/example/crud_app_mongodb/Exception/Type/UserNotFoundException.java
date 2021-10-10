package com.example.crud_app_mongodb.Exception.Type;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message)
    {
        super(message);
    }
}
