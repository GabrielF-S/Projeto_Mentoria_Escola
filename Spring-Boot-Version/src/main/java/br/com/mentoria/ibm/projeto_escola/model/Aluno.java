package br.com.mentoria.ibm.projeto_escola.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Integer id;
    @Column(name = "nomealuno")
    private String primeiroNomeAluno;
    @Column(name = "sobrenomealuno")
    private String sobrenomeAluno;
    @Column
    private int idade;




    public Aluno(String primeiroNomeAluno, String sobrenomeAluno, int idade) {
        setPrimeiroNomeAluno(primeiroNomeAluno);
        setSobrenomeAluno(sobrenomeAluno);
        setIdade(idade);

    }
    public Aluno(String primeiroNomeAluno, String sobrenomeAluno, int idade, int id) {
        setPrimeiroNomeAluno(primeiroNomeAluno);
        setSobrenomeAluno(sobrenomeAluno);
        setIdade(idade);

        this.id = id;
    }

    public String getPrimeiroNomeAluno() {
        return primeiroNomeAluno;
    }

    public void setPrimeiroNomeAluno(String primeiroNomeAluno) {
        this.primeiroNomeAluno = primeiroNomeAluno;
    }

    public String getSobrenomeAluno() {
        return sobrenomeAluno;
    }

    public void setSobrenomeAluno(String sobrenomeAluno) {
        this.sobrenomeAluno = sobrenomeAluno;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return " Id: "+ id +
                " Nome='" + primeiroNomeAluno+  " " + sobrenomeAluno + '\'' +
                ", idade= " + idade  + "\n ";

    }
}
