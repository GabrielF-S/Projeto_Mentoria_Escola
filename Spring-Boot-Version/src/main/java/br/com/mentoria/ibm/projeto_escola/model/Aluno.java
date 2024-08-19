package br.com.mentoria.ibm.projeto_escola.model;

import br.com.mentoria.ibm.projeto_escola.service.util.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Column(name = "nome_aluno")
    private String primeiroNomeAluno;
    @Column(name = "sobrenome_aluno")
    private String sobrenomeAluno;
    @Column(name = "idade_aluno")
    private int idade;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Integer id;
    @Column(name = "aprovacao")
    private Status status;
    @Column(name = "email")
    private  String email;


    public Aluno(String primeiroNomeAluno, String sobrenomeAluno, int idade,String email) {
        setPrimeiroNomeAluno(primeiroNomeAluno);
        setSobrenomeAluno(sobrenomeAluno);
        setIdade(idade);
        setEmail(email);
        setStatus(Status.PENDENTE);

    }


}
