package com.example.laith.test.springdata.exceptions;

public class ClubNotFoundException extends RuntimeException {

    public ClubNotFoundException(String message ) {
        super(message);
    }
}
