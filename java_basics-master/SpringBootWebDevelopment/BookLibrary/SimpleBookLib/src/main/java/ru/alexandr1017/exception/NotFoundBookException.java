package ru.alexandr1017.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundBookException extends Exception{
    public NotFoundBookException(String message){
        super(message);
    }
}
