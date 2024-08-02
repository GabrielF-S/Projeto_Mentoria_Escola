package br.com.mentoria.ibm.notas_sender.model;

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
    private Boolean aprovado;

    public Notas(String nomeAluno, Double a1, Double a2, Double a3) {
        this.nomeAluno = nomeAluno;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.notaFinal =  calcularNotas(this.a1, this.a2, this.a3);

        isAprovado();

    }

    private Double calcularNotas(Double a1, Double a2, Double a3) {
        return (a1 * 0.3) + (a2 * 0.3) + (a3 * 0.4);
    }

    private void isAprovado() {
        this.aprovado = notaFinal >= 7;
    }


}
