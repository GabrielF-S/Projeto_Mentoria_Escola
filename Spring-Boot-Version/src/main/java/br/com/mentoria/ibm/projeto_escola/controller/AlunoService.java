package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;

public interface AlunoService {

    Aluno criarAluno();

    String solicitarNovoNomeAluno();

    String IDgeneretor(String primeiroNomeAluno, String sobrenomeAluno, int idade);

    Aluno atualizarAluno(Aluno aluno);

     int solicitarIdadeAluno();

    int solicitarNovaIdadeAluno();

    String solicitarSobrenomeAluno();

    String solicitarNovoSobrenomeAluno();

    String solicitarNomeAluno();


}
