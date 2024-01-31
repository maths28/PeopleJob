package fr.mb.peoplejob.controller;

import fr.mb.peoplejob.exception.PeopleJobException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ PeopleJobException.class })
    public ResponseEntity<String> handleAccessDeniedException(
            Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
