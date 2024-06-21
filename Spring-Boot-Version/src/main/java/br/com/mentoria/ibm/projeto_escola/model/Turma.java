package br.com.mentoria.ibm.projeto_escola.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "tb_turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    final int TAMANHO_MAX= 3;
    @Column(name = "nome")
    private String nomeTurma;

    @OneToMany(mappedBy = "tb_turma", fetch = FetchType.LAZY)
    List<Aluno> alunos = new ArrayList<>();

    public Turma(String nomeTurma) {
        setNomeTurma(nomeTurma);
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
