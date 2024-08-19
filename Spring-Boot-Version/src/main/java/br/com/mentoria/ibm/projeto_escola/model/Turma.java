package br.com.mentoria.ibm.projeto_escola.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private int id;
    @Transient
    final int TAMANHO_MAX = 3;
    @EqualsAndHashCode.Include
    @Column(name = "nome_turma")
    private String nomeTurma;
    @OneToMany
    List<Aluno> alunos;
    @Override
    public String toString() {
        return "Turma: " + nomeTurma + "\nAlunos: \n";
    }

    public Turma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
}
