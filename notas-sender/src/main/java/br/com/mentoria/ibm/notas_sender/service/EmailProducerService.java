package br.com.mentoria.ibm.notas_sender.service;

import br.com.mentoria.ibm.notas_sender.service.util.Status;

public interface EmailProducerService {
    public void sendMail(String email, String nome, Status status);


}
