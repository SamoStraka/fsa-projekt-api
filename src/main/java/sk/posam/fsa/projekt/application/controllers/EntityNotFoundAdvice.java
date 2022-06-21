package sk.posam.fsa.projekt.application.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class EntityNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(sk.posam.fsa.projekt.application.controllers.EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String handler(sk.posam.fsa.projekt.application.controllers.EntityNotFoundException ex) {
        return ex.getMessage();
    }
}
