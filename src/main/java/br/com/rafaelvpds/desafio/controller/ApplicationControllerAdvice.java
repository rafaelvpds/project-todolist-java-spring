package br.com.rafaelvpds.desafio.controller;

import org.springframework.http.HttpStatus;
import br.com.rafaelvpds.desafio.exeption.RecordNotFaundExeption;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class ApplicationControllerAdvice {
    @ExceptionHandler(RecordNotFaundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(RecordNotFaundExeption ex) {
        return ex.getMessage();
    }
}
