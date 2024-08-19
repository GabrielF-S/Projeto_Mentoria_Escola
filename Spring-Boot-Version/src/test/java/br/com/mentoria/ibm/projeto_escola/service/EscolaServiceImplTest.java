package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Escola;
import br.com.mentoria.ibm.projeto_escola.model.Turma;
import br.com.mentoria.ibm.projeto_escola.service.impl.AlunoServiceImpl;
import br.com.mentoria.ibm.projeto_escola.service.impl.EscolaServiceImpl;
import br.com.mentoria.ibm.projeto_escola.service.impl.TurmaServiceImpl;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

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

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        escolaServiceSpy = spy(escolaService);

    }

    //deve cadastrar turma
    @Test
    public void deveCadastrarUmaTurma() {
        //cenario
        doCallRealMethod().when(escolaServiceSpy).criarEscola("IBM");
        escola = escolaServiceSpy.criarEscola("IBM");
        Turma turma = new Turma("Turma Teste");

        //ação
        escolaServiceSpy.adicionarTurma(escola.getId(), turma);
        //verificação
        Assert.assertTrue(escola.getTurmas().contains(turma));
    }

    //deve obter o nome da escola
    @Test
    public void deveVeriFicarNomeDaEscola() {
        //cenario
        //escola
        doCallRealMethod().when(escolaServiceSpy).criarEscola("IBM");
        //ação
        escola = escolaServiceSpy.criarEscola("IBM");
        //verificação
        MatcherAssert.assertThat(escolaServiceSpy.obterNomeEscola(), CoreMatchers.is("IBM"));
    }

    //deve criar uma escola
    @Test
    public void deveCriarEscola() {
        //cenario
        doCallRealMethod().when(escolaServiceSpy).criarEscola("IBM");
        //ação
        escola = escolaServiceSpy.criarEscola("IBM");
        //verificação
        Assert.assertNotNull(escola);
    }


}
