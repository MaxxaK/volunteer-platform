package com.maxxak.volunteer.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    
    public EmailAlreadyExistsException(){
        super();
    }

    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
