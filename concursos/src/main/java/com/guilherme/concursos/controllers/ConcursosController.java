package com.guilherme.concursos.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.concursos.dto.concurso.ConcursosListResponseDTO;
import com.guilherme.concursos.services.ConcursosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/concursos")
public class ConcursosController {

      private final ConcursosService concursosService;

      @PostMapping("/")
      public ResponseEntity<List<String>> createConcursos() {
            List<String> concursosId = concursosService.createConcursos();
            // concursoService.createConcursos(body);

            return ResponseEntity.ok().body(concursosId);
      }

      @GetMapping("/")
      public ResponseEntity<ConcursosListResponseDTO> getConscursos() {
            ConcursosListResponseDTO concursos = concursosService.getConcursos();

            return ResponseEntity.ok().body(concursos);
      }
}
