import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlunoTest {
    private Escola escolaTest;
    private Turma turmaTest;

    @Before
    public void iniciar() {
        escolaTest = new Escola("School");
        turmaTest = new Turma("Turma A");
    }

    @Test
    public void atualizarPrimeiroNomeVerdadeiro() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao", "Siqueira",
                13);
        turmaTest.adicionarAluno(alunoTest);
        escolaTest.adicionarTurma(turmaTest);
        escolaTest.adicionarAluno(alunoTest);
        //acao
        alunoTest.atualizarAluno("Jose", "Francisco", 15);
        //verificacao
        MatcherAssert.assertThat(alunoTest.getPrimeiroNomeAluno(), CoreMatchers.is("Jose"));
    }
    @Test
    public void atualizarSobrenomeVerdadeiro() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao", "Siqueira",
                13);
        turmaTest.adicionarAluno(alunoTest);
        escolaTest.adicionarTurma(turmaTest);
        escolaTest.adicionarAluno(alunoTest);
        //acao
        alunoTest.atualizarAluno("Jose", "Francisco", 15);
        //verificacao
        MatcherAssert.assertThat(alunoTest.getSobrenomeAluno(), CoreMatchers.is("Francisco"));
    }
    @Test
    public void atualizarIdadeVerdadeiro() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao", "Siqueira",
                13);
        turmaTest.adicionarAluno(alunoTest);
        escolaTest.adicionarTurma(turmaTest);
        escolaTest.adicionarAluno(alunoTest);
        //acao
        alunoTest.atualizarAluno("Jose", "Francisco", 15);
        //verificacao
        MatcherAssert.assertThat(alunoTest.getIdade(), CoreMatchers.is(15));
    }
    @Test
    public void verificarID() {
        //cenario
        Aluno alunoTest1 = new Aluno("Joao", "Siqueira",
                13);
        Aluno alunoTest2 = new Aluno("Joao", "Siqueira",
                13);
        //verificação
        Assert.assertNotSame("ID iguais", alunoTest1.getId(), alunoTest2.getId());
    }
    @Test
    public void atualizarPrimeiroNomeFalso() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao", "Siqueira",
                13);
        turmaTest.adicionarAluno(alunoTest);
        escolaTest.adicionarTurma(turmaTest);
        escolaTest.adicionarAluno(alunoTest);
        //acao
        alunoTest.atualizarAluno("Jose", "Francisco", 15);
        //verificacao
        MatcherAssert.assertThat(alunoTest.getPrimeiroNomeAluno(), CoreMatchers.is(CoreMatchers.not("Joao")));
    }
    @Test
    public void atualizarSobrenomeFalso() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao", "Siqueira",
                13);
        turmaTest.adicionarAluno(alunoTest);
        escolaTest.adicionarTurma(turmaTest);
        escolaTest.adicionarAluno(alunoTest);
        //acao
        alunoTest.atualizarAluno("Jose", "Francisco", 15);
        //verificacao
        MatcherAssert.assertThat(alunoTest.getSobrenomeAluno(), CoreMatchers.is(CoreMatchers.is(CoreMatchers.not("Siqueira"))));
    }
    @Test
    public void atualizarIdadeFalso() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao", "Siqueira",
                13);
        turmaTest.adicionarAluno(alunoTest);
        escolaTest.adicionarTurma(turmaTest);
        escolaTest.adicionarAluno(alunoTest);
        //acao
        alunoTest.atualizarAluno("Jose", "Francisco", 15);
        //verificacao
        MatcherAssert.assertThat(alunoTest.getIdade(), CoreMatchers.is(CoreMatchers.is(CoreMatchers.not(13))));
    }
}