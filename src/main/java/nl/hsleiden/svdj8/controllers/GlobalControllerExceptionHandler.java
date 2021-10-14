package nl.hsleiden.svdj8.controllers;

import nl.hsleiden.svdj8.exceptions.BadRequestException;
import nl.hsleiden.svdj8.exceptions.NoSuchElementException;
import nl.hsleiden.svdj8.exceptions.UnauthorizedException;
import nl.hsleiden.svdj8.models.ExceptionReturnObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    //todo rework so it is proper oo
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionReturnObject> handleNoSuchElementFoundException(NoSuchElementException e) {

        ExceptionReturnObject exceptionReturnObject = new ExceptionReturnObject(e.getMessage(),"no additional information");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionReturnObject);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST) //400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionReturnObject> handleBadRequest(BadRequestException e){

        ExceptionReturnObject exceptionReturnObject = new ExceptionReturnObject(e.getMessage(),"no additional information");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exceptionReturnObject);
    }
    @ResponseStatus(HttpStatus.UNAUTHORIZED) //401
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionReturnObject> handleRequest(UnauthorizedException e){

        ExceptionReturnObject exceptionReturnObject = new ExceptionReturnObject(e.getMessage(),"no additional information");
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(exceptionReturnObject);
    }
}
