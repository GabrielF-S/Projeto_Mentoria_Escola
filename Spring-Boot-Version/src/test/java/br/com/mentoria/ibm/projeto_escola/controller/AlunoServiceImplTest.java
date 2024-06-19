package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.view.Inputs;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AlunoServiceImplTest {
    @InjectMocks
    private AlunoServiceImpl alunoService;
    @Mock
    private Inputs scanner;

    AlunoServiceImpl alunoServiceSpy;


    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        alunoServiceSpy = spy(alunoService);
        scanner = Mockito.mock(Inputs.class);

    }

    //verificar a criação do Aluno
    @Test
    public void deveVerificarSeAInstanciaCriadaEhDaClasseAluno() {
        //cenario
        doReturn("John").when(alunoServiceSpy).solicitarNomeAluno();
        doReturn("Doe").when(alunoServiceSpy).solicitarSobrenomeAluno();
        doReturn(27).when(alunoServiceSpy).solicitarIdadeAluno();
        doCallRealMethod().when(alunoServiceSpy).criarAluno();
        //ação
        Aluno alunoTest = alunoServiceSpy.criarAluno();
        //verificação
        MatcherAssert.assertThat(alunoTest, instanceOf(Aluno.class));
    }


    //verificar atualização de aluno
    @Test
    public void deveVerificarSeAtualizouNomeDoAluno() {
        //cenario
        Aluno aluno = new Aluno("Jose", "Alguém", 27);
        doReturn("John").when(alunoServiceSpy).solicitarNovoNomeAluno();
        doReturn("Doe").when(alunoServiceSpy).solicitarNovoSobrenomeAluno();
        doReturn(27).when(alunoServiceSpy).solicitarNovaIdadeAluno();
        //ação
        alunoServiceSpy.atualizarAluno(aluno);
        //verificação
        MatcherAssert.assertThat(aluno.getPrimeiroNomeAluno(), is("John"));
    }

    @Test
    public void deveVerificarSeAtualizouSobrenomeDoAluno() {
        //cenario
        Aluno aluno = new Aluno("Jose", "Alguém", 27);
        doReturn("John").when(alunoServiceSpy).solicitarNovoNomeAluno();
        doReturn("Doe").when(alunoServiceSpy).solicitarNovoSobrenomeAluno();
        doReturn(27).when(alunoServiceSpy).solicitarNovaIdadeAluno();
        //ação
        alunoServiceSpy.atualizarAluno(aluno);
        //verificação
        MatcherAssert.assertThat(aluno.getSobrenomeAluno(), is("Doe"));
    }

    @Test
    public void deveVerificarSeAtualizouIdadeDoAluno() {
        //cenario
        Aluno aluno = new Aluno("Jose", "Alguém", 23);
        doReturn("John").when(alunoServiceSpy).solicitarNovoNomeAluno();
        doReturn("Doe").when(alunoServiceSpy).solicitarNovoSobrenomeAluno();
        doReturn(27).when(alunoServiceSpy).solicitarNovaIdadeAluno();
        //ação
        alunoServiceSpy.atualizarAluno(aluno);
        //verificação
        MatcherAssert.assertThat(aluno.getIdade(), is(27));
    }

    //verificar solicitação de idade
    @Test
    public void deveRetornarIdadeDoAlunoQuandoCriado() {
        //cenario
        doReturn(27).when(alunoServiceSpy).solicitarIdadeAluno();
        //ação
        alunoService.solicitarIdadeAluno();
        //verificação
        MatcherAssert.assertThat(alunoServiceSpy.solicitarIdadeAluno(), is(27));

    }

    //verificar solicitação de sobrenome
    @Test
    public void deveRetornarSobreNomeDoAlunoQuandoCriado() {
        //cenario
        doReturn("Doe").when(alunoServiceSpy).solicitarSobrenomeAluno();
        //ação
        alunoService.solicitarSobrenomeAluno();
        //verificação
        MatcherAssert.assertThat(alunoServiceSpy.solicitarSobrenomeAluno(), is("Doe"));

    }

    //verificar solicitação de nome
    @Test
    public void deveRetornarNomeDoAlunoQuandoCriado() {
        //cenario
        doReturn("John").when(alunoServiceSpy).solicitarNomeAluno();
        //ação
        alunoService.solicitarNomeAluno();
        //verificação
        MatcherAssert.assertThat(alunoServiceSpy.solicitarNomeAluno(), is("John"));

    }
    @Test
    public void deveRetornarNovaIdadeDoAluno() {
        //cenario
        doReturn(27).when(alunoServiceSpy).solicitarNovaIdadeAluno();
        //ação
        alunoService.solicitarNovaIdadeAluno();
        //verificação
        MatcherAssert.assertThat(alunoServiceSpy.solicitarNovaIdadeAluno(), is(27));

    }

    //verificar solicitação de sobrenome
    @Test
    public void deveRetornarNovoSobreNomeDoAlunoQuandoCriado() {
        //cenario
        doReturn("Doe").when(alunoServiceSpy).solicitarNovoSobrenomeAluno();

        //ação
        alunoService.solicitarNovoSobrenomeAluno();
        //verificação
        MatcherAssert.assertThat(alunoServiceSpy.solicitarNovoSobrenomeAluno(), is("Doe"));

    }

    //verificar solicitação de nome
    @Test
    public void deveRetornarNovoNomeDoAlunoQuandoCriado() {
        //cenario
        doReturn("John").when(alunoServiceSpy).solicitarNovoNomeAluno();
        //ação
        alunoService.solicitarNovoNomeAluno();
        //verificação
        MatcherAssert.assertThat(alunoServiceSpy.solicitarNovoNomeAluno(), is("John"));

    }
}
