CREATE TABLE cargos (
       id varchar(255) not null primary key,
      nome varchar(255) not null,
      nivel varchar(255) not null,
      cadastro_reserva boolean not null,
      quantidade_vagas integer not null,
      salario decimal(6,2) not null,
      concurso_id varchar(255) not null,

      CONSTRAINT cargos_concurso_id_fkey FOREIGN KEY (concurso_id) REFERENCES concursos (id) ON DELETE RESTRICT ON UPDATE CASCADE
)
