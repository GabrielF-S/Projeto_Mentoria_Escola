package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Turma;

public interface TurmaService {

    void adicionarAluno(Aluno aluno, Turma turma) throws Exception;

    void adicionarAluno(Aluno aluno) throws Exception;

    Aluno localizarAlunoID(String id) throws Exception;

    void removerAluno(Aluno aluno, Turma turma);

    void removerAluno(Aluno aluno) throws Exception;

    String solicitarNomeTurma();

    boolean isCheia(Turma turma);


    Turma criarTurma(String nomeTurma);
}
