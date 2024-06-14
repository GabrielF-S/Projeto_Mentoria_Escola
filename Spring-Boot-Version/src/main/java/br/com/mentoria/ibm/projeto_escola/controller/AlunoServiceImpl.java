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
        String idAluno = IDgeneretor(primeiroNomeAluno, sobreNomeAluno, idadeAluno);
        return new Aluno(primeiroNomeAluno, sobreNomeAluno, idadeAluno, idAluno);

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
    public String IDgeneretor(String primeiroNomeAluno, String sobrenomeAluno, int idade) {
        int num = (int) (Math.random() * 1001);
        String salt = String.valueOf(num);
        return primeiroNomeAluno.length() + String.valueOf(sobrenomeAluno.length()) + idade + salt;
    }

    @Override
    public Aluno atualizarAluno(Aluno aluno) {
        System.out.println("Aluno: " + aluno.getPrimeiroNomeAluno() + " " + aluno.getSobrenomeAluno() + " Idade: " + aluno.getIdade());
        System.out.println("Nome Antigo: " + aluno.getPrimeiroNomeAluno());
        String novoNome = solicitarNomeAluno();
        aluno.setPrimeiroNomeAluno(novoNome);
        System.out.println("Sobrenome Antigo: " + aluno.getSobrenomeAluno() );
        String novoSobrenome = solicitarSobrenomeAluno();
        aluno.setSobrenomeAluno(novoSobrenome);
        System.out.println("Idade Antiga: " + aluno.getIdade());
        int novoIdade = solicitarIdadeAluno();
        aluno.setIdade(novoIdade);
        System.out.println("Atualizado para: " + aluno.getPrimeiroNomeAluno() + " " + aluno.getSobrenomeAluno() + " Idade: " + aluno.getIdade());
        return aluno;

    }
}
