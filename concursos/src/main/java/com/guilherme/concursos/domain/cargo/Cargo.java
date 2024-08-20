package com.guilherme.concursos.domain.cargo;

import com.guilherme.concursos.domain.concurso.Concurso;

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
@Table(name = "cargos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {

      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      private String id;

      private String nome;

      private String nivel;

      private String cadastroReserva;

      private Integer quantidadeVagas;

      private Double salario;

      @ManyToOne
      @JoinColumn(name = "concurso_id", nullable = false)
      private Concurso concurso;

}
