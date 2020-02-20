package com.glofoxexc.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClassNotFoundException extends  RuntimeException {

    private static final long serialVersionUID = 1L;

    public ClassNotFoundException(String msg) {
        super(msg);
    }
}
