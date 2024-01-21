package com.ting.restfull.api.exception;


import java.net.http.HttpHeaders;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class AppExcetionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){

        String errorMessageDescription = ex.getLocalizedMessage();
        if (errorMessageDescription == null) errorMessageDescription = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
        System.out.println("handleAnyException is triggered");

        return  new ResponseEntity<>(
                errorMessage, HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointException(Exception ex, WebRequest request){

        String errorMessageDescription = ex.getLocalizedMessage();
        if (errorMessageDescription == null) errorMessageDescription = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
        System.out.println("handleNullPointException is triggered");

        return  new ResponseEntity<>(
                errorMessage, HttpStatus.INTERNAL_SERVER_ERROR
        );
    }





}