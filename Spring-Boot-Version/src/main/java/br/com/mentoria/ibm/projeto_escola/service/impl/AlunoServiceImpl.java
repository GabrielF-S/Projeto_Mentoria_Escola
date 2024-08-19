package br.com.mentoria.ibm.projeto_escola.service.impl;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.repository.AlunoRepository;
import br.com.mentoria.ibm.projeto_escola.service.AlunoService;
import br.com.mentoria.ibm.projeto_escola.service.exception.ObjectNotFoundException;
import br.com.mentoria.ibm.projeto_escola.service.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AlunoServiceImpl implements AlunoService {
    @Autowired
    private AlunoRepository alunoRepo;

    @Override
    public Aluno criarAluno(Aluno aluno) {
        aluno.setStatus(Status.PENDENTE);
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

    @Override
    public Aluno lancarAprovacao(Aluno aluno) {
        var alunoBusca = localizarAlunoPorId(aluno.getId());
        if (Objects.nonNull(alunoBusca)){
            return alunoRepo.save(aluno);
        }
        else{
            throw new ObjectNotFoundException("Aluno não localizado na base");
        }
    }
}
