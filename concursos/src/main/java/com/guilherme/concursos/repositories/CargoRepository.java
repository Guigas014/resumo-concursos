package com.guilherme.concursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.concursos.domain.cargo.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, String> {

}
