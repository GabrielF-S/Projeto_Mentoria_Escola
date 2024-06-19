package br.com.mentoria.ibm.projeto_escola.dao;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Escola;
import br.com.mentoria.ibm.projeto_escola.model.Turma;

import java.util.List;

public interface EscolaDao {

    void save(Escola escola);

    void  update(Escola escola);

    void delete(Long id);

    Escola localizarEscolaPorNome();

    List<Turma> localizarTurmas();

    List<Aluno> localizarAlunos();

}
