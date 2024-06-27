package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.repository.AlunoRepository;
import br.com.mentoria.ibm.projeto_escola.view.Inputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {
    private Inputs scanner = new Inputs();
    @Autowired
    private AlunoRepository alunoRepo;

    @Override
    public Aluno criarAluno(Aluno aluno) {
                return alunoRepo.save(aluno);
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
    public Aluno localizarAlunoPorId(int id) {
        return alunoRepo.findById(id).get();
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
        return alunoRepo.save(aluno);
    }

    @Override
    public List<Aluno> localizarTodosAlunos() {
        return alunoRepo.findAll();
    }

    @Override
    public void deletarAluno(int id) {
         alunoRepo.deleteById(id);
    }
}
