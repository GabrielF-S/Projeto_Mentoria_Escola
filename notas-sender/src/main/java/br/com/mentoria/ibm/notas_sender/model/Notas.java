package br.com.mentoria.ibm.notas_sender.model;

import br.com.mentoria.ibm.notas_sender.service.util.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notas {

    private String nomeAluno;
    private Double a1;
    private Double a2;
    private Double a3;
    private Double notaFinal;
    private Status status;

    public Notas(String nomeAluno, Double a1, Double a2, Double a3) {
        this.nomeAluno = nomeAluno;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;

    }

}