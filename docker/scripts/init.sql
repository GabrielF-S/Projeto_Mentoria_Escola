

 CREATE table tb_aluno(
    id_aluno  serial PRIMARY KEY,
    nome_aluno varchar(50) not null,
    sobrenome_aluno varchar(100) not null,
    idade_aluno integer not null,
    email varchar(50)
   aprovacao varchar(10),

);

CREATE table tb_turma(
    id_turma serial PRIMARY KEY,
    nome_turma varchar(50),
    id_aluno integer,
    FOREIGN KEY (id_aluno) REFERENCES tb_aluno (id_aluno)

);

CREATE table tb_escola(
    id_escola  serial PRIMARY KEY,
    nome_escola varchar(50),
    id_turma integer,
    FOREIGN KEY (id_turma) REFERENCES tb_turma (id_turma)
     
);