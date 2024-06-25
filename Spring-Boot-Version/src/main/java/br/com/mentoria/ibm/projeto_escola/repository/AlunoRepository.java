package br.com.mentoria.ibm.projeto_escola.repository;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    List<Aluno> findByPrimeiroNomeAluno(String primeiroNomeAluno);
    Optional<Aluno> findByPrimeiroNomeAlunoAndSobrenomeAluno(String primeiroNomeAluno, String sobremenome);

    @Query(value = "select * from tb_aluno", nativeQuery = true)
    List<Aluno> metodoDiferente();



}
