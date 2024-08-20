package com.guilherme.concursos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guilherme.concursos.domain.concurso.Concurso;
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

      public List<String> createConcursos(ConcursoRequestDTO concursoDTO) {

            // Testa se existe dados da tabela concurso, se positivo apaga todos.
            var concurosExistentes = this.concursoRepository.findAll();
            if (concurosExistentes.stream().count() > 0) {
                  this.concursoRepository.deleteAll();
            }

            List<List<String>> dataConcursos = scrappingData.getConcursosData();

            // EXEMPLO DE TRATAMENTO DE ERRO.
            // if (dataConcursos == null) {
            // throw new WebDriverException("Dados não encontrados!!");
            // }

            // ISSO AQUI É O MESMO CÓDIGO COMENTADO ABAIXO E QUE ESTÁ DENTRO DO FOREACH.
            // MAS COM A FUNÇÃO STREAM.
            List<String> idList = dataConcursos.stream().map(item -> {
                  String id = this.concursoRepository
                              .save(new Concurso(null, item.get(0), null, Integer.parseInt(item.get(1)), item.get(2)))
                              .getId();

                  return id;
            }).toList();

            return idList;

            // dataConcursos.forEach(item -> {
            // Concurso concurso2 = new Concurso();
            // concurso2.setNome(item.get(0));
            // concurso2.setAno(Integer.parseInt(item.get(1)));
            // concurso2.setLink(item.get(2));

            // // System.out.println("Concurso:\n" +
            // // "Nome: " + concurso2.getNome() + "\n" +
            // // "Ano: " + concurso2.getAno() + "\n" +
            // // "Link:" + concurso2.getLink() + "\n");

            // this.concursoRepository.save(concurso2);
            // });

            // Concurso newConcurso = new Concurso();

            // newConcurso.setNome(concursoDTO.nome());
            // newConcurso.setBanca(concursoDTO.banca());
            // newConcurso.setAno(concursoDTO.ano());
            // newConcurso.setLink(concursoDTO.link());

            // this.concursoRepository.save(newConcurso);

            // return new ConcursoIdDTO(newConcurso.getId());
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
