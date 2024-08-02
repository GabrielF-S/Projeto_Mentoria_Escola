package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Turma;
import br.com.mentoria.ibm.projeto_escola.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaServiceImpl implements TurmaService {

    private List<Turma> turmas = new ArrayList<>();
    @Autowired
    TurmaRepository turmaRepo;

    public List<Turma> getTurmas() {
        return turmas;
    }


    @Override
    public Turma adicionarAluno(int id, Aluno aluno) {
        Turma turma = turmaRepo.findById(id).get();
        if (turma.getAlunos().size() < turma.getTAMANHO_MAX()) {
            List<Aluno> alunoList = turma.getAlunos();
            alunoList.add(aluno);
            turma.setAlunos(alunoList);
            return turmaRepo.save(turma);
        }
        return null;
    }

    @Override
    public Turma removerAluno(int id, Aluno aluno)  {
        Turma turma = localizarTurmaPorId(id);
        List<Aluno> alunosList = turma.getAlunos();
        alunosList.remove(aluno);
        turma.setAlunos(alunosList);
        return turmaRepo.save(turma);

    }

    @Override
    public boolean isCheia(Turma verificar) {
        return verificar.getAlunos().size() == verificar.getTAMANHO_MAX();
    }

    @Override
    public Turma criarTurma(String nomeTurma) {
        turmas = turmaRepo.findAll();
        if (turmas.size() < 3) {
            Turma turma = new Turma(nomeTurma);

            if (turmas.contains(turma)) {
                System.out.println("Turma " + nomeTurma + " ja cadastrada");
                return null;
            }
            return turmaRepo.save(turma);
        }
        return null;
    }

    @Override
    public Turma atualizarNomeTurma(Turma turma) {
        return turmaRepo.save(turma);
    }

    @Override
    public Turma localizarTurmaPorId(int id) {
        return turmaRepo.findById(id).get();
    }

    @Override
    public void deletarTurma(int id) {
        turmaRepo.deleteById(id);
    }

    @Override
    public List<Turma> localizarTodasTurmas() {
        return turmaRepo.findAll();
    }


}
