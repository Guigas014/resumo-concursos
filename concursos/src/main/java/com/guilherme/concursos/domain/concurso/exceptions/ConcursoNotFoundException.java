package com.guilherme.concursos.domain.concurso.exceptions;

public class ConcursoNotFoundException extends RuntimeException {

      public ConcursoNotFoundException(String message) {
            super(message);
      }
}
