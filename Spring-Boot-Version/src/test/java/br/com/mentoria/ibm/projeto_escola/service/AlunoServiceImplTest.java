package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.repository.AlunoRepository;
import br.com.mentoria.ibm.projeto_escola.service.impl.AlunoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AlunoServiceImplTest {
    @InjectMocks
    private AlunoServiceImpl alunoService;

    @Mock
    private AlunoRepository alunoRepo;
    @Mock
    AlunoServiceImpl alunoServiceSpy;

    Aluno aluno;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        alunoServiceSpy = spy(alunoService);
        alunoRepo = Mockito.mock(AlunoRepository.class);
        aluno = new Aluno("John", "Doe", 27, "teste@mail.com");


    }

    //Todo criar aluno
    @Test
    public void deveVerificarSeMetodoDeCriarAlunoFoiChamado() {
        //cenario


        //ação
        alunoServiceSpy.criarAluno(aluno);

        //verificação
        verify(alunoServiceSpy, times(1)).criarAluno(aluno);
    }

    @Test
    public void deveVerificarSeAInstanciaCriadaEhDaClasseAluno() {
        //cenario
          doReturn(aluno).when(alunoServiceSpy).criarAluno(aluno);
        //ação
        Aluno alunoTest = alunoServiceSpy.criarAluno(aluno);
        //verificação
        assertThat(alunoTest, instanceOf(Aluno.class));
    }

    @Test
    public void deveVerificarSeNomeDoAlunoEstaCorreto() {
        //cenario
        doReturn(aluno).when(alunoServiceSpy).criarAluno(aluno);
        //ação
        Aluno alunoTest = alunoServiceSpy.criarAluno(aluno);
        //verificação
        assertThat(alunoTest.getPrimeiroNomeAluno(), is("John"));
    }
    //Todo localizarAlunoPorID
    @Test
    public  void deveLocalizarUmAlunoPorId(){
        //cenario
        doReturn(aluno).when(alunoServiceSpy).localizarAlunoPorId(1);
        //Todo verificar
        //ação
       Aluno alunotest = alunoServiceSpy.localizarAlunoPorId(1);

        //verificação
        assertThat(alunotest, is(aluno));
    }
    @Test
    public  void deveVerificarAssionamentodeMetodoLocalizarUmAlunoPorId(){
        //cenario
        doReturn(aluno).when(alunoServiceSpy).localizarAlunoPorId(1);
        //Todo verificar
        //ação
        Aluno alunotest = alunoServiceSpy.localizarAlunoPorId(1);

        //verificação
        verify(alunoServiceSpy, atLeastOnce()).localizarAlunoPorId(1);
    }

    //todo localizarTodosAlunos
    @Test
    public void deveRetornarListaCom3Alunos(){
        //cenario
        doReturn(List.of(new Aluno("John", "Doe", 27,"teste@mail.com" ),
                new Aluno("Ivan", "Doe", 27, "teste@mail.com"),
                new Aluno("Isac","Doe", 27, "teste@mail.com")))
                .when(alunoServiceSpy).localizarTodosAlunos();
        //ação
        List<Aluno> alunosList = alunoServiceSpy.localizarTodosAlunos();

        //verificação
        assertThat(alunosList.size(), is(3));
    }
    //Todo deletarAluno

    //verificar atualização de aluno
    @Test
    public void deveVerificarSeAtualizouNomeDoAluno() {
        //cenario
        Aluno aluno = new Aluno("Jose", "Alguém", 27, "teste@mail.com");
        doCallRealMethod().when(alunoServiceSpy).atualizarAluno(aluno);
        //TODO verificar como realizar este teste
        aluno.setPrimeiroNomeAluno("John");
        //ação
        alunoServiceSpy.atualizarAluno(aluno);
        //verificação
        assertThat(aluno.getPrimeiroNomeAluno(), is("John"));
    }

    @Test
    public void deveVerificarSeAtualizouSobrenomeDoAluno() {
        //cenario
        Aluno aluno = new Aluno("Jose", "Alguém", 27,"teste@mail.com");

        //ação
        alunoServiceSpy.atualizarAluno(aluno);
        //TODO verificar como realizar este teste
        aluno.setSobrenomeAluno("Doe");
        //verificação
        assertThat(aluno.getSobrenomeAluno(), is("Doe"));
    }

    @Test
    public void deveVerificarSeAtualizouIdadeDoAluno() {
        //cenario
        Aluno aluno = new Aluno("Jose", "Alguém", 23, "teste@mail.com");

        //ação
        alunoServiceSpy.atualizarAluno(aluno);
        //TODO verificar como realizar este teste
        aluno.setIdade(27);
        //verificação
        assertThat(aluno.getIdade(), is(27));
    }


}
