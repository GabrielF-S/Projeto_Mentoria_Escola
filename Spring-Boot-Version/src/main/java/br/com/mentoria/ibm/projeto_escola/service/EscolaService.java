package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Escola;
import br.com.mentoria.ibm.projeto_escola.model.Turma;

import java.util.List;
import java.util.Optional;

public interface EscolaService {
    Aluno criarAluno(Aluno aluno);

    void cadastrarAluno(Aluno aluno) throws Exception;

    void editarAluno() throws Exception;

    void excluirAluno() throws Exception;
    List<Aluno> localizarTodosAlunos() throws Exception;
    Aluno localizarAluno() throws Exception;

    Turma criarTurma(String nomeTurma);

    Escola cadastrarTurma(int id,Turma turma);

    void editarTurma();

    void excluirTurma() throws Exception;

    List<Turma> localizarTodasTurmas() throws Exception;

    Turma localizarUmaTurma(String nomeTurma) throws Exception;


    String obterNomeEscola();



    Escola criarEscola(String nome);
    void excuirEscola(int id);

    String solicitarNomeEscola();

    void localizarTurma();

    Turma localizarTurmaPorAluno(Aluno aluno);

    boolean confirmacao();

    String solicitarConfirmacao();

    Optional<Escola> localizarEscolaPorId(int id);

    Escola atualizarEscola(Escola escola);

    List<Escola> localizarEscola();
}
