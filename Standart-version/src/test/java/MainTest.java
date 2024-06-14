import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MainTest {
    @Mock
    private Controlador controladorTest;
    @InjectMocks
    private Main mainTest;

    @Before
    public void inicio(){
        mainTest = new Main();
        controladorTest = Mockito.mock(Controlador.class);
    }
    @Test
    public void DeveIniciarOPrograma() throws Exception {

        controladorTest.init();
        Mockito.verify(controladorTest).init();


    }

}
