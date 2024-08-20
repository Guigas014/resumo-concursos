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

import com.guilherme.concursos.domain.cargo.Cargo;
import com.guilherme.concursos.services.CargoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cargos")
public class CargoController {

      private final CargoService cargoService;

      @GetMapping("/")
      public ResponseEntity<List<Cargo>> getCargos() {
            List<Cargo> cargos = cargoService.getCargos();

            return ResponseEntity.ok().body(cargos);
      }

      @PostMapping("/{concursoId}")
      public ResponseEntity<String> createCargo(@RequestBody Cargo body, @PathVariable String concursoId) {
            String id = cargoService.createCargo(body, concursoId);

            return ResponseEntity.status(HttpStatus.CREATED).body(id);
      }

}