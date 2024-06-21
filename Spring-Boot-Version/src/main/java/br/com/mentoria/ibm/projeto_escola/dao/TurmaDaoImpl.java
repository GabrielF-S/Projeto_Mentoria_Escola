package br.com.mentoria.ibm.projeto_escola.dao;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Turma;

import java.util.List;

public class TurmaDaoImpl extends AbstractDao<Turma, Long> implements TurmaDao{
    @Override
    public List<Turma> localizarTurmaPorNome() {
        return null;
    }

    @Override
    public Turma localizarTurmaPorID(Long Id) {
        return null;
    }

    @Override
    public List<Aluno> localizarAlunoPorNome() {
        return null;
    }

    @Override
    public Aluno localizarAlunoPorId(Long Id) {
        return null;
    }
}
