package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;

import java.util.List;

public interface AlunoService {

    Aluno criarAluno(Aluno aluno);
    Aluno atualizarAluno(Aluno aluno);
    Aluno localizarAlunoPorId(int id);
    List<Aluno> localizarTodosAlunos();
    void deletarAluno(int id);

    Object lancarAprovacao(Aluno aluno);
}
