package ru.maxryazan.accidentrate.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private Object message;
    private String responseCode;

    public Response(Object message, String responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }
}
