package br.com.curso.web.spring.devdojo.util.handler;

import br.com.curso.web.spring.devdojo.util.ResourceNotFoundDetails;
import br.com.curso.web.spring.devdojo.util.util.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExpectionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        return new ResponseEntity<>(ResourceNotFoundDetails.builder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .titulo("Resource not found (não encontrado)")
                .detalhes(resourceNotFoundException.getClass().getName())
                .build(), HttpStatus.NOT_FOUND);
    }
}
