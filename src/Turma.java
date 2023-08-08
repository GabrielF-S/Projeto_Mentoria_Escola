import java.util.ArrayList;
import java.util.List;

public class Turma {
    private final int TAMANHO_MAX= 3;
    private String nomeTurma;
    private Escola escola;
    List<Aluno> alunos = new ArrayList<>();

    public Turma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void adicionarAluno(Aluno aluno){
        if (alunos.size()<TAMANHO_MAX){
            alunos.add(aluno);
            aluno.setTurma(this);
            aluno.setEscola(getEscola());
            System.out.println("Aluno cadastrado com sucesso!");
            System.out.println(aluno);
        }else {
            System.out.println("ERRO: Não é possivel adicionar mais alunos nesta turma");
        }
    }    public void adicionarAlunoInicio(Aluno aluno){
        if (alunos.size()<TAMANHO_MAX){
            alunos.add(aluno);
            aluno.setTurma(this);
            aluno.setEscola(getEscola());

        }else {
            System.out.println("ERRO: Não é possivel adicionar mais alunos nesta turma");
        }
    }



    @Override
    public String toString() {
        return "Escola: "+ escola.getNomeEscola() + " Turma: " + nomeTurma;
    }

    public void localizarAluno(String nomeAluno) {
        if (!alunos.isEmpty()) {
             for (Aluno aluno : alunos) {
                 if (aluno.getPrimeiroNomeAluno().equalsIgnoreCase(nomeAluno)) {
                    System.out.println(aluno);
            }
        }
    }
    }

    public Aluno localizarAlunoId(String idAluno) {
        for (Aluno aluno : alunos){
            if (aluno.getId().equalsIgnoreCase(idAluno)){
                return aluno;
            } else if (aluno.getPrimeiroNomeAluno().equalsIgnoreCase(idAluno)) {
                return aluno;
                
            }
        }
        return  null;
    }


    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
        System.out.println("Aluno removido!");
    }
}
