package com.guilherme.concursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.concursos.domain.avaliacao.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, String> {

}
