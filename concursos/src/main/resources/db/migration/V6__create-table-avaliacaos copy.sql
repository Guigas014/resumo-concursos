CREATE TABLE avaliacaos (
      id varchar(255) not null primary key,
      tipo varchar(255) not null,
      carater varchar(255) not null,
      pontuacao integer,
      data_prova varchar(255) not null,
      duracao varchar(150) not null,
      quantidade_questoes integer,
      cargo_id varchar(255) not null,

      CONSTRAINT avaliacaos_cargo_id_fkey FOREIGN KEY (cargo_id) REFERENCES cargos (id) ON DELETE RESTRICT ON UPDATE CASCADE
)
