package com.example.crud_app_mongodb.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class ApiExceptionModel {

    private final String message;
  //  private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;

}
