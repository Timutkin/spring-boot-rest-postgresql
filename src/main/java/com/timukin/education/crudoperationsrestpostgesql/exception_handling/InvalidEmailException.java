package com.timukin.education.crudoperationsrestpostgesql.exception_handling;

import java.security.spec.InvalidParameterSpecException;

/**
 * The type Invalid email exception.
 *
 * @author Timofey Utkin
 * @version 1.0
 */
public class InvalidEmailException extends IllegalArgumentException {
    /**
     * Instantiates a new Invalid email exception.
     *
     * @param s the s
     */
    public InvalidEmailException(String s) {
        super(s);
    }

}
