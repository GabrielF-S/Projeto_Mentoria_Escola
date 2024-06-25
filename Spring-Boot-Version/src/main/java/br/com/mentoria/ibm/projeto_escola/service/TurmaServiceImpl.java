package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Turma;
import br.com.mentoria.ibm.projeto_escola.repository.TurmaRepository;
import br.com.mentoria.ibm.projeto_escola.view.Inputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TurmaServiceImpl implements TurmaService {
    private List<Turma> turmas = new ArrayList<>();
    Inputs scanner = new Inputs();
    @Autowired
    TurmaRepository turmaRepo;

    public List<Turma> getTurmas() {
        return turmas;
    }


//    @Override
//    public void adicionarAluno(Aluno aluno, Turma verificar) throws Exception {
//        if (verificar.getAlunos().size() == verificar.getTAMANHO_MAX()) {
//            throw new Exception("Turma cheia!");
//        } else {
//            verificar.setAlunos(aluno);
//        }

//    }
    @Override
    public void adicionarAluno(Aluno aluno) throws Exception {
        boolean adicionado = false;
        for (Turma turma : turmas) {
            if (turma.getAlunos().size() < turma.getTAMANHO_MAX()) {
                turma.setAlunos(aluno);
                System.out.println("Aluno " + aluno.getPrimeiroNomeAluno() + " adicionado na turma: " + turma.getNomeTurma());
                adicionado = true;
                break;
            }
        }
        if (adicionado == false) {
            throw new Exception("Turmas cheias");
        }
    }

    @Override
    public Aluno localizarAlunoID(Integer id) throws Exception {
        for (Turma turma : turmas) {
            for (Aluno aluno : turma.getAlunos()) {
                if (aluno.getId() == id) {
                    return aluno;
                }
            }
            throw new Exception("Aluno não Localizado!");
        }
        return null;
    }

    @Override
    public Aluno localizarAlunoNome(String nome) throws Exception {
        for (Turma turma : turmas) {
            for (Aluno aluno : turma.getAlunos()) {
                if (aluno.getPrimeiroNomeAluno().equalsIgnoreCase(nome)) {
                    return aluno;
                }
            }
            throw new Exception("Aluno não Localizado!");
        }
        return null;
    }

//    @Override
//    public void removerAluno(Aluno aluno, Turma verificar) {
//        if (verificar.getAlunos().contains(aluno)) {
//            List<Aluno> turmas = verificar.getAlunos();
//            turmas.remove(aluno);
//            System.out.println("Aluno :" + aluno.getPrimeiroNomeAluno() + " Removido");
//        }
//
//    }

        @Override
        public void removerAluno (Aluno aluno) throws Exception {
            for (Turma turma : turmas) {
                for (Aluno alunoList : turma.getAlunos()) {
                    if (alunoList.equals(aluno)) {
                        turma.removerAluno(aluno);
                        System.out.println("Aluno :" + aluno.getPrimeiroNomeAluno() + " Removido");
                        break;
                    }
                }
            }
        }

        @Override public String solicitarNomeTurma () {
            System.out.println("Informe o nome da turma");
            return scanner.retornarString();
        }

        @Override public boolean isCheia (Turma verificar){
            return verificar.getAlunos().size() == verificar.getTAMANHO_MAX();
        }

        @Override public Turma criarTurma () {
            String nomeTurma = solicitarNomeTurma();
            if (turmas.size() < 3) {
                Turma turma = new Turma(nomeTurma);
                turmas.add(turma);
                return turma;
            }
            return null;
        }

        @Override public String solicitarNovoNomeTurma () {
            System.out.println("Informe o novo nome da turma");
            return scanner.retornarString();
        }

        @Override public void atualizarNomeTurma (Turma turma){
            turma.setNomeTurma(this.solicitarNovoNomeTurma());
        }
    }
