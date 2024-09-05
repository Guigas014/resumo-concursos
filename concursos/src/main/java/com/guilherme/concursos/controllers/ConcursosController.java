package com.guilherme.concursos.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.concursos.dto.concurso.ConcursoRequestDTO;
import com.guilherme.concursos.dto.concurso.ConcursoScrappingResponseDTO;
import com.guilherme.concursos.dto.concurso.ConcursosListResponseDTO;
import com.guilherme.concursos.services.ConcursosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/concursos")
public class ConcursosController {

      private final ConcursosService concursosService;

      @GetMapping("/")
      public ResponseEntity<List<ConcursoScrappingResponseDTO>> getConcursosDoScrapping() {
            List<ConcursoScrappingResponseDTO> concursosScrapping = concursosService.getConcursosDoScrapping();

            return ResponseEntity.ok().body(concursosScrapping);
      }

      // NÃO É NECESSÁRIO TIPAR A ENTRADA (ConcursoRequestDTO)
      @PostMapping("/concurso")
      public ResponseEntity<String> createConcurso(@RequestBody ConcursoRequestDTO body) {
            String concursoId = concursosService.createConcurso(body);

            return ResponseEntity.status(HttpStatus.CREATED).body(concursoId);
      }

      @GetMapping("/analisados")
      public ResponseEntity<ConcursosListResponseDTO> getConcursosAnalisados() {
            ConcursosListResponseDTO concursos = concursosService.getConcursosAnalisados();

            return ResponseEntity.ok().body(concursos);
      }
}
