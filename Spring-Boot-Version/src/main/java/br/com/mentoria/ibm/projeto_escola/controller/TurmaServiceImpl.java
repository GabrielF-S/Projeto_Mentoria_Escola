package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Turma;
import br.com.mentoria.ibm.projeto_escola.view.Inputs;

import java.util.ArrayList;
import java.util.List;

public class TurmaServiceImpl implements TurmaService {
    List<Turma> turmas = new ArrayList<>();
    Inputs scanner = new Inputs();


    @Override
    public void adicionarAluno(Aluno aluno, Turma verificar) throws Exception {
        if (verificar.getAlunos().size() == verificar.getTAMANHO_MAX()) {
            throw new Exception("Turma cheia!");
        } else {
            verificar.setAlunos(aluno);
        }
    }

    @Override
    public void adicionarAluno(Aluno aluno) throws Exception {
        boolean adicionado = false;
        for (Turma turma : turmas) {
            if (turma.getAlunos().size() < turma.getTAMANHO_MAX()) {
                turma.setAlunos(aluno);
                System.out.println("Aluno "+ aluno.getPrimeiroNomeAluno() +" adicionado na turma: " + turma.getNomeTurma());
                adicionado = true;
                break;
            }
        }if (adicionado== false){
            throw new Exception("Turmas cheias");
        }
    }

    @Override
    public Aluno localizarAlunoID(String id) throws Exception {
        for (Turma turma : turmas) {
            for (Aluno aluno : turma.getAlunos()) {
                if (aluno.getId().equalsIgnoreCase(id)) {
                    return aluno;
                } else if (aluno.getPrimeiroNomeAluno().equalsIgnoreCase(id)) {
                    return aluno;
                }
            }
        }
        throw new Exception("Aluno não Localizado!");
    }

    @Override
    public void removerAluno(Aluno aluno, Turma verificar) {
        if (verificar.getAlunos().contains(aluno)) {
            List<Aluno> turmas = verificar.getAlunos();
            turmas.remove(aluno);
            System.out.println("Aluno :" + aluno.getPrimeiroNomeAluno() + " Removido");
        }

    }

    @Override
    public void removerAluno(Aluno aluno) throws Exception {
        for (Turma turma : turmas) {
            for (Aluno alunoList : turma.getAlunos()) {
                if (alunoList.equals(aluno)) {
                    turma.removerAluno(aluno);
                    System.out.println("Aluno :" + aluno.getPrimeiroNomeAluno() + " Removido");
                }
            }
        }
    }

    @Override
    public String solicitarNomeTurma() {
        System.out.println("Informe o nome da turma");
        return scanner.retornarString();
    }

    @Override
    public boolean isCheia(Turma verificar) {
        return verificar.getAlunos().size() == verificar.getTAMANHO_MAX();
    }

    @Override
    public Turma criarTurma(String nomeTurma) {
        if (turmas.size()<3){
            Turma turma =new Turma(nomeTurma);
            turmas.add(turma);
            return turma;
        }
        return null;
    }
}
