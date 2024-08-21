package com.guilherme.concursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guilherme.concursos.domain.cargo.Cargo;
import com.guilherme.concursos.domain.avaliacao.Avaliacao;
import com.guilherme.concursos.domain.concurso.Concurso;
import com.guilherme.concursos.domain.concurso.exceptions.ConcursoNotFoundException;
import com.guilherme.concursos.dto.cargo.CargoAvaliacaoRequestDTO;
import com.guilherme.concursos.repositories.AvaliacaoRepository;
import com.guilherme.concursos.repositories.CargoRepository;
import com.guilherme.concursos.repositories.ConcursoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CargoService {

      private final CargoRepository cargoRepository;
      private final ConcursoRepository concursoRepository;
      private final AvaliacaoRepository avaliacaoRepository;

      public List<Cargo> getCargos() {
            List<Cargo> cargos = this.cargoRepository.findAll();

            return cargos;
      }

      @Transactional
      public String createCargo(CargoAvaliacaoRequestDTO dados, String concursoId) {
            Optional<Concurso> concurso = concursoRepository.findById(concursoId);

            if (!concurso.isPresent()) {
                  // System.out.println("Concurso não encontrado!");
                  // String message = "Concurso não encontrado!";

                  // return message;

                  throw new ConcursoNotFoundException("Concurso não encontrado!");
            }

            System.out.println(dados);

            Cargo cargo = new Cargo();

            cargo.setNome(dados.nome());
            cargo.setNivel(dados.nivel());
            cargo.setCadastroReserva(dados.cadastroReserva());
            cargo.setQuantidadeVagas(dados.quantidadeVagas());
            cargo.setSalario(dados.salario());
            cargo.setTaxaInscricao(dados.taxaInscricao());
            cargo.setConcurso(concurso.get());

            this.cargoRepository.save(cargo);

            Avaliacao avaliacao = new Avaliacao();

            avaliacao.setTipo(dados.tipo());
            avaliacao.setCarater(dados.carater());
            avaliacao.setPontuacao(dados.pontuacao());
            avaliacao.setDataProva(dados.dataProva());
            avaliacao.setDuracao(dados.duracao());
            avaliacao.setQuantidadeQuestoes(dados.quantidadeQuestoes());
            avaliacao.setCargo(cargo);

            this.avaliacaoRepository.save(avaliacao);

            return cargo.getId();
      }

}
