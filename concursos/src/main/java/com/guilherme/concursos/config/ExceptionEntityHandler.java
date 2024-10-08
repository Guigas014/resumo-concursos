package com.guilherme.concursos.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.guilherme.concursos.domain.avaliacao.exceptions.AvaliacaoNotFoundException;
import com.guilherme.concursos.domain.cargo.exceptions.CargoNotFoundException;
import com.guilherme.concursos.domain.concurso.exceptions.ConcursoNotFoundException;
import com.guilherme.concursos.domain.concurso.exceptions.WebDriverException;
import com.guilherme.concursos.domain.conteudo.exceptions.ConteudoNotFoundException;

@ControllerAdvice
public class ExceptionEntityHandler {

      @ExceptionHandler(WebDriverException.class)
      public ResponseEntity<String> handleDataNotFound(WebDriverException e) {
            return ResponseEntity.notFound().build();
      }

      @ExceptionHandler(ConcursoNotFoundException.class)
      public ResponseEntity<String> handleConcursoNotFound(ConcursoNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
      }

      @ExceptionHandler(CargoNotFoundException.class)
      public ResponseEntity<String> handleCargoNotFound(CargoNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
      }

      @ExceptionHandler(AvaliacaoNotFoundException.class)
      public ResponseEntity<String> handleAvaliacaoNotFound(AvaliacaoNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
      }

      @ExceptionHandler(ConteudoNotFoundException.class)
      public ResponseEntity<String> handleConteudoNotFound(ConteudoNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
      }
}
