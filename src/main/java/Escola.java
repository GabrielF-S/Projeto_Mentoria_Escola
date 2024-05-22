import java.util.ArrayList;
import java.util.List;

public class Escola {
    private String nomeEscola;
    private final int TAMANHO_MAX =3;
    private List<Turma> turmas = new ArrayList<>();

    private List<Aluno> alunos = new ArrayList<>();
    private  Controlador controlador;

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

    public void atualizarAluno() {
        if(!turmas.isEmpty()) {
            String idAluno = controlador.localizarAluno();
            Turma turma = controlador.localizarAlunoTurma(idAluno);
            if (turma != null) {
                Aluno aluno = turma.localizarAlunoId(idAluno);
                if (aluno != null){
                    if (controlador.confirmacao()){
                        controlador.atualizarAluno(aluno);

                    }

                }
            }

        }
    }



    public void editarTurmas() {

        Turma turma = controlador.localizarTurma();
        if (turma != null) {
            String novoNome = controlador.novoNomeTurma();
            if (controlador.confirmacao()){
                turma.setNomeTurma(novoNome);
                System.out.println("Nome da turma atualizado ["+turma.getNomeTurma()+"]");
            }
        }


    }


    public void excluirAluno() throws Exception {

        String idAluno = controlador.localizarAluno();
        Turma turma = controlador.localizarAlunoTurma(idAluno);
        if (turma != null){
            Aluno aluno = turma.localizarAlunoId(idAluno);
            if (aluno != null){
                System.out.println("["+ aluno.getPrimeiroNomeAluno()+"]");
                if (controlador.confirmacao()){
                    turma.removerAluno(aluno);
                }

            }else {
                System.out.println("ERRO: Não foi possivel excluir!");
            }
        }

    }

    public void excluirTurmas() {

        Turma turma = controlador.localizarTurma();
        if (turma != null){
            if (turma.getAlunos().isEmpty()){
                System.out.println("main.Turma ["+turma.getNomeTurma()+"] excluida");
                if (controlador.confirmacao()){
                    turmas.remove(turma);
                }

            }else {
                System.out.println("ERRO: Não é possivel excluir turmas que contenham alunos");
            }
        }

    }

    public void localizarAluno() {
        if (!turmas.isEmpty()){
            String idAluno = controlador.localizarAluno();

            Turma turma = controlador.localizarAlunoTurma(idAluno);
        if (turma!=null){
            Aluno aluno = turma.localizarAlunoId(idAluno);
            if (aluno != null){
                System.out.println(aluno);
            }

        }else
            System.out.println("ERRO: Nenhum aluno cadastrado");
        }

    }

    public void localizarTodasTurmas() {

        if (turmas.isEmpty()){
            System.out.println("ERRO: Não há turmas cadastradas");
        }else {
            for(Turma turma:  turmas){
                System.out.println(turma);
                if (turma.getAlunos().isEmpty()){
                    System.out.println("main.Turma Vazia!\n");
                }
                for (Aluno aluno : turma.getAlunos()){
                    System.out.println(aluno);
                }
            }
        }

    }

    public void adicionarTurma(Turma turma){
        turmas.add(turma);
    }
    public void cadastrarAluno() throws Exception {
        if (turmas.isEmpty()){
            System.out.println("ERRO: Não é possivel cadastrar aluno sem ter turmas");
        }else{
            Aluno aluno = controlador.criarAluno();
            Turma turma = controlador.localizarTurma();
            if (turma !=null){
                turma.adicionarAluno(aluno);
                alunos.add(aluno);
            }

        }

    }

    public void cadastrarTurma() {
        if (turmas.size()<TAMANHO_MAX){
            Turma turma = controlador.criarTurma();
            adicionarTurma(turma);
            System.out.println("main.Turma ["+turma.getNomeTurma()+"] Cadastrada com sucesso");
        }else {
            System.out.println("ERRO: Não é possivel adicionar mais turmas");
        }
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public Turma localizarTurma(String nomeTurma) {
        if (this.getTurmas().isEmpty()){
            System.out.println("ERRO: Não há turmas cadastradas");
        }

        for (Turma turma  : this.getTurmas()){
            if (turma.getNomeTurma().equalsIgnoreCase(nomeTurma)){
                return turma;
            }
        }

        System.out.println("ERRO: main.Turma não localizada!");
        return null;
    }

    public void localizarTodosAlunos() {
        for (Aluno aluno : alunos){
            System.out.println(aluno);
        }
    }
    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
    }
}