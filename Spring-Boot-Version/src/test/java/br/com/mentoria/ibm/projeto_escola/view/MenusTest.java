package br.com.mentoria.ibm.projeto_escola.view;

import br.com.mentoria.ibm.projeto_escola.controller.AlunoServiceImpl;
import br.com.mentoria.ibm.projeto_escola.controller.EscolaServiceImpl;
import br.com.mentoria.ibm.projeto_escola.controller.TurmaServiceImpl;
import br.com.mentoria.ibm.projeto_escola.model.Escola;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class MenusTest {

    @InjectMocks
    private Menus menusMock;


    Menus menusSpy;
    @Mock
    private EscolaServiceImpl escolaService;

    @Mock
    private TurmaServiceImpl turmaService;

    @Mock
    private AlunoServiceImpl alunoService;

    @Mock
    Escola escola;
    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        menusSpy = spy(menusMock);
        escolaService = mock(EscolaServiceImpl.class);
        turmaService = mock(TurmaServiceImpl.class);
        alunoService=mock(AlunoServiceImpl.class);
        escola=mock(Escola.class);
    }

    //Todo menu
    @Test
    public void deveVerificarSeMeotdoInitFoiChamadoQuandoProgramaIniciado() throws Exception {
        //cenario
         doCallRealMethod().when(menusSpy).init();
         when(escolaService.solicitarNomeEscola()).thenReturn("Escola Teste");
         when(escolaService.criarEscola()).thenReturn(new Escola("Escola Teste"));
         doReturn(0).when(menusSpy).selecionarOpcaoMenu();
        //ação
        menusSpy.init();
        //verificação
        verify(menusSpy, times(1)).init();

    }
    @Test
    public void deveVerificarSeMeotdoMenuFoiChamadoQuandoProgramaIniciado() throws Exception {
        //cenario
        doCallRealMethod().when(menusSpy).init();
        when(escolaService.solicitarNomeEscola()).thenReturn("Escola Teste");
        when(escolaService.criarEscola()).thenReturn(new Escola("Escola Teste"));
        doReturn(0).when(menusSpy).selecionarOpcaoMenu();
        //ação
        menusSpy.init();
        //verificação
        verify(menusSpy, times(1)).menu();

    }


    //todo cadastrarMenu
    @Test
    public void deveVerificarSeOpcaoDeCadastroEhSelecioanda() throws Exception {

    }


    //Todo ProcurarMenu

    //Todo AtualizarMenu

    //todo ExcluirMenu

    //todo Selecionar Opção


}