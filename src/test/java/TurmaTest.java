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
    private Aluno alunoTest;
    private Aluno alunoTest2;
    private Aluno alunoTest3;
    @Rule
    public ErrorCollector error = new ErrorCollector();
    @Before
    public void iniciar(){
        this.escolaTest = new Escola("School");
        this.turmaTest = new Turma("Turma A");
        this.alunoTest = new Aluno("Joao","Siqueira",
                13);
        this.alunoTest2 = new Aluno("Jose","Siqueira",
                13);
        this.alunoTest3 = new Aluno("Jeremiras","Siqueira",
                13);
    }
    @Test
    public void deveAdicionarAlunoQuandoTemVaga() throws Exception {
        //cenario
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        this.escolaTest.adicionarTurma(turmaTest);
        //ação
        this.turmaTest.adicionarAluno(alunoTest);

        //verificação
        Assert.assertTrue(turmaTest.getAlunos().contains(alunoTest));
    }
    @Test(expected= Exception.class)
    public void naoDeveadicionarAlunoQuandoNaoTemVaga() throws Exception {
        //cenario
        Aluno alunoTest4 = new Aluno("Francisco","Neto",
                13);
        this.escolaTest.adicionarTurma(turmaTest);
        //ação
        this.turmaTest.adicionarAluno(alunoTest);
        this.turmaTest.adicionarAluno(alunoTest2);
        this.turmaTest.adicionarAluno(alunoTest3);

        //verificação
        this.turmaTest.adicionarAluno(alunoTest4);
    }
    @Test
    public void naoDeveadicionarAlunoQuandoNaoTemVaga2() {
        //cenario
        Aluno alunoTest4 = new Aluno("Francisco","Neto",
                13);
        this.escolaTest.adicionarTurma(turmaTest);
        //ação
        try {
            this.turmaTest.adicionarAluno(alunoTest);
            this.turmaTest.adicionarAluno(alunoTest2);
            this.turmaTest.adicionarAluno(alunoTest3);
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
    public void deveLocalizarAlunoQuandoPassarOID() throws Exception {
        //cenario
        this.escolaTest.adicionarTurma(turmaTest);
        this.turmaTest.adicionarAluno(alunoTest);
        this.turmaTest.adicionarAluno(alunoTest2);
        this.turmaTest.adicionarAluno(alunoTest3);
        //ação
        Aluno buscaAluno =turmaTest.localizarAlunoId(alunoTest3.getId());
        //verificação
        Assert.assertEquals(buscaAluno, alunoTest3);
    }
    @Test
    public void deveLocalizarAlunoQuandoPassarONome() throws Exception {
        //cenario
        this.escolaTest.adicionarTurma(turmaTest);
        this.turmaTest.adicionarAluno(alunoTest);
        this.turmaTest.adicionarAluno(alunoTest2);
        this.turmaTest.adicionarAluno(alunoTest3);
        //ação
        Aluno buscaAluno =turmaTest.localizarAlunoId(alunoTest3.getPrimeiroNomeAluno());
        //verificação
        Assert.assertEquals(buscaAluno, alunoTest3);
    }
    @Test
    public void naoDeveLocalizarAlunoQuandoPassarONome() throws Exception {
        //cenario
        this.escolaTest.adicionarTurma(turmaTest);
        this.turmaTest.adicionarAluno(alunoTest);
        this.turmaTest.adicionarAluno(alunoTest2);
        this.turmaTest.adicionarAluno(alunoTest3);
        //ação
        Aluno buscaAluno =turmaTest.localizarAlunoId("Pedro");
        //verificação
        Assert.assertNull(buscaAluno);
    }
    @Test
    public void DeveLocalizarAlunoQuandoPassarOID2() throws Exception {
        //cenario
        this.escolaTest.adicionarTurma(turmaTest);
        this.turmaTest.adicionarAluno(alunoTest);
        this.turmaTest.adicionarAluno(alunoTest2);
        this.turmaTest.adicionarAluno(alunoTest3);
        //ação
        Aluno buscaAluno =turmaTest.localizarAlunoId(alunoTest3.getId());
        //verificação
        error.checkThat(alunoTest3.getPrimeiroNomeAluno(), CoreMatchers.is(buscaAluno.getPrimeiroNomeAluno()));
        error.checkThat(alunoTest3.getSobrenomeAluno(), CoreMatchers.is(buscaAluno.getSobrenomeAluno()));
        error.checkThat(alunoTest3.getIdade(), CoreMatchers.is(buscaAluno.getIdade()));
        error.checkThat(alunoTest3.getId(), CoreMatchers.is(buscaAluno.getId()));
    }
    @Test
    public void naoDevelocalizarAlunoQuandoIDFalso() throws Exception {
        //cenario
        this.escolaTest.adicionarTurma(turmaTest);
        this.turmaTest.adicionarAluno(alunoTest);
        this.turmaTest.adicionarAluno(alunoTest2);
        this.turmaTest.adicionarAluno(alunoTest3);
        //ação
        Aluno buscaAluno =turmaTest.localizarAlunoId(alunoTest3.getId());
        //verificação
        Assert.assertNotEquals(buscaAluno, alunoTest2);
    }

    @Test
    public void deveExcluirAlunoQuandoVerdadeiro() throws Exception {
        //cenario
        this.escolaTest.adicionarTurma(turmaTest);
        this.turmaTest.adicionarAluno(alunoTest);
        this.turmaTest.adicionarAluno(alunoTest2);
        this.turmaTest.adicionarAluno(alunoTest3);
        //ação
        this.turmaTest.removerAluno(alunoTest3);
        //verificação
        Assert.assertFalse(turmaTest.getAlunos().contains(alunoTest3));

    }
    @Test
    public void naoDeveExcluirAlunoQuandoFalso() throws Exception {
        //cenario
        this.escolaTest.adicionarTurma(turmaTest);
        this.turmaTest.adicionarAluno(alunoTest);
        this.turmaTest.adicionarAluno(alunoTest2);
        //ação
        try{
            this.turmaTest.removerAluno(alunoTest3);
        }catch (Exception e){
            //verificação
            MatcherAssert.assertThat(e.getMessage(),
                    CoreMatchers.is("Aluno não localizado") );
        }
            }
}
