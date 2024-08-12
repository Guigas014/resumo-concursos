package com.guilherme.concursos.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.stereotype.Component;

@Component
public class ScrappingData {

      public String getConcursosData() {
            // Web Scrapping
            WebDriver edgeDriver = new EdgeDriver();
            edgeDriver.get("https://www.pciconcursos.com.br/concursos/centrooeste/");

            edgeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            List<WebElement> list = edgeDriver.findElements(By.className("ca"));

            // Integer length = list.size();

            WebElement value = list.get(0);
            String item = value.getText();

            // System.out.println(item);

            // Fecha o navegador.
            edgeDriver.quit();

            return item;
      }
}
