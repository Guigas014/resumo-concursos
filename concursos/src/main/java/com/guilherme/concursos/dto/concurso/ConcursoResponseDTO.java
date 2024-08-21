package com.guilherme.concursos.dto.concurso;

public record ConcursoResponseDTO(
            String id,
            String nome,
            String banca,
            Integer ano,
            String inicoInscricao,
            String fimInscricao,
            String link) {
}
