package com.example.crud_app_mongodb.Exception;

import com.example.crud_app_mongodb.Exception.Type.FieldRequiredException;
import com.example.crud_app_mongodb.Exception.Type.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {



    //handle user not found
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleuserNotFound(UserNotFoundException e)
    {
        ApiExceptionModel apiExceptionModel=new ApiExceptionModel(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiExceptionModel,HttpStatus.NOT_FOUND);
    }

    //handle required filed
    @ExceptionHandler(value = {FieldRequiredException.class})
    public ResponseEntity<Object> handleuserFieldRequired(FieldRequiredException e)
    {
        ApiExceptionModel apiExceptionModel=new ApiExceptionModel(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiExceptionModel,HttpStatus.BAD_REQUEST);

    }

}
