import java.util.ArrayList;
import java.util.List;

public class Turma {
    private final int TAMANHO_MAX= 3;
    private String nomeTurma;

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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void adicionarAluno(Aluno aluno){
        if (alunos.size()<TAMANHO_MAX){
            alunos.add(aluno);
        }else {
            System.out.println("ERRO: Não é possivel adicionar mais alunos nesta turma");
        }
    }



    @Override
    public String toString() {
        return "Turma: " + nomeTurma;
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
