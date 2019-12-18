package ru.javamentor.predProject9_rest_server.exception;

public class DBException extends Exception {
    public DBException (Throwable throwable) {
        super(throwable);
    }
}
