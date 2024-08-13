package com.guilherme.concursos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guilherme.concursos.domain.concurso.Concurso;
import com.guilherme.concursos.dto.concurso.ConcursoIdDTO;
import com.guilherme.concursos.dto.concurso.ConcursoRequestDTO;
import com.guilherme.concursos.dto.concurso.ConcursoResponseDTO;
import com.guilherme.concursos.dto.concurso.ConcursosListResponseDTO;
import com.guilherme.concursos.repositories.ConcursoRepository;
import com.guilherme.concursos.util.ScrappingData;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConcursoService {

      private final ConcursoRepository concursoRepository;
      private final ScrappingData scrappingData;

      public ConcursoIdDTO createConcursos(ConcursoRequestDTO concursoDTO) {

            List<List<String>> dataConcursos = scrappingData.getConcursosData();

            // Executar repetidas vezes, conforme o dataConcursos.size() - em um stream()
            Concurso concurso1 = new Concurso();
            List<String> concurso = dataConcursos.get(0);
            concurso1.setNome(concurso.get(0));
            concurso1.setAno(Integer.parseInt(concurso.get(1)));

            // System.out.println(concurso1.getNome());

            Concurso newConcurso = new Concurso();

            newConcurso.setNome(concursoDTO.nome());
            newConcurso.setBanca(concursoDTO.banca());
            newConcurso.setAno(concursoDTO.ano());
            newConcurso.setLink(concursoDTO.link());

            this.concursoRepository.save(newConcurso);

            return new ConcursoIdDTO(newConcurso.getId());
      }

      public ConcursosListResponseDTO getConcursos() {
            List<Concurso> concursos = this.concursoRepository.findAll();

            List<ConcursoResponseDTO> listaConcursos = concursos.stream().map(concurso -> {
                  return new ConcursoResponseDTO(concurso.getId(), concurso.getNome(), concurso.getBanca(),
                              concurso.getAno(), concurso.getLink());
            }).toList();

            return new ConcursosListResponseDTO(listaConcursos);
      }
}
