package com.example.crud_app_mongodb.Exception.ENUM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;


@Data
@AllArgsConstructor
public class EnumModel {

    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime dateTime;

}
