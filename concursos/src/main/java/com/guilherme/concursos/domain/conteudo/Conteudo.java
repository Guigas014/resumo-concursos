package com.guilherme.concursos.domain.conteudo;

import com.guilherme.concursos.domain.avaliacao.Avaliacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "conteudos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Conteudo {

      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      private String id;

      private boolean portugues;
      private boolean matematica;
      private boolean informatica;
      private boolean raciocinio_logico;
      private boolean ingles;
      private boolean etica;
      private boolean atualidades;
      private boolean direito_administrativo;
      private boolean direito_constitucional;
      private boolean especifico;

      @Column(nullable = true)
      private String outros;

      @OneToOne
      @JoinColumn(name = "avaliacao_id", nullable = false)
      private Avaliacao avaliacao;
}
