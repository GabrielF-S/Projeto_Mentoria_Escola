import java.util.ArrayList;
import java.util.List;

public class Escola {
    private String nomeEscola;
    private final int TAMANHO_MAX = 3;
    private List<Turma> turmas = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

    public List<Aluno> getAlunos() {
        return alunos;
    }

    private Controlador controlador;

    public Escola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void editarAluno() {
        if (!turmas.isEmpty()) {
            String idAluno = controlador.localizarAluno();
            Aluno aluno = controlador.localizarAlunoTurma(idAluno);
            if (aluno != null) {
                if (controlador.confirmacao()) {
                    controlador.atualizarAluno(aluno);
                }
            }
        }
    }
    public void editarTurmas() throws Exception {
        Turma turma = controlador.localizarTurma();
        if (turma != null) {
            String novoNome = controlador.novoNomeTurma();
            if (controlador.confirmacao()) {
                turma.setNomeTurma(novoNome);
                System.out.println("Nome da turma atualizado [" + turma.getNomeTurma() + "]");
            }
        }
    }
    public void excluirAluno() throws Exception {
        String idAluno = controlador.localizarAluno();
        Aluno aluno = controlador.localizarAlunoTurma(idAluno);
        if (aluno != null) {
            System.out.println("[" + aluno.getPrimeiroNomeAluno() + "]");
            if (controlador.confirmacao()) {
                Turma turma = localizarTurma(aluno);
                turma.removerAluno(aluno);
            }
        } else {
            System.out.println("ERRO: Não foi possivel excluir!");
            throw new Exception("Não foi possivel excluir!");
        }
    }

    public void excluirTurmas() throws Throwable {
        Turma turma = controlador.localizarTurma();
        if (turma != null) {
            if (turma.getAlunos().isEmpty()) {
                System.out.println("main.Turma [" + turma.getNomeTurma() + "] excluida");
                if (controlador.confirmacao()) {
                    turmas.remove(turma);

                }
            } else {
                System.out.println("ERRO: Não é possivel excluir turmas que contenham alunos");
                throw new Exception("ERRO: Não é possivel excluir turmas que contenham alunos");
            }
        } else {
            throw new Exception("Nenhuma turma cadastrada");
        }
    }

    public Aluno localizarAluno() throws Exception {
        if (!turmas.isEmpty()) {
            String idAluno = controlador.localizarAluno();

            Aluno aluno = controlador.localizarAlunoTurma(idAluno);
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

    public List<Turma> localizarTodasTurmas() throws Exception {

        if (turmas.isEmpty()) {
            System.out.println("ERRO: Não há turmas cadastradas");
            throw new Exception("Não há turmas cadastradas");
        } else {
            for (Turma turma : turmas) {
                System.out.println(turma);
                if (turma.getAlunos().isEmpty()) {
                    System.out.println("main.Turma: '"+ turma.getNomeTurma() + "' Vazia!\n");
                }
                for (Aluno aluno : turma.getAlunos()) {
                    System.out.println(aluno);
                }
            }
            return turmas;
        }

    }

    public void adicionarTurma(Turma turma) throws Exception {
        if (turmas.contains(turma)){
            throw new Exception("Turma já cadastrada");
        }
        turmas.add(turma);
    }

    public void cadastrarAluno() throws Exception {
        if (turmas.isEmpty()) {
            System.out.println("ERRO: Não é possivel cadastrar aluno sem ter turmas");
            throw new Exception("Não é possivel cadastrar aluno sem ter turmas");
        } else {
            Aluno aluno = controlador.criarAluno();
            Turma turma = controlador.localizarTurma();
            if (turma != null) {
                turma.adicionarAluno(aluno);
                alunos.add(aluno);
            }

        }

    }

    public void cadastrarTurma() throws Exception {
        if (turmas.size() < TAMANHO_MAX) {
            Turma turma = controlador.criarTurma();
            adicionarTurma(turma);
            System.out.println("Turma [" + turma.getNomeTurma() + "] Cadastrada com sucesso");
        } else {
            System.out.println("ERRO: Não é possivel adicionar mais turmas");
            throw new Exception("Não é possivel adicionar mais turmas");
        }
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public Turma localizarTurma(String nomeTurma) throws Exception {
        if (this.getTurmas().isEmpty()) {
            System.out.println("ERRO: Não há turmas cadastradas");
            throw new Exception("Não há turmas cadastradas");
        }

        for (Turma turma : this.getTurmas()) {
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

    public List<Aluno> localizarTodosAlunos() throws Exception {

        if (alunos.isEmpty()) {
            throw new Exception("Nenhum aluno cadastrado");
        }
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
        return getAlunos();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public Turma localizarTurma(Aluno aluno) {
        for (Turma turma : turmas) {
            if (turma.getAlunos().contains(aluno)) {
                return turma;
            }
        }
        return null;
    }
}