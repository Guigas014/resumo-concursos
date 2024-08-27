package com.guilherme.concursos.dto.avaliacao;

import com.guilherme.concursos.dto.conteudo.ConteudoResponseDTO;

public record AvaliacaoResponseDTO(
            String concurso,
            String cargo,
            AvaliacaoDetailsDTO avaliacao,
            ConteudoResponseDTO conteudo) {

}
