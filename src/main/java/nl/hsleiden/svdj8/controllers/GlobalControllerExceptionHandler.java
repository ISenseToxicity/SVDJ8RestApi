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


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionReturnObject> handleNoSuchElementFoundException(NoSuchElementException e) {
           return makeResponseEntity(HttpStatus.NOT_FOUND,e.getMessage(),"No additional information");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST) //400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionReturnObject> handleBadRequest(BadRequestException e){

        return makeResponseEntity(HttpStatus.BAD_REQUEST,e.getMessage(),"No additional information");
    }
    @ResponseStatus(HttpStatus.UNAUTHORIZED) //401
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionReturnObject> handleRequest(UnauthorizedException e){
        return makeResponseEntity(HttpStatus.UNAUTHORIZED,e.getMessage(),"No additional information");
    }


    public ResponseEntity<ExceptionReturnObject> makeResponseEntity(HttpStatus httpStatus, String userMessage,String applicationMessage){
        ExceptionReturnObject exceptionReturnObject = new ExceptionReturnObject(userMessage,applicationMessage);
        return ResponseEntity
                .status(httpStatus)
                .body(exceptionReturnObject);
    }
}
