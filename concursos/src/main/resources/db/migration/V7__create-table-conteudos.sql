CREATE TABLE conteudos (
      id varchar(255) not null primary key,
      portugues boolean not null,
      matematica boolean not null,
      informatica boolean not null,
      raciocinio_logico boolean not null,
      ingles boolean not null,
      etica boolean not null,
      atualidades boolean not null,
      direito_administrativo boolean not null,
      direito_constitucional boolean not null,
      especifico boolean not null,
      outros varchar(255),
      avaliacao_id varchar(255) not null,

      CONSTRAINT conteudos_avaliacao_id_fkey FOREIGN KEY (avaliacao_id) REFERENCES avaliacaos (id) ON DELETE RESTRICT ON UPDATE CASCADE
)
