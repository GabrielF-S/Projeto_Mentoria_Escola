package br.com.mentoria.ibm.projeto_escola.dao;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Escola;

import java.util.List;

public interface AlunoDao {

    void save(Escola escola);

    void  update(Escola escola);

    void delete(Long id);

    List<Aluno> localizarPorNome(String nome);

    Aluno localizarPorID(Long id);


}
