package com.guilherme.concursos.domain.concurso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "concursos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Concurso {

      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      @Column(nullable = false)
      private String id;

      private String nome;

      private String banca;

      private Integer ano;

      private String inicioInscricao;

      private String fimInscricao;

      private String link;
}
