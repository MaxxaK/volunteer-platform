package com.maxxak.volunteer.exception;

public class InvalidRegistrationException extends RuntimeException {
    
    public InvalidRegistrationException(){
        super();
    }

    public InvalidRegistrationException(String message){
        super(message);
    }
}
