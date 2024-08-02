package br.com.mentoria.ibm.notas_sender.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    private Integer id;

    private String primeiroNomeAluno;

    private String sobrenomeAluno;

    private int idade;

}
