package com.guilherme.concursos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guilherme.concursos.domain.concurso.Concurso;
import com.guilherme.concursos.dto.concurso.ConcursoRequestDTO;
import com.guilherme.concursos.dto.concurso.ConcursoResponseDTO;
import com.guilherme.concursos.dto.concurso.ConcursoScrappingResponseDTO;
import com.guilherme.concursos.dto.concurso.ConcursosListResponseDTO;
import com.guilherme.concursos.repositories.ConcursoRepository;
import com.guilherme.concursos.util.ScrappingData;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConcursosService {

      private final ConcursoRepository concursoRepository;
      private final ScrappingData scrappingData;

      // Esse método retorna a lista dos concursos retirados do webscrapping.
      public List<ConcursoScrappingResponseDTO> getConcursosDoScrapping() {
            // DADOS VINDOS DO WEB SCRAPPING
            List<List<String>> dataConcursos = scrappingData.getConcursosData();

            // EXEMPLO DE TRATAMENTO DE ERRO (ESSE TRATAMENTO FOI UTILIZADO NO ARQUIVO
            // SCRAPPINGDATA).
            // if (dataConcursos == null) {
            // throw new WebDriverException("Dados não encontrados!!");
            // }

            List<ConcursoScrappingResponseDTO> listaConcursosScrapping = dataConcursos.stream().map(concurso -> {
                  return new ConcursoScrappingResponseDTO(concurso.get(0), concurso.get(1), concurso.get(3),
                              concurso.get(2));
            }).toList();

            return listaConcursosScrapping;
      }

      // ESSE MÉTODO SALVO NO DB UM CONCURSO ANALISADO OU SEJA, COM NO MINIMO UM CARGO
      // ADICIONADO.
      public String createConcurso(ConcursoRequestDTO concurso) {
            Concurso newConcurso = new Concurso();

            newConcurso.setNome(concurso.nome());
            newConcurso.setBanca(concurso.banca());
            newConcurso.setAno(concurso.ano());
            newConcurso.setInicioInscricao(concurso.inicioInscricao());
            newConcurso.setFimInscricao(concurso.fimInscricao());
            newConcurso.setLink(concurso.link());

            this.concursoRepository.save(newConcurso);

            return newConcurso.getId();

            // ISSO AQUI É O MESMO CÓDIGO COMENTADO ABAIXO E QUE ESTÁ DENTRO DO FOREACH.
            // MAS COM A FUNÇÃO STREAM.
            // List<String> idList = dataConcursos.stream().map(item -> {
            // String id = this.concursoRepository
            // .save(new Concurso(null, item.get(0), null, Integer.parseInt(item.get(1)),
            // null,
            // item.get(3), item.get(2)))
            // .getId();

            // return id;
            // }).toList();

            // return idList;

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
      }

      public ConcursosListResponseDTO getConcursosAnalisados() {
            List<Concurso> concursos = this.concursoRepository.findAll();

            List<ConcursoResponseDTO> listaConcursos = concursos.stream().map(concurso -> {
                  return new ConcursoResponseDTO(concurso.getId(), concurso.getNome(), concurso.getBanca(),
                              concurso.getAno(), concurso.getInicioInscricao(), concurso.getFimInscricao(),
                              concurso.getLink());
            }).toList();

            return new ConcursosListResponseDTO(listaConcursos);
      }
}
