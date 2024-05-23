import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ControladorTeste {

    private Escola escolaTest;
    private Turma turmaTestA;
    private Controlador controladorTest;
    private Aluno alunoTest1;

    private final InputStream originalSystemIn = System.in;
    private ByteArrayInputStream testIn;


    @Before
    public void inicio() throws Exception {
        escolaTest = new Escola("School");
        turmaTestA = new Turma("Turma A");
        controladorTest = new Controlador();
        alunoTest1 = new Aluno("Pedro","Assis", 16);
        escolaTest.adicionarTurma(turmaTestA);
        escolaTest.adicionarAluno(alunoTest1);
        turmaTestA.adicionarAluno(alunoTest1);

    }
    @After
    public void restoreSystemIn() {
        System.setIn(originalSystemIn);
    }

    //atualizar aluno



}
