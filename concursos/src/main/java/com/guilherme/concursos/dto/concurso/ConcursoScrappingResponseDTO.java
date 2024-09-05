package com.guilherme.concursos.dto.concurso;

public record ConcursoScrappingResponseDTO(
            String nome,
            String ano,
            String fimInscricao,
            String link) {
}
