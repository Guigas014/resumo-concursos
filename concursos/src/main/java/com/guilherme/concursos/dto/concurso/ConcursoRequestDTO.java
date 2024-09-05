package com.guilherme.concursos.dto.concurso;

public record ConcursoRequestDTO(
            String nome,
            String banca,
            Integer ano,
            String inicioInscricao,
            String fimInscricao,
            String link) {

}
