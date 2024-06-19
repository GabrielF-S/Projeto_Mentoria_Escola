package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Escola;
import br.com.mentoria.ibm.projeto_escola.model.Turma;
import br.com.mentoria.ibm.projeto_escola.view.Inputs;

import java.util.List;
import java.util.Scanner;

public class EscolaServiceImpl implements EscolaService {
    Inputs scaner = new Inputs();
    private Escola escola;
    private AlunoService alunoService = new AlunoServiceImpl();
    private TurmaService turmaService = new TurmaServiceImpl();

    @Override
    public Aluno criarAluno() {
        return alunoService.criarAluno();
    }

    @Override
    public void cadastrarAluno() throws Exception {
        if (escola.getTurmas().isEmpty()) {
            System.out.println("ERRO: Não é possivel cadastrar aluno sem ter turmas");
            throw new Exception("Não é possivel cadastrar aluno sem ter turmas");
        } else {
            for (Turma turma : escola.getTurmas()) {
                if (!turmaService.isCheia(turma)) {
                    Aluno alunoEscola = alunoService.criarAluno();
                    turmaService.adicionarAluno(alunoEscola);
                    List<Aluno> alunos = escola.getAlunos();
                    alunos.add(alunoEscola);
                    escola.setAlunos(alunos);
                    break;
                } else {
                    System.out.println("Turmas cheias!");
                }
            }
        }

    }

    @Override
    public void editarAluno() throws Exception {
        Aluno aluno = this.localizarAluno();
        alunoService.atualizarAluno(aluno);
    }

    @Override
    public void excluirAluno() throws Exception {
        List<Aluno> alunos = escola.getAlunos();
        Aluno aluno = this.localizarAluno();
        System.out.println("Deseja excluir aluno: " + aluno);
        if (confirmacao()) {
            System.out.println("Aluno: " + aluno.getPrimeiroNomeAluno() + " excluido");
            turmaService.removerAluno(aluno);
            alunos.remove(aluno);
            escola.setAlunos(alunos);
        }


    }

    @Override
    public List<Aluno> localizarTodosAlunos() throws Exception {
        if (escola.getAlunos().isEmpty()) {
            throw new Exception("Nenhum aluno cadastrado");
        }
        for (Aluno aluno : escola.getAlunos()) {
            System.out.println(aluno);
        }
        return escola.getAlunos();
    }

    @Override
    public Aluno localizarAluno() throws Exception {
        if (!escola.getTurmas().isEmpty()) {
            String alunoId = alunoService.solicitarNomeAluno();
            Aluno aluno = turmaService.localizarAlunoID(alunoId);
            if (aluno != null) {
                System.out.println(aluno);
                return aluno;
            } else {
                System.out.println("ERRO: Nenhum aluno cadastrado");
                throw new Exception("Nenhum aluno cadastrado");
            }
        } else {
            throw new Exception("Nenhuma Turma cadastrada");
        }
    }

    @Override
    public Turma criarTurma() {
        return turmaService.criarTurma();
    }

    @Override
    public void cadastrarTurma() {
        if (escola.getTurmas().size() < escola.getTAMANHO_MAX()) {
            Turma turmaEscola = criarTurma();
            if (escola.getTurmas().contains(turmaEscola)) {
                System.out.println("Turma já cadastrada");
            } else {
                System.out.println("Turma criada");
                List<Turma> turmas = escola.getTurmas();
                turmas.add(turmaEscola);
                escola.setTurmas(turmas);
            }
        }
    }

    @Override
    public void editarTurma() {
        String nomeTurma = turmaService.solicitarNomeTurma();
        Turma turma = this.localizarUmaTurma(nomeTurma);
        if (escola.getTurmas().contains(turma)) {
            turmaService.atualizarNomeTurma(turma);
            System.out.println("Nome da turma alterado para: " + turma.getNomeTurma());
        }
    }

    @Override
    public void excluirTurma() {
        List<Turma> turmas = escola.getTurmas();
        String nomeTurma = turmaService.solicitarNomeTurma();
        Turma turma = this.localizarUmaTurma(nomeTurma);
        if (turma.getAlunos().isEmpty()) {
            System.out.println("Deseja excluir turma: " + turma.getNomeTurma());
            if (this.confirmacao()) {
                System.out.println("Turma: " + turma.getNomeTurma() + " excluida");
                turmas.remove(turma);
                escola.setTurmas(turmas);
            }

        } else {
            System.out.println("Não é possivel excluir turmas que contenham alunos cadastrados");
        }
    }

    @Override
    public List<Turma> localizarTodasTurmas() throws Exception {
        if (escola.getTurmas().isEmpty()) {
            System.out.println("ERRO: Não há turmas cadastradas");
            throw new Exception("Não há turmas cadastradas");
        } else {
            for (Turma turma : escola.getTurmas()) {
                System.out.println(turma);
                if (turma.getAlunos().isEmpty()) {
                    System.out.println("Turma: " + turma.getNomeTurma() + " vazia!");
                } else {
                    for (Aluno aluno : turma.getAlunos()) {
                        System.out.println(aluno);
                    }
                }

            }
        }
        return escola.getTurmas();
    }

    @Override
    public Turma localizarUmaTurma(String nomeTurma) {
        for (Turma turma : escola.getTurmas()) {
            if (turma.getNomeTurma().equalsIgnoreCase(nomeTurma)) {
                System.out.println(turma);
                for (Aluno alunos : turma.getAlunos()) {
                    System.out.println(alunos);
                }
                return turma;
            }

        }
        System.out.println("ERRO: Turma não localizada!");
        return null;
    }

    @Override
    public String obterNomeEscola() {
        return escola.getNomeEscola();
    }

    @Override
    public Escola criarEscola() {
        String nomeEscola = this.solicitarNomeEscola();
        escola = new Escola(nomeEscola);
        return escola;
    }

    public String solicitarNomeEscola() {
        System.out.println("Informe o nome da Escola: ");
        return scaner.retornarString();
    }

    @Override
    public void localizarTurma() {
        String nomeTurma = turmaService.solicitarNomeTurma();
        this.localizarUmaTurma(nomeTurma);
    }

    @Override
    public Turma localizarTurmaPorAluno(Aluno aluno) {
        for (Turma turma : escola.getTurmas()) {
            if (turma.getAlunos().contains(aluno)) {
                return turma;
            }
        }
        return null;
    }
    @Override
    public boolean confirmacao() {
        String confirmacao = solicitarConfirmacao();
        return confirmacao.equalsIgnoreCase("y") ||
                confirmacao.equalsIgnoreCase("yes") ||
                confirmacao.equalsIgnoreCase("s") ||
                confirmacao.equalsIgnoreCase("sim");
    }

    @Override
    public String solicitarConfirmacao() {
        System.out.println("Confirmar a ação? y/n");
        return scaner.retornarString();
    }
}

