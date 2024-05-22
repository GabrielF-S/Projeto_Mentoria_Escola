import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class AlunoTeste {
    @Test
    public void atualizarPrimeiroNome(){
        //cenario
        Escola escolaTest = new Escola("School");
        Turma turmaTest = new Turma("Turma A");
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        turmaTest.adicionarAluno(alunoTest);
        escolaTest.adicionarTurma(turmaTest);
        escolaTest.adicionarAluno(alunoTest);

        //acao
        alunoTest.atualizarAluno("Jose","Francisco", 15);
        //verificacao

        Assert.assertThat(alunoTest.getPrimeiroNomeAluno(), CoreMatchers.is("Jose"));
    }
    @Test
    public void atualizarSobrenome(){
        //cenario
        Escola escolaTest = new Escola("School");
        Turma turmaTest = new Turma("Turma A");
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        turmaTest.adicionarAluno(alunoTest);
        escolaTest.adicionarTurma(turmaTest);
        escolaTest.adicionarAluno(alunoTest);

        //acao
        alunoTest.atualizarAluno("Jose","Francisco", 15);
        //verificacao

        Assert.assertThat(alunoTest.getSobrenomeAluno(), CoreMatchers.is("Francisco"));
    }

    @Test
    public void atualizarIdade(){
        //cenario
        Escola escolaTest = new Escola("School");
        Turma turmaTest = new Turma("Turma A");
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        turmaTest.adicionarAluno(alunoTest);
        escolaTest.adicionarTurma(turmaTest);
        escolaTest.adicionarAluno(alunoTest);

        //acao
        alunoTest.atualizarAluno("Jose","Francisco", 15);
        //verificacao

        Assert.assertThat(alunoTest.getIdade(), CoreMatchers.is(15));
    }
    @Test
    public  void verificarID(){
        //cenario
        Aluno alunoTest1 = new Aluno("Joao","Siqueira",
                13);
        Aluno alunoTest2 = new Aluno("Joao","Siqueira",
                13);
        //verificação
        Assert.assertFalse("ID iguais", alunoTest1.getId() == alunoTest2.getId());

    }

}
