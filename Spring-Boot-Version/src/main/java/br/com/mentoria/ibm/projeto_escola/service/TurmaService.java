package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Turma;

import java.util.List;

public interface TurmaService {


    Turma adicionarAluno(int id,Aluno aluno);

    Turma removerAluno(int id, Aluno aluno);


    boolean isCheia(Turma turma);

    Turma criarTurma(String nome);

    Turma atualizarNomeTurma(Turma turma);

    Turma localizarTurmaPorId(int id);

    void deletarTurma(int id);

    List<Turma> localizarTodasTurmas();
}
