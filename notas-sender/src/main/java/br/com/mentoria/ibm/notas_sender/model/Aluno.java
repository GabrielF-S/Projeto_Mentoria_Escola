package br.com.mentoria.ibm.notas_sender.model;

import br.com.mentoria.ibm.notas_sender.service.util.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    private Integer id;
    private String primeiroNomeAluno;
    private String sobrenomeAluno;
    private int idade;
    private Status status;
    private  String email;



}
