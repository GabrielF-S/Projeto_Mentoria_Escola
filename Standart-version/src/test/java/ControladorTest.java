import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ControladorTest {
    @Mock
    private Escola escolaTest;
    @InjectMocks
    private Controlador controladorTest;


    @Before
    public void setup() {

        MockitoAnnotations.openMocks(this);
        escolaTest= Mockito.mock(Escola.class);

    }

    @Test
    public void deveVerificarSeAlunoCriado() throws Exception {
        //cenario
        controladorTest = Mockito.mock(Controlador.class);
        escolaTest.setNomeEscola("Teste");
        Mockito.when(controladorTest.criarAluno()).thenCallRealMethod();
        Mockito.when(controladorTest.solicitarNomeAluno()).thenReturn("John");
        Mockito.when(controladorTest.solicitarSobrenomeAluno()).thenReturn("Doe");
        Mockito.when(controladorTest.solicitarIdadeAluno()).thenReturn(15);
        //ação
        controladorTest.criarAluno();
        //verificação
        Mockito.verify(controladorTest).criarAluno();
    }

    @Test
    public void deveVerificarSeAlunoContemNomeCorreto() throws Exception {
        //cenario
        controladorTest = Mockito.mock(Controlador.class);
        escolaTest.setNomeEscola("Teste");
        Mockito.when(controladorTest.criarAluno()).thenCallRealMethod();
        Mockito.when(controladorTest.solicitarNomeAluno()).thenReturn("John");
        Mockito.when(controladorTest.solicitarSobrenomeAluno()).thenReturn("Doe");
        Mockito.when(controladorTest.solicitarIdadeAluno()).thenReturn(15);
        //ação
        Aluno alunoTest = controladorTest.criarAluno();
        //verificação
        Assert.assertTrue(alunoTest.getPrimeiroNomeAluno().equalsIgnoreCase("John"));
    }
    @Test
    public void deveCriarTurmaQuandoInvocado() {
        //cenario
        controladorTest = Mockito.mock(Controlador.class);
        escolaTest.setNomeEscola("Teste");
        Mockito.when(controladorTest.criarTurma()).thenCallRealMethod();
        Mockito.when(controladorTest.solicitarNomeTurma()).thenReturn("Turma Teste");
        //ação
        Turma turma = controladorTest.criarTurma();
        //Verificação
        MatcherAssert.assertThat(turma.getNomeTurma(), CoreMatchers.is("Turma Teste"));

    }
    @Test
    public void deveRetornarNovoNomeParaTurmaQuandoInvocado(){
        //cenario
        controladorTest = Mockito.mock(Controlador.class);
        escolaTest.setNomeEscola("Teste");
        Mockito.when(controladorTest.novoNomeTurma()).thenCallRealMethod();
       Mockito.when(controladorTest.solicitarNomeTurma()).thenReturn("Turma teste");

       //ação
       String novoNomeTurma= controladorTest.novoNomeTurma();

       //verificação
        MatcherAssert.assertThat(novoNomeTurma, CoreMatchers.is("Turma teste"));

    }
    @Test
    public void deveRetornarONomeDoAlunoQuandoFeitoABusca(){
        controladorTest = Mockito.mock(Controlador.class);
        escolaTest.setNomeEscola("Teste");
        Mockito.when(controladorTest.localizarAluno()).thenCallRealMethod();
        Mockito.when(controladorTest.solicitarNomeAlunoOuID()).thenReturn("Jose");

        //ação
        String nomeAluno = controladorTest.localizarAluno();
        //verificação
        MatcherAssert.assertThat(nomeAluno, CoreMatchers.is("Jose"));

    }

    @Test
    public void deveVerificarRetornoDaConfirmacaoQuandoTrue(){
        //cenario
        controladorTest = Mockito.mock(Controlador.class);
        Mockito.when(controladorTest.solicitarConfirmacao()).thenReturn("yes");
        Mockito.when(controladorTest.confirmacao()).thenCallRealMethod();
        //ação
       boolean confirmacao = controladorTest.confirmacao();
        //verificação
        Assert.assertTrue(confirmacao);
    }
    @Test
    public void deveVerificarRetornoDaConfirmacaoQuandoFalse(){
        //cenario
        controladorTest = Mockito.mock(Controlador.class);
        Mockito.when(controladorTest.solicitarConfirmacao()).thenReturn("n");
        Mockito.when(controladorTest.confirmacao()).thenCallRealMethod();
        //ação
        boolean confirmacao = controladorTest.confirmacao();
        //verificação
        Assert.assertFalse(confirmacao);
    }

    //TESTAR MENUS

    @Test
    public void deveVerificarSeMenuEhChamado() throws Exception {
        //cenario
        Controlador controladorTestSpy = Mockito.spy(controladorTest);
        Mockito.doReturn("Teste").when(controladorTestSpy).solicitarNomeEscola();
        Mockito.doReturn(0).when(controladorTestSpy).selecionarOpcao();
        //ação
        controladorTestSpy.init();
        //verificação
        Mockito.verify(controladorTestSpy, Mockito.times(1)).menu();
    }

    @Test
    public void deveVerificarSeCadastroMenuEhChamado() throws Exception {
        //cenario
        Controlador controladorTestSpy = Mockito.spy(controladorTest);
        Mockito.doReturn(1).when(controladorTestSpy).selecionarOpcao();
        controladorTestSpy.escola = escolaTest;



        //ação
        controladorTestSpy.menu();
        //verificação
        Mockito.verify(controladorTestSpy, Mockito.times(1)).cadastrarMenu();
    }



}
