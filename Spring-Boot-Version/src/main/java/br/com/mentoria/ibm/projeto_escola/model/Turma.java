package br.com.mentoria.ibm.projeto_escola.model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    final int TAMANHO_MAX= 3;
    private String nomeTurma;


    List<Aluno> alunos = new ArrayList<>();

    public Turma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public int getTAMANHO_MAX() {
        return TAMANHO_MAX;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno aluno) {
        alunos.add(aluno);
    }



    @Override
    public String toString() {
        return "Turma: " + nomeTurma +"\nAlunos: \n";
    }




    public void removerAluno(Aluno aluno) throws Exception {
        if (!alunos.contains(aluno)){
            throw new Exception("Aluno não localizado");
        }
        alunos.remove(aluno);
        System.out.println("Aluno removido!");
    }

}
