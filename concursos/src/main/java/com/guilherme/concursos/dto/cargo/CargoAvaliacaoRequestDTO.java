package com.guilherme.concursos.dto.cargo;

public record CargoAvaliacaoRequestDTO(
            String nome,
            String nivel,
            boolean cadastroReserva,
            Integer quantidadeVagas,
            Double taxaInscricao,
            Double salario,
            String tipo,
            String carater,
            Integer pontuacao,
            String dataProva,
            String duracao,
            Integer quantidadeQuestoes

) {

}
