package br.com.mentoria.ibm.projeto_escola.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_escola")
public class Escola implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escola", nullable = false, unique = true)
    private int id;
    @Column(name = "nome_escola")
    private String nomeEscola;
    @Transient
    private final int TAMANHO_MAX = 3;

    @OneToMany
    private List<Turma> turmas;

    public Escola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }
}