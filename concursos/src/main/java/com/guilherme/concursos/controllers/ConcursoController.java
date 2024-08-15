package com.guilherme.concursos.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.concursos.domain.concurso.Concurso;
import com.guilherme.concursos.dto.concurso.ConcursoIdDTO;
import com.guilherme.concursos.dto.concurso.ConcursoRequestDTO;
import com.guilherme.concursos.dto.concurso.ConcursoResponseDTO;
import com.guilherme.concursos.dto.concurso.ConcursosListResponseDTO;
import com.guilherme.concursos.services.ConcursoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/concursos")
public class ConcursoController {

      private final ConcursoService concursoService;

      @PostMapping("/")
      public ResponseEntity<List<String>> createConcurso(@RequestBody ConcursoRequestDTO body) {
            List<String> concursosId = concursoService.createConcursos(body);
            // concursoService.createConcursos(body);

            return ResponseEntity.ok().body(concursosId);
      }

      @GetMapping("/")
      public ResponseEntity<ConcursosListResponseDTO> getConscursos() {
            ConcursosListResponseDTO concursos = concursoService.getConcursos();

            return ResponseEntity.ok().body(concursos);
      }
}
