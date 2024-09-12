package com.linktic.api.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class HandlerException {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException e) {
        return new ResponseEntity<>("Unauthorized access", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotImplementedException.class)
    public ResponseEntity<String> handleNotImplementedException(NotImplementedException e) {
        return new ResponseEntity<>("Functionality not implemented", HttpStatus.NOT_IMPLEMENTED);
    }
    
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleNotImplementedException(EmptyResultDataAccessException e) {
        return new ResponseEntity<>("Functionality not implemented", HttpStatus.NOT_IMPLEMENTED);
    }
	
}
