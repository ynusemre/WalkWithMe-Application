package com.example.WalkWithMe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReservationTimeTakenException extends RuntimeException{

    public ReservationTimeTakenException(String message){
        super(message);
    }
}
