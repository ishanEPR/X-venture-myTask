package com.example.crud_app_mongodb.Exception.Type;

import lombok.extern.slf4j.Slf4j;

public class UserNotFoundException extends RuntimeException{


    public UserNotFoundException(String message)
    {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
