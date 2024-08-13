package com.guilherme.concursos.dto.concurso;

public record ConcursoResponseDTO(
            String id,
            String nome,
            String banca,
            Integer ano,
            String link) {
}
