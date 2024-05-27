import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class EscolaTeste {

    public Escola escolaTest;
    public Turma turmaTestA;
    @Mock
    public Controlador controladorTest;
    public Aluno alunoTest1;



    @Before
    public void inicio() {
        escolaTest = new Escola("School");
        turmaTestA = new Turma("Turma A");
        controladorTest = Mockito.mock(Controlador.class);
        alunoTest1 = new Aluno("Pedro", "Assis", 16);
        escolaTest.setControlador(controladorTest);
    }


    //atualziar aluno
    @Test
    public void deveAtualizarAlunoQuandoPassadoOsDados() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        turmaTestA.adicionarAluno(alunoTest1);
        escolaTest.adicionarAluno(alunoTest1);

        Mockito.when(controladorTest.localizarAluno()).thenReturn(alunoTest1.getId());
        Mockito.when(controladorTest.localizarAlunoTurma(alunoTest1.getId())).thenReturn(alunoTest1);
        Mockito.when(controladorTest.confirmacao()).thenReturn(true);
        Mockito.when(controladorTest.SolicitarNome()).thenReturn("João");
        Mockito.when(controladorTest.SolicitarSobrenome()).thenReturn("Santos");
        Mockito.when(controladorTest.SolicitarIdade()).thenReturn(15);
        Mockito.when(controladorTest.atualizarAluno(alunoTest1)).thenCallRealMethod();




        //ação
        escolaTest.atualizarAluno();

        //verificação

        MatcherAssert.assertThat(alunoTest1.getPrimeiroNomeAluno(), CoreMatchers.is("João"));

    }

    //atualizar turma
    //cenario

    //ação

    //verificação

    //excluir alunos

    //excluir turma

    //localizar todos os alunos

    //localizar aluno

    //localizar todas as turmas turma

    //localizar turma

    //cadastrar turma

    //adicionar turma

    //localizar aluno


    //adicionar aluno
    @Test
    public void adicionarAlunoEscola() {
        //cenario -> @Before
        //ação
        escolaTest.adicionarAluno(alunoTest1);
        //verificação
        Assert.assertTrue(escolaTest.getAlunos().contains(alunoTest1));


    }
}
