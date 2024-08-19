package br.com.mentoria.ibm.notas_sender.service;

import br.com.mentoria.ibm.notas_sender.feignCliente.UserFeig;
import br.com.mentoria.ibm.notas_sender.model.Aluno;
import br.com.mentoria.ibm.notas_sender.model.Notas;
import br.com.mentoria.ibm.notas_sender.service.util.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
@RequiredArgsConstructor
@Slf4j
@Service
public class AlunoService {

    @Autowired
    private UserFeig feig;

    public Aluno getStatus(Integer alunoId, Notas notas){
        var aluno = feig.findById(alunoId).getBody();
        if (Objects.nonNull(aluno)){
            if (aluno.getStatus().equals(Status.PENDENTE)){
                aluno.setStatus(notas.getStatus());
                atualizarAluno(aluno);
                return aluno;
            } else if (aluno.getStatus().equals(Status.REPROVADO)){
                throw new ThrowsNotasException("Aluno consta como reprovado!");
            }else {
                throw new ThrowsNotasException("Nota já enviada");
            }

        }

        return null;
    }

    public void atualizarAluno(Aluno aluno){
        feig.updateAluno(aluno);
    }
}
