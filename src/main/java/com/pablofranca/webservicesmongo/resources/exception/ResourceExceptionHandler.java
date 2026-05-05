package com.pablofranca.webservicesmongo.resources.exception;


import com.pablofranca.webservicesmongo.services.exception.ObjectNotFoundException;
import com.pablofranca.webservicesmongo.services.exception.PostNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity <StandardError> objectNotFoundException (ObjectNotFoundException exception, HttpServletRequest servletRequest) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(Instant.now(), status.value(), "Object not found", exception.getMessage(), servletRequest.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity <StandardError> postNotFoundException (PostNotFoundException e, HttpServletRequest servletRequest) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(Instant.now(), status.value(), "Post not found", e.getMessage(), servletRequest.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }




}
