package br.com.mentoria.ibm.projeto_escola.dao;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Escola;
import br.com.mentoria.ibm.projeto_escola.model.Turma;

import java.util.List;

public interface TurmaDao {


    void save(Turma turma);

    void  update(Turma turma);

    void delete(Long id);

    List<Turma> localizarTurmaPorNome();

    Turma localizarTurmaPorID(Long Id);

    List<Aluno> localizarAlunoPorNome();

    Aluno localizarAlunoPorId(Long Id);


}
