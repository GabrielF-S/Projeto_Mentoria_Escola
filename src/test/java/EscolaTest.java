import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EscolaTest {

    public Escola escolaTest;
    public Turma turmaTestA;
    @Mock
    public Controlador controladorTest;
    public Aluno alunoTest1;

    @Before
    public void inicio() {
        escolaTest = new Escola("School");
        turmaTestA = new Turma("Turma A");
        controladorTest = mock(Controlador.class);
        alunoTest1 = new Aluno("Pedro", "Assis", 16);
        escolaTest.setControlador(controladorTest);
    }

    //atualziar aluno
    @Test
    public void deveAtualizarAlunoQuandoPassadoOsDados() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        turmaTestA.adicionarAluno(alunoTest1);
        escolaTest.adicionarAluno(alunoTest1);
        when(controladorTest.localizarAluno()).thenReturn(alunoTest1.getId());
        when(controladorTest.localizarAlunoTurma(alunoTest1.getId())).thenReturn(alunoTest1);
        when(controladorTest.confirmacao()).thenReturn(true);
        when(controladorTest.solicitarNomeAluno()).thenReturn("João");
        when(controladorTest.solicitarSobrenomeAluno()).thenReturn("Santos");
        when(controladorTest.solicitarIdadeAluno()).thenReturn(15);
        when(controladorTest.atualizarAluno(alunoTest1)).thenCallRealMethod();
        //ação
        escolaTest.editarAluno();
        //verificação
        MatcherAssert.assertThat(alunoTest1.getPrimeiroNomeAluno(), is("João"));
    }

    //atualizar turma
    @Test
    public void deveAtualizarTurmaQuandoInvocado() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        when(controladorTest.localizarTurma()).thenReturn(turmaTestA);
        when(controladorTest.solicitarNomeTurma()).thenReturn("Classe - A");
        when(controladorTest.novoNomeTurma()).thenReturn("Classe - A");
        when(controladorTest.confirmacao()).thenReturn(true);
        //ação
        escolaTest.editarTurmas();
        //verificação
        MatcherAssert.assertThat(turmaTestA.getNomeTurma(), is("Classe - A"));
    }

    //excluir alunos
    @Test
    public void deveExcluirAlunoDaTurma() throws Exception {
        escolaTest.adicionarTurma(turmaTestA);
        turmaTestA.adicionarAluno(alunoTest1);
        //cenario
        when(controladorTest.localizarAluno()).thenReturn(alunoTest1.getId());
        when(controladorTest.localizarAlunoTurma(alunoTest1.getId())).thenReturn(alunoTest1);
        when(controladorTest.confirmacao()).thenReturn(true);
        //ação
        escolaTest.excluirAluno();
        //verificação
        Assert.assertFalse(turmaTestA.getAlunos().contains(alunoTest1));
    }

    @Test
    public void deveVerificarSeAluno2PermaneceQuandoAluno1Excluido() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        turmaTestA.adicionarAluno(alunoTest1);
        Aluno alunoTest2 = new Aluno("Caique", "Fernandes", 14);
        turmaTestA.adicionarAluno(alunoTest2);
        when(controladorTest.localizarAluno()).thenReturn(alunoTest1.getId());
        when(controladorTest.localizarAlunoTurma(alunoTest1.getId())).thenReturn(alunoTest1);
        when(controladorTest.confirmacao()).thenReturn(true);
        //ação
        escolaTest.excluirAluno();
        //verificação
        Assert.assertTrue(turmaTestA.getAlunos().contains(alunoTest2));
    }

    @Test
    public void deveLancarExceptionQuandoTentarExcluirAlunoNulo() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        when(controladorTest.localizarAluno()).thenReturn(alunoTest1.getId());
        when(controladorTest.localizarAlunoTurma(alunoTest1.getId())).thenReturn(null);
        when(controladorTest.confirmacao()).thenReturn(true);
        //ação
        try {
            escolaTest.excluirAluno();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), is("Não foi possivel excluir!"));
        }
    }

    //excluir turma
    @Test
    public void deveExcluirTurmaDaEscola() throws Throwable {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        when(controladorTest.localizarTurma()).thenReturn(turmaTestA);
        when(controladorTest.confirmacao()).thenReturn(true);
        //ação
        escolaTest.excluirTurmas();
        //verificação
        Assert.assertFalse(escolaTest.getTurmas().contains(turmaTestA));
    }

    @Test
    public void naoDeveExcluirTurmaDaEscolaQuandoTemAluno() throws Throwable {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        turmaTestA.adicionarAluno(alunoTest1);
        when(controladorTest.localizarTurma()).thenReturn(turmaTestA);
        when(controladorTest.confirmacao()).thenReturn(true);
        //ação
        try {
            escolaTest.excluirTurmas();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(),
                    is("ERRO: Não é possivel excluir turmas que contenham alunos"));
        }
    }

    @Test
    public void deveRetornarExceptionQuandoTurmaNula() throws Throwable {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        when(controladorTest.localizarTurma()).thenReturn(null);
        when(controladorTest.confirmacao()).thenReturn(true);
        //ação
        try {
            escolaTest.excluirTurmas();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(),
                    is("Nenhuma turma cadastrada"));
        }
    }

    //localizar todos os alunos
    @Test
    public void deveRetornarListaComTodosAlunos() throws Exception {
        //cenario
        Aluno alunoTest2 = new Aluno("Aluno2", "Dois", 14);
        escolaTest.adicionarTurma(turmaTestA);
        escolaTest.adicionarAluno(alunoTest1);
        escolaTest.adicionarAluno(alunoTest2);
        turmaTestA.adicionarAluno(alunoTest1);
        turmaTestA.adicionarAluno(alunoTest2);
        //ação
        List<Aluno> alunos= escolaTest.localizarTodosAlunos();
        //verificação
        Assert.assertTrue(alunos.size() == 2);
    }
    @Test
    public void deveVerificarListaComTodosAlunosNaoNula() throws Exception {
        //cenario
        Aluno alunoTest2 = new Aluno("Aluno2", "Dois", 14);
        escolaTest.adicionarTurma(turmaTestA);
        escolaTest.adicionarAluno(alunoTest1);
        escolaTest.adicionarAluno(alunoTest2);
        turmaTestA.adicionarAluno(alunoTest1);
        turmaTestA.adicionarAluno(alunoTest2);

        //ação
        List<Aluno> alunos = escolaTest.localizarTodosAlunos();
        //verificação
        Assert.assertNotNull(alunos);

    }

    @Test
    public void deveRetornarExceptionQuandoListaNula() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);

        //ação
        try {
            escolaTest.localizarTodosAlunos();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), is("Nenhum aluno cadastrado"));
        }
    }

    //localizar aluno
    @Test
    public void deveRetornarUmAlunoQuandoVerificaSeSaoMesmaInstancia() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        turmaTestA.adicionarAluno(alunoTest1);
        when(controladorTest.localizarAluno()).thenReturn(alunoTest1.getId());
        when(controladorTest.localizarAlunoTurma(alunoTest1.getId())).thenReturn(alunoTest1);
        //ação
        Aluno aluno = escolaTest.localizarAluno();
        //verificação
        Assert.assertSame(aluno, alunoTest1);
    }

    @Test
    public void deveRetornarUmAlunoQuandoVerificaSeSaoIguais() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        turmaTestA.adicionarAluno(alunoTest1);
        when(controladorTest.localizarAluno()).thenReturn(alunoTest1.getId());
        when(controladorTest.localizarAlunoTurma(alunoTest1.getId())).thenReturn(alunoTest1);
        //ação
        escolaTest.localizarAluno();
        //verificação
        Assert.assertEquals(escolaTest.localizarAluno(), alunoTest1);
    }

    @Test
    public void deveVerificarSeBuscaAlunoCorreto() throws Exception {
        //cenario
        Aluno alunoTest2 = new Aluno("Aluno2", "Teste2", 2);
        escolaTest.adicionarTurma(turmaTestA);
        turmaTestA.adicionarAluno(alunoTest1);
        when(controladorTest.localizarAluno()).thenReturn(alunoTest1.getId());
        when(controladorTest.localizarAlunoTurma(alunoTest1.getId())).thenReturn(alunoTest1);
        //ação
        escolaTest.localizarAluno();
        //verificação
        Assert.assertNotEquals(escolaTest.localizarAluno(), alunoTest2);
    }

    @Test
    public void deveLancarExceptionQuandoNaoTemAluno() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        when(controladorTest.localizarAluno()).thenReturn(alunoTest1.getId());
        when(controladorTest.localizarAlunoTurma(alunoTest1.getId())).thenReturn(null);
        //ação
        try {
            escolaTest.localizarAluno();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), is("Nenhum aluno cadastrado"));
        }
    }

    @Test
    public void deveLancarExceptionQuandoNaoTemTurma() throws Exception {
        //cenario
        when(controladorTest.localizarAluno()).thenReturn(alunoTest1.getId());
        when(controladorTest.localizarAlunoTurma(alunoTest1.getId())).thenReturn(alunoTest1);
        //ação
        try {
            escolaTest.localizarAluno();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), is("Nenhuma Turma cadastrada"));
        }
    }

    //localizar todas as turmas
    @Test
    public void deveRetornarListaComTurmas() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        escolaTest.adicionarTurma(new Turma("Turma - B"));
        escolaTest.adicionarTurma(new Turma("Turma - C"));
        //ação
        escolaTest.localizarTodasTurmas();
        //verificação
        Assert.assertTrue(escolaTest.localizarTodasTurmas().size() == 3);
    }

    @Test
    public void deveRetornarListaComTurmasQuandoTemAlunos() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        escolaTest.adicionarTurma(new Turma("Turma - B"));
        escolaTest.adicionarTurma(new Turma("Turma - C"));
        turmaTestA.adicionarAluno(alunoTest1);
        //ação
        List<Turma> turmas= escolaTest.localizarTodasTurmas();
        //verificação
        Assert.assertTrue(turmas.size() == 3);
    }

    @Test
    public void deveVerificarSeListaEhNula() throws Exception {
        //cenario

        //ação
        try {
            escolaTest.localizarTodasTurmas();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), is("Não há turmas cadastradas"));
        }
    }

    @Test
    public void deveVerificarSeListaNaoEhNula() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        escolaTest.adicionarTurma(new Turma("Turma - B"));
        escolaTest.adicionarTurma(new Turma("Turma - C"));
        //ação
        escolaTest.localizarTodasTurmas();
        //verificacao
        Assert.assertNotNull(escolaTest.localizarTodasTurmas());
    }

    //localizar turma
    @Test
    public void deveLocalizarUmaTurma() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        //ação
        escolaTest.localizarTurma(turmaTestA.getNomeTurma());
        //verificação
        Assert.assertSame(turmaTestA, escolaTest.localizarTurma(turmaTestA.getNomeTurma()));
    }

    @Test
    public void deveLocalizarUmaTurmaComAluno() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        turmaTestA.adicionarAluno(alunoTest1);
        //ação
        escolaTest.localizarTurma(turmaTestA.getNomeTurma());
        //verificação
        Assert.assertSame(turmaTestA, escolaTest.localizarTurma(turmaTestA.getNomeTurma()));
    }

    @Test
    public void naoDeveLocalizarUmaTurmaQuandoTurmaNula() throws Exception {
        //cenario
        //ação
        try {
            escolaTest.localizarTurma(turmaTestA.getNomeTurma());
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), is("Não há turmas cadastradas"));
        }
    }
    @Test
    public void DeveLocalizarUmaTurmaQuandoAlunoNula() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);

        //ação
        Turma turmaTest2 = escolaTest.localizarTurma(alunoTest1);
        //verificação
        Assert.assertNull(turmaTest2);
    }

    @Test
    public void deveRetornarNullQuandoTurmaNaoCadastrada() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        //ação
        escolaTest.localizarTurma("Turma - B");
        //verificação
        Assert.assertNull(escolaTest.localizarTurma("Turma - B"));
    }

    //cadastrar turma
    @Test
    public void deveCadastrarTurmaQuandoSolicitado() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        when(controladorTest.solicitarNomeTurma()).thenReturn("Turma - B");
        when(controladorTest.criarTurma()).thenCallRealMethod();

        //ação
        escolaTest.cadastrarTurma();
        //verificação
        Assert.assertTrue(escolaTest.getTurmas().size() == 2);

    }

    @Test
    public void naoDeveCadastrarTurmaQuandoAtingitLimite() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        escolaTest.adicionarTurma(new Turma("Turma - B"));
        escolaTest.adicionarTurma(new Turma("Turma - C"));
        when(controladorTest.solicitarNomeTurma()).thenReturn("Turma - D");
        when(controladorTest.criarTurma()).thenCallRealMethod();
        //ação
        try {
            escolaTest.cadastrarTurma();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), is("Não é possivel adicionar mais turmas"));
        }
    }

    @Test
    public void naoDeveCadastrarTurmaQuandoDuplicada() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        when(controladorTest.criarTurma()).thenReturn(turmaTestA);
        //ação
        try {
            escolaTest.cadastrarTurma();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), is("Turma já cadastrada"));
        }
    }

    //adicionar turma
    @Test
    public void deveRetornarDuasTurmasTurma() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        //ação
        escolaTest.adicionarTurma(new Turma("Turma - B"));
        //verificação
        Assert.assertTrue(escolaTest.getTurmas().size() == 2);
    }

    @Test
    public void deveVerificarSeEscolaContemTurmaQuandoAdicionada() throws Exception {
        //cenario
        //ação
        escolaTest.adicionarTurma(turmaTestA);
        //verificação
        Assert.assertTrue(escolaTest.getTurmas().contains(turmaTestA));
    }

    //localizar aluno
    @Test
    public void deveLocalizarUmAluno() throws Exception {
        //cenario
        escolaTest.adicionarAluno(alunoTest1);
        turmaTestA.adicionarAluno(alunoTest1);
        escolaTest.adicionarTurma(turmaTestA);

        when(controladorTest.localizarAluno()).thenReturn(alunoTest1.getId());
        when(controladorTest.localizarAlunoTurma(alunoTest1.getId())).thenReturn(alunoTest1);
        //ação
        escolaTest.localizarAluno();
        //verificação
        Assert.assertSame(escolaTest.localizarAluno(), alunoTest1);
    }

    @Test
    public void deveLancarExceptionQuandoAlunoNulo() throws Exception {
        //cenario
        escolaTest.adicionarAluno(alunoTest1);
        turmaTestA.adicionarAluno(alunoTest1);
        escolaTest.adicionarTurma(turmaTestA);

        when(controladorTest.localizarAluno()).thenReturn(alunoTest1.getId());
        when(controladorTest.localizarAlunoTurma(alunoTest1.getId())).thenReturn(null);
        //ação
        try {
            escolaTest.localizarAluno();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), is("Nenhum aluno cadastrado"));
        }
    }

    @Test
    public void deveLancarExceptionQuandoTurmaNula() throws Exception {
        //cenario
        escolaTest.adicionarAluno(alunoTest1);
        turmaTestA.adicionarAluno(alunoTest1);


        when(controladorTest.localizarAluno()).thenReturn(alunoTest1.getId());
        when(controladorTest.localizarAlunoTurma(alunoTest1.getId())).thenReturn(null);
        //ação
        try {
            escolaTest.localizarAluno();
        } catch (Exception e) {
            //verificação
            MatcherAssert.assertThat(e.getMessage(), is("Nenhuma Turma cadastrada"));
        }
    }
    //cadastrar Aluno

    @Test
    public void deveCadastrarAlunoComMetodoReal() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);
        when(controladorTest.solicitarNomeAluno()).thenReturn("Caique");
        when(controladorTest.solicitarSobrenomeAluno()).thenReturn("Henrique");
        when(controladorTest.solicitarIdadeAluno()).thenReturn(16);
        when(controladorTest.criarAluno()).thenCallRealMethod();

        when(controladorTest.localizarTurma()).thenReturn(turmaTestA);
        //ação
        escolaTest.cadastrarAluno();
        //verificação
        Assert.assertTrue(escolaTest.getAlunos().size()==1);


    }
    @Test
    public void deveCadastrarAluno() throws Exception {
        //cenario
        escolaTest.adicionarTurma(turmaTestA);

        when(controladorTest.criarAluno()).thenReturn(alunoTest1);

        when(controladorTest.localizarTurma()).thenReturn(turmaTestA);
        //ação
        escolaTest.cadastrarAluno();
        //verificação
        Assert.assertTrue(escolaTest.getAlunos().contains(alunoTest1));


    }
    @Test
    public void deveLancarExceptionQuandoNaoTemTurmaParaCadastro() throws Exception {
        //cenario

        when(controladorTest.criarAluno()).thenReturn(alunoTest1);

        when(controladorTest.localizarTurma()).thenReturn(turmaTestA);
        //ação
        try {
            escolaTest.cadastrarAluno();
        }catch (Exception e){
            //verificação
            MatcherAssert.assertThat(e.getMessage(), is("Não é possivel cadastrar aluno sem ter turmas"));
        }
    }
    //adicionar aluno
    @Test
    public void adicionarAlunoEscola() throws Exception {
        //cenario -> @Before
        turmaTestA.adicionarAluno(alunoTest1);
        //ação
        escolaTest.adicionarAluno(alunoTest1);
        //verificação
        Assert.assertTrue(escolaTest.getAlunos().contains(alunoTest1));
    }
}
