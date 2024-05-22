import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;

public class TurmaTeste {
    @Test
    public void adicionarAlunoQuandoTemVaga() throws Exception {
        //cenario
        Escola escolaTest = new Escola("School");
        Turma turmaTest = new Turma("Turma A");
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        escolaTest.adicionarTurma(turmaTest);
        //ação
        turmaTest.adicionarAluno(alunoTest);

        //verificação
        Assert.assertTrue(turmaTest.getAlunos().contains(alunoTest));
    }
    @Test(expected= Exception.class)
    public void adicionarAlunoQuandoNaoTemVaga() throws Exception {
        //cenario
        Escola escolaTest = new Escola("School");
        Turma turmaTest = new Turma("Turma A");
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        Aluno alunoTest2 = new Aluno("Jose","Siqueira",
                13);
        Aluno alunoTest3 = new Aluno("Jeremiras","Siqueira",
                13);
        Aluno alunoTest4 = new Aluno("Francisco","Neto",
                13);
        escolaTest.adicionarTurma(turmaTest);
        //ação
        turmaTest.adicionarAluno(alunoTest);
        turmaTest.adicionarAluno(alunoTest2);
        turmaTest.adicionarAluno(alunoTest3);

        //verificação
        turmaTest.adicionarAluno(alunoTest4);
    }
    @Test
    public void adicionarAlunoQuandoNaoTemVaga2() {
        //cenario
        Escola escolaTest = new Escola("School");
        Turma turmaTest = new Turma("Turma A");
        Aluno alunoTest = new Aluno("Joao","Siqueira",
                13);
        Aluno alunoTest2 = new Aluno("Jose","Siqueira",
                13);
        Aluno alunoTest3 = new Aluno("Jeremiras","Siqueira",
                13);
        Aluno alunoTest4 = new Aluno("Francisco","Neto",
                13);
        escolaTest.adicionarTurma(turmaTest);
        //ação
        try {
            turmaTest.adicionarAluno(alunoTest);
            turmaTest.adicionarAluno(alunoTest2);
            turmaTest.adicionarAluno(alunoTest3);

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        //verificação
        try {
            turmaTest.adicionarAluno(alunoTest4);
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Turma Lotada"));
        }

    }



}
