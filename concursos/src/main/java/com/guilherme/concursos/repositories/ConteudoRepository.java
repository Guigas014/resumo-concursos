package com.guilherme.concursos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.concursos.domain.conteudo.Conteudo;

public interface ConteudoRepository extends JpaRepository<Conteudo, String> {

      Optional<Conteudo> findByAvaliacaoId(String id);

}
