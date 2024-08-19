package br.com.mentoria.ibm.notas_sender.service.impl;

import br.com.mentoria.ibm.notas_sender.model.Aluno;
import br.com.mentoria.ibm.notas_sender.model.Notas;
import br.com.mentoria.ibm.notas_sender.service.EmailProducerService;
import br.com.mentoria.ibm.notas_sender.service.NotasService;
import br.com.mentoria.ibm.notas_sender.service.util.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class NotasServiceImpl implements NotasService {

    private final EmailProducerService producerService;
    public void calcularNotaFinal(Notas notas){
       notas.setNotaFinal((notas.getA1() * 0.3) + (notas.getA2() * 0.3) + (notas.getA3() * 0.4));
       if (notas.getNotaFinal()>=7){
           notas.setStatus(Status.APROVADO);
       }else {
           notas.setStatus(Status.REPROVADO);
       }
    }


    public void sendEmail(Aluno aluno) {

        producerService.sendMail(aluno.getEmail(), aluno.getPrimeiroNomeAluno(), aluno.getStatus());
    }
}