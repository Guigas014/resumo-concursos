package com.guilherme.concursos.domain.conteudo;

import com.guilherme.concursos.domain.avaliacao.Avaliacao;

import jakarta.persistence.Column;
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
@Table(name = "conteudos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Conteudo {

      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      private String id;

      private boolean portugues = false;
      private boolean matematica = false;
      private boolean informatica = false;
      private boolean raciocinio_logico = false;
      private boolean ingles = false;
      private boolean etica = false;
      private boolean atualidades = false;
      private boolean direito_administrativo = false;
      private boolean direito_constitucional = false;
      private boolean especifico = false;

      @Column(nullable = true)
      private String outros;

      @ManyToOne
      @JoinColumn(name = "avaliacao_id", nullable = false)
      private Avaliacao avaliacao;
}
