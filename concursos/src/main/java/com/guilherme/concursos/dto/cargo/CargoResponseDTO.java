package com.guilherme.concursos.dto.cargo;

public record CargoResponseDTO(
            String id,
            String nome,
            String nivel,
            boolean cadastroReserva,
            Integer quantidadeVagas,
            Double taxaInscricao,
            Double salario,
            String nomeConcurso,
            String fimInscricao) {

}
