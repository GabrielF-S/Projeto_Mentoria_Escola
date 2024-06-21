package br.com.mentoria.ibm.projeto_escola.model;

import java.util.ArrayList;
import java.util.List;

public class Escola {
    private String nomeEscola;

    private final int TAMANHO_MAX = 3;

    private List<Turma> turmas = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();


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

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
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

}