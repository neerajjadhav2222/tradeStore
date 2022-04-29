package com.example.tradestore.tradestore.exception;

public class LowerVersionException extends Throwable{
    
    String message;
    
    public LowerVersionException(String message){
        this.message=message;
    }

}
