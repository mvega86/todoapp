package com.sacavix.todoapp.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ToDoException extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;


    public ToDoException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
