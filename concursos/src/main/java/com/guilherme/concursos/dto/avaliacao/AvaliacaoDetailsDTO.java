package com.guilherme.concursos.dto.avaliacao;

public record AvaliacaoDetailsDTO(
            String id,
            String tipo,
            String carater,
            Integer pontuacao,
            String dataProva,
            String duracao,
            Integer quantidadeQuestoes) {

}
