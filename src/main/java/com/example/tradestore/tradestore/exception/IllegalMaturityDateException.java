package com.example.tradestore.tradestore.exception;

public class IllegalMaturityDateException extends Throwable{

    String message;

    public IllegalMaturityDateException(String message){
        this.message=message;
    }
    
}
