package com.gabr.e_commerce.exception;

public class ResourseNotFound extends RuntimeException{
    public ResourseNotFound(String message){
        super(message);   // Constructor for RuntimeException
    }

}
