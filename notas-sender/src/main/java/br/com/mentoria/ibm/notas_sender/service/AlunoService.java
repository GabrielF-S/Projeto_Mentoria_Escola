package br.com.mentoria.ibm.notas_sender.service;

import br.com.mentoria.ibm.notas_sender.model.Aluno;
import br.com.mentoria.ibm.notas_sender.model.Notas;

public interface AlunoService {

    public Aluno getStatus(Integer alunoId, Notas notas);

    public void atualizarAluno(Aluno aluno);
}
