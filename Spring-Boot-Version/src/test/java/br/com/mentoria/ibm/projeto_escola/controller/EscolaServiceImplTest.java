package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Escola;
import br.com.mentoria.ibm.projeto_escola.model.Turma;
import br.com.mentoria.ibm.projeto_escola.view.Inputs;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EscolaServiceImplTest {
    @InjectMocks
    private EscolaServiceImpl escolaService;
    @Mock
    TurmaServiceImpl turmaService;
    @Mock
    AlunoServiceImpl alunoService;
    @Mock
    Escola escola;
    public EscolaServiceImpl escolaServiceSpy;
    @Mock
    Inputs scanner;
    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        escolaServiceSpy = spy(escolaService);
        scanner = Mockito.mock(Inputs.class);
    }
    //deve criar aluno
    @Test
    public void deveRetornarUmAlunoQuandoForCriado() {
        //cenario
        when(alunoService.criarAluno()).thenCallRealMethod();
        when(alunoService.solicitarNomeAluno()).thenReturn("Tom");
        when(alunoService.solicitarSobrenomeAluno()).thenReturn("Hanks");
        when(alunoService.solicitarIdadeAluno()).thenReturn(23);
        //açãp
        Aluno aluno = escolaServiceSpy.criarAluno();
        //verificação
        Assert.assertNotNull(aluno);

    }
    @Test
    public void deveRetornarONomeDoAlunoQuandoForCriado() {
        //cenario
        when(alunoService.criarAluno()).thenCallRealMethod();
        when(alunoService.solicitarNomeAluno()).thenReturn("Tom");
        when(alunoService.solicitarSobrenomeAluno()).thenReturn("Hanks");
        when(alunoService.solicitarIdadeAluno()).thenReturn(23);
        //açãp
        Aluno aluno = escolaServiceSpy.criarAluno();
        //verificação
        MatcherAssert.assertThat(aluno.getPrimeiroNomeAluno(), CoreMatchers.is("Tom"));

    }

    //deve cadastrar Aluno
    @Test
    public void deveCadastrarUmAluno() throws Exception {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        when(escolaServiceSpy.criarTurma()).thenReturn(new Turma("Teste"));
        doCallRealMethod().when(escolaServiceSpy).criarTurma();
        escolaServiceSpy.cadastrarTurma();
        //Aluno
        when(escolaServiceSpy.criarAluno()).thenReturn(new Aluno("Tom",
                "Hanks", 23, "12345"));
        doCallRealMethod().when(escolaServiceSpy).criarAluno();
        Aluno aluno = escolaServiceSpy.criarAluno();
        //ação
        escolaServiceSpy.cadastrarAluno();
        //verificação
        Assert.assertTrue(escolaServiceSpy.localizarTodosAlunos().contains(aluno));

    }
    @Test
    public void deveLancarEceptionQuandoNaoTemTurma() {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //escola
        when(escolaServiceSpy.criarAluno()).thenReturn(new Aluno("Tom",
                "Hanks", 23, "12345"));
        //ação
        try {
            escolaServiceSpy.cadastrarAluno();
            Assert.fail();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("Não é possivel cadastrar aluno sem ter turmas"));
        }
    }

    // deve editar Aluno
    @Test
    public void deveVerificarSeNomeDoAlunoFoiEditado() throws Exception {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        when(escolaServiceSpy.criarTurma()).thenReturn(new Turma("Teste"));
        doCallRealMethod().when(escolaServiceSpy).criarTurma();
        escolaServiceSpy.cadastrarTurma();
        //escola
        when(escolaServiceSpy.criarAluno()).thenReturn(new Aluno("Tom",
                "Hanks", 23, "12345"));
        doCallRealMethod().when(escolaServiceSpy).criarAluno();
        Aluno aluno = escolaServiceSpy.criarAluno();
        escolaServiceSpy.cadastrarAluno();
        when(alunoService.solicitarNomeAluno()).thenReturn("Tom");
        when(turmaService.localizarAlunoID("Tom")).thenReturn(aluno);
        doCallRealMethod().when(escolaServiceSpy).localizarAluno();
        when(alunoService.solicitarNovoNomeAluno()).thenReturn("John");
        when(alunoService.solicitarNovoSobrenomeAluno()).thenReturn("Doe");
        when(alunoService.solicitarNovaIdadeAluno()).thenReturn(27);
        when(alunoService.atualizarAluno(aluno)).thenCallRealMethod();
        //ação
        escolaServiceSpy.editarAluno();
        //verificação
        MatcherAssert.assertThat(aluno.getPrimeiroNomeAluno(), CoreMatchers.is("John"));
    }

    @Test
    public void deveVerificarSeSobrenomedoAlunoFoiEditado() throws Exception {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        when(escolaServiceSpy.criarTurma()).thenReturn(new Turma("Teste"));
        doCallRealMethod().when(escolaServiceSpy).criarTurma();
        escolaServiceSpy.cadastrarTurma();
        //escola
        when(escolaServiceSpy.criarAluno()).thenReturn(new Aluno("Tom",
                "Hanks", 23, "12345"));
        doCallRealMethod().when(escolaServiceSpy).criarAluno();
        Aluno aluno = escolaServiceSpy.criarAluno();
        escolaServiceSpy.cadastrarAluno();
        when(alunoService.solicitarNomeAluno()).thenReturn("Tom");
        when(turmaService.localizarAlunoID("Tom")).thenReturn(aluno);
        doCallRealMethod().when(escolaServiceSpy).localizarAluno();
        when(alunoService.solicitarNovoNomeAluno()).thenReturn("John");
        when(alunoService.solicitarNovoSobrenomeAluno()).thenReturn("Doe");
        when(alunoService.solicitarNovaIdadeAluno()).thenReturn(27);
        when(alunoService.atualizarAluno(aluno)).thenCallRealMethod();
        //ação
        escolaServiceSpy.editarAluno();
        //verificação
        MatcherAssert.assertThat(aluno.getSobrenomeAluno(), CoreMatchers.is("Doe"));
    }

    @Test
    public void deveVerificarSeIdadedoAlunoFoiEditado() throws Exception {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        when(escolaServiceSpy.criarTurma()).thenReturn(new Turma("Teste"));
        doCallRealMethod().when(escolaServiceSpy).criarTurma();
        escolaServiceSpy.cadastrarTurma();
        //escola
        when(escolaServiceSpy.criarAluno()).thenReturn(new Aluno("Tom",
                "Hanks", 23, "12345"));
        doCallRealMethod().when(escolaServiceSpy).criarAluno();
        Aluno aluno = escolaServiceSpy.criarAluno();
        escolaServiceSpy.cadastrarAluno();
        when(alunoService.solicitarNomeAluno()).thenReturn("Tom");
        when(turmaService.localizarAlunoID("Tom")).thenReturn(aluno);
        doCallRealMethod().when(escolaServiceSpy).localizarAluno();
        when(alunoService.solicitarNovoNomeAluno()).thenReturn("John");
        when(alunoService.solicitarNovoSobrenomeAluno()).thenReturn("Doe");
        when(alunoService.solicitarNovaIdadeAluno()).thenReturn(27);
        when(alunoService.atualizarAluno(aluno)).thenCallRealMethod();
        //ação
        escolaServiceSpy.editarAluno();
        //verificação
        MatcherAssert.assertThat(aluno.getIdade(), CoreMatchers.is(27));
    }
    @Test
    public void deveExcluirAlunoDaEscola() throws Exception {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        doCallRealMethod().when(escolaServiceSpy).criarTurma();
        escolaServiceSpy.cadastrarTurma();
        Aluno aluno1 = new Aluno("John",
                "Hanks", 23, "12346");
        Aluno aluno2 = new Aluno("Tom",
                "Hanks", 23, "12345");
        Aluno aluno3 = new Aluno("Bom",
                "Hanks", 23, "12347");
        Aluno aluno4 = new Aluno("Kon",
                "Hanks", 23, "12349");
        List<Aluno> alunosList = new ArrayList<>();
        alunosList.add(aluno1);
        alunosList.add(aluno2);
        alunosList.add(aluno3);
        alunosList.add(aluno4);
        escola.setAlunos(alunosList);
        doReturn(aluno2).when(escolaServiceSpy).localizarAluno();
        doReturn("yes").when(escolaServiceSpy).solicitarConfirmacao();
        //ação
        escolaServiceSpy.excluirAluno();
        //verificação
        Assert.assertFalse(escolaServiceSpy.localizarTodosAlunos().contains(aluno2));
    }
    @Test
    public void deveLancarExceptionQuandoExcluirAlunoDaEscolaComListaVazia() {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        doCallRealMethod().when(escolaServiceSpy).criarTurma();
        escolaServiceSpy.cadastrarTurma();
        //ação
        try {
            escolaServiceSpy.excluirAluno();
            Assert.fail();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("Nenhum aluno cadastrado"));
        }
    }

    @Test
    public void deveRetornarListaComTodosAlunos() throws Exception {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        doCallRealMethod().when(escolaServiceSpy).criarTurma();
        escolaServiceSpy.cadastrarTurma();
        Aluno aluno1 = new Aluno("John",
                "Hanks", 23, "12346");
        Aluno aluno2 = new Aluno("Tom",
                "Hanks", 23, "12345");
        Aluno aluno3 = new Aluno("Bom",
                "Hanks", 23, "12347");
        Aluno aluno4 = new Aluno("Kon",
                "Hanks", 23, "12349");
        List<Aluno> alunosList = new ArrayList<>();
        alunosList.add(aluno1);
        alunosList.add(aluno2);
        alunosList.add(aluno3);
        alunosList.add(aluno4);
        escola.setAlunos(alunosList);
        //açao
       List<Aluno> lista= escolaServiceSpy.localizarTodosAlunos();
        //verificação
        Assert.assertEquals(4, lista.size());
    }
    @Test
    public void deveRetornarExceptionQuandoNenhumAlunoCadastrado()  {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        doCallRealMethod().when(escolaServiceSpy).criarTurma();
        escolaServiceSpy.cadastrarTurma();
        //açao
        try {
          escolaServiceSpy.localizarTodosAlunos();
            Assert.fail();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(),CoreMatchers.is("Nenhum aluno cadastrado"));
        }

    }



    //deve criar uma turma
    @Test
    public void deveCriarUmaTurma() {
        //cenario
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        when(escolaServiceSpy.criarTurma()).thenReturn(new Turma("Teste"));
        doCallRealMethod().when(escolaServiceSpy).criarTurma();
        escola = escolaServiceSpy.criarEscola();
        //ação
        Turma turma = escolaServiceSpy.criarTurma();
        //verificação
        Assert.assertNotNull(turma);
    }

    //deve cadastrar turma
    @Test
    public void deveCadastrarUmaTurma() {
        //cenario
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        Turma turma = new Turma("Turma Teste");
        when(escolaServiceSpy.criarTurma()).thenReturn(turma);
        //ação
        escolaServiceSpy.cadastrarTurma();
        //verificação
        Assert.assertTrue(escola.getTurmas().contains(turma));
    }
    //deve editar turma
    @Test
    public void deveEditarUmaTurma() {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        doCallRealMethod().when(escolaServiceSpy).editarTurma();
        //turma
        Turma turma = new Turma("Turma Teste");
        when(escolaServiceSpy.criarTurma()).thenReturn(turma);
        escolaServiceSpy.cadastrarTurma();
        when(turmaService.solicitarNomeTurma()).thenReturn("Turma Teste");
        when(escolaServiceSpy.localizarUmaTurma("Turma Teste")).thenReturn(turma);
        doReturn("Novo Nome").when(turmaService).solicitarNovoNomeTurma();
        doCallRealMethod().when(turmaService).atualizarNomeTurma(turma);
        //ação
        escolaServiceSpy.editarTurma();
        //verificação
        MatcherAssert.assertThat(turma.getNomeTurma(), CoreMatchers.is("Novo Nome"));
    }
    //deve excluir turma
    @Test
    public void deveExcluirTurmaDaEscola() {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        doCallRealMethod().when(escolaServiceSpy).excluirTurma();
        //turma
        Turma turma = new Turma("Turma Teste");
        when(escolaServiceSpy.criarTurma()).thenReturn(turma);
        escolaServiceSpy.cadastrarTurma();
        when(turmaService.solicitarNomeTurma()).thenReturn("Turma Teste");
        doReturn("y").when(escolaServiceSpy).solicitarConfirmacao();
        //ação
        escolaServiceSpy.excluirTurma();
        //verificação
        Assert.assertTrue(escola.getTurmas().isEmpty());
    }
    @Test
    public void deveVerificarAConfirmacao() {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        doCallRealMethod().when(escolaServiceSpy).excluirTurma();
        //turma
        Turma turma = new Turma("Turma Teste");
        when(escolaServiceSpy.criarTurma()).thenReturn(turma);
        escolaServiceSpy.cadastrarTurma();
        when(turmaService.solicitarNomeTurma()).thenReturn("Turma Teste");

        doReturn("sim").when(escolaServiceSpy).solicitarConfirmacao();

        //ação
        escolaServiceSpy.excluirTurma();
        //verificação
        MatcherAssert.assertThat(escolaServiceSpy.solicitarConfirmacao(), CoreMatchers.is("sim"));
    }
    //deve localizar todas as turmas
    @Test
    public void deveRetornarTodasAsTurmas() throws Exception {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        Turma turma1 = new Turma("Turma A");
        Turma turma2 = new Turma("Turma B");
        Turma turma3 = new Turma("Turma C");
        List<Turma> listaDeTurmas = new ArrayList<>();
        listaDeTurmas.add(turma1);
        listaDeTurmas.add(turma2);
        listaDeTurmas.add(turma3);
        escolaServiceSpy.cadastrarTurma();
        escola.setTurmas(listaDeTurmas);
        //ação
        escolaServiceSpy.localizarTodasTurmas();
        //verificação
        Assert.assertEquals(3, escolaServiceSpy.localizarTodasTurmas().size());
    }
    //TODO
    @Test
    public void deveRetornarTodasAsTurmasQuandoSeTemAlunoCadastrado() throws Exception {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        Turma turma1 = new Turma("Turma A");
        Turma turma2 = new Turma("Turma B");
        Turma turma3 = new Turma("Turma C");
        List<Turma> listaDeTurmas = new ArrayList<>();
        listaDeTurmas.add(turma1);
        listaDeTurmas.add(turma2);
        listaDeTurmas.add(turma3);
        escolaServiceSpy.cadastrarTurma();
        escola.setTurmas(listaDeTurmas);
        Aluno aluno1 = new Aluno("Tom","Hanks", 23, "12346");
        turma2.setAlunos(aluno1);
        //ação
        escolaServiceSpy.localizarTodasTurmas();
        //verificação
        Assert.assertEquals(3, escolaServiceSpy.localizarTodasTurmas().size());
    }
    @Test
    public void deveLancarExceptionQuandoTurmaEhNula() {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //ação
        try {
            escolaServiceSpy.localizarTodasTurmas();
            Assert.fail();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("Não há turmas cadastradas"));
        }
    }
    //deve localizar uma turma pelo nome
    @Test
    public void deveRetornarUmaTurmaQuandoPassadoNome() {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        Turma turma1 = new Turma("Turma A");
        Turma turma2 = new Turma("Turma B");
        Turma turma3 = new Turma("Turma C");
        List<Turma> listaDeTurmas = new ArrayList<>();
        listaDeTurmas.add(turma1);
        listaDeTurmas.add(turma2);
        listaDeTurmas.add(turma3);
        escolaServiceSpy.cadastrarTurma();
        escola.setTurmas(listaDeTurmas);


        //ação
        Turma turma = escolaServiceSpy.localizarUmaTurma("Turma B");
        //verificação
        Assert.assertEquals(turma, turma2);
    }
    // deve localizar uma turma
    @Test
    public void deveVerificarSeFuncaoDeLocalizarTurmaFoiInvocada() {
        //cenario
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        Turma turma = new Turma("Turma Teste");
        when(escolaServiceSpy.criarTurma()).thenReturn(turma);
        //ação
        escolaServiceSpy.localizarTurma();
        //verificação
        verify(escolaServiceSpy, times(1)).localizarTurma();
    }

    @Test
    public void deveRetornarUmaTurmaQuandoTemAluno() throws Exception {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        Turma turma1 = new Turma("Turma A");
        Aluno aluno = new Aluno("John","Hanks", 23, "12346");
        List<Turma> listaDeTurmas = new ArrayList<>();
        listaDeTurmas.add(turma1);

        escolaServiceSpy.cadastrarTurma();
        escola.setTurmas(listaDeTurmas);

        turma1.setAlunos(aluno);


        //ação
        Turma turma = escolaServiceSpy.localizarUmaTurma("Turma A");
        //verificação
        verify(escolaServiceSpy,times(1)).localizarUmaTurma("Turma A");
    }
    //deve localizar uma turma por Aluno
    @Test
    public void deveLocalizarTurmaQuandoSePassaAluno() throws Exception {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        when(escolaServiceSpy.criarTurma()).thenReturn(new Turma("Teste"));
        doCallRealMethod().when(escolaServiceSpy).criarTurma();
        Turma turma = escolaServiceSpy.criarTurma();
        escolaServiceSpy.cadastrarTurma();
        //Aluno
        when(escolaServiceSpy.criarAluno()).thenReturn(new Aluno("Tom",
                "Hanks", 23, "12345"));
        doCallRealMethod().when(escolaServiceSpy).criarAluno();
        Aluno aluno = escolaServiceSpy.criarAluno();
        escolaServiceSpy.cadastrarAluno();
        turma.setAlunos(aluno);
        //ação
        Turma turmaTeste = escolaServiceSpy.localizarTurmaPorAluno(aluno);
        //verificação
        Assert.assertSame(turma, turmaTeste);
    }
    @Test
    public void deveRetornarQuandoSePassaAluno() throws Exception {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //Aluno
        when(escolaServiceSpy.criarAluno()).thenReturn(new Aluno("Tom",
                "Hanks", 23, "12345"));
        doCallRealMethod().when(escolaServiceSpy).criarAluno();
        Aluno aluno = escolaServiceSpy.criarAluno();
        //ação
        Turma turmaTeste = escolaServiceSpy.localizarTurmaPorAluno(aluno);
        //verificação
        Assert.assertNull(turmaTeste);
    }
    //deve obter o nome da escola
    @Test
    public void deveVeriFicarNomeDaEscola() {
        //cenario
        //escola
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        //ação
        escola = escolaServiceSpy.criarEscola();
        //verificação
        MatcherAssert.assertThat(escolaServiceSpy.obterNomeEscola(), CoreMatchers.is("IBM"));
    }
    //deve criar uma escola
    @Test
    public void deveCriarEscola() {
        //cenario
        doReturn("IBM").when(escolaServiceSpy).solicitarNomeEscola();
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        //ação
        escola = escolaServiceSpy.criarEscola();
        //verificação
        Assert.assertNotNull(escola);
    }
    // deve solicitar o nome da escola
    @Test
    public void deveSolicitarNomeDaEscola() {
        //cenario

        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        //ação
        escola = escolaServiceSpy.criarEscola();
        //verificação
        verify(escolaServiceSpy, times(1)).solicitarNomeEscola();
    }

    @Test
    public void deveRetornarNomeDaEscola() {
        //cenario

        doCallRealMethod().when(escolaServiceSpy).solicitarConfirmacao();


        //ação
        escolaServiceSpy.solicitarConfirmacao();
        //verificação
        verify(escolaServiceSpy,times(1)).solicitarConfirmacao();
    }


}
