package com.example.schedule.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RuntimeCustomException extends RuntimeException{

    private String errorMsg;

    private String errorFieldName;

}
