package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {
    @Autowired
    private AlunoRepository alunoRepo;

    @Override
    public Aluno criarAluno(Aluno aluno) {
        return alunoRepo.save(aluno);
    }

    @Override
    public Aluno localizarAlunoPorId(int id) {
        return alunoRepo.findById(id).get();
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
