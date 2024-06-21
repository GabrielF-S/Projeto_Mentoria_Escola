package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.view.Inputs;

public class AlunoServiceImpl implements AlunoService {
    Inputs scanner = new Inputs();

    @Override
    public Aluno criarAluno() {
        String primeiroNomeAluno = solicitarNomeAluno();
        String sobreNomeAluno = solicitarSobrenomeAluno();
        int idadeAluno = solicitarIdadeAluno();
        return new Aluno(primeiroNomeAluno, sobreNomeAluno, idadeAluno);

    }

    @Override
    public int solicitarIdadeAluno() {
        System.out.println("Informe a idade do aluno: ");
         int idade = scanner.retornarInt();
        return idade;
    }

    @Override
    public String solicitarSobrenomeAluno() {
        System.out.println("Informe o sobrenome do aluno: ");
        return scanner.retornarString();
    }
    @Override
    public String solicitarNomeAluno() {
        System.out.println("Digite o nome do Aluno: ");
        return scanner.retornarString();
    }
    @Override
    public int solicitarNovaIdadeAluno() {
        System.out.println("Informe a nova idade do aluno: ");
        int idade = scanner.retornarInt();
        return idade;
    }

    @Override
    public String solicitarNovoSobrenomeAluno() {
        System.out.println("Informe o novo sobrenome do aluno: ");
        return scanner.retornarString();
    }
    @Override
    public String solicitarNovoNomeAluno() {
        System.out.println("Digite o novo nome do Aluno: ");
        return scanner.retornarString();
    }



    @Override
    public Aluno atualizarAluno(Aluno aluno) {
        System.out.println("Aluno: " + aluno.getPrimeiroNomeAluno() + " " + aluno.getSobrenomeAluno() + " Idade: " + aluno.getIdade());
        System.out.println("Nome Antigo: " + aluno.getPrimeiroNomeAluno());
        String novoNome = solicitarNovoNomeAluno();
        aluno.setPrimeiroNomeAluno(novoNome);
        System.out.println("Sobrenome Antigo: " + aluno.getSobrenomeAluno() );
        String novoSobrenome = solicitarNovoSobrenomeAluno();
        aluno.setSobrenomeAluno(novoSobrenome);
        System.out.println("Idade Antiga: " + aluno.getIdade());
        int novoIdade = solicitarNovaIdadeAluno();
        aluno.setIdade(novoIdade);
        System.out.println("Atualizado para: " + aluno.getPrimeiroNomeAluno() + " " + aluno.getSobrenomeAluno() + " Idade: " + aluno.getIdade());
        return aluno;

    }
}
