package com.example.crud_app_mongodb.Exception.Type;

public class FieldRequiredException extends RuntimeException{

    public FieldRequiredException(String message) {
        super(message);

    }

    public FieldRequiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
