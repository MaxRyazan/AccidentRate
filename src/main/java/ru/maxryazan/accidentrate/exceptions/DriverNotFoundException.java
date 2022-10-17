package ru.maxryazan.accidentrate.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DriverNotFoundException extends RuntimeException {
    public DriverNotFoundException(){
    }
}
