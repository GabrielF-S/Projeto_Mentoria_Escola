package br.com.mentoria.ibm.projeto_escola.dao;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Escola;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlunoDaoImpl extends AbstractDao<Aluno,Long> implements AlunoDao {

    @Override
    public void save(Escola escola) {

    }

    @Override
    public void update(Escola escola) {

    }

    @Override
    public List<Aluno> localizarPorNome(String nome) {
        return null;
    }

    @Override
    public Aluno localizarPorID(Long id) {
        return null;
    }
}
