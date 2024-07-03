package br.com.mentoria.ibm.projeto_escola.service;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Escola;
import br.com.mentoria.ibm.projeto_escola.model.Turma;

import java.util.List;
import java.util.Optional;

public interface EscolaService {
    String obterNomeEscola();
    Escola criarEscola(String nome);
    void excuirEscola(int id);

    Optional<Escola> localizarEscolaPorId(int id);
    Escola atualizarEscola(Escola escola);
    List<Escola> localizarEscola();
    Escola adicionarTurma(int id, Turma turma);
    Escola removerTurma(int turmaId);
}
