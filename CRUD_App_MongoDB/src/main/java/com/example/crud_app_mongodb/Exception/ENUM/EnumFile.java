package com.example.crud_app_mongodb.Exception.ENUM;

import com.example.crud_app_mongodb.Exception.Type.FieldRequiredException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum EnumFile {

    UserNotFoundException("User not found", HttpStatus.NOT_FOUND),
    FieldRequiredException("Field is Required",HttpStatus.BAD_REQUEST);

    private final String errorMessage;
    private  final HttpStatus httpStatus;

    EnumFile(String errorMessage,HttpStatus httpStatus)
    {
        this.errorMessage=errorMessage;
        this.httpStatus=httpStatus;
    }
}
