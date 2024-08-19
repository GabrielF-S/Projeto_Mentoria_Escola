package br.com.mentoria.ibm.notas_sender.service;

import br.com.mentoria.ibm.notas_sender.model.Aluno;
import br.com.mentoria.ibm.notas_sender.model.Notas;
import br.com.mentoria.ibm.notas_sender.service.util.Status;

public interface NotasService {
    public void calcularNotaFinal(Notas notas);

    public void sendEmail(Aluno aluno);

}
