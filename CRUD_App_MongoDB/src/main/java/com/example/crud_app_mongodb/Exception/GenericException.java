package com.example.crud_app_mongodb.Exception;


import com.example.crud_app_mongodb.Exception.ENUM.EnumFile;
import com.example.crud_app_mongodb.Exception.ENUM.EnumModel;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
public class GenericException extends RuntimeException{

    private HttpStatus httpStatus;
    public GenericException(EnumFile enumFile)
    {
      super(enumFile.getErrorMessage());
      this.httpStatus=enumFile.getHttpStatus();

    }
}
