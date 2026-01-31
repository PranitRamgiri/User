package com.chalabookkaru.userservice.exception;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException {

    private final HttpStatus httpStatus;

    public UserException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
