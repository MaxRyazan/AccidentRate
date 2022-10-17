package ru.maxryazan.accidentrate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DriverNotFoundException.class)
    public final ResponseEntity<Response> handleDriverNotFoundException(){
        Response response = new Response("Driver not found!", "404");

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
