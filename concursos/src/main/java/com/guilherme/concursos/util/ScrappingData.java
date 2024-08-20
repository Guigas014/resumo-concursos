package com.guilherme.concursos.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.stereotype.Component;

import com.guilherme.concursos.domain.concurso.exceptions.WebDriverException;

@Component
public class ScrappingData {

      public List<List<String>> getConcursosData() {
            // Web Scrapping
            WebDriver edgeDriver = new EdgeDriver();

            try {
                  edgeDriver.get("https://www.pciconcursos.com.br/concursos/centrooeste/");

                  edgeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

                  List<WebElement> list = edgeDriver.findElements(By.className("ca"));

                  // Pega o tamanho do array
                  Integer length = list.size();

                  // Cria uma list de concursos
                  List<List<String>> concursos = new ArrayList<>();

                  for (int i = 0; i < length; i++) {
                        WebElement value = list.get(i);
                        String item = value.getText();

                        if (item.contains("DF")) {
                              String[] itemsConcurso = item.split("\n");

                              String nomeConcurso = itemsConcurso[0];

                              WebElement linkConcurso = value.findElement(By.tagName("a"));
                              String link = linkConcurso.getAttribute("href");

                              String data;

                              if (itemsConcurso.length > 6) {
                                    data = itemsConcurso[6];
                              } else {
                                    data = itemsConcurso[5];
                              }

                              String ano = data.substring(6, 10);

                              List<String> dataConcurso = new ArrayList<>();
                              dataConcurso.add(nomeConcurso);
                              dataConcurso.add(ano);
                              dataConcurso.add(link);

                              concursos.add(dataConcurso);

                        }
                  }

                  return concursos;

            } catch (Exception e) {
                  throw new WebDriverException("Dados nao encontrados pelo scrapping");
            } finally {
                  // Fecha o navegador.
                  edgeDriver.quit();
            }
      }
}
