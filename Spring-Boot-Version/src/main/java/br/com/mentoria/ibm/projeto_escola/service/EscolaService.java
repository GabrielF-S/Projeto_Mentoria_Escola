package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Escola;
import br.com.mentoria.ibm.projeto_escola.model.Turma;

import java.util.List;
import java.util.Optional;

public interface EscolaService {
    Aluno criarAluno();

    void cadastrarAluno() throws Exception;

    void editarAluno() throws Exception;

    void excluirAluno() throws Exception;
    List<Aluno> localizarTodosAlunos() throws Exception;
    Aluno localizarAluno() throws Exception;

    Turma criarTurma();

    void cadastrarTurma();

    void editarTurma();

    void excluirTurma() throws Exception;

    List<Turma> localizarTodasTurmas() throws Exception;

    Turma localizarUmaTurma(String nomeTurma) throws Exception;


    String obterNomeEscola();



    Escola criarEscola(String nome);
    void excuirEscola(Optional<Escola> escola);

    String solicitarNomeEscola();

    void localizarTurma();

    Turma localizarTurmaPorAluno(Aluno aluno);

    boolean confirmacao();

    String solicitarConfirmacao();

    Optional<Escola> localizarEscolaPorId(int id);

    Escola atualizarEscola(Optional<Escola> escolaBusca);

    List<Escola> localizarEscola();
}
