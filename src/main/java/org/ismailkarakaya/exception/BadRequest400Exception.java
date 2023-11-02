package org.ismailkarakaya.exception;

public class BadRequest400Exception extends RuntimeException{

    public BadRequest400Exception(String message) {
        super(message);
    }
}
