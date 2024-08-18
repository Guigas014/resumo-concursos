package com.guilherme.concursos.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.guilherme.concursos.domain.concurso.exceptions.WebDriverException;

@ControllerAdvice
public class ExceptionEntityHandler {

      @ExceptionHandler(WebDriverException.class)
      public ResponseEntity handleDataNotFound(WebDriverException e) {
            return ResponseEntity.notFound().build();
      }
}
