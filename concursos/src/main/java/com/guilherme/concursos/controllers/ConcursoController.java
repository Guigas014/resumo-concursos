package com.guilherme.concursos.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.concursos.domain.avaliacao.Avaliacao;
import com.guilherme.concursos.domain.cargo.Cargo;
import com.guilherme.concursos.domain.conteudo.Conteudo;
import com.guilherme.concursos.dto.avaliacao.AvaliacaoResponseDTO;
import com.guilherme.concursos.dto.cargo.CargoResponseDTO;
import com.guilherme.concursos.services.ConcursoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/concurso")
public class ConcursoController {

      private final ConcursoService concursoService;

      @GetMapping("/{concursoId}/cargos")
      public ResponseEntity<List<CargoResponseDTO>> getCargos(@PathVariable String concursoId) {
            List<CargoResponseDTO> cargos = concursoService.getCargos(concursoId);

            return ResponseEntity.ok().body(cargos);
      }

      @PostMapping("/{concursoId}/cargo")
      public ResponseEntity<String> createCargo(@RequestBody Cargo body,
                  @PathVariable String concursoId) {
            String id = concursoService.createCargo(body, concursoId);

            return ResponseEntity.status(HttpStatus.CREATED).body(id);
      }

      @PostMapping("/cargo/{cargoId}/avaliacao")
      public ResponseEntity<String> createAvaliacao(@RequestBody Avaliacao body,
                  @PathVariable String cargoId) {
            String id = concursoService.createAvaliacao(body, cargoId);

            return ResponseEntity.status(HttpStatus.CREATED).body(id);
      }

      @PostMapping("/cargo/avaliacao/{avaliacaoId}/conteudo")
      public ResponseEntity<String> createConteudo(@RequestBody Conteudo body, @PathVariable String avaliacaoId) {
            String id = concursoService.createConteudo(body, avaliacaoId);

            return ResponseEntity.status(HttpStatus.CREATED).body(id);
      }

      @GetMapping("cargo/{cargoId}/avaliacoes")
      public ResponseEntity<List<AvaliacaoResponseDTO>> getAvaliacoesAndConteudos(@PathVariable String cargoId) {
            List<AvaliacaoResponseDTO> avaliacoes = concursoService.getAvaliacoes(cargoId);

            return ResponseEntity.ok().body(avaliacoes);
      }

}
