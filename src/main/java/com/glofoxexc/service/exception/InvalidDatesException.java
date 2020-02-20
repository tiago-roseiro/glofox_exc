package com.glofoxexc.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidDatesException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    public InvalidDatesException(String msg) {
        super(msg);
    }
}
