package com.timukin.education.crudoperationsrestpostgesql.exception_handling;

import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * The type No such employee exception.
 *
 * @author Timofey Utkin
 * @version 1.0
 */
public class NoSuchEmployeeException extends IllegalArgumentException {
    /**
     * Instantiates a new No such employee exception.
     *
     * @param message the message
     */
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
