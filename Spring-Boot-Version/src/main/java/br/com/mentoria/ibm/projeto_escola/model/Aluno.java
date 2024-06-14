package br.com.mentoria.ibm.projeto_escola.model;

public class Aluno {
    private String id;
    private String primeiroNomeAluno;
    private String sobrenomeAluno;
    private int idade;

    public Aluno(String primeiroNomeAluno, String sobrenomeAluno, int idade) {
        this.primeiroNomeAluno = primeiroNomeAluno;
        this.sobrenomeAluno = sobrenomeAluno;
        this.idade = idade;
    }
    public Aluno(String primeiroNomeAluno, String sobrenomeAluno, int idade, String id) {
        this.primeiroNomeAluno = primeiroNomeAluno;
        this.sobrenomeAluno = sobrenomeAluno;
        this.idade = idade;
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

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return " Id: "+ id +
                " Nome='" + primeiroNomeAluno+  " " + sobrenomeAluno + '\'' +
                ", idade= " + idade  + "\n ";

    }
}
