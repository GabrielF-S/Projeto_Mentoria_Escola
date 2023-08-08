public class Aluno {
    private String id;
    private String primeiroNomeAluno;
    private String sobrenomeAluno;
    private int idade;
    private Turma turma;
    private Escola escola;

    public Aluno(String primeiroNomeAluno, String sobrenomeAluno, int idade) {
        this.primeiroNomeAluno = primeiroNomeAluno;
        this.sobrenomeAluno = sobrenomeAluno;
        this.idade = idade;
       this.id = generatedId(primeiroNomeAluno, sobrenomeAluno, idade);
    }

    private String generatedId(String primeiroNomeAluno, String sobrenomeAluno, int idade) {
        int num = (int)(Math.random()*1001);
        String salt = String.valueOf(num);

        return String.valueOf(primeiroNomeAluno.length()) + String.valueOf(sobrenomeAluno.length()) + String.valueOf(idade) + salt;
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    @Override
    public String toString() {
        return "Aluno{ Id: "+ id +
                " Nome='" + primeiroNomeAluno+  " " + sobrenomeAluno + '\'' +
                ", idade= " + idade + ", Turma: "+ turma+ ", Escola: "+  escola.getNomeEscola() + "  }\n ";

    }
}
