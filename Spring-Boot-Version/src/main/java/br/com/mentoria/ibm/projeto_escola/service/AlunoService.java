package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;

import java.util.List;

public interface AlunoService {

    Aluno criarAluno(Aluno aluno);

    String solicitarNovoNomeAluno();

    Aluno atualizarAluno(Aluno aluno);

     int solicitarIdadeAluno();

    int solicitarNovaIdadeAluno();

    String solicitarSobrenomeAluno();

    String solicitarNovoSobrenomeAluno();

    String solicitarNomeAluno();


    Aluno localizarAlunoPorId(int id);

    List<Aluno> localizarTodosAlunos();

    void deletarAluno(int id);
}
