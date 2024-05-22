import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
public class TurmaTest {
    private Escola escolaTest;
    private  Turma turmaTest;
    @Rule
    public ErrorCollector error = new ErrorCollector();
    @Before
    public void iniciar(){
        escolaTest = new Escola("School");
        turmaTest = new Turma("Turma A");
    }
    @Test
    public void adicionarAlunoQuandoTemVaga() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        escolaTest.adicionarTurma(turmaTest);
        //ação
        turmaTest.adicionarAluno(alunoTest);

        //verificação
        Assert.assertTrue(turmaTest.getAlunos().contains(alunoTest));
    }
    @Test(expected= Exception.class)
    public void adicionarAlunoQuandoNaoTemVaga() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        Aluno alunoTest2 = new Aluno("Jose","Siqueira",
                13);
        Aluno alunoTest3 = new Aluno("Jeremiras","Siqueira",
                13);
        Aluno alunoTest4 = new Aluno("Francisco","Neto",
                13);
        escolaTest.adicionarTurma(turmaTest);
        //ação
        turmaTest.adicionarAluno(alunoTest);
        turmaTest.adicionarAluno(alunoTest2);
        turmaTest.adicionarAluno(alunoTest3);

        //verificação
        turmaTest.adicionarAluno(alunoTest4);
    }
    @Test
    public void adicionarAlunoQuandoNaoTemVaga2() {
        //cenario
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        Aluno alunoTest2 = new Aluno("Jose","Siqueira",
                13);
        Aluno alunoTest3 = new Aluno("Jeremiras","Siqueira",
                13);
        Aluno alunoTest4 = new Aluno("Francisco","Neto",
                13);
        escolaTest.adicionarTurma(turmaTest);
        //ação
        try {
            turmaTest.adicionarAluno(alunoTest);
            turmaTest.adicionarAluno(alunoTest2);
            turmaTest.adicionarAluno(alunoTest3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //verificação
        try {
            turmaTest.adicionarAluno(alunoTest4);
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Turma Lotada"));
        }
    }

    @Test
    public void localizarAlunoVerdadeiro() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        Aluno alunoTest2 = new Aluno("Jose","Siqueira",
                13);
        Aluno alunoTest3 = new Aluno("Jeremiras","Siqueira",
                13);
        escolaTest.adicionarTurma(turmaTest);
        turmaTest.adicionarAluno(alunoTest);
        turmaTest.adicionarAluno(alunoTest2);
        turmaTest.adicionarAluno(alunoTest3);
        //ação
        Aluno buscaAluno =turmaTest.localizarAlunoId(alunoTest3.getId());
        //verificação
        Assert.assertEquals(buscaAluno, alunoTest3);
    }
    @Test
    public void localizarAlunoVerdadeiro2() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        Aluno alunoTest2 = new Aluno("Jose","Siqueira",
                13);
        Aluno alunoTest3 = new Aluno("Jeremiras","Siqueira",
                13);
        escolaTest.adicionarTurma(turmaTest);
        turmaTest.adicionarAluno(alunoTest);
        turmaTest.adicionarAluno(alunoTest2);
        turmaTest.adicionarAluno(alunoTest3);
        //ação
        Aluno buscaAluno =turmaTest.localizarAlunoId(alunoTest3.getId());
        //verificação
        error.checkThat(alunoTest3.getPrimeiroNomeAluno(), CoreMatchers.is(buscaAluno.getPrimeiroNomeAluno()));
        error.checkThat(alunoTest3.getSobrenomeAluno(), CoreMatchers.is(buscaAluno.getSobrenomeAluno()));
        error.checkThat(alunoTest3.getIdade(), CoreMatchers.is(buscaAluno.getIdade()));
        error.checkThat(alunoTest3.getId(), CoreMatchers.is(buscaAluno.getId()));
    }
    @Test
    public void localizarAlunoFalso() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        Aluno alunoTest2 = new Aluno("Jose","Siqueira",
                13);
        Aluno alunoTest3 = new Aluno("Jeremiras","Siqueira",
                13);
        escolaTest.adicionarTurma(turmaTest);
        turmaTest.adicionarAluno(alunoTest);
        turmaTest.adicionarAluno(alunoTest2);
        turmaTest.adicionarAluno(alunoTest3);
        //ação
        Aluno buscaAluno =turmaTest.localizarAlunoId(alunoTest3.getId());
        //verificação
        Assert.assertNotEquals(buscaAluno, alunoTest2);
    }

    @Test
    public void excluirAlunoVerdadeiro() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        Aluno alunoTest2 = new Aluno("Jose","Siqueira",
                13);
        Aluno alunoTest3 = new Aluno("Jeremiras","Siqueira",
                13);
        escolaTest.adicionarTurma(turmaTest);
        turmaTest.adicionarAluno(alunoTest);
        turmaTest.adicionarAluno(alunoTest2);
        turmaTest.adicionarAluno(alunoTest3);
        //ação
        turmaTest.removerAluno(alunoTest3);
        //verificação
        Assert.assertFalse(turmaTest.getAlunos().contains(alunoTest3));

    }
    @Test
    public void excluirAlunoFalso() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        Aluno alunoTest2 = new Aluno("Jose","Siqueira",
                13);
        Aluno alunoTest3 = new Aluno("Jeremiras","Siqueira",
                13);
        escolaTest.adicionarTurma(turmaTest);
        turmaTest.adicionarAluno(alunoTest);
        turmaTest.adicionarAluno(alunoTest2);
        //ação
        try{
            turmaTest.removerAluno(alunoTest3);
        }catch (Exception e){
            //verificação
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("Aluno não localizado") );
        }
            }
}
