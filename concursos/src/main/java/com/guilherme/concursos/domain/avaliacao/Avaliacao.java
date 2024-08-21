package com.guilherme.concursos.domain.avaliacao;

import com.guilherme.concursos.domain.cargo.Cargo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "avaliacaos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Avaliacao {

      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      private String id;

      private String tipo;

      private String carater;

      private Integer pontuacao;

      private String dataProva;

      private String duracao;

      private Integer quantidadeQuestoes;

      @ManyToOne
      @JoinColumn(name = "cargo_id", nullable = false)
      private Cargo cargo;
}
