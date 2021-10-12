package com.example.crud_app_mongodb.Exception;

import com.example.crud_app_mongodb.Exception.ENUM.EnumModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(value = {GenericException.class})
    public ResponseEntity<EnumModel> handleGenericException(GenericException exceptionNew)
    {
        EnumModel enumModel=new EnumModel(
                exceptionNew.getMessage(),
                exceptionNew.getHttpStatus(),
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(enumModel,exceptionNew.getHttpStatus());
    }
}
