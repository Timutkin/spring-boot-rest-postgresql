package com.timukin.education.crudoperationsrestpostgesql.exception_handling;

/**
 * The type User already exist exception.
 * @author Timofey Utkin
 * @version 1.0
 */
public class UserAlreadyExistException extends IllegalArgumentException{
    /**
     * Instantiates a new User already exist exception.
     *
     * @param s the s
     */
    public UserAlreadyExistException(String s) {
        super(s);
    }
}
