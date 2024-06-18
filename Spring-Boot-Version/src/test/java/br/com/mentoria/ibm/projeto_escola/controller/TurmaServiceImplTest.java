package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Turma;
import br.com.mentoria.ibm.projeto_escola.view.Inputs;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


public class TurmaServiceImplTest {

    @InjectMocks
    private TurmaServiceImpl turmaService;

    public TurmaServiceImpl turmaServiceSpy;
    String setNomeTurma;
    @Mock
    AlunoServiceImpl alunoService;
    Turma turmaTest;
    @Mock
    Inputs scanner;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        turmaServiceSpy = Mockito.spy(turmaService);
        alunoService = Mockito.mock(AlunoServiceImpl.class);
        setNomeTurma = "Turma Test";
        turmaTest = turmaService.criarTurma();
        turmaTest.setNomeTurma(setNomeTurma);
        scanner = Mockito.mock(Inputs.class);
    }

    //deve adicionar um Aluno
    @Test
    public void deveVerificarSeAlunoFoiAdicionadoNaTurma() throws Exception {
        //cenario
        when(alunoService.solicitarNomeAluno()).thenReturn("Phil");
        when(alunoService.solicitarSobrenomeAluno()).thenReturn("doe");
        when(alunoService.solicitarIdadeAluno()).thenReturn(27);
        when(alunoService.criarAluno()).thenCallRealMethod();
        Aluno alunoTeste = alunoService.criarAluno();

        //ação
        turmaServiceSpy.adicionarAluno(alunoTeste);
        //verificação
        Assert.assertTrue(turmaTest.getAlunos().contains(alunoTeste));
    }

    @Test
    public void deveRetornarFalsoQuandoAlunoNaoEstaNaTurma() throws Exception {
        //cenario
        when(alunoService.solicitarNomeAluno()).thenReturn("Phil");
        when(alunoService.solicitarSobrenomeAluno()).thenReturn("doe");
        when(alunoService.solicitarIdadeAluno()).thenReturn(27);
        when(alunoService.criarAluno()).thenCallRealMethod();
        Aluno alunoTeste = alunoService.criarAluno();
        Aluno alunoTest2 = new Aluno("John", "Doe", 27);
        //ação
        turmaServiceSpy.adicionarAluno(alunoTeste);
        //verificação
        Assert.assertFalse(turmaTest.getAlunos().contains(alunoTest2));
    }

    @Test
    public void deveLancarExeptionQuandoTurmaCheia() throws Exception {
        //cenario
        Aluno alunoTest1 = new Aluno("John1", "Doe1", 27);
        Aluno alunoTest2 = new Aluno("John2", "Doe2", 27);
        Aluno alunoTest3 = new Aluno("John3", "Doe3", 27);
        Aluno alunoTest4 = new Aluno("John", "Doe", 27);
        turmaServiceSpy.adicionarAluno(alunoTest1);
        turmaServiceSpy.adicionarAluno(alunoTest2);
        turmaServiceSpy.adicionarAluno(alunoTest3);
        //acao
        try {
            turmaServiceSpy.adicionarAluno(alunoTest4);
            Assert.fail();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("Turmas cheias"));
        }


    }

    // deve localizar um Aluno por ID
    @Test
    public void deveRetornarAlunoQuandoPassadoONome() throws Exception {
        //cenario
        when(alunoService.solicitarNomeAluno()).thenReturn("Phil");
        when(alunoService.solicitarSobrenomeAluno()).thenReturn("Doe");
        when(alunoService.solicitarIdadeAluno()).thenReturn(27);
        when(alunoService.IDgeneretor("Phil", "Doe",
                27)).thenCallRealMethod();
        when(alunoService.criarAluno()).thenCallRealMethod();
        Aluno alunoTeste = alunoService.criarAluno();
        turmaServiceSpy.adicionarAluno(alunoTeste);
        //ação
        Aluno alunoTest2 = turmaServiceSpy.localizarAlunoID("Phil");
        //verificação
        Assert.assertSame(alunoTeste, alunoTest2);
    }

    @Test
    public void deveRetornarAlunoQuandoPassadoONomeQuandoTemVariosAlunos() throws Exception {
        //cenario
        Aluno alunoTest1 = new Aluno("John1", "Doe1", 27, "teste1");
        Aluno alunoTest2 = new Aluno("John2", "Doe2", 27, "teste2");
        Aluno alunoTest3 = new Aluno("John3", "Doe3", 27, "teste3");

        turmaServiceSpy.adicionarAluno(alunoTest1);
        turmaServiceSpy.adicionarAluno(alunoTest2);
        turmaServiceSpy.adicionarAluno(alunoTest3);
        //ação
        Aluno alunoTest = turmaServiceSpy.localizarAlunoID("John3");
        //verificação
        Assert.assertSame(alunoTest3, alunoTest);
    }

    @Test
    public void deveRetornarAlunoQuandoPassadoOIDQuandoTemVariosAlunos() throws Exception {
        //cenario
        Aluno alunoTest1 = new Aluno("John1", "Doe1", 27, "teste1");
        Aluno alunoTest2 = new Aluno("John2", "Doe2", 27, "teste2");
        Aluno alunoTest3 = new Aluno("John3", "Doe3", 27, "teste3");
        String idAluno = alunoTest3.getId();
        turmaServiceSpy.adicionarAluno(alunoTest1);
        turmaServiceSpy.adicionarAluno(alunoTest2);
        turmaServiceSpy.adicionarAluno(alunoTest3);
        //ação
        Aluno alunoTest = turmaServiceSpy.localizarAlunoID(idAluno);
        //verificação
        Assert.assertSame(alunoTest3, alunoTest);
    }
    @Test
    public void deveRetornarFalsoQuandoAlunoPesqusadoForDiferente() throws Exception {
        //cenario
        Aluno alunoTest1 = new Aluno("John1", "Doe1", 27, "teste1");
        Aluno alunoTest2 = new Aluno("John2", "Doe2", 27, "teste2");
        Aluno alunoTest3 = new Aluno("John3", "Doe3", 27, "teste3");

        turmaServiceSpy.adicionarAluno(alunoTest1);
        turmaServiceSpy.adicionarAluno(alunoTest2);
        turmaServiceSpy.adicionarAluno(alunoTest3);
        //ação
        Aluno alunoTest = turmaServiceSpy.localizarAlunoID("John3");
        //verificação
        Assert.assertNotSame(alunoTest2, alunoTest);
    }

    @Test
    public void deveLancarExceptionQuandoAlunoAluno() throws Exception {
        //cenario
        Aluno alunoTest1 = new Aluno("John1", "Doe1",
                27, "teste1");
        Aluno alunoTest2 = new Aluno("John2", "Doe2",
                27, "teste2");
        Aluno alunoTest3 = new Aluno("John3", "Doe3",
                27, "teste3");

        turmaServiceSpy.adicionarAluno(alunoTest1);
        turmaServiceSpy.adicionarAluno(alunoTest2);
        turmaServiceSpy.adicionarAluno(alunoTest3);
        try {
            //ação
            turmaServiceSpy.localizarAlunoID("John4");
            Assert.fail();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is(
                    "Aluno não Localizado!"));
        }

    }

    // deve remover um Aluno
    @Test
    public void deveVerificarSeAlunoFoiExcluido() throws Exception {
        //cenario
        when(alunoService.criarAluno()).thenCallRealMethod();
        when(alunoService.solicitarNomeAluno()).thenReturn("Nome");
        when(alunoService.solicitarSobrenomeAluno()).thenReturn("Sobrenome");
        when(alunoService.solicitarIdadeAluno()).thenReturn(23);
        Aluno alunoTest = alunoService.criarAluno();
        turmaServiceSpy.adicionarAluno(alunoTest);
        //ação
        turmaServiceSpy.removerAluno(alunoTest);
        //verificação
        Assert.assertFalse(turmaServiceSpy.turmas.contains(alunoTest));

    }


    //deve verificar se a turma esta cheia
    @Test
    public void deveRetornarFalseQuandoTurmaNaoEstaCheia(){
        //verificação
        Assert.assertFalse(turmaServiceSpy.isCheia(turmaTest));
    }
    @Test
    public void deveRetornarTruQuandoTurmaContem3Alunos() throws Exception {
        //cenario
        Aluno alunoTest1 = new Aluno("John1", "Doe1",
                27, "teste1");
        Aluno alunoTest2 = new Aluno("John2", "Doe2",
                27, "teste2");
        Aluno alunoTest3 = new Aluno("John3", "Doe3",
                27, "teste3");

        turmaServiceSpy.adicionarAluno(alunoTest1);
        turmaServiceSpy.adicionarAluno(alunoTest2);
        turmaServiceSpy.adicionarAluno(alunoTest3);

        //verificaçao
        Assert.assertTrue(turmaServiceSpy.isCheia(turmaTest));

    }

    //deve criar uma turma
    @Test
    public void deveCriarTurma() {
        //cenario
        doCallRealMethod().when(turmaServiceSpy).criarTurma();
        when(turmaServiceSpy.solicitarNomeTurma()).thenReturn(setNomeTurma);
        //ação
        Turma turma = turmaServiceSpy.criarTurma();
        //verificação
        MatcherAssert.assertThat(turma.getNomeTurma(), CoreMatchers.is("Turma Test"));
    }

    @Test
    public void deveVerificarSeSolicitadoNomeDaTurma() {
        //cenario
        doCallRealMethod().when(turmaServiceSpy).criarTurma();
        when(turmaServiceSpy.solicitarNomeTurma()).thenReturn(setNomeTurma);
        //ação
        turmaServiceSpy.criarTurma();
        //verificação
        verify(turmaServiceSpy, atLeastOnce()).solicitarNomeTurma();

    }

    @Test
    public void deveRetornarNullQuandoNaoForPossivelCriarTurma() {
        //cenario
        doCallRealMethod().when(turmaServiceSpy).criarTurma();
        when(turmaServiceSpy.solicitarNomeTurma()).thenReturn(setNomeTurma);
        Turma turma1 = turmaServiceSpy.criarTurma();
        Turma turma2 = turmaServiceSpy.criarTurma();
        //acao
        Turma turmaNull = turmaServiceSpy.criarTurma();
        //verificacao
        Assert.assertNull(turmaNull);
    }
    @Test
    public void deveVerificarSeOutrasTUrmasNaoSaoNullQuandoForPossivelCriarTurma() {
        //cenario
        doCallRealMethod().when(turmaServiceSpy).criarTurma();
        when(turmaServiceSpy.solicitarNomeTurma()).thenReturn(setNomeTurma);
        Turma turma1 = turmaServiceSpy.criarTurma();
        Turma turma2 = turmaServiceSpy.criarTurma();
        //acao
        Turma turma3 = turmaServiceSpy.criarTurma();
        //verificacao
        Assert.assertNull(turma3);
    }


}
