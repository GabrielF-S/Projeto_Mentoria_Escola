

 CREATE table tb_aluno(
    id_aluno integer  serial,
    nome_aluno varchar(50) not null,
    sobrenome_aluno varchar(100) not null,
    idade_aluno integer not null,
    PRIMARY KEY(id_aluno)

);

CREATE table tb_turma(
    id_turma integer  serial,
    nome_turma varchar(50),
    id_aluno integer,
    PRIMARY KEY(id_turma),
    FOREIGN KEY (id_aluno) REFERENCES tb_aluno (id_aluno)

);

CREATE table tb_escola(
    id_escola  integer serial,
    nome_escola varchar(50),
    id_turma integer,

    PRIMARY KEY(id_escola),
    FOREIGN KEY (id_turma) REFERENCES tb_turma (id_turma),
     
);

