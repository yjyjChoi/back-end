package com.pasta.aglioeolio.exception.sub;

public class CustomException extends RuntimeException{

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

}