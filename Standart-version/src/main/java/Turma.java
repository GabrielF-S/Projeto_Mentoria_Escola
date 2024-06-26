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

    public void adicionarAluno(Aluno aluno) throws Exception {
        if (alunos.size() == TAMANHO_MAX){
            throw new Exception("Turma Lotada");
        }
        if (alunos.size()<TAMANHO_MAX){
            alunos.add(aluno);
        }
    }


    @Override
    public String toString() {
        return "Turma: " + nomeTurma +"\nAlunos: \n";
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


    public void removerAluno(Aluno aluno) throws Exception {
        if (!alunos.contains(aluno)){
            throw new Exception("Aluno não localizado");
        }
        alunos.remove(aluno);
        System.out.println("Aluno removido!");
    }

}
