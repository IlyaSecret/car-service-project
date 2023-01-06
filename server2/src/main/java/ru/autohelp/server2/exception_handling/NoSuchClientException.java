package ru.autohelp.server2.exception_handling;

public class NoSuchClientException extends RuntimeException{

    public NoSuchClientException(String message) {
        super(message);
    }
}
