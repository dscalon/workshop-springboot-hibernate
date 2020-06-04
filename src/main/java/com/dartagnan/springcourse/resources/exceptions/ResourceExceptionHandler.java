package com.dartagnan.springcourse.resources.exceptions;

import com.dartagnan.springcourse.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice //Intercepta as excessões para este objeto tratar elas
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //diz que o método vai capturar qualquer exceção do tipo resource not found e lançar o tratamento descrito nele
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){

        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }
}
