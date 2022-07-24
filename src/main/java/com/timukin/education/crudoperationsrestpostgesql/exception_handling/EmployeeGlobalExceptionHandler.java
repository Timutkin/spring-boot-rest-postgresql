package com.timukin.education.crudoperationsrestpostgesql.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Employee global exception handler.
 *
 * @author Timofey Utkin
 * @version 1.0
 */
@ControllerAdvice
public class EmployeeGlobalExceptionHandler {
    /**
     * Handle exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(value = {NoSuchEmployeeException.class, InvalidEmailException.class, UserAlreadyExistException.class})
    public ResponseEntity<Response> handleException(Exception exception){
        Response data = new Response();
        data.setInfo(exception.getClass().getSimpleName() + ":" + exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
