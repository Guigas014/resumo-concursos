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

            String concurso = scrappingData.getConcursosData();
            System.out.println(concurso);

            // // Web Scrapping
            // WebDriver edgeDriver = new EdgeDriver();
            // edgeDriver.get("https://www.pciconcursos.com.br/concursos/centrooeste/");

            // edgeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            // List<WebElement> list = edgeDriver.findElements(By.className("ca"));

            // Integer length = list.size();

            // WebElement value = list.get(0);
            // String item = value.getText();

            // System.out.println(item);

            // // Fecha o navegador.
            // edgeDriver.quit();

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
