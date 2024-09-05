package com.guilherme.concursos.dto.concurso;

public record ConcursoResponseDTO(
            String id,
            String nome,
            String banca,
            Integer ano,
            String inicioInscricao,
            String fimInscricao,
            String link) {
}
