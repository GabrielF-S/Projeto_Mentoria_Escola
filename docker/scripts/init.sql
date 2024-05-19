

 CREATE table tb_aluno(
    id_aluno integer  not null,
    nomeAluno varchar(50) not null,
    sobrenomeAluno varchar(100) not null,
    idade integer not null,
    PRIMARY KEY(id_aluno)

);

CREATE table tb_turma(
    id_turma integer  not null,
    nome varchar(50),
    id_aluno integer not null,
    PRIMARY KEY(id_turma),
    FOREIGN KEY (id_aluno) REFERENCES tb_aluno (id_aluno)

);

CREATE table tb_escola(
    id_escola integer  not null,
    nome varchar(50),
    id_turma integer not null,
    id_aluno integer not null,

    PRIMARY KEY(id_escola),
    FOREIGN KEY (id_turma) REFERENCES tb_turma (id_turma),
    FOREIGN KEY (id_aluno) REFERENCES tb_aluno (id_aluno)
     
);

