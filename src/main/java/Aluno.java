public class Aluno {
    private String id;
    private String primeiroNomeAluno;
    private String sobrenomeAluno;
    private int idade;

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

    public Aluno atualizarAluno(String primeiroNome, String sobrenome, int idade) {
        System.out.println("Aluno: " + this.getPrimeiroNomeAluno() + " "+ this.getSobrenomeAluno() + " Idade: " + this.getIdade());
        this.setPrimeiroNomeAluno(primeiroNome);
        this.setSobrenomeAluno(sobrenome);
        this.setIdade(idade);
        System.out.println("Atualizado para: "+ this.getPrimeiroNomeAluno() + " "+ this.getSobrenomeAluno()+ " Idade: "+ this.getIdade());
        return this;
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
