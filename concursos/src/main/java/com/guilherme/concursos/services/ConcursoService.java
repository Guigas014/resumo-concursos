package com.guilherme.concursos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guilherme.concursos.domain.concurso.Concurso;
import com.guilherme.concursos.dto.concurso.ConcursoIdDTO;
import com.guilherme.concursos.dto.concurso.ConcursoRequestDTO;
import com.guilherme.concursos.dto.concurso.ConcursoResponseDTO;
import com.guilherme.concursos.dto.concurso.ConcursosListResponseDTO;
import com.guilherme.concursos.repositories.ConcursoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConcursoService {

      private final ConcursoRepository concursoRepository;

      public ConcursoIdDTO createConcursos(ConcursoRequestDTO concursoDTO) {
            Concurso newConcurso = new Concurso();

            newConcurso.setNome(concursoDTO.nome());
            newConcurso.setBanca(concursoDTO.banca());
            newConcurso.setAno(concursoDTO.ano());

            this.concursoRepository.save(newConcurso);

            return new ConcursoIdDTO(newConcurso.getId());
      }

      public ConcursosListResponseDTO getConcursos() {
            List<Concurso> concursos = this.concursoRepository.findAll();

            List<ConcursoResponseDTO> listaConcursos = concursos.stream().map(concurso -> {
                  return new ConcursoResponseDTO(concurso.getId(), concurso.getNome(), concurso.getBanca(),
                              concurso.getAno());
            }).toList();

            return new ConcursosListResponseDTO(listaConcursos);
      }
}
