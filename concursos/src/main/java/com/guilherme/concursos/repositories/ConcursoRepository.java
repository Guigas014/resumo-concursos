package com.guilherme.concursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.concursos.domain.concurso.Concurso;

public interface ConcursoRepository extends JpaRepository<Concurso, String> {

}
