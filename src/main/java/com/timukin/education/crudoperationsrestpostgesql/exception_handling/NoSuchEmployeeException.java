package com.timukin.education.crudoperationsrestpostgesql.exception_handling;

import org.springframework.web.bind.annotation.ResponseStatus;


public class NoSuchEmployeeException extends IllegalArgumentException {
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
