package com.example.laith.test.springdata.exceptions;

public class PlayerExistClubException extends RuntimeException {
    public PlayerExistClubException(String message ) {
        super(message);
    }
}
