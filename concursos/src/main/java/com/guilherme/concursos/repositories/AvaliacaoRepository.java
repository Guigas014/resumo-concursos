package com.guilherme.concursos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.concursos.domain.avaliacao.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, String> {

      List<Avaliacao> findByCargoId(String id);

}
