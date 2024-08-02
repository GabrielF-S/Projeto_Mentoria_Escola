package br.com.mentoria.ibm.notas_sender.service;

import br.com.mentoria.ibm.notas_sender.feignCliente.UserFeig;
import br.com.mentoria.ibm.notas_sender.model.Notas;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class NotasService {

    @Autowired
    private  UserFeig feig;

    public Notas getStatus(Integer alunoId, Notas notas){
        var aluno = feig.findById(alunoId).getBody();
        if (Objects.nonNull(aluno)){
            return new Notas(aluno.getPrimeiroNomeAluno(), notas.getA1(), notas.getA2(), notas.getA3());
        }

        return null;
    }



}
