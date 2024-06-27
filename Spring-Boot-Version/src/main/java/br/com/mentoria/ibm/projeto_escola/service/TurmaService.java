package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Turma;

import java.util.List;

public interface TurmaService {

//    void adicionarAluno(Aluno aluno, Turma turma) throws Exception;

    void adicionarAluno(Aluno aluno) throws Exception;

    Aluno localizarAlunoNome(String nome) throws Exception;

    Aluno localizarAlunoID(Integer id) throws Exception;

//    void removerAluno(Aluno aluno, Turma turma);

    void removerAluno(Aluno aluno) throws Exception;

    String solicitarNomeTurma();

    boolean isCheia(Turma turma);

    Turma criarTurma(String nome);

    String solicitarNovoNomeTurma();

    Turma atualizarNomeTurma(Turma turma);

    Turma localizarTurmaPorId(int id);

    void deletarTurma(int id);

    List<Turma> localizarTodasTurmas();
}
