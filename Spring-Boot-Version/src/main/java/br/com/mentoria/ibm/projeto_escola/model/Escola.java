package br.com.mentoria.ibm.projeto_escola.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_escola")
public class Escola implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escola", nullable = false, unique = true)
    private int id;
    @Column(name = "nome_escola")
    private String nomeEscola;
    @Transient
    private final int TAMANHO_MAX = 3;

    @OneToMany
    private List<Turma> turmas;

    @OneToMany
    private List<Aluno> alunos;

    public Escola() {

    }

    public Escola(String nomeEscola) {
        setNomeEscola(nomeEscola);
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

    public void setTurmas(Turma turma) {
        this.turmas.add(turma);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public int getTAMANHO_MAX() {
        return TAMANHO_MAX;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}