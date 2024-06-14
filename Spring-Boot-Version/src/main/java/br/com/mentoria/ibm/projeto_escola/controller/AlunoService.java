package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;

public interface AlunoService {

    Aluno criarAluno();

    String IDgeneretor(String primeiroNomeAluno, String sobrenomeAluno, int idade);

    Aluno atualizarAluno(Aluno aluno);

     int solicitarIdadeAluno();

    String solicitarSobrenomeAluno();

    String solicitarNomeAluno();


}
