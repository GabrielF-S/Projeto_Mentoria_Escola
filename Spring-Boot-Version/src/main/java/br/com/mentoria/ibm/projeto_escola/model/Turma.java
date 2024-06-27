package br.com.mentoria.ibm.projeto_escola.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private int id;
    @Transient
    final int TAMANHO_MAX = 3;
    @Column(name = "nome_turma")
    private String nomeTurma;

    @OneToMany
    List<Aluno> alunos;

    public Turma() {
    }

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
        return "Turma: " + nomeTurma + "\nAlunos: \n";
    }


    public void removerAluno(Aluno aluno) throws Exception {
        if (!alunos.contains(aluno)) {
            throw new Exception("Aluno não localizado");
        }
        alunos.remove(aluno);
        System.out.println("Aluno removido!");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return id == turma.id && Objects.equals(nomeTurma, turma.nomeTurma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeTurma);
    }
}
