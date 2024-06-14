package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.view.Inputs;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EscolaServiceImplTest {
    @InjectMocks
    private EscolaServiceImpl escolaService;
    @Mock
    Inputs scanner;
    @Mock
    TurmaServiceImpl turmaService;

    public EscolaServiceImpl escolaServiceSpy;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);


    }

    @Test
    public void tetse() {

    }
    //deve criar aluno

    //deve cadastrar Aluno

    //deve editar Aluno

    //deve excluir aluno

    //deve localizar Todos os Alunos

    //deve localizar um Aluno

    //deve criar uma turma

    //deve cadastrar turma

    //deve editar turma

    //deve excluir turma

    //deve localizar todas as turmas

    //deve localizar uma turma pelo nome

    //deve obter o nome da escola

    //deve criar uma escola

    // deve solicitar o nome da escola

    //deve localizar uma turma

    //deve localizar uma turma por Aluno
}
