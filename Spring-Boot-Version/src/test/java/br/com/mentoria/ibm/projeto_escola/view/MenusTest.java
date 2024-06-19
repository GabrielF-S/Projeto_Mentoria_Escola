package br.com.mentoria.ibm.projeto_escola.view;

import br.com.mentoria.ibm.projeto_escola.controller.EscolaServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class MenusTest {

    @InjectMocks
    private Menus menusMock;


    Menus menusSpy;
    @InjectMocks
    private EscolaServiceImpl escolaService;

    EscolaServiceImpl escolaServiceSpy;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        menusSpy = spy(menusMock);
        escolaServiceSpy = spy(escolaService);
    }

    //Todo menu
    @Test
    public void deveVerificarSeMenuFoiChamadoQuandoProgramaIniciado() throws Exception {
        //cenario
        //ação
        menusSpy.menu();
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