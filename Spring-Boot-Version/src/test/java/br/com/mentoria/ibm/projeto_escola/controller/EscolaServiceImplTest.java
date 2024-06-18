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

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EscolaServiceImplTest {
    @InjectMocks
    private EscolaServiceImpl escolaService;
    @Mock
    Inputs scanner;
    @Mock
    TurmaServiceImpl turmaService;
    @Mock
    AlunoServiceImpl alunoService;
    @Mock
    Escola escola;
    public EscolaServiceImpl escolaServiceSpy;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        escolaServiceSpy = spy(escolaService);
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
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //turma
        when(escolaServiceSpy.criarTurma()).thenReturn(new Turma("Teste"));
        doCallRealMethod().when(escolaServiceSpy).criarTurma();
        Turma turma = escolaServiceSpy.criarTurma();
        escolaServiceSpy.cadastrarTurma();
        //escola
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
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        //escola
        when(escolaServiceSpy.criarAluno()).thenReturn(new Aluno("Tom",
                "Hanks", 23, "12345"));
        doCallRealMethod().when(escolaServiceSpy).criarAluno();
        Aluno aluno = escolaServiceSpy.criarAluno();
        //ação
        try {
            escolaServiceSpy.cadastrarAluno();
            Assert.fail();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("Não é possivel cadastrar aluno sem ter turmas"));

        }

    }
    //TODO deve editar Aluno

    //TODO deve excluir aluno

    //TODO deve localizar Todos os Alunos

    //TODO deve localizar um Aluno

    //TODO deve criar uma turma
    @Test
    public void deveCriarUmaTurma() {
        //cenario
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
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
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
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
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        doCallRealMethod().when(escolaServiceSpy).editarTurma();
        //turma
        Turma turma = new Turma("Turma Teste");
        when(escolaServiceSpy.criarTurma()).thenReturn(turma);
        escolaServiceSpy.cadastrarTurma();
        when(turmaService.solicitarNomeTurma()).thenReturn("Turma Teste");
        when(escolaServiceSpy.localizarUmaTurma("Turma Teste")).thenReturn(turma);
        when(turmaService.solicitarNovoNomeTurma()).thenReturn("Novo Nome");
        //ação
        escolaServiceSpy.editarTurma();
        //verificação
        MatcherAssert.assertThat(turma.getNomeTurma(), CoreMatchers.is("Novo Nome"));
    }

    //deve excluir turma
    @Test
    public void deveExcluirTurmaDaEscola() throws Exception {
        //cenario
        //escola
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();
        doCallRealMethod().when(escolaServiceSpy).excluirTurma();
        //turma
        Turma turma = new Turma("Turma Teste");
        when(escolaServiceSpy.criarTurma()).thenReturn(turma);
        escolaServiceSpy.cadastrarTurma();
        when(turmaService.solicitarNomeTurma()).thenReturn("Turma Teste");
        when(escolaServiceSpy.solicitarConfirmacao()).thenReturn("y");
        //ação
        escolaServiceSpy.excluirTurma();
        //verificação
        Assert.assertTrue(escola.getTurmas().isEmpty());
    }
    //deve localizar todas as turmas
    @Test
    public void deveRetornarTodasAsTurmas() throws Exception {
        //cenario
        //escola
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
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
    @Test
    public void deveLancarExceptionQuandoTurmaEhNula()  {
        //cenario
        //escola
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
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
    public void deveRetornarUmaTurmaQuandoPassadoNome(){
        //cenario
        //escola
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
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
    //deve localizar uma turma
    @Test
    public void deveRetornarUmaTurma(){
        //cenario
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        escola = escolaServiceSpy.criarEscola();

        Turma turma = new Turma("Turma Teste");
        when(escolaServiceSpy.criarTurma()).thenReturn(turma);


        //ação
        escolaServiceSpy.localizarTurma();
        //verificação
        verify(escolaServiceSpy,times(1)).localizarTurma();
    }
    //deve localizar uma turma por Aluno
    @Test
    public void deveLocalizarTurmaQuandoSePassaAluno() throws Exception {
        //cenario
        //escola
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
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

    //deve obter o nome da escola
    @Test
    public void deveVeriFicarNomeDaEscola(){
        //cenario
        //escola
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        //ação
        escola = escolaServiceSpy.criarEscola();
        //verificação
        MatcherAssert.assertThat(escola.getNomeEscola(), CoreMatchers.is("IBM"));

    }

    //deve criar uma escola
    @Test
    public void deveCriarEscola() {
        //cenario
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
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
        when(escolaServiceSpy.solicitarNomeEscola()).thenReturn("IBM");
        doCallRealMethod().when(escolaServiceSpy).criarEscola();
        //ação
        escola = escolaServiceSpy.criarEscola();
        //verificação
        verify(escolaServiceSpy, atLeastOnce()).solicitarNomeEscola();
    }

}
