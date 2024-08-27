package com.guilherme.concursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.concursos.domain.conteudo.Conteudo;

public interface ConteudoRepository extends JpaRepository<Conteudo, String> {

}
