import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class EscolaTeste {

    private Escola escolaTest;
    private Turma turmaTestA;
    private Controlador controladorTest;
    private Aluno alunoTest1;

    private final InputStream originalSystemIn = System.in;
    private ByteArrayInputStream testIn;
    @Before
    public void inicio() {
        escolaTest = new Escola("School");
        turmaTestA = new Turma("Turma A");
        controladorTest = new Controlador();
        alunoTest1 = new Aluno("Pedro", "Assis", 16);
        escolaTest.setControlador(controladorTest);
    }

    @After
    public void restoreSystemIn() {
        System.setIn(originalSystemIn);
    }

    //atualziar aluno

    //atualizar turma
    //cenario

    //ação

    //verificação

    //excluir alunos

    //excluir turma

    //localizar todos os alunos

    //localizar aluno

    //localizar todas as turmas turma

    //localizar turma

    //cadastrar turma

    //adicionar turma

    //localizar aluno


    //adicionar aluno
    @Test
    public void adicionarAlunoEscola() {
        //cenario -> @Before
        //ação
        escolaTest.adicionarAluno(alunoTest1);
        //verificação
        Assert.assertTrue(escolaTest.getAlunos().contains(alunoTest1));


    }
}
