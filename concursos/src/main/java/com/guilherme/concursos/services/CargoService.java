package com.guilherme.concursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guilherme.concursos.domain.cargo.Cargo;
import com.guilherme.concursos.domain.concurso.Concurso;
import com.guilherme.concursos.domain.concurso.exceptions.ConcursoNotFoundException;
import com.guilherme.concursos.repositories.CargoRepository;
import com.guilherme.concursos.repositories.ConcursoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CargoService {

      private final CargoRepository cargoRepository;
      private final ConcursoRepository concursoRepository;

      public List<Cargo> getCargos() {
            List<Cargo> cargos = this.cargoRepository.findAll();

            return cargos;
      }

      @Transactional
      public String createCargo(Cargo newCargo, String concursoId) {
            Optional<Concurso> concurso = concursoRepository.findById(concursoId);

            if (!concurso.isPresent()) {
                  // System.out.println("Concurso não encontrado!");
                  // String message = "Concurso não encontrado!";

                  // return message;

                  throw new ConcursoNotFoundException("Concurso não encontrado!");
            }

            Cargo cargo = new Cargo();

            cargo.setNome(newCargo.getNome());
            cargo.setNivel(newCargo.getNivel());
            cargo.setCadastroReserva(newCargo.getCadastroReserva());
            cargo.setQuantidadeVagas(newCargo.getQuantidadeVagas());
            cargo.setSalario(newCargo.getSalario());
            cargo.setConcurso(concurso.get());

            this.cargoRepository.save(cargo);

            return cargo.getId();
      }

}
