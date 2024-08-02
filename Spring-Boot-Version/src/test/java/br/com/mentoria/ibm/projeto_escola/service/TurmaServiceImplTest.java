package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Turma;
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


    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        turmaServiceSpy = Mockito.spy(turmaService);
        alunoService = Mockito.mock(AlunoServiceImpl.class);
        turmaTest = turmaService.criarTurma("Turma Teste");

    }

    //deve adicionar um Aluno
    @Test
    public void deveVerificarSeAlunoFoiAdicionadoNaTurma() throws Exception {

        Aluno alunoTeste = alunoService.criarAluno(new Aluno());

        //ação
        turmaServiceSpy.adicionarAluno(turmaTest.getId(), alunoTeste);
        //verificação
        Assert.assertTrue(turmaTest.getAlunos().contains(alunoTeste));
    }

    @Test
    public void deveRetornarFalsoQuandoAlunoNaoEstaNaTurma() throws Exception {
        //cenario

        Aluno alunoTeste = alunoService.criarAluno(new Aluno());
        Aluno alunoTest2 = new Aluno("John", "Doe", 27);
        //ação
        turmaServiceSpy.adicionarAluno(turmaTest.getId(), alunoTeste);
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
        turmaServiceSpy.adicionarAluno(turmaTest.getId(), alunoTest1);
        turmaServiceSpy.adicionarAluno(turmaTest.getId(), alunoTest2);
        turmaServiceSpy.adicionarAluno(turmaTest.getId(), alunoTest3);
        //acao
        try {
            turmaServiceSpy.adicionarAluno(turmaTest.getId(), alunoTest4);
            Assert.fail();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("Turmas cheias"));
        }


    }


    //deve verificar se a turma esta cheia
    @Test
    public void deveRetornarFalseQuandoTurmaNaoEstaCheia() {
        //verificação
        Assert.assertFalse(turmaServiceSpy.isCheia(turmaTest));
    }

    @Test
    public void deveRetornarTruQuandoTurmaContem3Alunos() throws Exception {
        //cenario
        Aluno alunoTest1 = new Aluno("John1", "Doe1",
                27);
        Aluno alunoTest2 = new Aluno("John2", "Doe2",
                27);
        Aluno alunoTest3 = new Aluno("John3", "Doe3",
                27);

        turmaServiceSpy.adicionarAluno(turmaTest.getId(), alunoTest1);
        turmaServiceSpy.adicionarAluno(turmaTest.getId(), alunoTest2);
        turmaServiceSpy.adicionarAluno(turmaTest.getId(), alunoTest3);

        //verificaçao
        Assert.assertTrue(turmaServiceSpy.isCheia(turmaTest));

    }

    //deve criar uma turma
    @Test
    public void deveCriarTurma() {
        //cenario
        doCallRealMethod().when(turmaServiceSpy).criarTurma("Turma Teste");
        //ação
        Turma turma = turmaServiceSpy.criarTurma("Turma Teste");
        //verificação
        MatcherAssert.assertThat(turma.getNomeTurma(), CoreMatchers.is("Turma Test"));
    }


    @Test
    public void deveRetornarNullQuandoNaoForPossivelCriarTurma() {
        //cenario
        doCallRealMethod().when(turmaServiceSpy).criarTurma("Turma Teste 1");
        Turma turma1 = turmaServiceSpy.criarTurma("Turma Teste 1");
        Turma turma2 = turmaServiceSpy.criarTurma("Turma Teste 1");
        //acao
        Turma turmaNull = turmaServiceSpy.criarTurma("Turma Teste 1");
        //verificacao
        Assert.assertNull(turmaNull);
    }


}
