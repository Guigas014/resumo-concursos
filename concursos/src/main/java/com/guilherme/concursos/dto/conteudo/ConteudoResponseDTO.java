package com.guilherme.concursos.dto.conteudo;

public record ConteudoResponseDTO(
            boolean portugues,
            boolean matematica,
            boolean informatica,
            boolean raciocinio_logico,
            boolean ingles,
            boolean etica,
            boolean atualidades,
            boolean direito_administrativo,
            boolean direito_constitucional,
            boolean especifico,
            String outros) {

}
